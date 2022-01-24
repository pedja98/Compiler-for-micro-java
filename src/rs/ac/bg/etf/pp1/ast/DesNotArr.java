// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class DesNotArr extends Designator {

    private String desName;

    public DesNotArr (String desName) {
        this.desName=desName;
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName=desName;
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
        buffer.append("DesNotArr(\n");

        buffer.append(" "+tab+desName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesNotArr]");
        return buffer.toString();
    }
}
