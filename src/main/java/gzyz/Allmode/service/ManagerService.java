package gzyz.Allmode.service;

import gzyz.Allmode.pojo.Meau;
import gzyz.Allmode.pojo.User;

import java.util.List;

public interface ManagerService {


    public List<Meau> queryMenu();

    public List<User> queryAllUser();

    public boolean managerUser(User user);

    public boolean addMenu(Meau meau);

    public boolean editMenu(Meau meau);

    public boolean delOneMenu(String meauId);

    public boolean delManyMenu(String[] menuIds);

    public User verifyLogin(String userPhone,String userPwd);

    public Meau queryOneMenuById(String meauParentId);

    public List<Meau> queryFirstMenu();

}
