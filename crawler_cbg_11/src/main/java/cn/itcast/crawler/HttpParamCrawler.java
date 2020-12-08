package cn.itcast.crawler;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pro.attr;
import pro.property;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class HttpParamCrawler {
    public static void main(String[] args) throws Exception{
        //server_id = 142 是扬名立万   139是少年游    140是圣兽元    fair_show_list 公示期
        List<Integer> list = new ArrayList<Integer>();
        list.add(143);
        list.add(144);
        list.add(140);
        int ran = 0;

        while (true){
            int falg = 2;
           while(falg > 0){
               boolean act = false;
               for (Integer i: list){

                   //随机等待一段时间
                   ran = new Random().nextInt(8)+1;

                   for (int j = 1; j<50; j++) {
                       System.out.println("jjjjjjjjjjj"+ j);

                       List<property> listPro =  crawler(i, act, j);
                       if(listPro == null){
                           System.out.println("全部页码遍历结束");
                           j = 50;     //break; //遍历完了   break退出当前语句， 放在这里退出的是if语句
                       }else{
                           judgePrice(listPro);   //对封装好的商品进行价格判断
                       }
                   }
               }
               Thread.sleep(ran*1888);

               falg--;
               if (falg == 1){
                   act = true;
               }
           }

        }


    }
    
//act为true是扫描公示期物品
    public static List<property> crawler(int server_id, boolean act, int page) throws Exception {
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建httpGet对象，设置URL地址
        URIBuilder uriBuilder = new URIBuilder("https://dh2.cbg.163.com/cgi-bin/equipquery.py");

        uriBuilder.addParameter("server_id", server_id+"");
        uriBuilder.addParameter("page", page+"");
        uriBuilder.addParameter("areaid", "3");
        if (act){
            uriBuilder.addParameter("act", "query");
        }else {
            uriBuilder.addParameter("act", "fair_show_list");
        }
        uriBuilder.addParameter("kind_id", "43");     //43可以获取道具类的
        uriBuilder.addParameter("query_order", "selling_time+DESC");
        uriBuilder.addParameter("server_name", "%D1%EF%C3%FB%C1%A2%CD%F2");
        uriBuilder.addParameter("kind_depth", "2");
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        //发起访问获得响应头
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //解析响应头
       /* if (response.getStatusLine().getStatusCode() == 200){
            String content = EntityUtils.toString(response.getEntity(), "gbk");
            System.out.println(content);
        }
        //调用处理响应的方法*/    
       List<property> list = respon(response, act);

        httpClient.close();
        return list;

    }

    public static List<property> respon(CloseableHttpResponse response ,boolean act) throws Exception{
        List<property> list = new ArrayList<property>();
        //获取响应头，解析数据
        if (response.getStatusLine().getStatusCode() == 200) {
            String content = EntityUtils.toString(response.getEntity(), "gbk");
            //System.out.println(content);


            //使用Jsoup解析获得的字符串
            //解析字符串
            Document doc = Jsoup.parse(content);
            //      Elements element2 = doc.getElementsByClass("b_left").nextAll();
            Elements element = doc.getElementsByClass("b_left");
            Elements element2 = doc.getElementsByClass("b_left").nextAll();

            Elements priceclass = doc.getElementsByClass("equip_icon");

             System.out.println("nextAll:" + element2.text());

//.first得到该元素的第一个兄弟元素    .next是得到该元素的下一个兄弟元素
            List<String> typeList = new ArrayList<String>();
            List<String> nameList = new ArrayList<String>();
            Double[] price = new Double[15];

            List<attr> listAttr = new ArrayList<attr>();

            ObjectMapper mapper = new ObjectMapper();

            for (Element e : element){
                attr att = new attr();
                try
                {
                 att = mapper.readValue(e.text(),attr.class);}
                catch (Exception ex){
                    System.out.println("捉到异常！！！");

                    att.setiAmount(1);
                    att.setDesc("捕获到异常");
                }
           //     System.out.println( att.toString());

                listAttr.add(att);
            }

            for (Element link : element.next()) {
                nameList.add(link.text());
                //     System.out.println(link.text());

            }


         //   System.out.println(element.nextAll().text());
/*
            for (Element link : element.next().next().next().next().next().next()) {

                System.out.println("6xiaxia" + link.text());
            } */
            int pi = 0;
            if(act) {
                for (Element link : element.next().next().next()) {

                    String aaa = link.text();
              //      System.out.println(aaa);

                    String bbb = aaa.substring(1, aaa.length());
                    String ccc = bbb.substring(0, bbb.length() - 1);
                    //      System.out.println(ccc);


                    double v = Double.parseDouble(ccc);
                    price[pi] = v;
              //      System.out.println("打印价格："+price[pi]);
                    pi++;
                }
            }else {

                for (Element e: priceclass){
             //       System.out.println(""+e.attr("data_price"));
                    price[pi]=Double.parseDouble(String.format("%.2f", (Double.parseDouble(e.attr("data_price")) / listAttr.get(pi).getiAmount())));
                    pi++;
                }

            }
           //     System.out.println(nameList);
           //     System.out.println(Arrays.deepToString(price));


            for (int i = 0; i < price.length; i++) {

                if (price[i] == null) {
                    System.out.println("价格数组遍历完");
                    return null;
                }   //如果读出来null 就是遍历全部了
                property pro = new property(nameList.get(i), price[i], listAttr.get(i).getDesc());
                System.out.println(pro);
                list.add(pro);     //封装好对象放入集合
            }

        }
        response.close();
        return list;
    }

    public static void judgePrice(List<property> list){
        for(property p: list){


            switch (p.getName()){
                case "八荒遗风":
                    if (p.getPrice() < 17.0){
                        System.out.println("找到低价的了"+p);

                    }
                    break;
                case "千年魂石":
                    if (p.getPrice() < 16.0){
                        System.out.println("找到低价的了"+p);

                    }
                    break;
                case "龙之骨":
                    if (p.getPrice() < 20){
                        System.out.println("找到低价的了"+p);
                    }
                    break;
                case "黄宝石":
                    if (p.getPrice()< 30){
                        System.out.println("找到低价的了"+p);

                    }
                    break;

            }
        }
    }
}


