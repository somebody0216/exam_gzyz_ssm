package gzyz.user_mode.service.Impl;

import gzyz.user_mode.dao.UserDao;
import gzyz.user_mode.pojo.User;
import gzyz.user_mode.service.UserService;
import gzyz.user_mode.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
//   验证注册
    public boolean verifyRegister(String user_phone) {
        boolean result=false;
        List<User> users = userDao.queryUserInfo();
        for(User u:users){
            if(u.getUserPhone()!=null){
                if(user_phone.equals(u.getUserPhone())){
                    result=true;
                }
            }
        }
        return result;
    }

    @Override
    public int addUser(String user_phone, String user_pwd) {
        User u= new User();
        u.setUserRole(0);
        u.setUserID(UUID.randomUUID().toString());
        u.setUserPhone(user_phone);
        u.setUserPwd(user_pwd);
        String a = JDK8DateUtil.LocalDateTime2String(null, null);
        u.setCreateTime(a);
        int i = userDao.addUserInfo(u);
        return i;
    }

    @Override
    public boolean verifyLogin(String user_phone, String user_pwd) {
        boolean result=false;
        List<User> users = userDao.queryUserInfo();
        for(User u:users){
            if(u.getUserPhone()!=null&&u.getUserPwd()!=null){
                if(u.getUserPhone().equals(user_phone)&&u.getUserPwd().equals(user_pwd)){
                    result=true;
                }
            }
        }
        return result;
    }

    @Override
    public List<User> queryMyMsg(String user_id) {
        return userDao.queryMyMsg(user_id);
    }

    @Override
    public int ModifyUserInfo(String user_id, String user_img, String user_phone, String user_name, String user_pwd) {
        User u = new User();
        u.setUserImg(user_img);
        u.setUserPhone(user_phone);
        u.setUserName(user_name);
        u.setUserPwd(user_pwd);
        int i = userDao.editMyMsg(u);
        return i;
    }


}
