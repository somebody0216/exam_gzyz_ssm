package gzyz.user_mode.pojo;

public class User {
    private String userID;
    private String userImg;
    private String userPhone;
    private String userName;
    private String userPwd;
    private String createTime;

    public User() {
    }

    public User(String userID, String userImg, String userPhone, String userName, String userPwd, String createTime) {
        this.userID = userID;
        this.userImg = userImg;
        this.userPhone = userPhone;
        this.userName = userName;
        this.userPwd = userPwd;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "user{" +
                "userID='" + userID + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
