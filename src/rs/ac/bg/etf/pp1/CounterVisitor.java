package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.FormParamArr;
import rs.ac.bg.etf.pp1.ast.FormParamNoArr;
import rs.ac.bg.etf.pp1.ast.MethodVarArray;
import rs.ac.bg.etf.pp1.ast.MethodVarNoArray;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	protected int count;

	public int getCount() {
		return count;
	}

	public static class FormParamCounter extends CounterVisitor {

		public void visit(FormParamNoArr formParamDecl) {
			count++;
		}
		
		public void visit(FormParamArr formParamDecl) {
			count++;
		}
	}

	public static class VarCounter extends CounterVisitor {

		public void visit(MethodVarNoArray varDecl) {
			count++;
		}
		public void visit(MethodVarArray varDecl) {
			count++;
		}
	}
}
