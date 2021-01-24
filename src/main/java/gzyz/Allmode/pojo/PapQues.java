package gzyz.Allmode.pojo;

public class PapQues {

    private String pqId;
    private String p_Id;
    private String quesId;
    private int isDelete;
    private String createTime;
    private String userId;

    public PapQues() {
    }

    public PapQues(String pqId, String p_Id, String quesId, int isDelete, String createTime, String userId) {
        this.pqId = pqId;
        this.p_Id = p_Id;
        this.quesId = quesId;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.userId = userId;
    }

    public String getPqId() {
        return pqId;
    }

    public void setPqId(String pqId) {
        this.pqId = pqId;
    }

    public String getP_Id() {
        return p_Id;
    }

    public void setP_Id(String p_Id) {
        this.p_Id = p_Id;
    }

    public String getQuesId() {
        return quesId;
    }

    public void setQuesId(String quesId) {
        this.quesId = quesId;
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
        return "PapQues{" +
                "pqId='" + pqId + '\'' +
                ", p_Id='" + p_Id + '\'' +
                ", quesId='" + quesId + '\'' +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
