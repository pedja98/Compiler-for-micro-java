package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
//import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	Logger log = Logger.getLogger(getClass());

	boolean errorDetected = false;
	int nVars;

	private Struct typeStruct = null;
	private String typeName = "";

	private Obj currMethod = null;

	private Struct mtdTypeStruct = null;
	private String mtdTypeName = "";

	private boolean mainDef = false;
	private boolean isDesArr = false;
	private boolean isVar = false;

	private List<String> lstLocalParams = null;
	private List<String> lstMtdParams = null;

	private List<String> lstDefLabels = null;
	private List<GotoSingleStm> lstUndefGotoLabels = null;

	private String desSymbName = "";

	public void report_error(String message, SyntaxNode info) {
		this.errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public boolean passed() {
		return !errorDetected;
	}

	public void visit(ProgramName progName) {
		progName.obj = TabExt.insert(Obj.Prog, progName.getProgName(), TabExt.noType);
		TabExt.openScope();
	}

	public void visit(Program program) {
		this.nVars = TabExt.currentScope.getnVars();
		TabExt.chainLocalSymbols(program.getProgramName().obj);
		TabExt.closeScope();

		if (!this.mainDef) {
			report_error("Greska: Metoda main nije definisan", null);
		}
	}

	public void visit(Type type) {
		Obj typeNode = TabExt.find(type.getTypeName());
		if (typeNode == TabExt.noObj) {
			report_error("Greska: Trazeni tip " + type.getTypeName() + " nije pronadjen u tabeli simbola! ", type);
			type.struct = TabExt.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} else {
				report_error("Greska: " + type.getTypeName() + " ne predstavlja tip!", type);
				type.struct = TabExt.noType;
			}
		}
		this.typeStruct = type.struct;
		this.typeName = type.getTypeName();
	}

	public void visit(VarNoArr var) {
		if (TabExt.find(var.getVarName()) != TabExt.noObj) {
			report_error("Greska: Promenljiva sa imenom " + var.getVarName() + " je vec deklarisana", var);
			return;
		}
		report_info("Deklarisana globalna promenljiva " + var.getVarName(), var);
		TabExt.insert(Obj.Var, var.getVarName(), this.typeStruct);
	}

	public void visit(VarArr var) {
		if (TabExt.find(var.getVarName()) != TabExt.noObj) {
			report_error("Greska: Promenljiva sa imenom " + var.getVarName() + " je vec deklarisana", var);
			return;
		}
		report_info("Deklarisana globalna nizovna promenljiva " + var.getVarName(), var);
		Struct arrStr = new Struct(Struct.Array, this.typeStruct);
		TabExt.insert(Obj.Var, var.getVarName(), arrStr);
	}

	public void visit(NumberConst numConst) {
		if (!this.typeName.equals("int")) {
			report_error("Greska: Tip za numericku const " + numConst.getConstName() + " mora da bude int", numConst);
		} else {
			if (TabExt.find(numConst.getConstName()) != TabExt.noObj) {
				report_error("Greska: Promenljiva sa imenom " + numConst.getConstName() + " je vec deklarisana ",
						numConst);
				return;
			}
			report_info("Definisana numericka konstanta " + numConst.getConstName() + " ", numConst);
			Obj numConNode = TabExt.insert(Obj.Con, numConst.getConstName(), this.typeStruct);
			numConNode.setAdr(numConst.getNumVal());
		}
	}

	public void visit(CharachterConst charConst) {
		if (!this.typeName.equals("char")) {
			report_error("Greska: Tip za char const" + charConst.getConstName() + "mora da bude char", charConst);
		} else {
			if (TabExt.find(charConst.getConstName()) != TabExt.noObj) {
				report_error("Greska: Promenljiva sa imenom " + charConst.getConstName() + " je vec deklarisana ",
						charConst);
				return;
			}
			report_info("Definisana char konstanta " + charConst.getConstName() + " ", charConst);
			Obj charConNode = TabExt.insert(Obj.Con, charConst.getConstName(), this.typeStruct);
			char constVal = charConst.getCharVal().charAt(1);
			charConNode.setAdr((int) constVal);
		}
	}

	public void visit(BooleanConst boolConst) {
		if (!this.typeName.equals("bool")) {
			report_error("Greska: Tip za bool const " + boolConst.getConstName() + " mora da bude bool", boolConst);
		} else {
			if (TabExt.find(boolConst.getConstName()) != TabExt.noObj) {
				report_error("Greska: Promenljiva sa imenom " + boolConst.getConstName() + " je vec deklarisana ",
						boolConst);
				return;
			}
			report_info("Definisana bool konstanta " + boolConst.getConstName() + " ", boolConst);
			Obj boolConNode = TabExt.insert(Obj.Con, boolConst.getConstName(), this.typeStruct);
			String boolVal = boolConst.getBoolVal();
			if (boolVal.equals("false")) {
				boolConNode.setAdr(0);
			} else {
				boolConNode.setAdr(1);
			}
		}
	}

	public void visit(RetTypeType type) {
		Obj typeNode = TabExt.find(type.getMtdTypeName());
		if (typeNode == TabExt.noObj) {
			report_error("Greska: Trazeni tip " + type.getMtdTypeName() + " nije pronadjen u tabeli simbola! ", type);
			type.struct = TabExt.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} else {
				report_error("Greska: " + type.getMtdTypeName() + " ne predstavlja tip!", type);
				type.struct = TabExt.noType;
			}
		}
		this.mtdTypeStruct = type.struct;
		this.mtdTypeName = type.getMtdTypeName();
	}

	public void visit(ReturnTypeVoid retVoid) {
		this.mtdTypeName = "void";
		this.mtdTypeStruct = TabExt.noType;
	}

	public void visit(MethTypeName metTypName) {
		this.currMethod = TabExt.insert(Obj.Meth, metTypName.getMtdName(), this.mtdTypeStruct);

		metTypName.obj = this.currMethod;

		this.lstLocalParams = new ArrayList<>();
		this.lstMtdParams = new ArrayList<>();
		this.lstDefLabels = new ArrayList<>();
		this.lstUndefGotoLabels = new ArrayList<>();

		TabExt.openScope();
		report_info("Obradjuje se funkcija " + metTypName.getMtdName(), metTypName);
		if (metTypName.getMtdName().equals("main")) {
			this.mainDef = true;
		}
		if (this.mainDef && !this.mtdTypeName.equals("void")) {
			report_error("Greska: Metod main mora biti tipa void", metTypName);
		}
	}

	public void visit(MethodDecl metDecl) {
		TabExt.chainLocalSymbols(this.currMethod);
		TabExt.closeScope();
		for (GotoSingleStm g : this.lstUndefGotoLabels) {
			if (this.lstDefLabels.contains(g.getGotoLabelName())) {
				continue;
			} else {
				report_error("Greska: goto naredba koristi nedefinisanu labelu " + g.getGotoLabelName(), g);
			}
		}
		this.currMethod = null;
		this.lstLocalParams = null;
		this.lstMtdParams = null;
	}

	public void visit(MethodVarNoArray var) {
		if (this.lstLocalParams.contains(var.getMtdVarName())) {
			report_error("Greska: Metod " + this.currMethod.getName() + " vec sadrzi lokalnu promenljivu "
					+ var.getMtdVarName(), var);
			return;
		}
		report_info("Deklarisana lokalna promenljiva " + var.getMtdVarName(), var);
		TabExt.insert(Obj.Var, var.getMtdVarName(), this.typeStruct);
		this.lstLocalParams.add(var.getMtdVarName());
	}

	public void visit(MethodVarArray var) {
		if (this.lstLocalParams.contains(var.getMtdVarName())) {
			report_error("Greska: Metod " + this.currMethod.getName() + " vec sadrzi lokalnu promenljivu "
					+ var.getMtdVarName(), var);
			return;
		}
		report_info("Deklarisana lokalna nizovna promenljiva " + var.getMtdVarName(), var);
		Struct arrStr = new Struct(Struct.Array, this.typeStruct);
		this.lstLocalParams.add(var.getMtdVarName());
		TabExt.insert(Obj.Var, var.getMtdVarName(), arrStr);
	}

	public void visit(FormParamNoArr param) {
		if (this.currMethod.getName().equals("main")) {
			report_error("Greska: Metod main ne sme da ima paramatre", param);
			return;
		}
		if (this.lstMtdParams.contains(param.getParamName())) {
			report_error("Greska: Metod " + this.currMethod.getName() + " vec sadrzi  parametar sa nazivom"
					+ param.getParamName(), param);
			return;
		}
		report_info("Deklarisana parametar funkcije " + param.getParamName(), param);
		TabExt.insert(Obj.Var, param.getParamName(), this.typeStruct);
		this.lstMtdParams.add(param.getParamName());
	}

	public void visit(FormParamArr param) {
		if (this.currMethod.getName().equals("main")) {
			report_error("Greska: Metod main ne sme da ima paramatre", param);
			return;
		}
		if (this.lstMtdParams.contains(param.getParamName())) {
			report_error("Greska: Metod " + this.currMethod.getName() + " vec sadrzi  parametar sa nazivom"
					+ param.getParamName(), param);
			return;
		}
		report_info("Deklarisana lokalna nizovna promenljiva " + param.getParamName(), param);
		Struct arrStr = new Struct(Struct.Array, this.typeStruct);
		this.lstMtdParams.add(param.getParamName());
		TabExt.insert(Obj.Var, param.getParamName(), arrStr);
	}

	public void visit(Lab l) {
		if (this.lstDefLabels.contains(l.getLabelName())) {
			report_error(
					"Greska: Na liniji " + l.getLine() + " labela sa nazivom " + l.getLabelName() + " je vec navedena",
					null);
			return;
		}
		this.lstDefLabels.add(l.getLabelName());
	}

	public void visit(GotoSingleStm goTo) {
		this.lstUndefGotoLabels.add(goTo);
	}

	public void visit(DesNotArr des) {
		Obj obj = TabExt.find(des.getDesName());
		if (obj == TabExt.noObj) {
			report_error("Greska: Na liniji " + des.getLine() + " ime " + des.getDesName() + " nije deklarisano! ",
					null);
		}
		des.obj = obj;
		this.isDesArr = false;
		if (des.obj.getKind() == Obj.Con) {
			report_info("Pristup globalnoj konstanti " + des.getDesName() + " na liniji " + des.getLine(), null);
			return;
		}
		this.desSymbName = des.getDesName();
		if (des.obj.getLevel() == 0) {
			report_info("Pristup globalnoj promenljivoj " + des.getDesName() + " na liniji " + des.getLine(), null);
		} else {
			report_info("Pristup lokalnoj promenljivoj " + des.getDesName() + " na liniji " + des.getLine(), null);
		}
	}

	public void visit(DesArrName des) {
		Obj obj = TabExt.find(des.getDesName());
		des.obj = obj;
		if (obj == TabExt.noObj) {
			report_error("Greska: Na liniji " + des.getLine() + " ime " + des.getDesName() + " nije deklarisano! ",
					null);
			des.obj = obj;
			return;
		}
		if (obj.getType().getKind() != Struct.Array) {
			report_error("Greska: Na liniji " + des.getLine() + " ime " + des.getDesName() + " nije niz! ", null);
			des.obj = TabExt.noObj;
			return;
		}
		this.desSymbName = des.getDesName();
		if (des.obj.getLevel() == 0) {
			report_info("Pristup elementu globalnog niza " + des.getDesName() + " na liniji " + des.getLine(), null);
		} else {
			report_info("Pristup elementu lokalnog niza " + des.getDesName() + " na liniji " + des.getLine(), null);
		}
	}

	public void visit(DesArr des) {
		Obj obj = des.getDesArrName().obj;
		Struct te = des.getExpr().struct;
		if (te != TabExt.intType) {
			report_error(
					"Greska: Na liniji " + des.getLine() + " pokusaj pristupa elementu niza preko necelobrojnog izraza",
					null);
			des.obj = TabExt.noObj;
			return;
		}
		des.obj = obj;
		this.isDesArr = true;
	}

	public void visit(DesStatementInc desInc) {
		if (desInc.getDesignator().obj.getType() == TabExt.intType) {
			report_info(
					"Koristi se promenljiva " + this.desSymbName + " u increment izrazu na liniji " + desInc.getLine(),
					null);
			return;
		} else if (desInc.getDesignator().obj.getType().getKind() == Struct.Array
				&& desInc.getDesignator().obj.getType().getElemType() == TabExt.intType && this.isDesArr) {
			report_info(
					"Koristi se element niza " + this.desSymbName + " u increment izrazu na liniji " + desInc.getLine(),
					null);
			return;
		} else {
			report_error("Greska: Promenljiva " + this.desSymbName + "mora biti tipa int ili element niza intigera",
					desInc);
		}
	}

	public void visit(DesStatementDec desInc) {
		if (desInc.getDesignator().obj.getType() == TabExt.intType) {
			report_info(
					"Koristi se promenljiva " + this.desSymbName + " u decrementu izrazu na liniji " + desInc.getLine(),
					null);
			return;
		} else if (desInc.getDesignator().obj.getType().getKind() == Struct.Array
				&& desInc.getDesignator().obj.getType().getElemType() == TabExt.intType && this.isDesArr) {
			report_info("Koristi se element niza " + this.desSymbName + " u decrementu izrazu na liniji "
					+ desInc.getLine(), null);
			return;
		} else {
			report_error("Greska: Promenljiva " + this.desSymbName + "mora biti tipa int ili element niza intigera",
					desInc);
		}
	}

	public void visit(FactDes fact) {
		if (!this.isDesArr) {
			fact.struct = fact.getDesignator().obj.getType();
		} else {
			fact.struct = fact.getDesignator().obj.getType().getElemType();
		}
	}

	public void visit(FactNumConst fact) {
		fact.struct = TabExt.intType;
	}

	public void visit(FactCharConst fact) {
		fact.struct = TabExt.charType;
	}

	public void visit(FactBoolConst fact) {
		fact.struct = TabExt.boolType;
	}

	public void visit(FactNewArr fact) {
		Struct t = fact.getExpr().struct;
		if (t != TabExt.intType) {
			report_error("Greska: izraz u kreiranju novog tipa nije tipa int ", fact);
			fact.struct = TabExt.noType;
			return;
		}

		if (this.typeStruct != TabExt.intType && this.typeStruct != TabExt.charType
				&& this.typeStruct != TabExt.boolType) {
			report_error("Greska: tip niza mora biti i od ugradjenih tipova", fact);
			fact.struct = TabExt.noType;
			return;
		}

		Struct arrStr = new Struct(Struct.Array, this.typeStruct);
		fact.struct = arrStr;
	}

	public void visit(FactBracExpr fact) {
		fact.struct = fact.getExpr().struct;
	}

	public void visit(FactExpr term) {
		term.struct = term.getFactor().struct;
	}

	public void visit(MulTerm term) {
		Struct t = term.getTerm().struct;
		Struct te = term.getFactor().struct;

		if (te.equals(t) && te == TabExt.intType) {
			term.struct = te;
		} else {
			report_error("Greska na liniji " + term.getLine() + " : nekompatibilni tipovi u izrazu.", null);
			term.struct = TabExt.noType;
		}
	}

	public void visit(TermNoList term) {
		Struct te = term.getTerm().struct;
		if (te == TabExt.intType) {
			term.struct = te;
		} else {
			report_error("Greska na liniji " + term.getLine() + " : nekompatibilni tipovi u izrazu.", null);
			term.struct = TabExt.noType;
		}

	}

	public void visit(TermLst term) {
		Struct t = term.getTerm().struct;
		Struct te = term.getTermList().struct;

		if (te.equals(t) && te == TabExt.intType) {
			term.struct = te;
		} else {
			report_error("Greska na liniji " + term.getLine() + " : nekompatibilni tipovi u izrazu.", null);
			term.struct = TabExt.noType;
		}
	}

	public void visit(MoreTerm term) {
		Struct t = term.getTerm().struct;
		Struct te = term.getTermList().struct;

		if (te.equals(t) && te == TabExt.intType) {
			term.struct = te;
		} else {
			report_error("Greska na liniji " + term.getLine() + " : nekompatibilni tipovi u izrazu.", null);
			term.struct = TabExt.noType;
		}
	}

	public void visit(MinusMoreTerm term) {
		Struct t = term.getTerm().struct;
		Struct te = term.getTermList().struct;

		if (te.equals(t) && te == TabExt.intType) {
			term.struct = te;
		} else {
			report_error("Greska na liniji " + term.getLine() + " : nekompatibilni tipovi u izrazu.", null);
			term.struct = TabExt.noType;
		}
	}

	public void visit(MinusOneTerm term) {
		Struct te = term.getTerm().struct;
		if (te == TabExt.intType) {
			term.struct = te;
		} else {
			report_error("Greska na liniji " + term.getLine() + " : nekompatibilni tipovi u izrazu.", null);
			term.struct = TabExt.noType;
		}
	}

	public void visit(OneTerm term) {
		term.struct = term.getTerm().struct;
	}

	public void visit(DesLeftAsgn des) {
		if (des.getDesignator().obj.getType().getKind() == Struct.Array && this.isDesArr) {
			Obj obj = new Obj(Obj.Elem, "elem", des.getDesignator().obj.getType().getElemType());
			des.obj = obj;
			this.isVar = true;
		} else {
			des.obj = des.getDesignator().obj;
			if (des.getDesignator().obj.getKind() == Obj.Var) {
				this.isVar = true;
			} else {
				this.isVar = false;
			}
		}
	}

	public void visit(DesStatementAsgnExpr des) {

		if (!this.isVar) {
			report_error("Greska na liniji " + des.getLine() + " : pokusaj dodele vrednosti konstanti", null);
			return;
		}

		Struct t = des.getExpr().struct;
		Struct te = des.getDesLeftAsgn().obj.getType();

		if (t == TabExt.nullType) {
			if (te.getKind() != Struct.Array) {
				report_error("Greska na liniji " + des.getLine() + " : nekompatibilni tipovi u izrazu dodele.", null);
			}
			return;
		}

		if (te.equals(t)) {
			return;
		} else {
			report_error("Greska na liniji " + des.getLine() + " : nekompatibilni tipovi u izrazu dodele.", null);
		}
	}

	public void visit(ReadDesignator des) {
		if (des.getDesignator().obj.getType().getKind() == Struct.Array && this.isDesArr) {
			des.struct = des.getDesignator().obj.getType().getElemType();
		} else {
			if (des.getDesignator().obj.getKind() == Obj.Var) {
				des.struct = des.getDesignator().obj.getType();
			} else {
				des.struct = TabExt.noType;
			}
		}
	}

	public void visit(Read read) {
		Struct t = read.getReadDesignator().struct;
		if (t == TabExt.intType || t == TabExt.charType || t == TabExt.boolType) {
			return;
		}
		report_error(
				"Greska na liniji " + read.getLine()
						+ " : nekompatibilni tipovi u read naredbi (mora biti promenljiva tipa int, char ili bool).",
				null);
	}

	public void visit(Print print) {
		Struct t = print.getExpr().struct;
		if (t == TabExt.intType || t == TabExt.charType || t == TabExt.boolType) {
			return;
		}
		report_error("Greska na liniji " + print.getLine()
				+ " : nekompatibilni tipovi u print naredbi (izraz mora biti tipa int, char ili bool).", null);
	}
}
