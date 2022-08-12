package domain;


public class Accident {
    private String cNumber;
    private Integer wellNumber;
    private String Oname;
    private String inDepth;
    private String EndDepth;
    private String Encoding;
    private String gfloor;
    private String stratum;
    private String Octime;
    private String Retime;
    private String lossMoney;
    private String pass;
    private String Apattern;

    public Accident() {
    }

    public Accident(String cNumber, Integer wellNumber,
                    String oname, String inDepth, String endDepth,
                    String encoding, String gfloor, String stratum,
                    String octime, String retime, String lossMoney,
                    String pass, String apattern) {
        this.cNumber = cNumber;
        this.wellNumber = wellNumber;
        Oname = oname;
        this.inDepth = inDepth;
        EndDepth = endDepth;
        Encoding = encoding;
        this.gfloor = gfloor;
        this.stratum = stratum;
        Octime = octime;
        Retime = retime;
        this.lossMoney = lossMoney;
        this.pass = pass;
        Apattern = apattern;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public Integer getWellNumber() {
        return wellNumber;
    }

    public void setWellNumber(Integer wellNumber) {
        this.wellNumber = wellNumber;
    }

    public String getOname() {
        return Oname;
    }

    public void setOname(String oname) {
        Oname = oname;
    }

    public String getInDepth() {
        return inDepth;
    }

    public void setInDepth(String inDepth) {
        this.inDepth = inDepth;
    }

    public String getEndDepth() {
        return EndDepth;
    }

    public void setEndDepth(String endDepth) {
        EndDepth = endDepth;
    }

    public String getEncoding() {
        return Encoding;
    }

    public void setEncoding(String encoding) {
        Encoding = encoding;
    }

    public String getGfloor() {
        return gfloor;
    }

    public void setGfloor(String gfloor) {
        this.gfloor = gfloor;
    }

    public String getStratum() {
        return stratum;
    }

    public void setStratum(String stratum) {
        this.stratum = stratum;
    }

    public String getOctime() {
        return Octime;
    }

    public void setOctime(String octime) {
        Octime = octime;
    }

    public String getRetime() {
        return Retime;
    }

    public void setRetime(String retime) {
        Retime = retime;
    }

    public String getLossMoney() {
        return lossMoney;
    }

    public void setLossMoney(String lossMoney) {
        this.lossMoney = lossMoney;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getApattern() {
        return Apattern;
    }

    public void setApattern(String apattern) {
        Apattern = apattern;
    }


    @Override
    public String toString() {
        return "Accident{" +
                "cNumber='" + cNumber + '\'' +
                ", wellNumber=" + wellNumber +
                ", Oname='" + Oname + '\'' +
                ", inDepth='" + inDepth + '\'' +
                ", EndDepth='" + EndDepth + '\'' +
                ", Encoding='" + Encoding + '\'' +
                ", gfloor='" + gfloor + '\'' +
                ", stratum='" + stratum + '\'' +
                ", Octime='" + Octime + '\'' +
                ", Retime='" + Retime + '\'' +
                ", lossMoney='" + lossMoney + '\'' +
                ", pass='" + pass + '\'' +
                ", Apattern='" + Apattern + '\'' +
                '}';
    }
}
