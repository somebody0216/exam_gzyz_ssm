package gzyz.Allmode.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import gzyz.Allmode.pojo.Meau;
import gzyz.Allmode.pojo.PageUtils;
import gzyz.Allmode.pojo.Paper;
import gzyz.Allmode.pojo.User;
import gzyz.Allmode.service.ManagerService;
import gzyz.Allmode.util.JDK8DateUtil;
import gzyz.Allmode.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class ManagerController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ManagerService managerService;

//    查询所有菜单
    @RequestMapping("/Manager/queryMenu")
    @ResponseBody
    public List<Meau> queryMenu(){
        return managerService.queryMenu();
    }



//查询所有用户
    @RequestMapping("/User/queryAllUser")
    @ResponseBody
    public PageUtils queryAllUser(@RequestBody Map<String,String> map){
        List<User> users = managerService.queryAllUser();
        System.out.println("从数据库拿到的所有user:"+users);
        PageHelper.offsetPage(Integer.parseInt(map.get("offSet")),Integer.parseInt(map.get("pageNumber")));
        PageInfo<User> pageInfo=new PageInfo<User>(users);
        return new PageUtils(new Long(pageInfo.getTotal()).intValue(),pageInfo.getList());

    }

//禁用启动用户
    @RequestMapping("/Manager/managerUser")
    @ResponseBody
    public Boolean managerUser(@RequestBody User user){
        System.out.println("从前端拿到的"+user);
        return managerService.managerUser(user);
    }


//   添加菜单
    @RequestMapping("/Manager/addMenu")
    @ResponseBody
    public Boolean addMenu(@RequestBody Meau meau){
        meau.setCreateTime(JDK8DateUtil.LocalDateTime2String(null,null));
        meau.setMeauId(UUID.randomUUID().toString());
        return managerService.addMenu(meau);
    }

//修改菜单
    @RequestMapping("/Manager/editMenu")
    @ResponseBody
    public Boolean editMenu(@RequestBody Meau meau){
        return managerService.editMenu(meau);
    }

//    删除一个菜单
    @RequestMapping("/Manager/delOneMenu")
    @ResponseBody
    public Boolean delOneMenu(@RequestBody Meau meau){
        return managerService.delOneMenu(meau.getMeauId());
    }

//删除多个菜单
    @RequestMapping("/Manager/delManyMenu/{menuIds}")
    @ResponseBody
    public Boolean delManyMenu(@PathVariable("menuIds") String menuIds){
        String[] menuIdsArray=menuIds.split(",");
        return managerService.delManyMenu(menuIdsArray);
    }





    //管理员登录
    @RequestMapping("/manager/login")
    @ResponseBody
    public Map<String,String> managerLogin(String userPhone, String userPwd){
        System.out.println(userPhone);
        System.out.println(userPwd);

        User user =  managerService.verifyLogin(userPhone, userPwd);
        System.out.println(user);
        HashMap<String,String> map=new HashMap<String,String>();
        if (user==null){
            map.put("flag","0");
        }else {
            map.put("flag","1");
//        map.put("userId",user.getUserId());
        }
        return map;
    }


//    根据Id查询菜单
    @RequestMapping("/Manager/queryOneMenuById")
    @ResponseBody
    public String queryOneMenuById(String meauParentId){
        return managerService.queryOneMenuById(meauParentId);

    }


//    查询所有一级菜单
    @RequestMapping("/Manager/queryFirstMenu")
    @ResponseBody
    public List<Meau> queryFirstMenu(@RequestBody Meau meau){
        return managerService.queryFirstMenu();
    }

}



