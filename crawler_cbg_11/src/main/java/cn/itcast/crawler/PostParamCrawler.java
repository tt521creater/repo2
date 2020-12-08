package cn.itcast.crawler;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pro.property;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class PostParamCrawler {
    public static void main(String[] args) throws IOException {
        //1.创建HTTPClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2. 创建HttpPost对象,封装表单中的参数
        HttpPost httpPost = new HttpPost("https://dh2.cbg.163.com/cgi-bin/equipquery.py");


        //创建List集合
        List<NameValuePair>  params= new ArrayList<NameValuePair>();
        //封装参数

        params.add(new BasicNameValuePair("name", "search_browse_f"));
        params.add(new BasicNameValuePair("search_text", "八荒遗风"));
        params.add(new BasicNameValuePair("equip_type_ids", "display:none") );
        params.add(new BasicNameValuePair("act", "query") );
        params.add(new BasicNameValuePair("server_id", "142") );
        params.add(new BasicNameValuePair("page", "1") );
        params.add(new BasicNameValuePair("kind_id", "43") );
        params.add(new BasicNameValuePair("query_order", "selling_time DESC") );
        params.add(new BasicNameValuePair("server_name", "杨名立万") );
        params.add(new BasicNameValuePair("areaid", "3") );
        params.add(new BasicNameValuePair("kind_depth", "2") );
        params.add(new BasicNameValuePair("search_page", "5") );

        //创建表单的Entity对象，第一个参数就是
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "gbk");
        //设置表单的Entity对象到Post中
        httpPost.setEntity(formEntity);

        //3. 发送请求
       CloseableHttpResponse response = httpClient.execute(httpPost);

        //获取响应头，解析数据
        if (response.getStatusLine().getStatusCode() == 200){
            String content = EntityUtils.toString(response.getEntity(), "gbk");
            System.out.println(content);
            
            //使用Jsoup解析获得的字符串
            //解析字符串
            Document doc = Jsoup.parse(content);
             Elements element2 = doc.getElementsByClass("b_left").nextAll();
            Elements element = doc.getElementsByClass("b_left");



               System.out.println("nextAll:"+element2.text());

//.first得到该元素的第一个兄弟元素    .next是得到该元素的下一个兄弟元素

            List<String> nameList = new ArrayList<String>();
            Double[] price = new Double[20];
            for (Element link : element.next()) {
                System.out.println(link.text());
               nameList.add(link.text()) ;
            }

            for (Element link:element.next().next()){
                System.out.println(link.text());
            }

            for (Element link:element.next().next().next()){
                System.out.println(link.text());
                
            /*    int i=0;
                String aaa = link.text();
                String bbb = aaa.substring(1, aaa.length());
                double v = Double.parseDouble(bbb);
                price[i++] = v;
            }

            property pro = new property();     //道具实体对象
            List<property> list = new ArrayList<property>();
            for (int i=0; i< price.length; i++){
              pro.setName(nameList.get(i));
              pro.setPrice(price[i]);
              list.add(pro);     //封装好对象放入集合
            }
            //遍历集合
            System.out.println(list);

            for(property p: list){
                if(p.getName().equals("八荒遗风")){
                    if(p.getPrice()<15){
                        //八荒遗风单价小于15
                    }
                }

                if (p.getName().equals("凝魂珠（中）")){
                    if (p.getPrice()<50){

                    }
                }
*/

            }


        }

        response.close();
        httpClient.close();

    }


}
