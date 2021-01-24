package gzyz.Allmode.service;

import gzyz.Allmode.pojo.PaperClassify;

import java.util.List;

public interface PaperClassifyService {

    public List<PaperClassify> queryAllClassify(String userId);

    public boolean addClassify(PaperClassify paperClassify);

    public boolean delClassifyById(String pcId);

    public PaperClassify queryOneClassify(String pcId);

    public boolean editClassifyById(PaperClassify paperClassify);


}
