package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.UserDao;
import gzyz.Allmode.pojo.User;
import gzyz.Allmode.service.UserService;
import gzyz.Allmode.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        if (user_phone!=null){
            for(User u:users){
                if(u.getUserPhone()!=null){
                    if(user_phone.equals(u.getUserPhone())){
                        result=true;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public int addUser(String user_phone, String user_pwd) {
        User u= new User();
        u.setUserRole(0);
        u.setUserId(UUID.randomUUID().toString());
        u.setUserPhone(user_phone);
        u.setUserPwd(user_pwd);
        String a = JDK8DateUtil.LocalDateTime2String(null, null);
        u.setCreateTime(a);
        System.out.println(u);
        int i = userDao.addUserInfo(u);
        return i;
    }

    @Override
    public boolean verifyLogin(String user_phone, String user_pwd) {
        boolean result=false;
        List<User> users = userDao.queryUserInfo();
        for(User u:users){
            if(u.getUserPhone()!=null&&u.getUserPwd()!=null){
                if(u.getUserPhone().equals(user_phone) && u.getUserPwd().equals(user_pwd)){
                    result=true;
                }
            }
        }
        return result;
    }

    @Override
    public List<User> queryMyMsg(String user_phone) {
        return userDao.queryMyMsg(user_phone);
    }

    @Override
    public int ModifyUserInfo(String user_phone, String user_name, String user_pwd) {
        User u = new User();
        u.setUserPhone(user_phone);
        u.setUserName(user_name);
        u.setUserPwd(user_pwd);
        int i = userDao.editMyMsg(u);
        return i;
    }

    @Override
    public int ModifyUserImg(String user_phone,String user_img) {
       User u = new User();
       u.setUserPhone(user_phone);
       u.setUserImg(user_img);
        int i = userDao.ImgChange(u);

        return i;
    }


    //        真实文件名  UUID_xxx.txt
    @Override
    public  String makeFileName(String fileName){
        return UUID.randomUUID().toString()+"_"+fileName;
    }


    //        设定文件存储路径：按照时间划分
    @Override
    public String makePath(String savaPath){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dataPath = sdf.format(new Date());
        String dir = savaPath+"\\"+dataPath;
        File file = new File(dir);
        if (!file.exists()){
            file.mkdirs();
        }
        return dir;
    }


}
