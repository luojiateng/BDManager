package domain;

public class Well {
    private String Cnumber;
    private Integer Wnumber;
    private String oilName;

    public Well(String cnumber, Integer wnumber, String oilName) {
        Cnumber = cnumber;
        Wnumber = wnumber;
        this.oilName = oilName;
    }

    public Well() {
    }

    public String getCnumber() {
        return Cnumber;
    }

    public void setCnumber(String cnumber) {
        Cnumber = cnumber;
    }

    public Integer getWnumber() {
        return Wnumber;
    }

    public void setWnumber(Integer wnumber) {
        Wnumber = wnumber;
    }

    public String getOilName() {
        return oilName;
    }

    public void setOilName(String oilName) {
        this.oilName = oilName;
    }

    @Override
    public String toString() {
        return "Well{" +
                "Cnumber='" + Cnumber + '\'' +
                ", Wnumber=" + Wnumber +
                ", oilName='" + oilName + '\'' +
                '}';
    }
}
