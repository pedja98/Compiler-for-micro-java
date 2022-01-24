// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class MinusOneTerm extends Expr {

    private Negation Negation;
    private Term Term;

    public MinusOneTerm (Negation Negation, Term Term) {
        this.Negation=Negation;
        if(Negation!=null) Negation.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public Negation getNegation() {
        return Negation;
    }

    public void setNegation(Negation Negation) {
        this.Negation=Negation;
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
        if(Negation!=null) Negation.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Negation!=null) Negation.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Negation!=null) Negation.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MinusOneTerm(\n");

        if(Negation!=null)
            buffer.append(Negation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MinusOneTerm]");
        return buffer.toString();
    }
}
