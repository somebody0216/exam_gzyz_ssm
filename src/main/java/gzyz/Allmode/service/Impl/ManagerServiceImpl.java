package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.ManagerDao;
import gzyz.Allmode.pojo.Meau;
import gzyz.Allmode.pojo.User;
import gzyz.Allmode.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;


    @Override
    public List<Meau> queryMenu() {
        return managerDao.queryMenu();
    }

    @Override
    public List<User> queryAllUser() {
        return managerDao.queryAllUser();
    }

    @Override
    public boolean managerUser(String userId) {
        return managerDao.managerUser(userId)==1;
    }

    @Override
    public boolean addMenu(Meau meau) {
        return managerDao.addMenu(meau)==1;
    }

    @Override
    public boolean editMenu(Meau meau) {
        return managerDao.editMenu(meau)==1;
    }

    @Override
    public boolean delOneMenu(String meauId) {
        return managerDao.delOneMenu(meauId)==1;
    }

    @Override
    public boolean delManyMenu(String[] menuIds) {
        return managerDao.delManyMenu(menuIds)==menuIds.length;
    }

    @Override
    public User verifyLogin(String userPhone, String userPwd) {
        User user=null;
        List<User> users = managerDao.queryManagerInfo();

        for(User u:users){
            System.out.println(u);
            if(u.getUserPhone()!=null&&u.getUserPwd()!=null){
                if(u.getUserPhone().equals(userPhone) && u.getUserPwd().equals(userPwd)){
                    user=u;
                    break;
                }
            }
        }
        System.out.println(user);
        return user;
    }
}
