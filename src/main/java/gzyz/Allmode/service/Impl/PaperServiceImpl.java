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
        String[] strings = pId.split("-");
        String randNum=strings[0]+"-"+strings[1]+"-"+paper.getpTitle().hashCode();

        paper.setpId(pId);
        paper.setpStatus(0);
        paper.setpRandNum(randNum);
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
    public List<Question> queryAllQuesByPid(String pId) {
        return paperDao.queryAllQuesByPid(pId);
    }

    @Override
    public boolean addOneQuestion(PapQues papQues) {
        return paperDao.addOneQuestion(papQues)==1;
    }

    @Override
    public boolean addManyQuestion(List<Map<String,String>> pqList) {
        return paperDao.addManyQuestion(pqList)==pqList.size();
    }

    @Override
    public boolean delQuestion(String pId, String[] quesIds) {
        return paperDao.delQuestion(pId,quesIds)==quesIds.length;
    }
}
