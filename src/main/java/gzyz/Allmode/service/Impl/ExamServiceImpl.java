package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.ExamDao;
import gzyz.Allmode.pojo.PaperStuGrade;
import gzyz.Allmode.pojo.StuPaperInfo;
import gzyz.Allmode.pojo.Student;
import gzyz.Allmode.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jun
 * @date 2021/1/25-11:04
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamDao examDao;
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public Student addStudent(Student student) {
        student.setStuId(UUID.randomUUID().toString());
        student.setCreateTime(dateFormat.format(new Date()));
        student.setIsDelete(0);
        if (examDao.addStudent(student)==1){
            return student;
        }else {
            return null;
        }
    }

    @Override
    public boolean addStuPaperInfo(List<StuPaperInfo> stuPaperInfos) {
        String stuId=stuPaperInfos.get(0).getStuId();
        String pId=stuPaperInfos.get(0).getpId();
        for (StuPaperInfo stuPaperInfo : stuPaperInfos) {
            stuPaperInfo.setSpiId(UUID.randomUUID().toString());
            stuPaperInfo.setCreateTime(dateFormat.format(new Date()));
            stuPaperInfo.setIsDelete(0);
            if (examDao.addStuPaperInfo(stuPaperInfo)!=1){
                return false;
            }
        }//单个学生成绩已经全部保存完毕

        //计算单个学生的总分并保存
        double score = examDao.querySumScore(stuId, pId);//学生总分
        PaperStuGrade paperStuGrade=new PaperStuGrade();
        paperStuGrade.setCreateTime(dateFormat.format(new Date()));
        paperStuGrade.setIsDelete(0);
        paperStuGrade.setpId(pId);
        paperStuGrade.setPsgGrade(score);
        paperStuGrade.setStuId(stuId);
        paperStuGrade.setPsgId(UUID.randomUUID().toString());
        examDao.addPaperStuGrade(paperStuGrade);

        return true;
    }

    @Override
    public List<Map<String,Object>> queryGrageBypid(String pid) {
        return examDao.queryAllGradeMsg(pid);
    }
}
