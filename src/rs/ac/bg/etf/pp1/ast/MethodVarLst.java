// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class MethodVarLst extends MethodVarList {

    private MethodVarDeclaration MethodVarDeclaration;
    private MethodVarList MethodVarList;

    public MethodVarLst (MethodVarDeclaration MethodVarDeclaration, MethodVarList MethodVarList) {
        this.MethodVarDeclaration=MethodVarDeclaration;
        if(MethodVarDeclaration!=null) MethodVarDeclaration.setParent(this);
        this.MethodVarList=MethodVarList;
        if(MethodVarList!=null) MethodVarList.setParent(this);
    }

    public MethodVarDeclaration getMethodVarDeclaration() {
        return MethodVarDeclaration;
    }

    public void setMethodVarDeclaration(MethodVarDeclaration MethodVarDeclaration) {
        this.MethodVarDeclaration=MethodVarDeclaration;
    }

    public MethodVarList getMethodVarList() {
        return MethodVarList;
    }

    public void setMethodVarList(MethodVarList MethodVarList) {
        this.MethodVarList=MethodVarList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodVarDeclaration!=null) MethodVarDeclaration.accept(visitor);
        if(MethodVarList!=null) MethodVarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodVarDeclaration!=null) MethodVarDeclaration.traverseTopDown(visitor);
        if(MethodVarList!=null) MethodVarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodVarDeclaration!=null) MethodVarDeclaration.traverseBottomUp(visitor);
        if(MethodVarList!=null) MethodVarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodVarLst(\n");

        if(MethodVarDeclaration!=null)
            buffer.append(MethodVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVarList!=null)
            buffer.append(MethodVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodVarLst]");
        return buffer.toString();
    }
}
