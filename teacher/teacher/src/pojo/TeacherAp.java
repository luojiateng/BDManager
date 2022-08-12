package pojo;


/**
 * 教师奖惩统计表的视图
 */
public class TeacherAp {
    private Integer ApID;
    private Integer teacherId;
    private String teacherName;
    private String type;
    private String time;
    private String describe;

    public TeacherAp() {
    }

    public TeacherAp(Integer apID, Integer teacherId, String teacherName, String type, String time, String describe) {
        ApID = apID;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.type = type;
        this.time = time;
        this.describe = describe;
    }

    public Integer getApID() {
        return ApID;
    }

    public void setApID(Integer apID) {
        ApID = apID;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "TeacherAp{" +
                "ApID=" + ApID +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
