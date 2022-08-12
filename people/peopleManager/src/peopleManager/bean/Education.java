package peopleManager.bean;


import java.sql.Date;

public class Education {
    private Integer teacherId;
    private String teacherName;
    private String education;
    private String school;
    private Date beginTiem;
    private Date endTime;

    public Education() {
    }

    public Education(Integer teacherId, String teacherName, String education, String school, Date beginTiem, Date endTime) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.education = education;
        this.school = school;
        this.beginTiem = beginTiem;
        this.endTime = endTime;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBeginTiem() {
        return beginTiem;
    }

    public void setBeginTiem(Date beginTiem) {
        this.beginTiem = beginTiem;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Education{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", beginTiem=" + beginTiem +
                ", endTime=" + endTime +
                '}';
    }
}
