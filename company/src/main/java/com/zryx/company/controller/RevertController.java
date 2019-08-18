package com.zryx.company.controller;

import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.News;
import com.zryx.company.model.Revert;
import com.zryx.company.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/revert")
public class RevertController extends BaseController {

    @Autowired
    RevertService revertService;

    @PostMapping("/getRevertByMessageId")
    public String getRevertByMessageId(int id) {
        List<Revert> reverts = revertService.getRevertByMessageId(id);
        String json = dealQueryResult(reverts,reverts);
        logger.debug("json===>" + json);
        return json;
    }

    @PostMapping("/addRevert")
    public String addNews(Revert revert){
        revertService.addRevert(revert);
        return dealQueryResult("插入成功",null);
    }

    @PostMapping("/delRevert")
    public String delRevert(int id) {
        revertService.delRevert(id);
        return dealSuccessResutl("删除成功",null);
    }


}
