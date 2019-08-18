package com.zryx.company.service.imp;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.exception.CustomException;
import com.zryx.company.mapper.NewsMapper;
import com.zryx.company.model.News;
import com.zryx.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 123
 * @create 2019/7/17
 * @Service注解就是告诉spring容器，我这里有一个对象，你可以把它拿去用
 */
@Service
public class NewsServiceImpl implements NewsService {

    /**
     * 从spring容器当中得到NewsMapper对象，然后将该对象注入到newsMapper当中
     * 也就是说newsMapper就相当于是NewsMapper接口类型的一个对象了。
     */
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private PageConfig<News> pageConfig;

    /**
     * 查询并返回所有的新闻
     * @return
     */
    @Override
    public List<News> getAllNews() {
        List<News> news = newsMapper.getAllNews();
        return news;
    }

    @Override
    public void delNews(int id) {
        int row = newsMapper.delNews(id);
        if(row == 0) {
            throw new CustomException(100,"删除新闻出现异常");
        }
    }

    @Override
    public void updNews(News news) {
        int row = newsMapper.updNews(news);
        if(row == 0) {
            throw new CustomException(100,"修改新闻出现异常");
        }
    }

    @Override
    public void addNews(News news) {
        int row = newsMapper.addNews(news);
        if(row ==0){
            throw new CustomException(100,"插入新闻出现异常");
        }
    }

    @Override
    public News getNewsById(int id) {
        News news = newsMapper.getNewsById(id);
        return news;
    }

   @Override
    public List<News> selTop8News() {
        return newsMapper.selTop8News();
    }

    @Override
    public PageConfig<News> getNewsByPage(int page) {
        //设置当前页
        pageConfig.setPageNum(page);
        //得到从哪开始查询
        int from = (page - 1) * pageConfig.pageSize;
        //得到查几条
        int size = pageConfig.pageSize;
        //查出当前页的数据
        List<News> news = newsMapper.getNewsByPage(from,size);
        //设置当前页
        pageConfig.setPageData(news);
        //得到总数据量
        int count = newsMapper.dataCount();
        //设置一共有几条数据
        pageConfig.setDataCount(count);
        //返回包含当前页的数据、当前页、总页数、总记录数的一个对象
        return pageConfig;
    }
}
