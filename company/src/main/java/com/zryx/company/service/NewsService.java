package com.zryx.company.service;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.model.News;

import java.util.List;

/**
 * 针对新闻进行的业务处理
 * @author 123
 * @create 2019/7/17
 */
public interface NewsService {
    /**
     * 查询所有的新闻
     * @return
     */
    public List<News> getAllNews();

    /**
     * 根据id删除新闻
     * @param id
     * @return
     */
    public void delNews(int id);

    /**
     * 修改
     * @param news
     */
    public void updNews(News news);

    public void addNews(News news);

    News getNewsById(int id);

   List<News> selTop8News();

    PageConfig<News> getNewsByPage(int page);
}
