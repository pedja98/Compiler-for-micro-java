// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class VaDecl extends ElemDec {

    private VarDecl VarDecl;
    private ElemDeclList ElemDeclList;

    public VaDecl (VarDecl VarDecl, ElemDeclList ElemDeclList) {
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
        this.ElemDeclList=ElemDeclList;
        if(ElemDeclList!=null) ElemDeclList.setParent(this);
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
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
        if(VarDecl!=null) VarDecl.accept(visitor);
        if(ElemDeclList!=null) ElemDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
        if(ElemDeclList!=null) ElemDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        if(ElemDeclList!=null) ElemDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VaDecl(\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElemDeclList!=null)
            buffer.append(ElemDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VaDecl]");
        return buffer.toString();
    }
}
