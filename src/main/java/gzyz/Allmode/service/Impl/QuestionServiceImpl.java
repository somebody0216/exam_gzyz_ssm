package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.QuestionDao;
import gzyz.Allmode.pojo.Question;
import gzyz.Allmode.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author jun
 * @date 2021/1/21-15:56
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;
    int i=0;
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public boolean addQuestion(Question question) {
        i++;
        question.setQuesId(question.getQuesTitle().hashCode()+"-"+i);
        question.setIsDelete(0);
        question.setCreateTime(dateFormat.format(new Date()));
        return questionDao.addQuestion(question)==1;
    }

    @Override
    public boolean delOneQuestion(String quesId) {
        return questionDao.delOneQuestion(quesId)==1;
    }

    @Override
    public boolean delManyQuestion(String[] quesIds) {
        return questionDao.delManyQuestion(quesIds)==quesIds.length;
    }

    @Override
    public boolean editQuestion(Question question) {
        return questionDao.editQuestion(question)==1;
    }

    @Override
    public List<Question> queryQuestions(String userId) {
        return questionDao.queryQuestions(userId);
    }

    @Override
    public List<Question> queryQuestionsByCondition(HashMap<String, String> map) {
        return questionDao.queryQuestionsByCondition(map.get("createTime1"),
                map.get("createTime2"),map.get("quesType"),
        map.get("courId"),map.get("quesTitle"));
    }
}
