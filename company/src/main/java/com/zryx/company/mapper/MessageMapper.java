package com.zryx.company.mapper;


import com.zryx.company.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {


    /**
     * message表的增删查改
     */

    public List<Message> getALLMessage();

    public int addMessage(Message message);

    public int delMessage(@Param("messageId") int messageId);

    public int updMessage(Message message);

    Message getMessageById(int messageId);

    List<Message> getMessageByPage(@Param("from") int from,@Param("size") int size);

    int dataCount();
}
