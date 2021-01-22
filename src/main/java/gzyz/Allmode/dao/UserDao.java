package gzyz.Allmode.dao;


import gzyz.Allmode.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

    @Mapper
    public interface UserDao {

        public int addUserInfo(User u);

        public List<User> queryUserInfo();

        public List<User> queryMyMsg(String user_phone);

        public int editMyMsg(User u);

        public int ImgChange(User u);
    }
