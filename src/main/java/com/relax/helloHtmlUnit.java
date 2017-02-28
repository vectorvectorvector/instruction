package com.relax;

/**
 * Created by 周超 on 2017/02/28.
 */
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlBody;
import java.util.List;

public class helloHtmlUnit{
    public static void main(String[] args) throws Exception{
        String str;
        //创建一个webclient
        WebClient webClient = new WebClient();
        //htmlunit 对css和javascript的支持不好，所以请关闭之
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        //获取页面
//        HtmlPage page = webClient.getPage("http://www.baidu.com/");
        HtmlPage page = webClient.getPage("http://coral.qq.com/1787868177");
        //获取页面的TITLE
        str = page.getTitleText();
        System.out.println(str);
        //获取页面的XML代码
        str = page.asXml();
        System.out.println(str);
        //获取页面的文本
        str = page.asText();
        System.out.println("----------------页面文本-------------------");
        System.out.println(str);
        //关闭webclient
        webClient.close();
//        webClient.closeAllWindows();
    }
}