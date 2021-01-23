package gzyz.Allmode.pojo;

public class PaperClassify {

    private String pcId;
    private String pcName;
    private int isDelete;
    private String createTime;
    private String userId;

    public PaperClassify() {
    }

    public PaperClassify(String pcId, String pcName, int isDelete, String createTime, String userId) {
        this.pcId = pcId;
        this.pcName = pcName;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PaperClassify{" +
                "pcId='" + pcId + '\'' +
                ", pcName='" + pcName + '\'' +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
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
}
