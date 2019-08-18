package com.zryx.company.service.imp;

import com.zryx.company.common.exception.CustomException;
import com.zryx.company.mapper.RevertMapper;
import com.zryx.company.model.Revert;
import com.zryx.company.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevertServiceImpl implements RevertService {

    @Autowired
    RevertMapper revertMapper;

    @Override
    public List<Revert> getRevertByMessageId(int messageId) {
        List<Revert> reverts = revertMapper.getRvertByMessageId(messageId);

        return reverts;
    }

    @Override
    public void addRevert(Revert revert) {
        int row = revertMapper.addRevert(revert);
        if(row ==0){
            throw new CustomException(100,"插入回复出现异常");
        }
    }

    @Override
    public void delRevert(int id) {
        int row = revertMapper.delRevert(id);
        if(row == 0) {
            throw new CustomException(100,"删除回复出现异常");
        }
    }

}
