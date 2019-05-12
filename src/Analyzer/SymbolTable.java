package Analyzer;

import java.util.Hashtable;
import java.util.Set;

public class SymbolTable {
	private Hashtable<String, ClassAnalyzer> table;
	
	public SymbolTable() {
		table = new Hashtable<String, ClassAnalyzer>();
	}

	public Hashtable<String, ClassAnalyzer> getTable() {
		return table;
	}

	public void setTable(Hashtable<String, ClassAnalyzer> table) {
		this.table = table;
	}
	
	public void setClass(ClassAnalyzer _class) {
		if(!table.containsKey(_class.getClassName())) 
			table.put(_class.getClassName(), _class);
	}
	
	public ClassAnalyzer getClass(String _className) {
		if(table.containsKey(_className))
		{
			System.out.println("inferno");
			return table.get(_className);
		}
		
		return new ClassAnalyzer("", "");
	}

	public boolean checkVariable(ClassAnalyzer _class, MethodAnalyzer _method, String variableName) {
		if(!(table.containsKey(_class.getClassName()))) 
			return false;

		ClassAnalyzer auxClass = getClass(_class.getClassName());
		if (auxClass.getClassVariables().containsKey(variableName))
			return true;
		
		if (table.containsKey(_class.getClassName()) && _class.getClassMethods().containsKey(_method.getName())){
			if (_class.getClassMethods().containsKey(_method.getName())){
				MethodAnalyzer auxMethod = _class.getClassMethods().get(_method.getName());
				
				if(auxMethod.getArguments().containsKey(variableName))
					return true;
				else if(auxMethod.getLoacalVariables().containsKey(variableName))
					return true;
			}
		}

		auxClass = getClass(_class.getParentClassName());
		while (auxClass != null) {
			if (auxClass.getClassVariables().containsKey(variableName))
				return true;

			auxClass = getClass(auxClass.getParentClassName());
		}
		
		return false;
	}
	
	public VariableAnalyzer getVariable(ClassAnalyzer _class, MethodAnalyzer _method, String variableName) {
		if(!(table.containsKey(_class.getClassName()))) 
			return null;

		ClassAnalyzer auxClass = getClass(_class.getClassName());
		if (auxClass.getClassVariables().containsKey(variableName))
			return auxClass.getClassVariables().get(variableName);
		
		if (table.containsKey(_class.getClassName()) && _class.getClassMethods().containsKey(_method.getName())){
			if (_class.getClassMethods().containsKey(_method.getName())){
				MethodAnalyzer auxMethod = _class.getClassMethods().get(_method.getName());
				
				if(auxMethod.getArguments().containsKey(variableName))
					return auxMethod.getArguments().get(variableName);
				else if(auxMethod.getLoacalVariables().containsKey(variableName))
					return auxMethod.getLoacalVariables().get(variableName);
			}
		}

		auxClass = getClass(_class.getParentClassName());
		while (auxClass != null) {
			if (auxClass.getClassVariables().containsKey(variableName))
				return auxClass.getClassVariables().get(variableName);

			auxClass = getClass(auxClass.getParentClassName());
		}
		
		return null;
	}
}
