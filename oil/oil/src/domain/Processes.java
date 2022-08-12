package domain;


public class Processes {
    private String Cnumber;
    private String trpocesses;

    public Processes() {
    }

    public Processes(String cnumber, String trpocesses) {
        Cnumber = cnumber;
        this.trpocesses = trpocesses;
    }

    public String getCnumber() {
        return Cnumber;
    }

    public void setCnumber(String cnumber) {
        Cnumber = cnumber;
    }

    public String getTrpocesses() {
        return trpocesses;
    }

    public void setTrpocesses(String trpocesses) {
        this.trpocesses = trpocesses;
    }

    @Override
    public String toString() {
        return "ProcessesDao{" +
                "Cnumber='" + Cnumber + '\'' +
                ", trpocesses='" + trpocesses + '\'' +
                '}';
    }
}
