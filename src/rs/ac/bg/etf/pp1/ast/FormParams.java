// generated with ast extension for cup
// version 0.8
// 24/0/2022 15:44:49


package rs.ac.bg.etf.pp1.ast;

public class FormParams extends FormPars {

    private FormParamTypeName FormParamTypeName;
    private FormPar FormPar;

    public FormParams (FormParamTypeName FormParamTypeName, FormPar FormPar) {
        this.FormParamTypeName=FormParamTypeName;
        if(FormParamTypeName!=null) FormParamTypeName.setParent(this);
        this.FormPar=FormPar;
        if(FormPar!=null) FormPar.setParent(this);
    }

    public FormParamTypeName getFormParamTypeName() {
        return FormParamTypeName;
    }

    public void setFormParamTypeName(FormParamTypeName FormParamTypeName) {
        this.FormParamTypeName=FormParamTypeName;
    }

    public FormPar getFormPar() {
        return FormPar;
    }

    public void setFormPar(FormPar FormPar) {
        this.FormPar=FormPar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParamTypeName!=null) FormParamTypeName.accept(visitor);
        if(FormPar!=null) FormPar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParamTypeName!=null) FormParamTypeName.traverseTopDown(visitor);
        if(FormPar!=null) FormPar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParamTypeName!=null) FormParamTypeName.traverseBottomUp(visitor);
        if(FormPar!=null) FormPar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParams(\n");

        if(FormParamTypeName!=null)
            buffer.append(FormParamTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPar!=null)
            buffer.append(FormPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParams]");
        return buffer.toString();
    }
}
