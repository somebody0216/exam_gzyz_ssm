package gzyz.Allmode.controller;


import gzyz.Allmode.pojo.PaperClassify;
import gzyz.Allmode.service.PaperClassifyService;
import gzyz.Allmode.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class PaperClassifyController {

    @Autowired
    private PaperClassifyService paperClassifyService;

    /*@RequestMapping("/paper/queryAllClassify")
    public List<PaperClassify> queryAllClassify(@RequestBody PaperClassify paperClassify){
        return paperClassifyService.queryAllClassify(paperClassify.getUserId());
    }*/

    @RequestMapping("/paper/queryAllClassify/{userId}")
    @ResponseBody
    public List<PaperClassify> queryAllClassify(@PathVariable String userId){
        return paperClassifyService.queryAllClassify(userId);
    }

    @RequestMapping("/paper/addClassify")
    @ResponseBody
    public boolean addClassify(@RequestBody PaperClassify paperClassify){
    PaperClassify pc = new PaperClassify();
    pc.setPcId(UUID.randomUUID().toString());
    pc.setPcName(paperClassify.getPcName());
    pc.setCreateTime(JDK8DateUtil.LocalDateTime2String(null,null));
    pc.setUserId(paperClassify.getUserId());
    pc.setIsDelete(0);
    return paperClassifyService.addClassify(pc);
    }


    @RequestMapping("/paper/delClassifyById")
    @ResponseBody
    public boolean delClassifyById(@RequestBody PaperClassify paperClassify){

        return paperClassifyService.delClassifyById(paperClassify.getPcId());
    }


    @RequestMapping("/paper/queryOneClassify")
    @ResponseBody
    public PaperClassify queryOneClassify( PaperClassify paperClassify){
        System.out.println("进入queryOneClasify接口");
        System.out.println(paperClassifyService.queryOneClassify(paperClassify.getPcId()));
        return paperClassifyService.queryOneClassify(paperClassify.getPcId());
    }

    @RequestMapping("/paper/editClassifyById")
    @ResponseBody
    public boolean editClassifyById(@RequestBody PaperClassify paperClassify){

        return paperClassifyService.editClassifyById(paperClassify);
    }
}
