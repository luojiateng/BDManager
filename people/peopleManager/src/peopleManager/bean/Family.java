package peopleManager.bean;


public class Family {
    private Integer teacherId;
    private String teacherName;
    private String relation;
    private String mamberName;

    public Family() {
    }

    public Family(Integer teacherId, String teacherName, String relation, String mamberName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.relation = relation;
        this.mamberName = mamberName;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getMamberName() {
        return mamberName;
    }

    public void setMamberName(String mamberName) {
        this.mamberName = mamberName;
    }

    @Override
    public String toString() {
        return "Family{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", relation='" + relation + '\'' +
                ", mamberName='" + mamberName + '\'' +
                '}';
    }
}
