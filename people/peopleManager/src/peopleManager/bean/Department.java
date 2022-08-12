package peopleManager.bean;


public class Department {
    private Integer deptId;
    private String deptName;
    private String title;
    private Integer teaNumber;

    public Department() {
    }

    public Department(Integer deptId, String deptName, String title, Integer teaNumber) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.title = title;
        this.teaNumber = teaNumber;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public Integer getTeaNumber() {
        return teaNumber;
    }

    public void setTeaNumber(Integer teaNumber) {
        this.teaNumber = teaNumber;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", title='" + title + '\'' +
                ", teaNumber=" + teaNumber +
                '}';
    }
}
