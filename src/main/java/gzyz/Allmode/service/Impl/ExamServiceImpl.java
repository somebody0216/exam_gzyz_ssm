package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.ExamDao;
import gzyz.Allmode.pojo.PaperStuGrade;
import gzyz.Allmode.pojo.StuPaperInfo;
import gzyz.Allmode.pojo.Student;
import gzyz.Allmode.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public boolean addStuPaperInfo(StuPaperInfo stuPaperInfo) {
        stuPaperInfo.setSpiId(UUID.randomUUID().toString());
        stuPaperInfo.setCreateTime(dateFormat.format(new Date()));
        stuPaperInfo.setIsDelete(0);
        return examDao.addStuPaperInfo(stuPaperInfo)==1;
    }

    @Override
    public List<PaperStuGrade> queryGrageBypid(String pid) {
        List<String> StudIds = examDao.queryAllStudent(pid);
        ArrayList<PaperStuGrade> list=new ArrayList<>();
        for (String studId : StudIds) {
            double score = examDao.querySumScore(studId, pid);
            PaperStuGrade paperStuGrade=new PaperStuGrade();
            paperStuGrade.setCreateTime(dateFormat.format(new Date()));
            paperStuGrade.setIsDelete(0);
            paperStuGrade.setpId(pid);
            paperStuGrade.setPsgGrade(score);
            paperStuGrade.setStuId(studId);
            paperStuGrade.setPsgId(UUID.randomUUID().toString());
            list.add(paperStuGrade);
        }
        return list;
    }
}
