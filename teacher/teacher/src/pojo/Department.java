package pojo;

/**
 * 对应部门表
 */
public class Department {
    private Integer deptNumber;
    private String deptName;
    private String TitleName;
    private Integer TitleCount;


    public Department(Integer deptNumber, String deptName, String titleName, Integer titleCount) {
        this.deptNumber = deptNumber;
        this.deptName = deptName;
        this.TitleName = titleName;
        this.TitleCount = titleCount;
    }

    public Integer getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(Integer deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }

    public Integer getTitleCount() {
        return TitleCount;
    }

    public void setTitleCount(Integer titleCount) {
        TitleCount = titleCount;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptNumber=" + deptNumber +
                ", deptName='" + deptName + '\'' +
                ", TitleName='" + TitleName + '\'' +
                ", TitleCount=" + TitleCount +
                '}';
    }
}
