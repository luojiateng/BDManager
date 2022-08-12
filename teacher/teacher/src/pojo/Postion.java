package pojo;

/**
 * 对应职务表
 */
public class Postion {
    private Integer postNumber;
    private String postName;

    public Postion() {
    }

    public Postion(Integer postNumber, String postName) {
        this.postNumber = postNumber;
        this.postName = postName;
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Postion{" +
                "postNumber=" + postNumber +
                ", postName='" + postName + '\'' +
                '}';
    }
}
