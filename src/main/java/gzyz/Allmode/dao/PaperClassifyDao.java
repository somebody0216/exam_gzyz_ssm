package gzyz.Allmode.dao;


import gzyz.Allmode.pojo.Paper;
import gzyz.Allmode.pojo.PaperClassify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperClassifyDao {

    public List<PaperClassify> queryAllClassify(String userId);

    public int addClassify(PaperClassify paperClassify);

    public int delClassifyById(String pcId);

    public PaperClassify queryOneClassify(String pcId);

    public int editClassifyById(PaperClassify paperClassify);
}
