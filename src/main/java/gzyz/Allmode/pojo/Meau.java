package gzyz.Allmode.pojo;

import java.io.Serializable;

public class Meau implements Serializable {
    private String meauId;
    private String meauName;
    private int meauLevel;
    private String meauParentId;
    private String meauHref;
    private int isDelete;
    private String createTime;

    public Meau() {
    }

    public Meau(String meauId, String meauName, int meauLevel, int isDelete, String createTime) {
        this.meauId = meauId;
        this.meauName = meauName;
        this.meauLevel = meauLevel;
        this.isDelete = isDelete;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Meau{" +
                "meauId='" + meauId + '\'' +
                ", meauName='" + meauName + '\'' +
                ", meauLevel=" + meauLevel +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public String getMeauId() {
        return meauId;
    }

    public void setMeauId(String meauId) {
        this.meauId = meauId;
    }

    public String getMeauName() {
        return meauName;
    }

    public void setMeauName(String meauName) {
        this.meauName = meauName;
    }

    public int getMeauLevel() {
        return meauLevel;
    }

    public void setMeauLevel(int meauLevel) {
        this.meauLevel = meauLevel;
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

    public String getMeauParentId() {
        return meauParentId;
    }

    public void setMeauParentId(String meauParentId) {
        this.meauParentId = meauParentId;
    }

    public String getMeauHref() {
        return meauHref;
    }

    public void setMeauHref(String meauHref) {
        this.meauHref = meauHref;
    }
}
