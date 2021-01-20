package gzyz.user_mode.service;


import gzyz.user_mode.pojo.User;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface UserService {

    public boolean verifyRegister(String user_phone);

    public int addUser(String user_phone, String user_pwd);

    public boolean verifyLogin(String user_phone,String user_pwd);


    public List<User> queryMyMsg(String user_phone);


    public int ModifyUserInfo(String user_id,String user_img,String user_phone,String user_name,String user_pwd);
    //        真实文件名  UUID_xxx.txt
    public  String makeFileName(String fileName);


    //        设定文件存储路径：按照时间划分
    public String makePath(String savaPath);



}
