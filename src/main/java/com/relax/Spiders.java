package com.relax;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 周超 on 2017/02/21.
 */
@Service
public class Spiders implements InitializingBean {
    private Logger log = Logger.getLogger(Spiders.class);

    @Resource
    private WangYiNews wangYiNews;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("爬虫启动了....");
        wangYiNews.run();
    }
}
