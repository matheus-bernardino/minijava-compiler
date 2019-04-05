package AST;

import AST.Visitor.Visitor;
import java_cup.runtime.ComplexSymbolFactory.Location;

public class IfElse extends Statement{
	public Exp e;
	public Statement s1, s2;
	
    public IfElse(Exp ae, Statement as1, Statement as2, Location pos) {
    	super(pos);
    	e = ae; s1 = as1; s2 = as2;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
