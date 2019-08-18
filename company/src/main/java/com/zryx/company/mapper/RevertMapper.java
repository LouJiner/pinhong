package com.zryx.company.mapper;

import com.zryx.company.model.Revert;

import java.util.List;

public interface RevertMapper {

    /**
     * 根据消息ID查询回帖
     * @param id
     * @return
     */
    List<Revert> getRvertByMessageId(int id);

    int delRevert( int revertId);

    int addRevert(Revert revert);
}
