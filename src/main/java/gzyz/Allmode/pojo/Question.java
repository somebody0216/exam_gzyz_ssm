package gzyz.Allmode.pojo;

/**
 * @author jun
 * @date 2021/1/21-13:13
 */
public class Question {
    private String quesId;
    private int quesType;
    private String courId;
    private String quesTitle;
    private String quesSelA;
    private String quesSelB;
    private String quesSelC;
    private String quesSelD;
    private String quesAns;
    private double quesScore;
    private String quesImg;
    private int isDelete;
    private String createTime;
    private String userId;

    public Question() {
    }

    public String getQuesId() {
        return quesId;
    }

    public void setQuesId(String quesId) {
        this.quesId = quesId;
    }

    public int getQuesType() {
        return quesType;
    }

    public void setQuesType(int quesType) {
        this.quesType = quesType;
    }

    public String getCourId() {
        return courId;
    }

    public void setCourId(String courId) {
        this.courId = courId;
    }

    public String getQuesTitle() {
        return quesTitle;
    }

    public void setQuesTitle(String quesTitle) {
        this.quesTitle = quesTitle;
    }

    public String getQuesSelA() {
        return quesSelA;
    }

    public void setQuesSelA(String quesSelA) {
        this.quesSelA = quesSelA;
    }

    public String getQuesSelB() {
        return quesSelB;
    }

    public void setQuesSelB(String quesSelB) {
        this.quesSelB = quesSelB;
    }

    public String getQuesSelC() {
        return quesSelC;
    }

    public void setQuesSelC(String quesSelC) {
        this.quesSelC = quesSelC;
    }

    public String getQuesSelD() {
        return quesSelD;
    }

    public void setQuesSelD(String quesSelD) {
        this.quesSelD = quesSelD;
    }

    public String getQuesAns() {
        return quesAns;
    }

    public void setQuesAns(String quesAns) {
        this.quesAns = quesAns;
    }

    public double getQuesScore() {
        return quesScore;
    }

    public void setQuesScore(double quesScore) {
        this.quesScore = quesScore;
    }

    public String getQuesImg() {
        return quesImg;
    }

    public void setQuesImg(String quesImg) {
        this.quesImg = quesImg;
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
        return "Question{" +
                "quesId='" + quesId + '\'' +
                ", quesType=" + quesType +
                ", courId='" + courId + '\'' +
                ", quesTitle='" + quesTitle + '\'' +
                ", quesSelA='" + quesSelA + '\'' +
                ", quesSelB='" + quesSelB + '\'' +
                ", quesSelC='" + quesSelC + '\'' +
                ", quesSelD='" + quesSelD + '\'' +
                ", quesAns='" + quesAns + '\'' +
                ", quesScore=" + quesScore +
                ", quesImg='" + quesImg + '\'' +
                ", isDelete=" + isDelete +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
