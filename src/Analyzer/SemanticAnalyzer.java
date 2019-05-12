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
import AST.Type;
import AST.VarDecl;
import AST.While;
import AST.Visitor.Visitor;

public class SemanticAnalyzer implements Visitor {
	private SymbolTable symbolTable;
	private Vector<String> errorList;
	
	private ClassAnalyzer currentClass;
	private MethodAnalyzer currentMethod;
	
	public SemanticAnalyzer() {
		this.setSymbolTable(new SymbolTable());
		this.setErrorList(new Vector<String>());
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
		currentClass = symbolTable.getClass(n.m.i1.s);
		currentMethod = null;

		n.m.s.accept(this);

		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.get(i).accept(this);
		}
	}

	@Override
	public void visit(MainClass n) {
		n.s.accept(this);
	}

	@Override
	public void visit(ClassDeclSimple n) {
		currentClass = symbolTable.getClass(n.i.s);

		for (int i = 0; i < n.vl.size(); i++) 
			n.vl.get(i).accept(this);

		for (int i = 0; i < n.ml.size(); i++) 
			n.ml.get(i).accept(this);
	}

	@Override
	public void visit(ClassDeclExtends n) {
		currentClass = symbolTable.getClass(n.i.s);
		currentClass.setParentClassName(n.j.s);

		for (int i = 0; i < n.vl.size(); i++)
			n.vl.get(i).accept(this);

		if (!symbolTable.getTable().containsKey(n.j.s))
			errorList.add("In the line of number " + n.line_number + " this error occured: " + 
						"The class " + n.j.s + " to be inherited does not exits.");

		for (int i = 0; i < n.ml.size(); i++) 
			n.ml.get(i).accept(this);
	}

	@Override
	public void visit(VarDecl n) {
		if(!(n.t instanceof BooleanType) 
		   && !(n.t instanceof IntegerType)
		   && !(n.t instanceof IdentifierType)
		   && !(n.t instanceof IntArrayType)) {
			errorList.add("In the line of number " + n.line_number + " this error occured: " + 
					"The type was not declared.");
		}
	}

	@Override
	public void visit(MethodDecl n) {
		for (int i = 0; i < n.fl.size(); i++) 
			n.fl.get(i).accept(this);
		
		for (int i = 0; i < n.vl.size(); i++) 
			n.vl.get(i).accept(this);
		
		for (int i = 0; i < n.sl.size(); i++) 
			n.sl.get(i).accept(this);
		
		n.e.accept(this);
		
		System.out.println(currentClass.getClassName());
		currentMethod = symbolTable.getClass(currentClass.getClassName()).getClassMethods().get(n.i.s);
		System.out.println(currentMethod.getType());
		System.out.println(n.t);
		
		if (currentMethod.getType() instanceof IdentifierType && n.t instanceof IdentifierType) {
			IdentifierType t1 = (IdentifierType) n.t;
			IdentifierType t2 = (IdentifierType) currentMethod.getType();

			
			Boolean error = false;
			
			if (!t1.s.equals(t2.s))
				error = true;
			else {
				ClassAnalyzer aux = symbolTable.getClass(t2.s);
				while (aux != null) {
					if (t1.s.equals(aux.getClassName()))
						error = true;
	
					aux = symbolTable.getClass(aux.getParentClassName());
				}
			}
			
			if(!error) {
				errorList.add("In the line of number " + n.line_number + " this error occured: " + 
						"The type and method's return" + currentMethod.getName() +
						" of the class " + currentClass.getClassName() + " are differents.");
			}
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
		for (int i = 0; i < n.sl.size(); i++)
			n.sl.get(i).accept(this);
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
		if (!this.getSymbolTable().getTable().containsKey(n.i.s)) {
			errorList.add("In the line of number " + n.line_number + " this error occured: " + 
					   "The identifier " + n.i.s + " does not have a corresponding class previously declared.");
		}
	}

	@Override
	public void visit(Not n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Identifier n) {
		if (!this.getSymbolTable().checkVariable(currentClass, currentMethod, n.s)) {
			errorList.add("In the line of number " + n.line_number + " this error occured: " + 
					   "The identifier " + n.s + " was not declared before.");
		}
	}

	@Override
	public void visit(IfElse ifElse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(GreaterThan greaterThan) {
		// TODO Auto-generated method stub

	}

	public SymbolTable getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}

	public Vector<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(Vector<String> errorList) {
		this.errorList = errorList;
	}

}
