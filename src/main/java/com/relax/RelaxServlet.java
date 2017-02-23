package com.relax;

import java.io.IOException;
import java.util.Timer;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * 每个一段时间爬取新闻保存到数据库中
 */

public class RelaxServlet extends HttpServlet {

    private Timer timer;

    public RelaxServlet() {
        timer = new Timer();
    }

    public void init() throws ServletException {
        timer.schedule(new RelaxSpider(), 1000, 60000); // 2秒执行一次
    }

    public void doGet(HttpServletRequest httpservletrequest,
                      HttpServletResponse httpservletresponse) throws ServletException,
            IOException {
    }

    public void destory() {
        timer.cancel();
    }
}