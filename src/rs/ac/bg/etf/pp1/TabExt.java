package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class TabExt extends Tab {
	public static final Struct boolType = new Struct(5);
	
	public static void init() {
		Tab.init();
		Scope universe = Tab.currentScope;
		universe.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}
	
	public static void dump(SymbolTableVisitor stv) {
		System.out.println("=====================SYMBOL TABLE DUMP=========================");
		if (stv == null)
			stv = new DumpSymbolTableVisitorExt();
		for (Scope s = currentScope; s != null; s = s.getOuter()) {
			s.accept(stv);
		}
		System.out.println(stv.getOutput());
	}
	
	public static void dump() {
		dump(null);
	}
	
	
}
