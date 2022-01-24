package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;

	private List<String> lstAddop = new ArrayList<String>();
	private List<String> lstMulop = new ArrayList<String>();
	
	private List<String> lstGotoWaitLabel = null; 
	private List<String> lstDefLabelName = null; 
	private List<Integer> lstGotoWaitLabelPc = null; 
	private List<Integer> lstDefLabelPc = null;
	
	private Obj readDesObj = null;

	private boolean isArray = true;
	private boolean isReadOp = false;

	private List<String> lstIsNeg = new ArrayList<String>();
	private List<Integer> lstNegNumOfBr = new ArrayList<Integer>();

	public int getMainPc() {
		return mainPc;
	}

	public void visit(Lab l) {
		this.lstDefLabelName.add(l.getLabelName());
		this.lstDefLabelPc.add(Code.pc);
		int i = 0;
		while (i < this.lstGotoWaitLabel.size()) {
			if (this.lstGotoWaitLabel.get(i).equals(l.getLabelName())) {
				int gotoPc = this.lstGotoWaitLabelPc.get(i);
				Code.fixup(gotoPc + 1);
				this.lstGotoWaitLabel.remove(i);
				this.lstGotoWaitLabelPc.remove(i);
			}
			i++;
		}
	}

	public void visit(GotoSingleStm goTo) {
		if (this.lstDefLabelName.contains(goTo.getGotoLabelName())) {
			int labPc = this.lstDefLabelName.indexOf(goTo.getGotoLabelName());
			Code.putJump(this.lstDefLabelPc.get(labPc));
		} else {
			this.lstGotoWaitLabel.add(goTo.getGotoLabelName());
			this.lstGotoWaitLabelPc.add(Code.pc);
			Code.putJump(0);
		}
	}
	
	public void visit(Print printStmt) {
		if (printStmt.getExpr().struct == TabExt.intType || printStmt.getExpr().struct == TabExt.boolType) {
			Code.loadConst(5);
			Code.put(Code.print);
		} else if (printStmt.getExpr().struct == TabExt.charType) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}

	public void visit(Read readStmt) {
		if (this.isArray) {
			if (readStmt.getReadDesignator().struct == TabExt.charType) {
				Code.put(Code.bread);
				Code.put(Code.bastore);
			} else {
				Code.put(Code.read);
				Code.put(Code.astore);
			}
		} else {
			if (readStmt.getReadDesignator().struct == TabExt.charType) {
				Code.put(Code.bread);
				Code.store(this.readDesObj);
			} else {
				Code.put(Code.read);
				Code.store(this.readDesObj);
			}
		}
	}

	public void visit(FactNumConst cnst) {
		Obj con = TabExt.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getNumVal());
		Code.load(con);
		if (this.lstIsNeg.size() == 0) {
			return;
		}

		String neg = this.lstIsNeg.get(this.lstIsNeg.size() - 1);
		if (neg.equals("Neg")) {
			if (this.lstNegNumOfBr.get(this.lstNegNumOfBr.size() - 1) == 0) {
				this.lstIsNeg.remove(this.lstIsNeg.size() - 1);
				this.lstNegNumOfBr.remove(this.lstNegNumOfBr.size() - 1);
				Code.put(Code.neg);
			}
		} else {
			this.lstIsNeg.remove(this.lstIsNeg.size() - 1);
		}
	}

	public void visit(FactCharConst cnst) {
		Obj con = TabExt.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		char constVal = cnst.getCharVal().charAt(1);
		con.setAdr((int) constVal);
		Code.load(con);
	}

	public void visit(Negation neg) {
		this.lstIsNeg.add("Neg");
		this.lstNegNumOfBr.add(0);
	}

	public void visit(BrO b) {
		if (this.lstNegNumOfBr.size() == 0) {
			return;
		}
		int i = this.lstNegNumOfBr.remove(this.lstNegNumOfBr.size() - 1);
		this.lstNegNumOfBr.add(++i);
	}

	public void visit(BrC b) {
		if (this.lstNegNumOfBr.size() == 0) {
			return;
		}
		int i = this.lstNegNumOfBr.remove(this.lstNegNumOfBr.size() - 1);
		i--;
		if (i == 0) {
			Code.put(Code.neg);
			this.lstIsNeg.remove(this.lstIsNeg.size() - 1);
		} else {
			this.lstNegNumOfBr.add(i);
		}
	}

	public void visit(NoNegation noNeg) {
		this.lstIsNeg.add("NoNeg");
	}

	public void visit(FactBoolConst cnst) {
		Obj con = TabExt.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		String bv = cnst.getBoolVal();
		if (bv.equals("true")) {
			con.setAdr(1);
		} else {
			con.setAdr(0);
		}
		Code.load(con);
	}

	public void visit(DesStatementAsgnExpr asg) {

		Code.store(asg.getDesLeftAsgn().obj);
	}

	public void visit(DesArr des) {
		this.isArray = true;
	}

	public void visit(DesArrName des) {
		Code.load(des.obj);
	}

	public void visit(FactDes fact) {
		if (this.isArray) {
			this.isArray = false;
			if (fact.getDesignator().obj.getType().getElemType() == TabExt.intType) {
				Code.put(Code.aload);
			} else if (fact.getDesignator().obj.getType().getElemType() == TabExt.charType) {
				Code.put(Code.baload);
			}
		}
		if (this.lstIsNeg.size() == 0) {
			return;
		}
		String neg = this.lstIsNeg.get(this.lstIsNeg.size() - 1);
		if (neg.equals("Neg")) {
			if (this.lstNegNumOfBr.get(this.lstNegNumOfBr.size() - 1) == 0) {
				this.lstIsNeg.remove(this.lstIsNeg.size() - 1);
				this.lstNegNumOfBr.remove(this.lstNegNumOfBr.size() - 1);
				Code.put(Code.neg);
			}
		} else {
			this.lstIsNeg.remove(this.lstIsNeg.size() - 1);
		}
	}

	public void visit(DesNotArr des) {
		this.isArray = false;
		SyntaxNode parent = des.getParent();
		this.readDesObj = des.obj;
		if (parent.getClass() != DesLeftAsgn.class && this.isReadOp == false) {
			Code.load(des.obj);
			return;
		}
		this.isReadOp = false;
	}

	public void visit(ReadOp rop) {
		this.isReadOp = true;
	}

	public void visit(FactNewArr fact) {
		Code.put(Code.newarray);
		if (fact.getType().struct == TabExt.intType) {
			Code.loadConst(1);
		} else {
			Code.loadConst(0);
		}
	}

	public void visit(MethTypeName methodTypeName) {
		if ("main".equalsIgnoreCase(methodTypeName.getMtdName())) {
			mainPc = Code.pc;
		}

		methodTypeName.obj.setAdr(Code.pc);

		SyntaxNode methodNode = methodTypeName.getParent();

		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);

		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);

		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
		
		this.lstDefLabelName = new ArrayList<>();
		this.lstDefLabelPc = new ArrayList<>();
		this.lstGotoWaitLabel = new ArrayList<>();
		this.lstGotoWaitLabelPc = new ArrayList<>();
	}

	public void visit(AddOperation add) {
		this.lstAddop.add("PLUS");
	}

	public void visit(SubOperation sub) {
		this.lstAddop.add("MINUS");
	}

	public void visit(TermNoList term) {
		String addOp = this.lstAddop.remove(this.lstAddop.size() - 1);
		if (addOp.equals("PLUS")) {
			Code.put(Code.add);
		} else {
			Code.put(Code.sub);
		}
	}

	public void visit(TermLst term) {
		String addOp = this.lstAddop.remove(this.lstAddop.size() - 1);
		if (addOp.equals("PLUS")) {
			Code.put(Code.add);
		} else {
			Code.put(Code.sub);
		}
	}

	public void visit(MulOperation mul) {
		this.lstMulop.add("MUL");
	}

	public void visit(DivOperation div) {
		this.lstMulop.add("DIV");
	}

	public void visit(RemOperation rem) {
		this.lstMulop.add("REM");
	}

	public void visit(MulTerm terem) {
		String mulOp = this.lstMulop.remove(this.lstMulop.size() - 1);
		if (mulOp.equals("MUL")) {
			Code.put(Code.mul);
		} else if (mulOp.equals("DIV")) {
			Code.put(Code.div);
		} else {
			Code.put(Code.rem);
		}
	}

	public void visit(DesStatementInc des) {
		if (this.isArray) {
			Code.put(Code.dup2);
			Code.put(Code.aload);
			Code.loadConst(1);
			Code.put(Code.add);
			Code.put(Code.astore);
			return;
		}
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(des.getDesignator().obj);
	}

	public void visit(DesStatementDec des) {
		if (this.isArray) {
			Code.put(Code.dup2);
			Code.put(Code.aload);
			Code.loadConst(1);
			Code.put(Code.sub);
			Code.put(Code.astore);
			return;
		}
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(des.getDesignator().obj);
	}

	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

}
