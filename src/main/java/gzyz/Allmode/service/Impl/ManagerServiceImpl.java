package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.ManagerDao;
import gzyz.Allmode.pojo.Meau;
import gzyz.Allmode.pojo.User;
import gzyz.Allmode.service.ManagerService;
import gzyz.Allmode.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ManagerDao managerDao;


    @Override
    public List<Meau> queryMenu() {
        if (redisUtil.exists("MeauInfo")){
            return (List<Meau>) redisUtil.get("MeauInfo");
        }else {
            redisUtil.set("MeauInfo",managerDao.queryMenu());
            return managerDao.queryMenu();
        }
//        return managerDao.queryMenu();
    }

    @Override
    public List<User> queryAllUser() {
        return managerDao.queryAllUser();
    }

    @Override
    public boolean managerUser(User user) {
        return managerDao.managerUser(user)==1;
    }

    @Override
    public boolean addMenu(Meau meau) {
        int i = managerDao.addMenu(meau);
        redisUtil.set("MeauInfo",managerDao.queryMenu());
        redisUtil.set("FirstMeauInfo",managerDao.queryFirstMenu());
        return i==1;
    }

    @Override
    public boolean editMenu(Meau meau) {
        int i = managerDao.editMenu(meau);
        redisUtil.set("MeauInfo",managerDao.queryMenu());
        redisUtil.set("FirstMeauInfo",managerDao.queryFirstMenu());
        return i==1;
    }

    @Override
    public boolean delOneMenu(String meauId) {
        //验证是否有子菜单
        if (managerDao.queryChildMeau(meauId)>0){
            return false;
        }
        int i = managerDao.delOneMenu(meauId);
        redisUtil.set("MeauInfo",managerDao.queryMenu());
        redisUtil.set("FirstMeauInfo",managerDao.queryFirstMenu());
        return i==1;
    }

    @Override
    public boolean delManyMenu(String[] menuIds) {
        for (int i=0;i<menuIds.length;i++){
            int i1 = managerDao.queryChildMeau(menuIds[i]);
            if (i1>0){
                return false;//含有有子菜单的一级菜单
            }
        }
        int i = managerDao.delManyMenu(menuIds);
        redisUtil.set("MeauInfo",managerDao.queryMenu());
        redisUtil.set("FirstMeauInfo",managerDao.queryFirstMenu());
        return i==menuIds.length;
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

    @Override
    public Meau queryOneMenuById(String meauParentId) {
        return managerDao.queryOneMenuById(meauParentId);
    }

    @Override
    public List<Meau> queryFirstMenu() {
        if(redisUtil.exists("FirstMenuInfo")){
            return (List<Meau>) redisUtil.get("FirstMenuInfo");
        }else {
            redisUtil.set("FirstMenuInfo",managerDao.queryFirstMenu());
            return managerDao.queryFirstMenu();
        }
//        return managerDao.queryFirstMenu();
    }
}
