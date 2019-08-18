package com.zryx.company.controller;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.News;
import com.zryx.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 123
 * @create 2019/7/17
 * 创建控制器，增加@RestController表示该类是一个后台控制器
 */
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    NewsService newsService;

    /**
     * 后台控制器当中的一个方法，该方法用来进行查询并返回一个json
     * @PostMapping用来处理post请求
     * @return 向客户端返回json格式的字符串
     */
    @PostMapping("/initNews")
    public String initNews(@RequestParam(value="page",required = false,defaultValue = "1") Integer page) {
        //List<News> news = newsService.getAllNews();
        PageConfig pageConfig = newsService.getNewsByPage(page);
        String json = dealQueryResult(pageConfig,pageConfig);
        logger.debug("json===>" + json);
        return json;
    }

    @PostMapping("/initNews11")
    public String initNews() {
        List<News> news = newsService.getAllNews();
        String json = dealQueryResult(news,news);
        logger.debug("json===>" + json);
        return json;
    }

    @PostMapping("/delNews")
    public String delNews(int id) {
        newsService.delNews(id);
        return dealSuccessResutl("删除成功",null);
    }

    @PostMapping("/updNews")
    public String updNews(News news) {
        newsService.updNews(news);
        return dealSuccessResutl("修改成功",null);
    }

    @PostMapping("/addNews")
    public String addNews(News news){
        newsService.addNews(news);
        return dealQueryResult("插入成功",null);
    }

    @PostMapping("/getNewsById")
      public String getNewsById (int id){
        News news = newsService.getNewsById(id);
        String json = dealQueryResult(news,news);
        logger.debug("json===>" + json);
        return json;
        }
}
