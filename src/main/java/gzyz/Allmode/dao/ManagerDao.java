package gzyz.Allmode.dao;


import gzyz.Allmode.pojo.Meau;
import gzyz.Allmode.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerDao {

    public List<Meau> queryMenu();

    public List<User> queryAllUser();

    public int managerUser(User user);

    public int addMenu(Meau meau);

    public int editMenu(Meau meau);

    public int delOneMenu(String meauId);

    public int delManyMenu(@Param("menuIds") String[] menuIds);

    public List<User> queryManagerInfo();

}
