package Analyzer;

import java.util.Vector;

import AST.And;
import AST.ArrayAssign;
import AST.ArrayLength;
import AST.ArrayLookup;
import AST.Assign;
import AST.Block;
import AST.BooleanType;
import AST.Call;
import AST.ClassDeclExtends;
import AST.ClassDeclSimple;
import AST.Display;
import AST.DoubleType;
import AST.False;
import AST.Formal;
import AST.GreaterThan;
import AST.Identifier;
import AST.IdentifierExp;
import AST.IdentifierType;
import AST.If;
import AST.IfElse;
import AST.IntArrayType;
import AST.IntegerLiteral;
import AST.IntegerType;
import AST.LessThan;
import AST.MainClass;
import AST.MethodDecl;
import AST.Minus;
import AST.NewArray;
import AST.NewObject;
import AST.Not;
import AST.Or;
import AST.Plus;
import AST.Print;
import AST.Program;
import AST.This;
import AST.Times;
import AST.True;
import AST.VarDecl;
import AST.While;
import AST.Visitor.Visitor;

public class GlobalTableBuilder implements Visitor {
	private SymbolTable globalTable;
	private Vector<String> errorList;
	
	public GlobalTableBuilder() {
		setTable(new SymbolTable());
		setErrorList(new Vector<String>());
	}
	
	
	@Override
	public void visit(Display n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Or n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Program n) {
		n.m.accept(this);
		
		for(int i = 0; i < n.cl.size(); i++)
		{ 
			n.cl.get(i).accept(this);
		}
	}

	@Override
	public void visit(MainClass n) {
		ClassAnalyzer mainClass = new ClassAnalyzer("", n.i1.s);
		globalTable.setClass(mainClass);
	}

	@Override
	public void visit(ClassDeclSimple n) {
		ClassAnalyzer simpleClass = new ClassAnalyzer("", n.i.s);
		
		// Add variables to this class
		for(int i = 0; i < n.vl.size(); i++)
		{
//			Variable auxVariable = (Variable)classDeclSimple.vl.elementAt(i).accept(this);
			VariableAnalyzer auxVar = new VariableAnalyzer(n.vl.get(i).t, n.vl.get(i).i.s);
//			n.vl.get(i);
			if(!simpleClass.getClassVariables().containsKey(auxVar.getName()))
				simpleClass.getClassVariables().put(auxVar.getName(), auxVar);
			else
				errorList.add("In the line of number " + n.vl.get(i).line_number + " this error occured: " + 
							   "The variable " + auxVar.getName() + 
							   " is already in the class " + simpleClass.getClassName() + ".");
		}
		
		// Add methods for the class
		for(int i = 0; i < n.ml.size(); i++)
		{
			MethodAnalyzer auxMeth = new MethodAnalyzer(n.ml.get(i).t, n.ml.get(i).i.s);
			n.ml.get(i).accept(this);
			
			if(!simpleClass.getClassMethods().containsKey(auxMeth.getName()))
				simpleClass.getClassMethods().put(auxMeth.getName(), auxMeth);
			else
				errorList.add("In the line of number " + n.ml.get(i).line_number + " this error occured: " + 
							   "The method " + auxMeth.getName() + 
							   "is already in the class " + simpleClass.getClassName() + ".");	
		}
		
		// Add class to the globalTable
		if(!globalTable.getTable().containsKey(simpleClass.getClassName()))
			globalTable.setClass(simpleClass);
		else
			errorList.add("In the line number " + n.line_number + " this error occured: " + 
						   "The class " + simpleClass.getClassName() + " already exists.");
	}

