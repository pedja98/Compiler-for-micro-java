// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class CoDecl extends ElemDec {

    private ConstDecl ConstDecl;
    private ElemDeclList ElemDeclList;

    public CoDecl (ConstDecl ConstDecl, ElemDeclList ElemDeclList) {
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
        this.ElemDeclList=ElemDeclList;
        if(ElemDeclList!=null) ElemDeclList.setParent(this);
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
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
        if(ConstDecl!=null) ConstDecl.accept(visitor);
        if(ElemDeclList!=null) ElemDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
        if(ElemDeclList!=null) ElemDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        if(ElemDeclList!=null) ElemDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CoDecl(\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElemDeclList!=null)
            buffer.append(ElemDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CoDecl]");
        return buffer.toString();
    }
}
