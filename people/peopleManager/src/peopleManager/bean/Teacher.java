package peopleManager.bean;


public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private String gender;
    private String email;
    private String deptName;
    private String title;
    private String position;

    public Teacher() {
    }

    public Teacher(Integer teacherId, String teacherName, String gender, String email, String deptName, String title, String position) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.gender = gender;
        this.email = email;
        this.deptName = deptName;
        this.title = title;
        this.position = position;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", deptName='" + deptName + '\'' +
                ", title='" + title + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
