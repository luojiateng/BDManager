package StudentManager.pojo;

public class ClassInfo {
    private Integer classId;//班级Id
    private String className;//班级名称
    private Integer studentNumber;//学生总数
    private Integer boyNumber;//男生总数
    private Integer grilNumber;//女生总数
    private String major;
    private String faculty;//学院

    public ClassInfo() {
    }

    public ClassInfo(Integer classId, String className, String major) {
        this.classId = classId;
        this.className = className;
        this.major = major;
    }

    public ClassInfo(Integer classId, String className, Integer studentNumber, Integer boyNumber, Integer grilNumber, String major, String faculty) {
        this.classId = classId;
        this.className = className;
        this.studentNumber = studentNumber;
        this.boyNumber = boyNumber;
        this.grilNumber = grilNumber;
        this.major = major;
        this.faculty = faculty;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getBoyNumber() {
        return boyNumber;
    }

    public void setBoyNumber(Integer boyNumber) {
        this.boyNumber = boyNumber;
    }

    public Integer getGrilNumber() {
        return grilNumber;
    }

    public void setGrilNumber(Integer grilNumber) {
        this.grilNumber = grilNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", studentNumber=" + studentNumber +
                ", boyNumber=" + boyNumber +
                ", grilNumber=" + grilNumber +
                ", major='" + major + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
