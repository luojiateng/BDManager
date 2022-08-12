package pojo;


/**
 * 对应家庭的视图
 */
public class Family {
    private Integer teacherNumber;
    private String teacherName;
    private String familys;//家庭关系
    private String fName;

    public Family() {
    }

    public Family(Integer teacherNumber, String teacherName, String familys, String fName) {
        this.teacherNumber = teacherNumber;
        this.teacherName = teacherName;
        this.familys = familys;
        this.fName = fName;
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

    public String getFamilys() {
        return familys;
    }

    public void setFamilys(String familys) {
        this.familys = familys;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public String toString() {
        return "Family{" +
                "teacherNumber=" + teacherNumber +
                ", teacherName='" + teacherName + '\'' +
                ", familys='" + familys + '\'' +
                ", fName='" + fName + '\'' +
                '}';
    }
}
