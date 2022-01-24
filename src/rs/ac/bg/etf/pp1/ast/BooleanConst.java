// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class BooleanConst extends Const {

    private String constName;
    private String boolVal;

    public BooleanConst (String constName, String boolVal) {
        this.constName=constName;
        this.boolVal=boolVal;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public String getBoolVal() {
        return boolVal;
    }

    public void setBoolVal(String boolVal) {
        this.boolVal=boolVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BooleanConst(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+boolVal);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BooleanConst]");
        return buffer.toString();
    }
}
