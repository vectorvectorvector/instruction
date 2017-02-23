package com.relax.controller;

import com.relax.WangYiNews;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by 周超 on 2017/02/10.
 */
@Controller
public class RelaxComtroller {

    private Logger log = Logger.getLogger(RelaxComtroller.class);

    @Resource
    private WangYiNews wangYiNews;

    @RequestMapping("/relax")
    public String relax() {
        log.info("开始爬取网易新闻...........");
//        wangYiNews.getNews();
        return "index";
    }
}
