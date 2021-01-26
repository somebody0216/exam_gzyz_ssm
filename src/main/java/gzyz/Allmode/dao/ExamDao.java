package gzyz.Allmode.dao;

import gzyz.Allmode.pojo.PaperStuGrade;
import gzyz.Allmode.pojo.StuPaperInfo;
import gzyz.Allmode.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jun
 * @date 2021/1/25-11:02
 */
@Mapper
public interface ExamDao {
    public int addStudent(Student student);

    public Student queryStudentById(String stuId);
    public int addStuPaperInfo(StuPaperInfo stuPaperInfo);

    /**
     *计算学生分数
     * @param stuId
     * @return
     */
    public double querySumScore(@Param("stuId") String stuId,@Param("pId") String pId);

    /**
     * 根据试卷id获得所有考试得学生的id
     * @param pid
     * @return
     */
    public List<String> queryAllStudent(String pid);

    public void addPaperStuGrade(PaperStuGrade paperStuGrade);

    /**
     * 查询总的成绩统计
     * @param pId
     * @return
     */
    public List<Map<String,Object>> queryAllGradeMsg(String pId);
}
