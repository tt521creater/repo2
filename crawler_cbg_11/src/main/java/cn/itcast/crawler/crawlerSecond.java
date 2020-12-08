package cn.itcast.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class crawlerSecond {
    public static void main(String[] args) throws IOException {

        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建httpGet对象，设置URL地址
        HttpPost HttpPost = new HttpPost("http://www.itcast.cn/");
        //发起访问获得响应头
        CloseableHttpResponse response = httpClient.execute(HttpPost);
        //解析响应头
        if (response.getStatusLine().getStatusCode() == 200){
            String content = EntityUtils.toString(response.getEntity(), "utf8");
            System.out.println(content);
        }


        response.close();
        httpClient.close();

    }
}
