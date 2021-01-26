package gzyz.Allmode.pojo;

/**
 * @author jun
 * @date 2021/1/25-11:41
 */
public class StuPaperInfo {
    private String spiId;
    private String pId;
    private String stuId;
    private String pqId;
    private String myAns;
    private int isDelete;
    private String createTime;

    public StuPaperInfo() {
    }

    public String getSpiId() {
        return spiId;
    }

    public void setSpiId(String spiId) {
        this.spiId = spiId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getPqId() {
        return pqId;
    }

    public void setPqId(String pqId) {
        this.pqId = pqId;
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

    public String getMyAns() {
        return myAns;
    }

    public void setMyAns(String myAns) {
        this.myAns = myAns;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "StuPaperInfo{" +
                "spiId='" + spiId + '\'' +
                ", pId='" + pId + '\'' +
                ", stuId='" + stuId + '\'' +
                ", pqId='" + pqId + '\'' +
                ", myAns='" + myAns + '\'' +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
