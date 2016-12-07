package com.laowang;

import com.google.gson.Gson;
import com.laowang.utils.User;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 * 用户流  后端防止要在servlet前加验证码验证,防止这些机器语言
 */
public class text {
    public static void main(String[] args) throws IOException {
        User user = new User(1,"LISI","BEIJING");
        String json = new Gson().toJson(user);
        System.out.println(json);



        /*CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("");
        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("userName","jack"));
        pairs.add(new BasicNameValuePair("address","usa"));
        httpPost.setEntity(new UrlEncodedFormEntity(pairs));

        for(int i = 0;i < 5;i++) {
            httpClient.execute(httpPost);
        }
*/


       /*//用来跨域调用的输入流
        //创建一个可以发出请求的客服端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个GET请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        //发出请求兵接收服务端的响应
        HttpResponse response = httpClient.execute(httpGet);
        //获取HTTP响应的状态码
        int statuscode = response.getStatusLine().getStatusCode();
        if(statuscode == 200){
            InputStream inputStream = response.getEntity().getContent();
            Str00.ing result = IOUtils.toString(inputStream,"UTF-8");

            inputStream.close();
            System.out.println(result);
        }else {
            System.out.println("服务器异常"+statuscode);
        }
        httpClient.close();*/


    }
}
