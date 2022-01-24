// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class ClDec extends ElemDec {

    private ClassDecl ClassDecl;
    private ElemDeclList ElemDeclList;

    public ClDec (ClassDecl ClassDecl, ElemDeclList ElemDeclList) {
        this.ClassDecl=ClassDecl;
        if(ClassDecl!=null) ClassDecl.setParent(this);
        this.ElemDeclList=ElemDeclList;
        if(ElemDeclList!=null) ElemDeclList.setParent(this);
    }

    public ClassDecl getClassDecl() {
        return ClassDecl;
    }

    public void setClassDecl(ClassDecl ClassDecl) {
        this.ClassDecl=ClassDecl;
    }

    public ElemDeclList getElemDeclList() {
        return ElemDeclList;
    }

    public void setElemDeclList(ElemDeclList ElemDeclList) {
        this.ElemDeclList=ElemDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDecl!=null) ClassDecl.accept(visitor);
        if(ElemDeclList!=null) ElemDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDecl!=null) ClassDecl.traverseTopDown(visitor);
        if(ElemDeclList!=null) ElemDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDecl!=null) ClassDecl.traverseBottomUp(visitor);
        if(ElemDeclList!=null) ElemDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClDec(\n");

        if(ClassDecl!=null)
            buffer.append(ClassDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElemDeclList!=null)
            buffer.append(ElemDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClDec]");
        return buffer.toString();
    }
}
