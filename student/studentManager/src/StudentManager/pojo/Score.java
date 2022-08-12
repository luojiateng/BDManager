package StudentManager.pojo;

public class Score {
    private Integer stuId;
    private String stuName;
    private String CourseName;
    private Double score;

    public Score(Integer stuId, String stuName, String courseName, Double score) {
        this.stuId = stuId;
        this.stuName = stuName;
        CourseName = courseName;
        this.score = score;
    }

    public Score(Integer stuId, String courseName, Double score) {
        this.stuId = stuId;
        CourseName = courseName;
        this.score = score;
    }

    public Score() {
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", score=" + score +
                '}';
    }
}
