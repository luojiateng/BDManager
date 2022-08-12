package pojo;


/**
 * 教师信息表，对应视图teacherInfo
 */
public class Teacher {
    private Integer teacherID;
    private String teacherName;
    private String sex;
    private String birth;
    private String email;
    private String titlName;
    private String deptName;
    private String positionName;

    public Teacher() {
    }

    public Teacher(Integer teacherID, String teacherName, String sex, String birth, String email, String titlName, String deptName, String positionName) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.sex = sex;
        this.birth = birth;
        this.email = email;
        this.titlName = titlName;
        this.deptName = deptName;
        this.positionName = positionName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitlName() {
        return titlName;
    }

    public void setTitlName(String titlName) {
        this.titlName = titlName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", teacherName='" + teacherName + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", email='" + email + '\'' +
                ", titlName='" + titlName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
