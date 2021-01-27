package gzyz.Allmode.service;


import gzyz.Allmode.pojo.User;

import java.util.List;

public interface UserService {

    public boolean verifyRegister(String user_phone);

    public int addUser(String user_phone, String user_pwd);

   /* public boolean verifyLogin(String userPhone,String userPwd);*/

    public User verifyLogin(String userPhone,String userPwd);

    public List<User> queryMyMsg(String user_phone);


    public int ModifyUserInfo(String user_phone,String user_name,String user_pwd,String userImg,String userId);


//    public int ModifyUserImg(String user_phone,String user_img);
    //        真实文件名  UUID_xxx.txt
    public  String makeFileName(String fileName);


    //        设定文件存储路径：按照时间划分
    public String makePath(String savaPath);



}
