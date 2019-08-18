package com.zryx.company.service;

import com.zryx.company.model.Revert;

import java.util.List;

public interface RevertService {

    /**
     * 根据messageId查询回帖消息
     * @return
     */
    List<Revert> getRevertByMessageId(int messageId);

    void addRevert(Revert revert);

    void delRevert(int id);
}
