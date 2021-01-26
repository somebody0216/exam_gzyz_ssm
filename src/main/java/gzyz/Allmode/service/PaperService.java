package gzyz.Allmode.service;

import gzyz.Allmode.pojo.PapQues;
import gzyz.Allmode.pojo.Paper;
import gzyz.Allmode.pojo.Question;

import java.util.List;
import java.util.Map;

public interface PaperService {

    public List<Paper> queryAllPapers(String userId);

    public boolean addPaper(Paper paper);

    public boolean delOnePaper(String pId);

    public Paper queryPaperBypid(String pId);

    public boolean editPaperById(Paper paper);

    public boolean delManyPaper(String[] pIds);

    public List<Map<String,String>> queryAllQuesByPid(String pId);

    public boolean addOneQuestion(PapQues papQues);

    public boolean addManyQuestion(List<Map<String,String>> pqList);

    public boolean delQuestion(String pId, String[] quesIds);
}
