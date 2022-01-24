// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class MethodVarListOneElem extends MethodVarList {

    private MethodVarDeclaration MethodVarDeclaration;

    public MethodVarListOneElem (MethodVarDeclaration MethodVarDeclaration) {
        this.MethodVarDeclaration=MethodVarDeclaration;
        if(MethodVarDeclaration!=null) MethodVarDeclaration.setParent(this);
    }

    public MethodVarDeclaration getMethodVarDeclaration() {
        return MethodVarDeclaration;
    }

    public void setMethodVarDeclaration(MethodVarDeclaration MethodVarDeclaration) {
        this.MethodVarDeclaration=MethodVarDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodVarDeclaration!=null) MethodVarDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodVarDeclaration!=null) MethodVarDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodVarDeclaration!=null) MethodVarDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodVarListOneElem(\n");

        if(MethodVarDeclaration!=null)
            buffer.append(MethodVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodVarListOneElem]");
        return buffer.toString();
    }
}
