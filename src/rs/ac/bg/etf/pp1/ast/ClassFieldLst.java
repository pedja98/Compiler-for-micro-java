// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class ClassFieldLst extends ClassFieldList {

    private VarDecl VarDecl;
    private ClassFieldList ClassFieldList;

    public ClassFieldLst (VarDecl VarDecl, ClassFieldList ClassFieldList) {
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
        this.ClassFieldList=ClassFieldList;
        if(ClassFieldList!=null) ClassFieldList.setParent(this);
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public ClassFieldList getClassFieldList() {
        return ClassFieldList;
    }

    public void setClassFieldList(ClassFieldList ClassFieldList) {
        this.ClassFieldList=ClassFieldList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDecl!=null) VarDecl.accept(visitor);
        if(ClassFieldList!=null) ClassFieldList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
        if(ClassFieldList!=null) ClassFieldList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        if(ClassFieldList!=null) ClassFieldList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassFieldLst(\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassFieldList!=null)
            buffer.append(ClassFieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassFieldLst]");
        return buffer.toString();
    }
}
