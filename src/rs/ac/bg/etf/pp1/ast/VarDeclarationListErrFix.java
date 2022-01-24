// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationListErrFix extends VarDeclList {

    private VarDeclList VarDeclList;
    private VarDecListErr VarDecListErr;

    public VarDeclarationListErrFix (VarDeclList VarDeclList, VarDecListErr VarDecListErr) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.VarDecListErr=VarDecListErr;
        if(VarDecListErr!=null) VarDecListErr.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public VarDecListErr getVarDecListErr() {
        return VarDecListErr;
    }

    public void setVarDecListErr(VarDecListErr VarDecListErr) {
        this.VarDecListErr=VarDecListErr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(VarDecListErr!=null) VarDecListErr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(VarDecListErr!=null) VarDecListErr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(VarDecListErr!=null) VarDecListErr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationListErrFix(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecListErr!=null)
            buffer.append(VarDecListErr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationListErrFix]");
        return buffer.toString();
    }
}
