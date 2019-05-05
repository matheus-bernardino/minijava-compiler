package Analyzer;

import java.util.Hashtable;

public class ClassAnalyzer {
	private String parentClassName;
	private String className;
	
	private Hashtable<String, VariableAnalyzer> classVariables;
	private Hashtable<String, MethodAnalyzer> classMethods;
	
	public ClassAnalyzer(String parentClassName, String className) {
		this.setClassName(className);
		this.setParentClassName(parentClassName);
		this.setClassVariables(new Hashtable<String, VariableAnalyzer>());
		this.setClassMethods(new Hashtable<String, MethodAnalyzer>());
	}

	public String getParentClassName() {
		return parentClassName;
	}

	public void setParentClassName(String parentClassName) {
		this.parentClassName = parentClassName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Hashtable<String, VariableAnalyzer> getClassVariables() {
		return classVariables;
	}

	public void setClassVariables(Hashtable<String, VariableAnalyzer> classVariables) {
		this.classVariables = classVariables;
	}

	public Hashtable<String, MethodAnalyzer> getClassMethods() {
		return classMethods;
	}

	public void setClassMethods(Hashtable<String, MethodAnalyzer> classMethods) {
		this.classMethods = classMethods;
	}

}
