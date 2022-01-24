// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class Read implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ReadOp ReadOp;
    private ReadDesignator ReadDesignator;

    public Read (ReadOp ReadOp, ReadDesignator ReadDesignator) {
        this.ReadOp=ReadOp;
        if(ReadOp!=null) ReadOp.setParent(this);
        this.ReadDesignator=ReadDesignator;
        if(ReadDesignator!=null) ReadDesignator.setParent(this);
    }

    public ReadOp getReadOp() {
        return ReadOp;
    }

    public void setReadOp(ReadOp ReadOp) {
        this.ReadOp=ReadOp;
    }

    public ReadDesignator getReadDesignator() {
        return ReadDesignator;
    }

    public void setReadDesignator(ReadDesignator ReadDesignator) {
        this.ReadDesignator=ReadDesignator;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReadOp!=null) ReadOp.accept(visitor);
        if(ReadDesignator!=null) ReadDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReadOp!=null) ReadOp.traverseTopDown(visitor);
        if(ReadDesignator!=null) ReadDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReadOp!=null) ReadOp.traverseBottomUp(visitor);
        if(ReadDesignator!=null) ReadDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Read(\n");

        if(ReadOp!=null)
            buffer.append(ReadOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ReadDesignator!=null)
            buffer.append(ReadDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Read]");
        return buffer.toString();
    }
}
