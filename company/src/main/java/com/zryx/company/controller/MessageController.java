package com.zryx.company.controller;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.Message;
import com.zryx.company.model.News;
import com.zryx.company.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController extends BaseController {

    @Autowired
     MessageService messageService;

    @PostMapping("/initMessage")
    public String initMessage(@RequestParam(value="page",required = false,defaultValue = "1") Integer page) {
        //List<News> news = newsService.getAllNews();
        PageConfig pageConfig = messageService.getMessageByPage(page);
        String json = dealQueryResult(pageConfig,pageConfig);
        logger.debug("json===>" + json);
        return json;
    }


    @PostMapping("/delMessage")
    public String delMessage(int id) {
        messageService.delMessage(id);
        return dealSuccessResutl("删除成功",null);
    }

    @PostMapping("/updMessage")
    public String updMessage(Message message) {
        messageService.updMessage(message);
        return dealSuccessResutl("修改成功",null);
    }

    @PostMapping("/addMessage")
    public String addMessage(Message message){
        messageService.addMessage(message);
        return dealQueryResult("插入成功",null);
    }

    @PostMapping("/getMessageById")
    public String getMessageById (int id){
        Message message = messageService.getMessageById(id);
        String json = dealQueryResult(message,message);
        logger.debug("json===>" + json);
        return json;
    }
}
