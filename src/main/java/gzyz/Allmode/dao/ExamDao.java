package gzyz.Allmode.dao;

import gzyz.Allmode.pojo.StuPaperInfo;
import gzyz.Allmode.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jun
 * @date 2021/1/25-11:02
 */
@Mapper
public interface ExamDao {
    public int addStudent(Student student);
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
}
