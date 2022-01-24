// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarationMet extends ClassDecl {

    private String className;
    private Extends Extends;
    private ClassFieldList ClassFieldList;
    private MethodDeclList MethodDeclList;

    public ClassDeclarationMet (String className, Extends Extends, ClassFieldList ClassFieldList, MethodDeclList MethodDeclList) {
        this.className=className;
        this.Extends=Extends;
        if(Extends!=null) Extends.setParent(this);
        this.ClassFieldList=ClassFieldList;
        if(ClassFieldList!=null) ClassFieldList.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public Extends getExtends() {
        return Extends;
    }

    public void setExtends(Extends Extends) {
        this.Extends=Extends;
    }

    public ClassFieldList getClassFieldList() {
        return ClassFieldList;
    }

    public void setClassFieldList(ClassFieldList ClassFieldList) {
        this.ClassFieldList=ClassFieldList;
    }

    public MethodDeclList getMethodDeclList() {
        return MethodDeclList;
    }

    public void setMethodDeclList(MethodDeclList MethodDeclList) {
        this.MethodDeclList=MethodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Extends!=null) Extends.accept(visitor);
        if(ClassFieldList!=null) ClassFieldList.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Extends!=null) Extends.traverseTopDown(visitor);
        if(ClassFieldList!=null) ClassFieldList.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Extends!=null) Extends.traverseBottomUp(visitor);
        if(ClassFieldList!=null) ClassFieldList.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarationMet(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(Extends!=null)
            buffer.append(Extends.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassFieldList!=null)
            buffer.append(ClassFieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarationMet]");
        return buffer.toString();
    }
}
