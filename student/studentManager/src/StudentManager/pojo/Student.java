package StudentManager.pojo;

/**
 * 学生信息
 */
public class Student {
    private Integer studentId;//学生id
    private String studentName;//姓名
    private String gender;//性别
    private String faculty;//院系
    private String major;//专业
    private String classInfo;//班级
    private Double GPA;//绩点
    private Integer award;//奖励
    private Integer sanction;//处分

    public Student() {
    }


    public Student(Integer studentId, String studentName, String gender, String faculty, String major, String classInfo, Double GPA, Integer award, Integer sanction) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.faculty = faculty;
        this.major = major;
        this.classInfo = classInfo;
        this.GPA = GPA;
        this.award = award;
        this.sanction = sanction;
    }

    public Student(Integer studentId, String studentName, String gender, String classInfo, Double GPA, Integer award, Integer sanction) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.classInfo = classInfo;
        this.GPA = GPA;
        this.award = award;
        this.sanction = sanction;
    }


    public Student(Integer studentId, String studentName, String gender, String classInfo) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.classInfo = classInfo;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public Integer getSanction() {
        return sanction;
    }

    public void setSanction(Integer sanction) {
        this.sanction = sanction;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", faculty='" + faculty + '\'' +
                ", major='" + major + '\'' +
                ", classInfo='" + classInfo + '\'' +
                ", GPA=" + GPA +
                ", award=" + award +
                ", sanction=" + sanction +
                '}';
    }
}
