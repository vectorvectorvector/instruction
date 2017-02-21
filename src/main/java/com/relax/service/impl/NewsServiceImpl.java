package com.relax.service.impl;

import com.relax.dao.NewsDao;
import com.relax.model.News;
import com.relax.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsDao newsDao;

    public News selectNewsById(int newsId) {
        return newsDao.selectNewsById(newsId);
    }

    public News selectNewsByChannelName(String channelName) {
        return newsDao.selectNewsByChannelName(channelName);
    }

    public List<News> getAllNews() {
        return newsDao.selectAllNews();
    }

    public int insertNews(News news){
        return newsDao.insertNews(news);
    }
}
