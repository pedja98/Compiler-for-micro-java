// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class FactCharConst extends Factor {

    private String charVal;

    public FactCharConst (String charVal) {
        this.charVal=charVal;
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
        buffer.append("FactCharConst(\n");

        buffer.append(" "+tab+charVal);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactCharConst]");
        return buffer.toString();
    }
}
