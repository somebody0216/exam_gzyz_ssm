package gzyz.Allmode.service;

import gzyz.Allmode.pojo.Meau;
import gzyz.Allmode.pojo.User;

import java.util.List;

public interface ManagerService {


    public List<Meau> queryMenu();

    public List<User> queryAllUser();

    public boolean managerUser(String userId);

    public boolean addMenu(Meau meau);

    public boolean editMenu(Meau meau);

    public boolean delOneMenu(String meauId);

    public boolean delManyMenu(String[] menuIds);

    public User verifyLogin(String userPhone,String userPwd);

}
