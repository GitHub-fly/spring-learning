package com.soft1851.spring.web.util;

import com.soft1851.spring.web.entity.Book;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xunmi
 * @ClassName WangYiYunYueDuSpider
 * @Description TODO
 * @Date 2020/3/28
 * @Version 1.0
 **/
public class WangYiYunYueDuSpider {


    /**
     * 解析 HTML 模板一
     */
    public static void getData() {
        String url = "https://yuedu.163.com/book/rank/pv/week/p4/s20";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpClient.execute(httpGet, context);

            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity);
            Document document = Jsoup.parse(res);
            System.out.println(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析 HTML 模板二
     *
     * @return List<Book>
     */
    public static List<Book> getYueDuData() {
        List<Book> list = new ArrayList<>();
        Document document = null;
        try {
            for (int i = 1; i <= 5; i++) {
                document = Jsoup.connect("https://yuedu.163.com/book/rank/pv/week/p" + i + "/s20").get();
                Thread.sleep(2 * 1000);
                Elements div = document.getElementsByClass("yd-rank-bookitem");
                div.forEach(item -> {
                    String cover = item.child(1).child(0).attr("src");
                    String title = item.child(1).child(1).text();
                    String author = item.child(1).child(2).text();
                    String description = item.child(1).child(3).child(0).text();
                    Book book = Book.builder()
                            .title(title)
                            .author(author)
                            .cover(cover)
                            .description(description)
                            .build();
                    list.add(book);
                });
            }
            document.clone();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void main(String[] args) {
        getYueDuData();
    }
}
