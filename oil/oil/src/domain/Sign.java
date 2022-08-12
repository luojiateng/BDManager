package domain;

public class Sign {
    private String Cnumber;
    private String Time;
    private String Symbol;

    public Sign() {
    }

    public Sign(String cnumber, String time, String symbol) {
        Cnumber = cnumber;
        Time = time;
        Symbol = symbol;
    }

    public String getCnumber() {
        return Cnumber;
    }

    public void setCnumber(String cnumber) {
        Cnumber = cnumber;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "Cnumber='" + Cnumber + '\'' +
                ", Time='" + Time + '\'' +
                ", Symbol='" + Symbol + '\'' +
                '}';
    }
}
