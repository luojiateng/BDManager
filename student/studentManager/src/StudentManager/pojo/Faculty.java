package StudentManager.pojo;

/**
 * 学院
 */
public class Faculty {
    private Integer facultyId;
    private String facultyName;
    private Integer studentNumber;
    private Integer grilNumber;
    private Integer boyNumber;

    public Faculty() {
    }

    public Faculty(Integer facultyId, String facultyName, Integer studentNumber, Integer grilNumber, Integer boyNumber) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.studentNumber = studentNumber;
        this.grilNumber = grilNumber;
        this.boyNumber = boyNumber;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getGrilNumber() {
        return grilNumber;
    }

    public void setGrilNumber(Integer grilNumber) {
        this.grilNumber = grilNumber;
    }

    public Integer getBoyNumber() {
        return boyNumber;
    }

    public void setBoyNumber(Integer boyNumber) {
        this.boyNumber = boyNumber;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", studentNumber=" + studentNumber +
                ", grilNumber=" + grilNumber +
                ", boyNumber=" + boyNumber +
                '}';
    }
}
