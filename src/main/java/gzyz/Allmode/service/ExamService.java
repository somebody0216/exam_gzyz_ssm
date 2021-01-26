package gzyz.Allmode.service;

import gzyz.Allmode.pojo.PaperStuGrade;
import gzyz.Allmode.pojo.StuPaperInfo;
import gzyz.Allmode.pojo.Student;

import java.util.List;

/**
 * @author jun
 * @date 2021/1/25-11:03
 */
public interface ExamService {
    public Student addStudent(Student student);
    public boolean addStuPaperInfo(StuPaperInfo stuPaperInfo);
    public List<PaperStuGrade> queryGrageBypid(String pid);
}
