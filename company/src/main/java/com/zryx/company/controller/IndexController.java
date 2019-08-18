package com.zryx.company.controller;

import com.zryx.company.common.exception.CustomException;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.News;
import com.zryx.company.model.Product;
import com.zryx.company.model.Users;
import com.zryx.company.service.NewsService;
import com.zryx.company.service.ProductService;
import com.zryx.company.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 123
 * @create 2019/7/10
 */
@RestController
public class IndexController extends BaseController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;

    /**
     * 初始化首页新闻数据
     * @return
     */
    @PostMapping("/initNewss")
    public String initNews() {
        List<News> top8News = newsService.selTop8News();
        String result = dealQueryResult(top8News,top8News);
        return result;
    }


    /**
     * 聊天
     * @return
     */
    @PostMapping("/chat")
    public String chat(HttpSession session) {
        Users user = (Users)session.getAttribute("user");
        if(user==null) {
            throw new CustomException(1000,"您未曾登录");
        }
        return dealSuccessResutl("into chat",null);
    }

    @PostMapping("/login")
    public String login(HttpSession session, Users user) {
        Users dbUser = usersService.login(user.getUserName(),user.getPassword());
        if(dbUser!=null) {
            session.setAttribute("user",dbUser);
            List<Users> users = (List<Users>)session.getServletContext().getAttribute("users");
            if(users==null) {
                users = new ArrayList<Users>();
            }
            users.add(user);
            session.getServletContext().setAttribute("users",users);
            return dealSuccessResutl("login success",null);
        }
        throw new CustomException(1100,"登录失败，用户名或密码错误");
    }
}
