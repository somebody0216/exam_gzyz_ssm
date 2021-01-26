package gzyz.Allmode.dao;


import gzyz.Allmode.pojo.PapQues;
import gzyz.Allmode.pojo.Paper;
import gzyz.Allmode.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaperDao {


    public List<Paper> queryAllPapers(String userId);

    public int addPaper(Paper paper);

    public int delOnePaper(String pId);

    public Paper queryPaperBypid(String pId);

    public int editPaperById(Paper paper);

    public int delManyPaper(@Param("pIds") String[] pIds);

    public List<Question> queryAllQuesByPid(String pId);

    public int addOneQuestion(PapQues papQues);

    public int addManyQuestion(List<Map<String,String>> pqList);

    public int delQuestion(@Param("pId") String pId, @Param("quesIds") String[] quesIds);

    public int queryByRandNum(String pid);
}
