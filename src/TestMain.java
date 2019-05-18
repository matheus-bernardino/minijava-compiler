import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

import AST.Program;
import Analyzer.GlobalTableBuilder;
import Analyzer.SemanticAnalyzer;
import CodeGenerator.AssemblyGenerator;
import Parser.parser;
import Scanner.scanner;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

public class TestMain {

	public static void main(String[] args) {
		 try {
	            // create a scanner on the input file
	        	GlobalTableBuilder globalTable = new GlobalTableBuilder();
	        	SemanticAnalyzer semanticAnalaizer = new SemanticAnalyzer();
	        	AssemblyGenerator codeAsm = new AssemblyGenerator();
	        	String path = "/home/matheus/eclipse-workspace/minijava-compiler/SamplePrograms/SampleMiniJavaPrograms/BinarySearch.java";
	            ComplexSymbolFactory sf = new ComplexSymbolFactory();
	            Reader in = new BufferedReader(new FileReader(path)); 
	            		
	            scanner s = new scanner(in, sf);
	            parser p = new parser(s, sf);
	            Symbol root;
	            
		    // replace p.parse() with p.debug_parse() in next line to see trace of
		    // parser shift/reduce actions during parse
	            root = p.parse();
	            System.out.print("\nParsing completed"); 
	            Program program = (Program)root.value;
	            
	            program.accept(globalTable);
	            
	            if(globalTable.getErrorList().isEmpty())
	            	System.out.println("\nTable build succesfully");
	            else
	            	System.out.println("\nErrors encountered on the construction os the table");
	            
	            semanticAnalaizer.setSymbolTable(globalTable.getTable());
	            semanticAnalaizer.setIdentifiersType(globalTable.getIdentifiersType());
	            program.accept(semanticAnalaizer);

	            if(semanticAnalaizer.getErrorList().isEmpty())
	            	System.out.println("Semantic analizes succesful");
	            else {
	            	System.out.println("Errors encountered on the semantic analize");
	            	for (String errors: semanticAnalaizer.getErrorList()) {
	            		System.out.println(errors);
	            	}
	            }
	            
	        	program.accept(codeAsm);
	        	
	        	System.out.println("Code Assembly Generated.");
////	            List<Statement> program = (List<Statement>)root.value;
//	            for (Statement statement: program) {
//	                statement.accept(new PrettyPrintVisitor());
//	                System.out.print("\n");
//	            }
	        } catch (Exception e) {
	            // yuck: some kind of error in the compiler implementation
	            // that we're not expecting (a bug!)
	            System.err.println("Unexpected internal compiler error: " + 
	                               e.toString());
	            // print out a stack dump
	            e.printStackTrace();
	        }
	}

}
