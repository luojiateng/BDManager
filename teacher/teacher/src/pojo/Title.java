package pojo;

/**
 * 对应职称表
 */
public class Title {
    private Integer titleNumebr;
    private String titleName;

    public Title() {
    }

    public Title(Integer titleNumebr, String titleName) {
        this.titleNumebr = titleNumebr;
        this.titleName = titleName;
    }

    public Integer getTitleNumebr() {
        return titleNumebr;
    }

    public void setTitleNumebr(Integer titleNumebr) {
        this.titleNumebr = titleNumebr;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Override
    public String toString() {
        return "TitleDao{" +
                "titleNumebr=" + titleNumebr +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}
