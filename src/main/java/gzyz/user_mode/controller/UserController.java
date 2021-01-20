package gzyz.user_mode.controller;


import gzyz.user_mode.pojo.User;
import gzyz.user_mode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;



//    用户注册
    @RequestMapping("/user/register")
    @ResponseBody
    public String userRegister(String user_phone,String user_pwd){
        String flag="注册失败";
        boolean b = userService.verifyRegister(user_phone);
        if (b=false){
            int i = userService.addUser(user_phone, user_pwd);
            if(i==1){
                flag="注册成功";
            }
        }
        return flag;
    }

//    用户登录
    @RequestMapping("/user/login")
    @ResponseBody
    public String userLogin(String user_phone,String user_pwd){
    String flag="登录失败";
        boolean b = userService.verifyLogin(user_phone, user_pwd);
        if(b==true){
            flag="登录成功";
        }
        return flag;
    }


//用户根据ID查看用户信息
    @RequestMapping("/user/queryMyMsg")
    @ResponseBody
    public User queryMyMsg(@RequestBody User u){
       User user = (User)userService.queryMyMsg(u.getUserID());
         return user;
    }

//    用户修改信息
   @RequestMapping("/user/editMyMsg")
    public String editMyMsg(@RequestBody User u){
        String flag="修改失败";
       int i = userService.ModifyUserInfo(u.getUserID(), u.getUserImg(), u.getUserPhone(), u.getUserName(), u.getUserPwd());
       if(i==1){
           flag="修改成功";
       }
       return flag;
    }

}
