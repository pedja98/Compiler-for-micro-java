// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class ElemDeclaration extends ElemDeclList {

    private ElemDec ElemDec;

    public ElemDeclaration (ElemDec ElemDec) {
        this.ElemDec=ElemDec;
        if(ElemDec!=null) ElemDec.setParent(this);
    }

    public ElemDec getElemDec() {
        return ElemDec;
    }

    public void setElemDec(ElemDec ElemDec) {
        this.ElemDec=ElemDec;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ElemDec!=null) ElemDec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ElemDec!=null) ElemDec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ElemDec!=null) ElemDec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ElemDeclaration(\n");

        if(ElemDec!=null)
            buffer.append(ElemDec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ElemDeclaration]");
        return buffer.toString();
    }
}
