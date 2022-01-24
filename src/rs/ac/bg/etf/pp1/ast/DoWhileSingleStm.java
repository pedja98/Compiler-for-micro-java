// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class DoWhileSingleStm extends SingleStatement {

    private DoWhile DoWhile;

    public DoWhileSingleStm (DoWhile DoWhile) {
        this.DoWhile=DoWhile;
        if(DoWhile!=null) DoWhile.setParent(this);
    }

    public DoWhile getDoWhile() {
        return DoWhile;
    }

    public void setDoWhile(DoWhile DoWhile) {
        this.DoWhile=DoWhile;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoWhile!=null) DoWhile.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoWhile!=null) DoWhile.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoWhile!=null) DoWhile.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoWhileSingleStm(\n");

        if(DoWhile!=null)
            buffer.append(DoWhile.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoWhileSingleStm]");
        return buffer.toString();
    }
}
