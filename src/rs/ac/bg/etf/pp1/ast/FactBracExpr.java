// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class FactBracExpr extends Factor {

    private BrO BrO;
    private Expr Expr;
    private BrC BrC;

    public FactBracExpr (BrO BrO, Expr Expr, BrC BrC) {
        this.BrO=BrO;
        if(BrO!=null) BrO.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.BrC=BrC;
        if(BrC!=null) BrC.setParent(this);
    }

    public BrO getBrO() {
        return BrO;
    }

    public void setBrO(BrO BrO) {
        this.BrO=BrO;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public BrC getBrC() {
        return BrC;
    }

    public void setBrC(BrC BrC) {
        this.BrC=BrC;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BrO!=null) BrO.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(BrC!=null) BrC.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BrO!=null) BrO.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(BrC!=null) BrC.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BrO!=null) BrO.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(BrC!=null) BrC.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactBracExpr(\n");

        if(BrO!=null)
            buffer.append(BrO.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BrC!=null)
            buffer.append(BrC.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactBracExpr]");
        return buffer.toString();
    }
}
