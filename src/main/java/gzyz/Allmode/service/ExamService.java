package gzyz.Allmode.service;

import gzyz.Allmode.pojo.PaperStuGrade;
import gzyz.Allmode.pojo.StuPaperInfo;
import gzyz.Allmode.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @author jun
 * @date 2021/1/25-11:03
 */
public interface ExamService {
    public Student addStudent(Student student);
    public boolean addStuPaperInfo(List<StuPaperInfo> stuPaperInfos);
    public List<Map<String,Object>> queryGrageBypid(String pid);
}
