package gzyz.Allmode.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import gzyz.Allmode.pojo.PageUtils;
import gzyz.Allmode.pojo.PapQues;
import gzyz.Allmode.pojo.Paper;
import gzyz.Allmode.pojo.Question;
import gzyz.Allmode.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;

    /*@RequestMapping("/paper/queryAllPapers")
    @ResponseBody
    public List<Paper> paperQueryAllPapers(String userId){
        return paperService.queryAllPapers(userId);
    }*/
    @RequestMapping("/paper/queryAllPapers")
    @ResponseBody
    public PageUtils paperQueryAllPapers(@RequestBody Map<String,String> map){
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key+"  "+map.get(key));
        }
        /*必须在Service前*/
        PageHelper.offsetPage(Integer.parseInt(map.get("offSet")),Integer.parseInt(map.get("pageNumber")));
        List<Paper> paperList = paperService.queryAllPapers(map.get("userId"));
        PageInfo<Paper> pageInfo=new PageInfo<Paper>(paperList);
        return new PageUtils(new Long(pageInfo.getTotal()).intValue(),pageInfo.getList());
    }

    @RequestMapping("/paper/addPaper")
    @ResponseBody
    public boolean addPaper(Paper paper){

        return paperService.addPaper(paper);
    }

    @RequestMapping("/paper/delOnePaper/{pId}")
    @ResponseBody
    public boolean delOnePaper(@PathVariable("pId") String pId){

        return paperService.delOnePaper(pId);
    }


    @RequestMapping("/paper/queryPaperBypid")
    @ResponseBody
    public Paper queryPaperBypid(@RequestBody Paper paper){
        return paperService.queryPaperBypid(paper.getpId());
    }


    @RequestMapping("/paper/editPaperById")
    @ResponseBody
    public boolean editPaperById(@RequestBody Paper paper){

        return paperService.editPaperById(paper) ;
    }


    @RequestMapping("/paper/delManyPaper/{pIds}")
    @ResponseBody
    public Boolean delManyPaper(@PathVariable("pIds") String pIds){
        String[] pIdsArr=pIds.split(",");
        for (int i=0;i<pIdsArr.length;i++){
            System.out.println(pIdsArr[i]);
        }
        return paperService.delManyPaper(pIdsArr);
    }


//    查询试卷上的试题信息
//    @RequestMapping("/paper/queryAllQuesByPid")
//    @ResponseBody
//    public List<Question> queryAllQuesByPid(@RequestBody Paper paper){
//        return paperService.queryAllQuesByPid(paper.getpId());
//    }

    @RequestMapping("/paper/queryAllQuesByPid")
    @ResponseBody
    public List<Map<String,Object>> queryAllQuesByPid(@RequestBody Paper paper){
        return paperService.queryAllQuesByPid(paper.getpId());
    }


//    向试卷中添加一个试题
    @RequestMapping("/paper/addOneQuestion")
    @ResponseBody
    public Boolean addOneQuestion(@RequestBody PapQues papQues){
        return paperService.addOneQuestion(papQues);
    }


    /*@RequestMapping("/paper/addManyQuestion")
    @ResponseBody
    public Boolean addManyQuestion(@RequestBody Map<String,String> pqMap){
        String pId = pqMap.get("pId");
        String[] quesIdsArr=pqMap.get("quesIds").split(",");
        Map<String,String> map = new HashMap<String,String>();
        List<Map<String,String>> pqList = new ArrayList<Map<String,String>>();
        for(String quesId:quesIdsArr){
            map.put("pId",pId);
            map.put("quesId",quesId);
            pqList.add(map);
        }
        return paperService.addManyQuestion(pqList);

    }*/

    @RequestMapping("/paper/addManyQuestion")
    @ResponseBody
    public Boolean addManyQuestion(@RequestBody Map<String,String> pqMap){
        String pId = pqMap.get("pId");
        String userId=pqMap.get("userId");
        String[] quesIdsArr=pqMap.get("quesIds").split(",");
        return paperService.addManyQuestion(userId,pId,quesIdsArr);

    }


    @RequestMapping("/paper/delQuestion")
    @ResponseBody
    public Boolean delQuestion(@RequestBody Map<String,String> map){
        String pId = map.get("pId");
        String quesIds = map.get("quesIds");
        String[] quesIdsArr = quesIds.split(",");
        return paperService.delQuestion(pId,quesIdsArr);
    }
}
