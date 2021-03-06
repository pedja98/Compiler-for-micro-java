// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class DesStatementAsgnExpr extends DesignatorStatement {

    private DesLeftAsgn DesLeftAsgn;
    private Assignop Assignop;
    private Expr Expr;

    public DesStatementAsgnExpr (DesLeftAsgn DesLeftAsgn, Assignop Assignop, Expr Expr) {
        this.DesLeftAsgn=DesLeftAsgn;
        if(DesLeftAsgn!=null) DesLeftAsgn.setParent(this);
        this.Assignop=Assignop;
        if(Assignop!=null) Assignop.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesLeftAsgn getDesLeftAsgn() {
        return DesLeftAsgn;
    }

    public void setDesLeftAsgn(DesLeftAsgn DesLeftAsgn) {
        this.DesLeftAsgn=DesLeftAsgn;
    }

    public Assignop getAssignop() {
        return Assignop;
    }

    public void setAssignop(Assignop Assignop) {
        this.Assignop=Assignop;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesLeftAsgn!=null) DesLeftAsgn.accept(visitor);
        if(Assignop!=null) Assignop.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesLeftAsgn!=null) DesLeftAsgn.traverseTopDown(visitor);
        if(Assignop!=null) Assignop.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesLeftAsgn!=null) DesLeftAsgn.traverseBottomUp(visitor);
        if(Assignop!=null) Assignop.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesStatementAsgnExpr(\n");

        if(DesLeftAsgn!=null)
            buffer.append(DesLeftAsgn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Assignop!=null)
            buffer.append(Assignop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesStatementAsgnExpr]");
        return buffer.toString();
    }
}
