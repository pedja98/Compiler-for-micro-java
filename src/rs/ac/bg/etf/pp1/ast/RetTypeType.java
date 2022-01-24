// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class RetTypeType extends RetType {

    private String mtdTypeName;

    public RetTypeType (String mtdTypeName) {
        this.mtdTypeName=mtdTypeName;
    }

    public String getMtdTypeName() {
        return mtdTypeName;
    }

    public void setMtdTypeName(String mtdTypeName) {
        this.mtdTypeName=mtdTypeName;
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
        buffer.append("RetTypeType(\n");

        buffer.append(" "+tab+mtdTypeName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RetTypeType]");
        return buffer.toString();
    }
}
