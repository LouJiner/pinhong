package com.zryx.company.mapper;

import com.zryx.company.model.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 123
 * @create 2019/7/16
 */
public interface NewsMapper {

    /**
     * 获得所有的新闻
     * @return 以List<News>集合的形式返回新闻列表
     */


    public List<News> getAllNews();

    /**
     * 添加新闻
     * @param news
     * @return
     */
    public int addNews(News news);

    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    public int delNews(@Param("nId") int newsId);

    /**
     * 更新新闻
     * @param news
     * @return
     */
    public int updNews(News news);

    /**
     * 根据id查找news
     * @param id
     * @return
     */
    News getNewsById(int id);

    public List<News> selTop8News();

    List<News> getNewsByPage(@Param("from") int from,@Param("size") int size);

    int dataCount();
}
