package BankAppProject;

public class Transfer {
    private String recName;
    private String recANum;
    private String valuE;
    private String funAf;
    private String datT;

    public Transfer (String recipName, String recipNum, String value, String fundsAft, String date){
        this.recName=recipName;
        this.recANum=recipNum;
        this.valuE=value;
        this.funAf=fundsAft;
        this.datT=date;
    }

    public String getRecName() {
        return recName;
    }

    public String getRecANum() {
        return recANum;
    }

    public String getValuE() {
        return valuE;
    }

    public String getFunAf() {
        return funAf;
    }

    public String getDatT() {
        return datT;
    }

    @Override
    public String toString() {
        return recName +":"+ recANum +":"+  valuE +":"+funAf +":"+  datT ;
    }
}
