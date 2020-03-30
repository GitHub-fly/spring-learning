package com.soft1851.spring.web.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Author;
import com.soft1851.spring.web.entity.Bo;
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
 * @ClassName ZhiHuSpider
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
public class ZhiHuSpider {
    public static List<Bo> getBooks() {
        ArrayList<Bo> list = new ArrayList<Bo>();
        // 目标地址
        String url = "https://www.zhihu.com/api/v3/books/categories/147?version=v2&limit=5&sort_by=read_count_7days&offset=15";
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
        assert response != null;
        if (response.getStatusLine().getStatusCode() == 200) {
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
            // 获取 data 中的数据
            JSONArray array = jsonObject.getJSONArray("data");

            array.forEach(item -> {
                // 遍历
                JSONObject json = JSONObject.parseObject(item.toString());
                JSONArray authors = json.getJSONArray("authors");
                // 存放 “authors” 字段的集合
//                List<Author> listAuthor = new ArrayList<>(10);
//                // 获取数据（authors）
//                authors.forEach(author -> {
//                    JSONObject authorJson = JSONObject.parseObject(author.toString());
//                    Author au = Author.builder()
//                            .avatarUrl(authorJson.getString("avatar_url"))
//                            .gender((authorJson.getInteger("gender")))
//                            .name(authorJson.getString("name"))
//                            .id(authorJson.getString("id"))
//                            .type(authorJson.getString("type"))
//                            .url(authorJson.getString("url"))
//                            .build();
//                    listAuthor.add(au);
//                });
                Bo bo = Bo.builder()
                        .skuId(json.getString("sku_id"))
                        .type(json.getString("type"))
                        .description(json.getString("description"))
                        .title(json.getString("title"))
                        .url(json.getString("url"))
                        .cover(json.getString("cover"))
                        .bookSize(json.getInteger("book_size"))
                        .id(json.getInteger("id"))
                        .isOwn(json.getBoolean("is_own"))
//                        .authors(listAuthor)
                        .bookVersion(json.getString("book_version"))
                        .cornerText(json.getString("corner_text"))
                        .name(JSONObject.parseObject(json.getJSONArray("authors").get(0).toString()).getString("name"))
                        .build();
                list.add(bo);
            });
        }
        return list;
    }

    public static void main(String[] args) {
//        getBooks();
        getBooks().forEach(System.out::println);
    }
}
