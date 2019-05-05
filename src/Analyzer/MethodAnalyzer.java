package Analyzer;

import java.util.Hashtable;

import AST.Type;

public class MethodAnalyzer {
	private Type type;
	private String name;
	
	private Hashtable<String, VariableAnalyzer> loacalVariables;
	private Hashtable<String, VariableAnalyzer> arguments;
	
	public MethodAnalyzer(Type type, String name) {
		this.setType(type);
		this.setName(name);
		this.setLoacalVariables(new Hashtable<String, VariableAnalyzer>());
		this.setArguments(new Hashtable<String, VariableAnalyzer>());
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hashtable<String, VariableAnalyzer> getLoacalVariables() {
		return loacalVariables;
	}

	public void setLoacalVariables(Hashtable<String, VariableAnalyzer> loacalVariables) {
		this.loacalVariables = loacalVariables;
	}

	public Hashtable<String, VariableAnalyzer> getArguments() {
		return arguments;
	}

	public void setArguments(Hashtable<String, VariableAnalyzer> arguments) {
		this.arguments = arguments;
	}

}
