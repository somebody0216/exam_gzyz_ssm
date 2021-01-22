package gzyz.Allmode.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import gzyz.Allmode.pojo.PageUtils;
import gzyz.Allmode.pojo.Question;
import gzyz.Allmode.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author jun
 * @date 2021/1/21-19:15
 */
@Controller
public class QuestionController {
    @Autowired
    QuestionService questionService;

    /**
     * 添加题目（OK）
     * @param question
     * @return
     * Question question   formData数据不成功
     */
    @RequestMapping("/question/ques/addQuestion")
    @ResponseBody
    public boolean addQuestion(@RequestBody Question question){
        System.out.println("/question/ques/addQuestion==》"+question);
        return questionService.addQuestion(question);
    }

    /**
     * 删除一个题目(OK)
     * @param question quesId
     * @return
     */
    @RequestMapping("/question/ques/delOneQuestion")
    @ResponseBody
    public boolean delOneQuestion(@RequestBody Question question){
        System.out.println(question.getQuesId());
        return questionService.delOneQuestion(question.getQuesId());
    }

    /**
     * 刪除多个题目(OK)
     * @param quesIds
     * @return
     */
    @RequestMapping("/question/ques/delManyQuestion/{quesIds}")
    @ResponseBody
    public boolean delManyQuestion(@PathVariable("quesIds") String quesIds){
        String[] quesIdsArr=quesIds.split(",");
        for (int i=0;i<quesIdsArr.length;i++){
            System.out.println(quesIdsArr[i]);
        }
       return questionService.delManyQuestion(quesIdsArr);
    }

    /**
     * 修改题目(OK)
     * @param question
     * @return
     */
    @RequestMapping("/question/ques/editQuestion")
    @ResponseBody
    public boolean editQuestion(@RequestBody Question question){
        System.out.println(question);
        return questionService.editQuestion(question);
    }

    /**
     * 根据id查询题目(分页)(OK)
     * @param map userId  offSet pageNumber
     * @return
     */
    @RequestMapping("/question/ques/queryQuestions")
    @ResponseBody
    public PageUtils queryQuestions(@RequestBody HashMap<String,String> map){
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s+": "+map.get(s));
        }
        /*必须在Service前*/
        PageHelper.offsetPage(Integer.parseInt(map.get("offSet")),Integer.parseInt(map.get("pageNumber")));

        List<Question> questionList = questionService.queryQuestions(map.get("userId"));

        PageInfo<Question> pageInfo=new PageInfo<Question>(questionList);
        return new PageUtils(new Long(pageInfo.getTotal()).intValue(),pageInfo.getList());
    }

    /**
     * 多条件查询(x)
     * @param map
     * @return
     */
    @RequestMapping("/question/ques/queryQuestionsByCondition")
    @ResponseBody
    public List<Question> queryQuestionsByCondition(@RequestBody HashMap<String,String> map){
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
             System.out.println(s+":" +map.get(s));
        }
        return questionService.queryQuestionsByCondition(map);
    }
}
