package gzyz.user_mode.service;


import gzyz.user_mode.pojo.User;

import java.util.List;

public interface UserService {

    public boolean verifyRegister(String user_phone);

    public int addUser(String user_phone, String user_pwd);

    public boolean verifyLogin(String user_phone,String user_pwd);


    public List<User> queryMyMsg(String user_id);


    public int ModifyUserInfo(String user_id,String user_img,String user_phone,String user_name,String user_pwd);

}
