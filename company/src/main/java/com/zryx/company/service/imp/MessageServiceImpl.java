package com.zryx.company.service.imp;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.exception.CustomException;
import com.zryx.company.mapper.MessageMapper;
import com.zryx.company.model.Message;
import com.zryx.company.model.News;
import com.zryx.company.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private PageConfig<Message> pageConfig;

    @Override
    public List<Message> getAllMessage() {
        List<Message> messages = messageMapper.getALLMessage();
        return messages;
    }

    @Override
    public void delMessage(int id) {
        int row = messageMapper.delMessage(id);
        if(row == 0) {
            throw new CustomException(100,"删除新闻出现异常");
        }
    }

    @Override
    public void updMessage(Message message) {
       System.out.println(message.getMessageId());
        int row = messageMapper.updMessage(message);
        if(row == 0) {
            throw new CustomException(100,"修改新闻出现异常");
        }
    }

    @Override
    public void addMessage(Message message) {
        int row = messageMapper.addMessage(message);
        if(row == 0) {
            throw new CustomException(100,"增加新闻出现异常");
        }
    }

    @Override
    public Message getMessageById(int id) {
        Message messages = messageMapper.getMessageById(id);
        return messages;
    }

    @Override
    public PageConfig<Message> getMessageByPage(int page) {
        //设置当前页
        pageConfig.setPageNum(page);
        //得到从哪开始查询
        int from = (page - 1) * pageConfig.pageSize;
        //得到查几条
        int size = pageConfig.pageSize;
        //查出当前页的数据
        List<Message> messages = messageMapper.getMessageByPage(from,size);
        //设置当前页
        pageConfig.setPageData(messages);
        //得到总数据量
        int count = messageMapper.dataCount();
        //设置一共有几条数据
        pageConfig.setDataCount(count);
        //返回包含当前页的数据、当前页、总页数、总记录数的一个对象
        return pageConfig;
    }
}
