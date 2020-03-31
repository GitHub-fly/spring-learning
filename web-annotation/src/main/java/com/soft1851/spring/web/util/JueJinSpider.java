package com.soft1851.spring.web.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xunmi
 * @ClassName JueJinSpider
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
public class JueJinSpider {
    private static final Integer SUCCESS = 200;

    /**
     * 爬取 掘金 中的专题数据
     * @return 数据集
     */
    public static List<Topic> getTopics() {
        List<Topic> topicList = new ArrayList<>();
        // 目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7d5d79f265da794d4a6825&device_id=1585274233791&token=eyJhY2Nlc3NfdG9rZW4iOiJQWGVqQzE4QlNFbEFrM1dOIiwicmVmcmVzaF90b2tlbiI6IjRhS1FOdnJvNHNrSENUZ0MiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        // 创建 HttpClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建 get 对象
        HttpGet get = new HttpGet(url);
        // 创建 context 对象
        HttpClientContext context = HttpClientContext.create();
        // 创建 response 对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 如果请求成功，则获取网页源码
        assert response != null;
        if (response.getStatusLine().getStatusCode() == SUCCESS) {
            // 获取相应对象实体，并转成 UTF-8 字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 将字符串转为 JSON 对象
            JSONObject jsonObject = JSONObject.parseObject(res);

            // getXxx() 方法，表示从 JSON 对象中获取 “键” 的值，返回值为 String 类型
            JSONArray list= jsonObject.getJSONObject("d").getJSONArray("list");
            // 遍历数组
            list.forEach(item -> {
                // 遍历过程中，将每一个对象(Java类型)拿出转为 JSONObject
                JSONObject json = JSONObject.parseObject(item.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followersCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topicList.add(topic);
            });
        } else {
            System.out.println("请求失败" + response.getStatusLine());
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topicList;
    }



    public static List<Topic> getData() {
        List<Topic> topicList = new ArrayList<>();
        // 目标地址
        String url = "https://xiaoce-timeline-api-ms.juejin.im/v1/getListByLastTime?uid=5dc985d9f265da4d2b350fa9&client_id=1585185008570&token=eyJhY2Nlc3NfdG9rZW4iOiJpNlBwdHI1SE91dldtZmcyIiwicmVmcmVzaF90b2tlbiI6IjNTRjk2NEJLbE5VZ3o1azgiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&alias=&pageNum=1";
        // 创建 HttpClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建 get 对象
        HttpGet get = new HttpGet(url);
        // 创建 context 对象
        HttpClientContext context = HttpClientContext.create();
        // 创建 response 对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 如果请求成功，则获取网页源码
        assert response != null;
        if (response.getStatusLine().getStatusCode() == SUCCESS) {
            // 获取相应对象实体，并转成 UTF-8 字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(res);
            // 将字符串转为 JSON 对象
            JSONObject jsonObject = JSONObject.parseObject(res);
            System.out.println(jsonObject);

            // getXxx() 方法，表示从 JSON 对象中获取 “键” 的值，返回值为 String 类型
            JSONArray list = jsonObject.getJSONArray("d");
            // 遍历数组
            list.forEach(item -> {
                // 遍历过程中，将每一个对象(Java类型)拿出转为 JSONObject
                JSONObject json = JSONObject.parseObject(item.toString());
                System.out.println(JSONObject.parseObject(json.get("userData").toString()).getString("username"));
            });
        } else {
            System.out.println("请求失败" + response.getStatusLine());
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topicList;
    }

    public static void main(String[] args) {
//        getTopics().forEach(System.out::println);
        getData();
//        getTopics();
    }
}
