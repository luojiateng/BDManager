package pojo;


public class Education {
    //编号
    private Integer teacherNumber;
    //姓名
    private String teacherName;
    //教育阶段
    private String eduName;
    private String begin;
    private String end;
    private String schoolName;

    public Education() {
    }

    public Education(Integer teacherNumber, String teacherName, String eduName, String begin, String end, String schoolName) {
        this.teacherNumber = teacherNumber;
        this.teacherName = teacherName;
        this.eduName = eduName;
        this.begin = begin;
        this.end = end;
        this.schoolName = schoolName;
    }

    public Integer getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(Integer teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "EducationFrame{" +
                "teacherNumber=" + teacherNumber +
                ", teacherName='" + teacherName + '\'' +
                ", eduName='" + eduName + '\'' +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
