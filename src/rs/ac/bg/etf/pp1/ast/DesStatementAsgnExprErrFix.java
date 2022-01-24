// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class DesStatementAsgnExprErrFix extends DesignatorStatement {

    private DesLeftAsgn DesLeftAsgn;
    private Assignop Assignop;
    private DesAsgnErrFix DesAsgnErrFix;

    public DesStatementAsgnExprErrFix (DesLeftAsgn DesLeftAsgn, Assignop Assignop, DesAsgnErrFix DesAsgnErrFix) {
        this.DesLeftAsgn=DesLeftAsgn;
        if(DesLeftAsgn!=null) DesLeftAsgn.setParent(this);
        this.Assignop=Assignop;
        if(Assignop!=null) Assignop.setParent(this);
        this.DesAsgnErrFix=DesAsgnErrFix;
        if(DesAsgnErrFix!=null) DesAsgnErrFix.setParent(this);
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

    public DesAsgnErrFix getDesAsgnErrFix() {
        return DesAsgnErrFix;
    }

    public void setDesAsgnErrFix(DesAsgnErrFix DesAsgnErrFix) {
        this.DesAsgnErrFix=DesAsgnErrFix;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesLeftAsgn!=null) DesLeftAsgn.accept(visitor);
        if(Assignop!=null) Assignop.accept(visitor);
        if(DesAsgnErrFix!=null) DesAsgnErrFix.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesLeftAsgn!=null) DesLeftAsgn.traverseTopDown(visitor);
        if(Assignop!=null) Assignop.traverseTopDown(visitor);
        if(DesAsgnErrFix!=null) DesAsgnErrFix.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesLeftAsgn!=null) DesLeftAsgn.traverseBottomUp(visitor);
        if(Assignop!=null) Assignop.traverseBottomUp(visitor);
        if(DesAsgnErrFix!=null) DesAsgnErrFix.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesStatementAsgnExprErrFix(\n");

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

        if(DesAsgnErrFix!=null)
            buffer.append(DesAsgnErrFix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesStatementAsgnExprErrFix]");
        return buffer.toString();
    }
}
