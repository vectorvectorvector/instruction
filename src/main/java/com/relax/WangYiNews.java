package com.relax;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.relax.model.News;
import com.relax.service.NewsService;
import com.relax.util.HttpUtil;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 周超 on 2017/02/21.
 */
@Service
public class WangYiNews implements Runnable {
    @Resource
    private NewsService newsService;

    @Resource
    private HttpUtil httpUtil;

    @Value("#{spiderConfig['wangyi_news']}")
    public String wangyi_news;

    @Value("#{spiderConfig['wangyi_news_details']}")
    private String wangyi_news_details;

    @Value("#{spiderConfig['page']}")
    private int page;//当前页数

    @Value("#{spiderConfig['limit']}")
    private int limit;//新闻条数

    // 1 war 军事; 2	sport 体育; 3 tech 科技; 4 edu 教育; 5 ent 娱乐; 6 money 财经; 7 gupiao 股票; 8 travel 旅游; 9 lady	女人
    private String type;//新闻类型
    private String[] types = {"war", "sport", "tech", "edu", "ent", "money", "gupiao", "travel", "lady"};
    private int simpleId;//查看详细内容的

    /**
     * 爬取新闻保存到数据库中
     *
     * @return
     */
    public void getNews() {
        while (true) {
            for (String type : types) {
                HttpResponse response = httpUtil.get(wangyi_news + "type=" + type + "&page=" + page + "&limit=" + limit);
                String jsonString = response.toString();
                JSONObject object = JSON.parseObject(jsonString);
                JSONArray array = object.getJSONArray("list");
                List<News> lists = JSON.parseArray(array.toJSONString(),News.class);
                for (News news:lists) {
                    newsService.insertNews(news);
                }
            }
        }
    }

    @Override
    public void run() {
        getNews();
    }
}
