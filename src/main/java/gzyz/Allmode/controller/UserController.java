package gzyz.Allmode.controller;


import gzyz.Allmode.pojo.User;
import gzyz.Allmode.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    用户注册
    @RequestMapping("/user/register")
    @ResponseBody
    public String userRegister(String user_phone,String user_pwd){
        System.out.println(user_phone);
        System.out.println(user_pwd);
        System.out.println("11111111");
        String flag="0";
        boolean b = userService.verifyRegister(user_phone);
        if (b==false){
            int i = userService.addUser(user_phone, user_pwd);
            if(i==1){
                flag="1";
            }
        }
        System.out.println(flag);
        return flag;
    }

//    用户登录

    @RequestMapping("/user/login")
    @ResponseBody
    public Map<String,String> userLogin(String userPhone, String userPwd){
        System.out.println(userPhone);
        System.out.println(userPwd);

        User user =  userService.verifyLogin(userPhone, userPwd);
        System.out.println("从数据库拿到="+user);
        HashMap<String,String> map=new HashMap<String,String>();
        if (user==null){
            map.put("flag","0");
        }else {
            map.put("flag","1");
            map.put("userId",user.getUserId());
        }
        return map;
    }

//用户根据手机号查看用户信息
    @RequestMapping("/user/queryMyMsg")
    @ResponseBody
    public User queryMyMsg(@RequestBody User u){
        System.out.println(u);
       User user = (User)userService.queryMyMsg(u.getUserPhone()).get(0);
         return user;
    }

//    用户修改信息
   @RequestMapping("/user/editMyMsg")
   @ResponseBody
    public String editMyMsg(@RequestBody User u){
        String flag="0";
       int i = userService.ModifyUserInfo(u.getUserPhone(),  u.getUserName(), u.getUserPwd(),u.getUserImg(),u.getUserId());
       if(i==1){
           flag="1";
       }
       return flag;
    }

//    头像上传
    @RequestMapping("/user/ImgUpload")
    @ResponseBody
    public String ImgUpload( HttpServletRequest request){
        String RealName="";
//        String flag="0";
        //上传文件环境准备w
//        本地文件传输到服务器端  服务器端存储文件的目录
        String savePath = request.getServletContext().getRealPath("/uploadFile");
//        String savePath = "http://localhost:8080/exam_gzyz_ssm/uploadFile";
//   临时目录/缓存目录
        String tempPath = request.getServletContext().getRealPath("/tempFile");
//        String tempPath = "http://localhost:8080/exam_gzyz_ssm/tempFile";
        File tmpFile= new File(tempPath);
        if(!tmpFile.exists()){
            tmpFile.mkdir();
        }

//        实现上传
//        Apache文件上传组件中  文件上传工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
//      设置缓冲区：当上传的文件超过设定缓冲区大小，需要指定一个临时目录，存放上传过程中的流数据
        factory.setSizeThreshold(1024*100);
//      绑定上传临时目录
        factory.setRepository(tmpFile);

//        上传前的流格式内容准备
//                 创建Apache 上传组件  上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
//        进度监听 可有可无
        upload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long l, long l1, int i) {
                System.out.println("文件大小为："+l1+",当前已处理"+l);
            }
        });

//        如下较重要设置
//        设定上传文件名的中文编码
        upload.setHeaderEncoding("UTF-8");
//        判定当前请求携带上传数据的流格式是否为formdata格式（普通形式，非Ajax）

//        单个文件最大1MB
        upload.setFileSizeMax(1024*1024);
//        设定上传总量10MB
        upload.setSizeMax(1024*1024*10);

//        实现上传流解析
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item:list){
                if(item.isFormField()){
//                    获取文本域key
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println(name+"="+value);
                }else {
//                    获得上传文件名称
                    String fileName = item.getName();
                    System.out.println("文件名称"+fileName);
                    if(fileName==null||fileName.trim().equals("")){
                        continue;
                    }
//                    文件名  xxx.xxx
                    fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
//                    前缀
                    String fileSuffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    System.out.println("上传的文件后缀"+fileSuffixName);

//                    获取上传文件输入流
                    InputStream in = item.getInputStream();
//                    设定真实保存文件名称
                    String saveFileName = userService.makeFileName(fileName);

//                    获取最终存储路径+UUID的文件名称
//                    uploadFile\xxxxx\UUID_xxx.txt
                    String realSavePath = userService.makePath(savePath);
                     RealName=realSavePath+"\\"+saveFileName;
                    FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFileName);


//                    int i = userService.ModifyUserImg(u.getUserPhone(), realname);
//                    if(i==1){
//                        flag="1";
//                    }


//                    创建缓冲区
                    byte[] buffer = new byte[1024];
                    int len=0;
                    while((len=in.read(buffer))!=-1){
                        out.write(buffer,0,len);
                    }
                    out.flush();
                    out.close();
                    in.close();
                }
            }
        } catch (FileUploadException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服务端生成的路径："+RealName);
        return RealName;
    }

}
