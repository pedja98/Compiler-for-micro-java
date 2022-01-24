// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class OneTerm extends Expr {

    private NoNegation NoNegation;
    private Term Term;

    public OneTerm (NoNegation NoNegation, Term Term) {
        this.NoNegation=NoNegation;
        if(NoNegation!=null) NoNegation.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public NoNegation getNoNegation() {
        return NoNegation;
    }

    public void setNoNegation(NoNegation NoNegation) {
        this.NoNegation=NoNegation;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NoNegation!=null) NoNegation.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NoNegation!=null) NoNegation.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NoNegation!=null) NoNegation.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneTerm(\n");

        if(NoNegation!=null)
            buffer.append(NoNegation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneTerm]");
        return buffer.toString();
    }
}
