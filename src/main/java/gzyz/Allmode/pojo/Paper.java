package gzyz.Allmode.pojo;

public class Paper {

    private String pId;
    private String pTitle;
    private String pcId;
    private double pTolScore;
    private String pStartTime;
    private String pEndTime;
    private int pFree;
    private String pRandNum;
    private int pStatus;
    private int isDelete;
    private String createTime;
    private String userId;

    public Paper() {
    }

    public Paper(String pId, String pTitle, String pcId, double pTolScore, String pStartTime, String pEndTime, int pFree, String pRandNum, int pStatus, int isDelete, String createTime, String userId) {
        this.pId = pId;
        this.pTitle = pTitle;
        this.pcId = pcId;
        this.pTolScore = pTolScore;
        this.pStartTime = pStartTime;
        this.pEndTime = pEndTime;
        this.pFree = pFree;
        this.pRandNum = pRandNum;
        this.pStatus = pStatus;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "pId='" + pId + '\'' +
                ", pTitle='" + pTitle + '\'' +
                ", pcId='" + pcId + '\'' +
                ", pTolScore=" + pTolScore +
                ", pStartTime='" + pStartTime + '\'' +
                ", pEndTime='" + pEndTime + '\'' +
                ", pFree=" + pFree +
                ", pRandNum='" + pRandNum + '\'' +
                ", pStatus=" + pStatus +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public double getpTolScore() {
        return pTolScore;
    }

    public void setpTolScore(double pTolScore) {
        this.pTolScore = pTolScore;
    }

    public String getpStartTime() {
        return pStartTime;
    }

    public void setpStartTime(String pStartTime) {
        this.pStartTime = pStartTime;
    }

    public String getpEndTime() {
        return pEndTime;
    }

    public void setpEndTime(String pEndTime) {
        this.pEndTime = pEndTime;
    }

    public int getpFree() {
        return pFree;
    }

    public void setpFree(int pFree) {
        this.pFree = pFree;
    }

    public String getpRandNum() {
        return pRandNum;
    }

    public void setpRandNum(String pRandNum) {
        this.pRandNum = pRandNum;
    }

    public int getpStatus() {
        return pStatus;
    }

    public void setpStatus(int pStatus) {
        this.pStatus = pStatus;
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
