package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.PaperClassifyDao;
import gzyz.Allmode.pojo.PaperClassify;
import gzyz.Allmode.service.PaperClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaperClassifyServiceImpl implements PaperClassifyService {

    @Autowired
    private PaperClassifyDao paperClassifyDao;


    @Override
    public List<PaperClassify> queryAllClassify(String userId) {
        return paperClassifyDao.queryAllClassify(userId);
    }

    @Override
    public boolean addClassify(PaperClassify paperClassify) {
        return paperClassifyDao.addClassify(paperClassify)==1;
    }

    @Override
    public boolean delClassifyById(String pcId) {
        return paperClassifyDao.delClassifyById(pcId)==1;
    }

    @Override
    public PaperClassify queryOneClassify(String pcId) {
        return paperClassifyDao.queryOneClassify(pcId);
    }

    @Override
    public boolean editClassifyById(PaperClassify paperClassify) {
        return paperClassifyDao.editClassifyById(paperClassify)==1;
    }
}