	@Override
	public void visit(ClassDeclExtends n) {
		ClassAnalyzer classeExtends = new ClassAnalyzer(n.j.s, n.i.s);
		
		// Add variables to this class
		for(int i = 0; i < n.vl.size(); i++)
		{
//			Variable auxVariable = (Variable)classDeclSimple.vl.elementAt(i).accept(this);
			VariableAnalyzer auxVar = new VariableAnalyzer(n.vl.get(i).t, n.vl.get(i).i.s);
//			n.vl.get(i);
			if(!classeExtends.getClassVariables().containsKey(auxVar.getName()))
				classeExtends.getClassVariables().put(auxVar.getName(), auxVar);
			else
				errorList.add("In the line of number " + n.vl.get(i).line_number + " this error occured: " + 
							   "The variable " + auxVar.getName() + 
							   " is already in the class " + classeExtends.getClassName() + ".");
		}
		
		// Add methods for the class
		for(int i = 0; i < n.ml.size(); i++)
		{
			MethodAnalyzer auxMeth = new MethodAnalyzer(n.ml.get(i).t, n.ml.get(i).i.s);
			n.ml.get(i).accept(this);
			
			if(!classeExtends.getClassMethods().containsKey(auxMeth.getName()))
				classeExtends.getClassMethods().put(auxMeth.getName(), auxMeth);
			else
				errorList.add("In the line of number " + n.ml.get(i).line_number + " this error occured: " + 
							   "The method " + auxMeth.getName() + 
							   "is already in the class " + classeExtends.getClassName() + ".");	
		}
		
		// Add class to the globalTable
		if(!globalTable.getTable().containsKey(classeExtends.getClassName()))
			globalTable.setClass(classeExtends);
		else
			errorList.add("In the line number " + n.line_number + " this error occured: " + 
						   "The class " + classeExtends.getClassName() + " already exists.");
	
	}

	@Override
	public void visit(VarDecl n) {
		
	}

	@Override
	public void visit(MethodDecl n) {
		MethodAnalyzer auxMeth = new MethodAnalyzer(n.t, n.i.s);
		VariableAnalyzer auxVar;
		
		for(int i = 0; i < n.fl.size(); i++)
		{
			auxVar = new VariableAnalyzer(n.fl.get(i).t, n.fl.get(i).i.s);
		
			if(!auxMeth.getArguments().containsKey(auxVar.getName()))
				auxMeth.getArguments().put(auxVar.getName(), auxVar);
			else
				errorList.add("In the line of number " + n.fl.get(i).line_number + " this error occured: " + 
						   "The argument variable " + auxVar.getName() + 
						   " is already in the method parameters " + auxMeth.getName() + ".");
		}
		
		/* Adds the local variables of the Method */
		for(int i = 0; i < n.vl.size(); i++)
		{
			auxVar = new VariableAnalyzer(n.vl.get(i).t, n.vl.get(i).i.s);
			
			if(!auxMeth.getLoacalVariables().containsKey(auxVar.getName()) && 
			   !auxMeth.getArguments().containsKey(auxVar.getName()))
				auxMeth.getLoacalVariables().put(auxVar.getName(), auxVar);
			else
				errorList.add("In the line of number " + n.vl.get(i).line_number 
						      + " this error occured: " 
						      + "The variable " + auxVar.getName() 
						      + " is already in the method local variables " + auxMeth.getName() + ".");
		}

	}

	@Override
	public void visit(Formal n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IntArrayType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(BooleanType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IntegerType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IdentifierType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(DoubleType n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Block n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(If n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(While n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Print n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Assign n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ArrayAssign n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(And n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(LessThan n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Plus n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Minus n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Times n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ArrayLookup n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ArrayLength n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Call n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IntegerLiteral n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(True n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(False n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IdentifierExp n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(This n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(NewArray n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(NewObject n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Not n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Identifier n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IfElse ifElse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(GreaterThan greaterThan) {
		// TODO Auto-generated method stub

	}


	public Vector<String> getErrorList() {
		return errorList;
	}


	public void setErrorList(Vector<String> errorList) {
		this.errorList = errorList;
	}


	public SymbolTable getTable() {
		return globalTable;
	}


	public void setTable(SymbolTable globalTable) {
		this.globalTable = globalTable;
	}

}
