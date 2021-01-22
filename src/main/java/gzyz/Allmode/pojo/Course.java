package gzyz.Allmode.pojo;

/**
 * @author jun
 * @date 2021/1/21-10:21
 */
public class Course {
    private String courId;
    private String courName;
    private int isDelete;
    private String createTime;
    private String userId;

    public Course() {
    }

    public Course(String courId, String courName, int isDelete, String createTime, String userId) {
        this.courId = courId;
        this.courName = courName;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.userId = userId;
    }

    public String getCourId() {
        return courId;
    }

    public void setCourId(String courId) {
        this.courId = courId;
    }

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courId='" + courId + '\'' +
                ", courName='" + courName + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
