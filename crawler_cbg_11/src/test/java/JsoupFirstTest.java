import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import pro.attr;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class JsoupFirstTest {
    
    @Test
    public void test() throws Exception{
        //参数： 地址，  超时时间
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"), 3000);
    
        //使用标签选择器,获取title标签的内容
        String content = doc.getElementsByTag("title").first().text();

        System.out.println(content);
    }

    @Test
    public void testString() throws  Exception{
        //使用工具类读取文件获取字符串
        String content = FileUtils.readFileToString(new File("C:\\Users\\Administrator.DESKTOP-7MTTGFI\\Desktop\\dh.html"), "gbk");

        //解析字符串


    }

    @Test
    public void testFile() throws Exception{
        //解析文件
        Document doc = Jsoup.parse(new File("C:\\Users\\Administrator.DESKTOP-7MTTGFI\\Desktop\\dh.html"), "gbk");
        //使用标签选择器,获取title标签的内容
        String text = doc.getElementsByTag("script").nextAll().text();
        
        System.out.println(text);
    }

    @Test
    public void testDOM() throws Exception{
        //解析DOM

        //1.获取Document对象
        Document doc = Jsoup.parse(new File("C:\\Users\\Administrator.DESKTOP-7MTTGFI\\Desktop\\dh.html"), "gbk");


        //2.获取元素
        //根据id查询元素getElemenById
     //   Element element = doc.getElementById("mhb_desc_12014");

        //根据标签获取元素
    //    Elements element = doc.getElementsByTag("script").nextAll();

        //根据class获取元素
       Elements element = doc.getElementsByClass("td.b_right");
    System.out.println(element.text());
    
        //4.	根据属性获取元素getElementsByAttribute
     //   Elements element = doc.getElementsByAttribute("mhb_desc_4_dhbdesc_12014").nextAll();

       // System.out.println("获取到的内容为："+element.text());
    }

    @Test
    public void testData() throws Exception{
        //解析文件，获取Document
        Document doc = Jsoup.parse(new File("C:\\Users\\Administrator.DESKTOP-7MTTGFI\\Desktop\\公式.html"), "gbk");
        //根据类名获取元素
        Elements element2 = doc.getElementsByClass("b_left").nextAll();   //接下来所有的兄弟元素
       Elements element = doc.getElementsByClass("b_left");     //所有的同样的元素
        Elements priceclass = doc.getElementsByClass("equip_icon");
        //根据属性获取元素，在根据元素获取属性

        Elements el = doc.getElementsByClass("Catalog-list-pages");
        System.out.println(""+el.text());//共32页 第1页 1 2 3 4 5 下一页 末页slfdjjsfn
        for (Element e: priceclass){
            System.out.println(""+e.attr("data_price"));
        }




        //     System.out.println(link.text());


        
//.first得到该元素的第一个兄弟元素    .next是得到该元素的下一个兄弟元素

       for (Element link : element.next().next()) {
          System.out.println(link.text());

        }

/*{ "desc":"","iType":108001,"cGblKey":"5uI0000NdXX","iAmount":40}
{ "desc":"","iType":108001,"cGblKey":"5uI0000NdJF","iAmount":40}
{ "desc":"","iType":108001,"cGblKey":"5uI0000NdIE","iAmount":40}
* */

        for (Element link:element){
            System.out.println(link.text());
        }
        for (Element link:element.next().next().next().next()){
            System.out.println(link.text());
        }
        for (Element link:element2.next().next().next()){
            System.out.println("element2....."+link.text());
        }

       String str = "";
        //1.元素中获取数据
      //  str = element.id();
        
        //2.从元素中获取className
        //str = element.className();
        
        //3.从元素中获取属性的值      ????      ?????     ?????
        //str = element.attr("class");
        //str = element.attr("id");

        //4.从元素中获取所有属性
      //  Attributes attributes = element.attributes();
    //    System.out.println(attributes.toString());

        //从元素中获取文本内容
    //    str = element.text();


    //    System.out.println("获取到的内容为："+element.text());

    }

    @Test
    public void testSelector() throws Exception{
        //解析html文件，获取Document对象
    }



    @Test
    public void testA(){
        String aaa = "*155*";
        String bbb = aaa.substring(1, aaa.length());
        System.out.println(bbb);

      //  double b = Double.parseDouble(bbb);
        String ccc = bbb.substring(0, bbb.length()-1);
        System.out.println(ccc);

        
        String a = "";
        System.out.println(a.length());
        
        if (a.equals(null)){
            System.out.println("是的");
            
        }
   
    }
}
