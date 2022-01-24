// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class MtdVars extends MethodVars {

    private MethodVarList MethodVarList;

    public MtdVars (MethodVarList MethodVarList) {
        this.MethodVarList=MethodVarList;
        if(MethodVarList!=null) MethodVarList.setParent(this);
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
        if(MethodVarList!=null) MethodVarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodVarList!=null) MethodVarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodVarList!=null) MethodVarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MtdVars(\n");

        if(MethodVarList!=null)
            buffer.append(MethodVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MtdVars]");
        return buffer.toString();
    }
}
