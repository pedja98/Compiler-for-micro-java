// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class GotoSingleStm extends SingleStatement {

    private String gotoLabelName;

    public GotoSingleStm (String gotoLabelName) {
        this.gotoLabelName=gotoLabelName;
    }

    public String getGotoLabelName() {
        return gotoLabelName;
    }

    public void setGotoLabelName(String gotoLabelName) {
        this.gotoLabelName=gotoLabelName;
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
        buffer.append("GotoSingleStm(\n");

        buffer.append(" "+tab+gotoLabelName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GotoSingleStm]");
        return buffer.toString();
    }
}
