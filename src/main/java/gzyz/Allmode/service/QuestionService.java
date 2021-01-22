package gzyz.Allmode.service;


import gzyz.Allmode.pojo.Question;

import java.util.HashMap;
import java.util.List;

/**
 * @author jun
 * @date 2021/1/21-15:56
 */
public interface QuestionService {
    public boolean addQuestion(Question question);
    public boolean delOneQuestion(String quesId);
    public boolean delManyQuestion(String[] quesIds);
    public boolean editQuestion(Question question);
    public List<Question> queryQuestions(String userId);
    public List<Question> queryQuestionsByCondition(HashMap<String, String> map);
}
