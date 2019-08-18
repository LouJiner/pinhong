package com.zryx.company.controller;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.Users;
import com.zryx.company.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController extends BaseController {

    @Autowired
    UsersService usersService;

    @PostMapping("/initUsers")
    public String initUsers(@RequestParam(value="page",required = false,defaultValue = "1") Integer page) {
        //List<News> news = newsService.getAllNews();
        PageConfig pageConfig = usersService.getUsersByPage(page);
        String json = dealQueryResult(pageConfig,pageConfig);
        logger.debug("json===>" + json);
        return json;
    }

    @PostMapping("/delUsers")
    public String delUsers(int id){
        usersService.delUsers(id);
        return dealSuccessResutl("删除成功",null);
    }

    @PostMapping("/addUsers")
    public String addUsers(Users users){
        usersService.addUsers(users);
        return dealSuccessResutl("添加成功",null);
    }

    @PostMapping("/updUser")
    public String updNews(Users users) {
        usersService.updUsers(users);
        return dealSuccessResutl("修改成功",null);
    }

    @PostMapping("/loginInspection")
    public int loginInspection(String userName,String password){
        int result =  usersService.loginInspection(userName,password);
        return result;
    }

    @PostMapping("/getUserByName")
    public String getUserByName(String name)
    {
        Users users = usersService.getUserByName(name);
        String json = dealQueryResult(users,users);
        logger.debug("json===>" + json);
        return json;
    }


}
