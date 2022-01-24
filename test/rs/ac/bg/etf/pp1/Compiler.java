package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
//import rs.etf.pp1.symboltable.Tab;

public class Compiler {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void tsdump() {
		TabExt.dump();
	}

	public static void main(String[] args) throws Exception {

		Logger log = Logger.getLogger(Compiler.class);
		Reader br = null;
		try {
			String path = args[0];
			
			File sourceCode = new File(path);
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());

			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);

			MJParser p = new MJParser(lexer);
			Symbol s = p.parse();

			TabExt.init();
			
			Program prog = (Program) (s.value);
			log.info(prog.toString(""));
			SemanticAnalyzer v = new SemanticAnalyzer();
			prog.traverseBottomUp(v); 
			log.info("===================================");
			tsdump();

			if(!p.errorDetected && v.passed()){
				String pathObj = args[1];
				log.info("Parsiranje uspesno zavrseno!");
				File objFile = new File(pathObj);
				if(objFile.exists()) objFile.delete();
				
				CodeGenerator codeGenerator = new CodeGenerator();
				prog.traverseBottomUp(codeGenerator);
				Code.dataSize = v.nVars;
				Code.mainPc = codeGenerator.getMainPc();
				Code.write(new FileOutputStream(objFile));
			}else{
				log.error("Parsiranje NIJE uspesno zavrseno!");
			}
			
		} 
		catch(FileNotFoundException e) {
			log.error(e.getMessage(), e);
		}
		finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e1) {
					log.error(e1.getMessage(), e1);
				}
		}

	}

}
