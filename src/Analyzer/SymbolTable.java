package Analyzer;

import java.util.Hashtable;

public class SymbolTable {
	private Hashtable<String, ClassAnalyzer> table;
	
	public SymbolTable() {
		this.setTable(new Hashtable<String, ClassAnalyzer>());
	}

	public Hashtable<String, ClassAnalyzer> getTable() {
		return table;
	}

	public void setTable(Hashtable<String, ClassAnalyzer> table) {
		this.table = table;
	}
	
	

}
