// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class CharachterConst extends Const {

    private String constName;
    private String charVal;

    public CharachterConst (String constName, String charVal) {
        this.constName=constName;
        this.charVal=charVal;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public String getCharVal() {
        return charVal;
    }

    public void setCharVal(String charVal) {
        this.charVal=charVal;
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
        buffer.append("CharachterConst(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+charVal);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharachterConst]");
        return buffer.toString();
    }
}
