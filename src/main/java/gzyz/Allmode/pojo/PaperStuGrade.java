package gzyz.Allmode.pojo;

/**
 * @author jun
 * @date 2021/1/25-23:26
 */
public class PaperStuGrade {
    private String psgId;
    private String pId;
    private String stuId;
    private double psgGrade;
    private int isDelete;
    private String createTime;

    public PaperStuGrade() {
    }

    public String getPsgId() {
        return psgId;
    }

    public void setPsgId(String psgId) {
        this.psgId = psgId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public double getPsgGrade() {
        return psgGrade;
    }

    public void setPsgGrade(double psgGrade) {
        this.psgGrade = psgGrade;
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

    @Override
    public String toString() {
        return "PaperStuGrade{" +
                "psgId='" + psgId + '\'' +
                ", pId='" + pId + '\'' +
                ", stuId='" + stuId + '\'' +
                ", psgGrade=" + psgGrade +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
