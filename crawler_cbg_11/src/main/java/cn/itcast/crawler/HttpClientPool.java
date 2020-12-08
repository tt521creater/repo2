package cn.itcast.crawler;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientPool  {
    public static void main(String[] args) {
        //创建连接池管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

            //设置最大连接数
            cm.setMaxTotal(100);
            //设置每个主机最大连接数
        cm.setDefaultMaxPerRoute(10);

        //使用连接池发起请求
        try {
            doGet(cm);

            
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            doGet(cm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doGet(PoolingHttpClientConnectionManager cm) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        //创建httpGet对象
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");




         //配置请求信息
         RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)   //创建连接的最长时间，单位是毫秒
                .setConnectionRequestTimeout(500)   //设置获取连接的最长时间，单位是毫秒
                .setSocketTimeout(10*1000)      //设置数据传输的最长时间，单位是毫秒
                .build();
        //给请求设置请求信息
        httpGet.setConfig(config);




        //发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        if (response.getStatusLine().getStatusCode() == 200){
            //正常的话解析数据
            String content = EntityUtils.toString(response.getEntity(), "utf8");
            System.out.println(content.length());
        }

        if (response != null) response.close();



    }
}
