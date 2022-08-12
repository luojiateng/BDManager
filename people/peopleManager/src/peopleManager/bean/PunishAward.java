package peopleManager.bean;

import java.sql.Date;

public class PunishAward {
    private Integer apId;
    private Integer teacherId;
    private String teacherName;
    private String type;
    private String time;
    private String describe;

    public PunishAward() {
    }

    public PunishAward(Integer teacherId, String teacherName, String type, String time, String describe) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.type = type;
        this.time = time;
        this.describe = describe;
    }

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
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
        return "PunishAward{" +
                "apId=" + apId +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
