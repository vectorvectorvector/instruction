package com.relax;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 周超 on 2017/02/21.
 */
@Service
public class Spiders implements InitializingBean,ApplicationContextAware {
    private Logger log = Logger.getLogger(Spiders.class);

//    private WangYiNews wangYiNews = new WangYiNews();

    private ApplicationContext context;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("爬虫启动了....");
//        WangYiNews wangYiNews=new WangYiNews(context);
//        wangYiNews.run();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
