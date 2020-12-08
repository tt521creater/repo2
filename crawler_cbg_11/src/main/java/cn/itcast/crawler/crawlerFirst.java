package cn.itcast.crawler;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class crawlerFirst {
    public static void main(String[] args) throws IOException {
        //1.打开浏览器
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //2.设置uri
        HttpGet httpGet = new HttpGet("https://dh2.cbg.163.com/cgi-bin/equipquery.py?searck_text=八荒遗风");

        //3.发起请求,获取响应头
        CloseableHttpResponse response = httpclient.execute(httpGet);

        //4.解析响应头
        if( response.getStatusLine().getStatusCode() == 200){
            //获取响应体
            HttpEntity entity = response.getEntity();
          String str = EntityUtils.toString(entity, "gbk");
            System.out.println(str);
        }



    }
}
