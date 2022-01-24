// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class ReturnTypeNoVoid extends ReturnType {

    private RetType RetType;

    public ReturnTypeNoVoid (RetType RetType) {
        this.RetType=RetType;
        if(RetType!=null) RetType.setParent(this);
    }

    public RetType getRetType() {
        return RetType;
    }

    public void setRetType(RetType RetType) {
        this.RetType=RetType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RetType!=null) RetType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RetType!=null) RetType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RetType!=null) RetType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnTypeNoVoid(\n");

        if(RetType!=null)
            buffer.append(RetType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnTypeNoVoid]");
        return buffer.toString();
    }
}
