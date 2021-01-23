package gzyz.Allmode.controller;


import gzyz.Allmode.pojo.PaperClassify;
import gzyz.Allmode.service.PaperClassifyService;
import gzyz.Allmode.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class PaperClassifyController {

    @Autowired
    private PaperClassifyService paperClassifyService;

    @RequestMapping("/paper/queryAllClassify")
    public List<PaperClassify> queryAllClassify(@RequestBody PaperClassify paperClassify){
        return paperClassifyService.queryAllClassify(paperClassify.getUserId());
    }

    @RequestMapping("/paper/addClassify")
    @ResponseBody
    public boolean addClassify(@RequestBody PaperClassify paperClassify){
    PaperClassify pc = new PaperClassify();
    pc.setPcId(UUID.randomUUID().toString());
    pc.setPcName(paperClassify.getPcName());
    pc.setCreateTime(JDK8DateUtil.LocalDateTime2String(null,null));
    pc.setUserId(paperClassify.getUserId());
    return paperClassifyService.addClassify(pc);
    }


    @RequestMapping("/paper/delClassifyById")
    @ResponseBody
    public boolean delClassifyById(@RequestBody PaperClassify paperClassify){

        return paperClassifyService.delClassifyById(paperClassify.getPcId());
    }


    @RequestMapping("/paper/queryOneClassify")
    @ResponseBody
    public PaperClassify queryOneClassify(String pcId){
        return paperClassifyService.queryOneClassify(pcId);
    }

    @RequestMapping("/paper/editClassifyById")
    @ResponseBody
    public boolean editClassifyById(@RequestBody PaperClassify paperClassify){

        return paperClassifyService.editClassifyById(paperClassify);
    }
}
