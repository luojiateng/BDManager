package StudentManager.pojo;

/**
 * 专业
 */
public class Major {
    private Integer majorId;
    private String majorName;
    private Integer studentNumber;
    private Integer girlNumber;
    private Integer boyNumber;
    private String facultyName;

    public Major() {
    }

    public Major(Integer majorId, String majorName, Integer studentNumber, Integer girlNumber, Integer boyNumber, String facultyName) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.studentNumber = studentNumber;
        this.girlNumber = girlNumber;
        this.boyNumber = boyNumber;
        this.facultyName = facultyName;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getGirlNumber() {
        return girlNumber;
    }

    public void setGirlNumber(Integer girlNumber) {
        this.girlNumber = girlNumber;
    }

    public Integer getBoyNumber() {
        return boyNumber;
    }

    public void setBoyNumber(Integer boyNumber) {
        this.boyNumber = boyNumber;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                ", studentNumber=" + studentNumber +
                ", girlNumber=" + girlNumber +
                ", boyNumber=" + boyNumber +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}
