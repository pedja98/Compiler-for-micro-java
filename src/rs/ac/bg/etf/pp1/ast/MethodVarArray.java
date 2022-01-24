// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class MethodVarArray extends MethodVar {

    private String mtdVarName;

    public MethodVarArray (String mtdVarName) {
        this.mtdVarName=mtdVarName;
    }

    public String getMtdVarName() {
        return mtdVarName;
    }

    public void setMtdVarName(String mtdVarName) {
        this.mtdVarName=mtdVarName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodVarArray(\n");

        buffer.append(" "+tab+mtdVarName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodVarArray]");
        return buffer.toString();
    }
}
