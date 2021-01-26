package gzyz.Allmode.controller;

import gzyz.Allmode.pojo.Paper;
import gzyz.Allmode.pojo.PaperStuGrade;
import gzyz.Allmode.pojo.StuPaperInfo;
import gzyz.Allmode.pojo.Student;
import gzyz.Allmode.service.PaperService;
import gzyz.Allmode.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jun
 * @date 2021/1/25-11:04
 */
@Controller
public class ExamController {
    @Autowired
    ExamService studentService;
    @Autowired
    PaperService paperService;
    @Autowired
    ExamService examService;
    /**
     * 添加学生
     * @param student
     * @return
     */
    @RequestMapping("/exam/addStudent")
    @ResponseBody
    public Map<String,String> addStudent(@RequestBody Student student){
        Student student1 = examService.addStudent(student);
        HashMap<String,String> map=new HashMap<>();
        if (student1!=null){
            map.put("flag","1");
            map.put("userId",student1.getStuId());
        }else {
            map.put("flag","0");
        }
        return map;
    }

    /**
     * 验证随机码
     * @param paper
     * @return
     */
    @RequestMapping("/exam/testRandNum")
    @ResponseBody
    public boolean queryByRandNum(@RequestBody Paper paper){
        return paperService.queryByRandNum(paper);
    }


    /**
     *保存学生试卷信息
     * @param  list
     * @return
     */
    @RequestMapping("/exam/addStuPaperInfo")
    @ResponseBody
    public boolean addStuPaperInfo(@RequestBody List<StuPaperInfo> list){
        return examService.addStuPaperInfo(list);
    }

    /**
     * 根据试卷查询学生成绩
     * @param pId
     * @return
     */
    @RequestMapping("/exam/queryGrageBypid")
    @ResponseBody
    public List<PaperStuGrade> queryGrageBypid(@RequestBody String pId){
        return  examService.queryGrageBypid(pId);
    }
}
