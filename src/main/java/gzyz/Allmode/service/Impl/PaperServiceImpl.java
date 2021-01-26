package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.PaperDao;
import gzyz.Allmode.pojo.PapQues;
import gzyz.Allmode.pojo.Paper;
import gzyz.Allmode.pojo.Question;
import gzyz.Allmode.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public List<Paper> queryAllPapers(String userId) {
        return paperDao.queryAllPapers(userId);
    }

    /*@Override
    public boolean addPaper(Paper paper) {
        return paperDao.addPaper(paper)==1;
    }*/
    @Override
    public boolean addPaper(Paper paper) {
        String pId=UUID.randomUUID().toString();
        paper.setpId(pId);
        paper.setpStatus(0);
        paper.setpRandNum(pId);
        paper.setIsDelete(0);
        paper.setCreateTime(dateFormat.format(new Date()));
        return paperDao.addPaper(paper)==1;
    }

    @Override
    public boolean delOnePaper(String pId) {
        return paperDao.delOnePaper(pId)==1;
    }

    @Override
    public Paper queryPaperBypid(String pId) {
        return paperDao.queryPaperBypid(pId);
    }

    @Override
    public boolean editPaperById(Paper paper) {
        return paperDao.editPaperById(paper)==1;
    }

    @Override
    public boolean delManyPaper(String[] pIds) {
        return paperDao.delManyPaper(pIds)==pIds.length;
    }

    @Override
    public List<Map<String,Object>> queryAllQuesByPid(String pId) {
        return paperDao.queryAllQuesByPid(pId);
    }

    @Override
    public boolean addOneQuestion(PapQues papQues) {
        if (paperDao.addOneQuestion(papQues)==1){
            double score = paperDao.querySumScore(papQues.getpId());
            Paper paper = paperDao.queryPaperBypid(papQues.getpId());
            paper.setpTolScore(score);//更改试卷总分
            paperDao.editPaperById(paper);
            return true;
        }
        return false;
    }

    /*@Override
    public boolean addOneQuestion(PapQues papQues) {
        return paperDao.addOneQuestion(papQues)==1;
    }*/

    @Override
    public boolean addManyQuestion(String userId,String pId, String[] quesIds) {
        for (String quesId : quesIds) {
            PapQues papQues=new PapQues();
            papQues.setCreateTime(dateFormat.format(new Date()));
            papQues.setIsDelete(0);
            papQues.setpId(pId);
            papQues.setQuesId(quesId);
            papQues.setUserId(userId);
            papQues.setPqId(UUID.randomUUID().toString());
            if (paperDao.addOneQuestion(papQues)!=1){
                return false;
            }
        }
        double score = paperDao.querySumScore(pId);
        Paper paper = paperDao.queryPaperBypid(pId);
        paper.setpTolScore(score);//更改试卷总分
        paperDao.editPaperById(paper);
        return true;
    }

    /*@Override
    public boolean addManyQuestion(List<Map<String,String>> pqList) {
        return paperDao.addManyQuestion(pqList)==pqList.size();
    }*/

    @Override
    public boolean delQuestion(String pId, String[] quesIds) {
        if (paperDao.delQuestion(pId,quesIds)>0){
            double score = paperDao.querySumScore(pId);
            Paper paper = paperDao.queryPaperBypid(pId);
            paper.setpTolScore(score);//更改试卷总分
            paperDao.editPaperById(paper);
            return true;
        }
        return false;
    }

    @Override
    public boolean queryByRandNum(Paper paper) {
        return paperDao.queryByRandNum(paper.getpId())==1;
    }
}
