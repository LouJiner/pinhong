package com.zryx.company.service;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.model.Message;
import com.zryx.company.model.News;

import java.util.List;

/**
 * 针对新闻进行的业务处理
 * @author 123
 * @create 2019/7/17
 */
public interface MessageService {
    /**
     * 查询所有的新闻
     * @return
     */
    public List<Message> getAllMessage();

    public void delMessage(int id);

    public void updMessage(Message message);

    public void addMessage(Message message);

    Message getMessageById(int id);

    PageConfig<Message> getMessageByPage(int page);
}
