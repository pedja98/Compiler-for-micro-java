// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class VarDeclaration extends VarDecl {

    private Type Type;
    private VarDeclErrFix VarDeclErrFix;

    public VarDeclaration (Type Type, VarDeclErrFix VarDeclErrFix) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclErrFix=VarDeclErrFix;
        if(VarDeclErrFix!=null) VarDeclErrFix.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclErrFix getVarDeclErrFix() {
        return VarDeclErrFix;
    }

    public void setVarDeclErrFix(VarDeclErrFix VarDeclErrFix) {
        this.VarDeclErrFix=VarDeclErrFix;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDeclErrFix!=null) VarDeclErrFix.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclErrFix!=null) VarDeclErrFix.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclErrFix!=null) VarDeclErrFix.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclErrFix!=null)
            buffer.append(VarDeclErrFix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclaration]");
        return buffer.toString();
    }
}
