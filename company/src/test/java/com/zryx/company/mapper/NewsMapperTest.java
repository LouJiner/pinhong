package com.zryx.company.mapper;

import com.zryx.company.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * 这就是一个测试类，该类对应NewsMapper接口。那么它当中的方法就对
 * 应被测试的接口当中的所有方法@RunWith和@SpringBootTest注解将
 * springboot环境加载到当前测试类当中
 * @author 123
 * @create 2019/7/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsMapperTest {

    //@Autowired表示自动注入所需的对象
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 测试方法，该方法的命名规范是原来的被测试方法的后面增加Test后缀，
     * 同时该方法前要增加@Test注解。表示这个方法是一个测试方法。
     */
    @Test
    public void getAllNewsTest() {
        //调用接口当中的方法，获得所有的新闻。
        List<News> news = newsMapper.getAllNews();
        //增强for循环，它的作用是用来专门遍历集合或者数组的循环，其中的n就是集合当中的每个元素（每一条新闻）
        for(News n : news) {
            //直接输出n（News类型的对象）相当于调用它的toString方法。
            System.out.println(n);
        }
    }

    @Test
    public void addNewsTest() {
        News news = new News(0,"呜呜呜呜呜呜呜呜","啊啊啊啊啊啊啊啊啊 ",new Date());

        int row = newsMapper.addNews(news);
        if(row > 0) {
            System.out.println("添加成功");
        }
    }

    @Test
    public void delNewsTest() {
        int row = newsMapper.delNews(13);
        if(row > 0) {
            System.out.println("删除成功！");
        }
    }

    @Test
    public void updNewsTest() {
        News news = new News(11,"使用idea+mybatis添加新闻","新闻很好看",new Date());
        int row = newsMapper.updNews(news);
        if(row > 0) {
            System.out.println("更新成功");
        }
    }
}
