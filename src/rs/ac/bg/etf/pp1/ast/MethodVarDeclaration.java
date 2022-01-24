// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class MethodVarDeclaration implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private MethodVar MethodVar;
    private MethodVarDeclList MethodVarDeclList;

    public MethodVarDeclaration (Type Type, MethodVar MethodVar, MethodVarDeclList MethodVarDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.MethodVar=MethodVar;
        if(MethodVar!=null) MethodVar.setParent(this);
        this.MethodVarDeclList=MethodVarDeclList;
        if(MethodVarDeclList!=null) MethodVarDeclList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public MethodVar getMethodVar() {
        return MethodVar;
    }

    public void setMethodVar(MethodVar MethodVar) {
        this.MethodVar=MethodVar;
    }

    public MethodVarDeclList getMethodVarDeclList() {
        return MethodVarDeclList;
    }

    public void setMethodVarDeclList(MethodVarDeclList MethodVarDeclList) {
        this.MethodVarDeclList=MethodVarDeclList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(MethodVar!=null) MethodVar.accept(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MethodVar!=null) MethodVar.traverseTopDown(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MethodVar!=null) MethodVar.traverseBottomUp(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodVarDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVar!=null)
            buffer.append(MethodVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVarDeclList!=null)
            buffer.append(MethodVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodVarDeclaration]");
        return buffer.toString();
    }
}
