// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class ReadSingleStm extends SingleStatement {

    private Read Read;

    public ReadSingleStm (Read Read) {
        this.Read=Read;
        if(Read!=null) Read.setParent(this);
    }

    public Read getRead() {
        return Read;
    }

    public void setRead(Read Read) {
        this.Read=Read;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Read!=null) Read.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Read!=null) Read.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Read!=null) Read.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReadSingleStm(\n");

        if(Read!=null)
            buffer.append(Read.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReadSingleStm]");
        return buffer.toString();
    }
}
