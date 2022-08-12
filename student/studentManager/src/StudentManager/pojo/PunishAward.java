package StudentManager.pojo;

public class PunishAward {
    private Integer apId;
    private Integer studentId;
    private String studentName;
    private String type;
    private String time;
    private String describe;

    public PunishAward() {
    }

    public PunishAward(Integer apId, Integer studentId, String studentName, String type, String time, String describe) {
        this.apId = apId;
        this.studentId = studentId;
        this.studentName = studentName;
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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
        return "PunishAwardFrame{" +
                "apId=" + apId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
