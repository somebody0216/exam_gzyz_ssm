package gzyz.Allmode.dao;

import gzyz.Allmode.pojo.Course;
import gzyz.Allmode.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author jun
 * @date 2021/1/21-13:17
 */
@Mapper
public interface QuestionDao {
    public int addQuestion(Question question);
    public int delOneQuestion(String quesId);
    public int delManyQuestion(@Param("quesIds") String[] quesIds);
    public int editQuestion(Question question);
    public List<Question> queryQuestions(String userId);
    public List<Question> queryQuestionsByCondition(@Param("time1") String createTime1,
            @Param("time2") String createTime2,@Param("type") String quesType,
            @Param("courId") String courId,@Param("title") String quesTitle);

}
