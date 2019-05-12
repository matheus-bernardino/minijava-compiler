package CodeGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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

public class AssemblyGenerator implements Visitor {
	String codeAsm;
	File codeAssembly;
	FileWriter fwCodeAsm;
	BufferedWriter bwCodeAsm;
	
	public AssemblyGenerator() {
		codeAsm = new String();
	}
	
	public void generatingCodeFile(String code) throws Exception
	{
		codeAssembly = new File("CodeAsmGenerated.s");
		
		fwCodeAsm = new FileWriter(codeAssembly);
		bwCodeAsm = new BufferedWriter(fwCodeAsm);
		bwCodeAsm.write(code);
		
		bwCodeAsm.close();
		fwCodeAsm.close();
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
		/* Escreve cabeçalho do código assembly */
		codeAsm = "#Code Assembly Generated\n\n";
		codeAsm = codeAsm + "\t.text\n";
		codeAsm = codeAsm + "\t.global asm_main		#label for Main program\n\n";
		codeAsm = codeAsm + "#Main function\n";
		codeAsm = codeAsm + "asm_main:\n";
		
		/* Escrevendo o Prólogo */
		codeAsm = codeAsm + "\tpushl	%ebp		# prologue - save frame ptr\n";
		codeAsm = codeAsm + "\tmovl	%esp,%ebp		# no local vars - no additional stack\n\n";
		
		n.m.s.accept(this);

		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.get(i).accept(this);
		}
		
		/* Escrevendo o Epilogo */
		codeAsm = codeAsm + "\n\tmovl	%ebp,%esp	# epilogue - return\n";
		codeAsm = codeAsm + "\tpopl	%ebp\n";
		codeAsm = codeAsm + "\tret\n";
		
		/* Escrevendo a String do código no arquivo .s */
		try{
			//System.out.println(codigoAsm);
			generatingCodeFile(codeAsm);
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void visit(MainClass n) {
		n.s.accept(this);
	}

	@Override
	public void visit(ClassDeclSimple n) {
		for (int i = 0; i < n.vl.size(); i++) 
			n.vl.get(i).accept(this);
		String codeTimes = new String();
		
		/* Recebe o código .s referente a expressao 1(EXP1). Joga o resultado dessa
		 * expressão no registrador EBX */
//		String codeExp1 = (String)n.e1.accept(this);
		codeTimes = codeTimes; //+ codeExp1;
		codeTimes = codeTimes + "\tmov %eax, %ebx\n";
		
		/* Recebe o código .s referente a expressao 2(EXP2). */
//		String codeExp2 = (String)n.e2.accept(this);
		codeTimes = codeTimes; //+ codeExp2;
		
		/* Multiplica o conteudo do resgistrador ebx com o do eax e joga o resultado em eax  */
		codeTimes = codeTimes + "\timul %ebx, %eax			# exp1 * exp2\n";
		codeTimes = codeTimes + "\tpush %eax				# Put the result in the stack\n\n"; 
	

		for (int i = 0; i < n.ml.size(); i++) 
			n.ml.get(i).accept(this);
	}

	@Override
	public void visit(ClassDeclExtends n) {
		for (int i = 0; i < n.vl.size(); i++) 
			n.vl.get(i).accept(this);

		for (int i = 0; i < n.ml.size(); i++) 
			n.ml.get(i).accept(this);
	}

	@Override
	public void visit(VarDecl n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MethodDecl n) {
		for (int i = 0; i < n.vl.size(); i++) 
			n.vl.get(i).accept(this);
		
			
		for (int i = 0; i < n.sl.size(); i++) 
			n.sl.get(i).accept(this);

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
		String codePlus = new String();
		
		/* Recebe o código .s referente a expressao 1(EXP1). Joga o resultado dessa
		 * expressão no registrador EDX */
//		String codeExp1 = (String)n.e1.accept(this);
		codePlus = codePlus; //+ codeExp1;
		codePlus = codePlus + "\tmov %eax, %edx\n";
		
		/* Recebe o código .s referente a expressao 2(EXP2) */
//		String codeExp2 = (String)n.e2.accept(this);
		codePlus = codePlus; //+ codeExp2;
		
		/* Soma o conteudo do resgistrador edx com o do eax e joga o resultado em eax  */
		codePlus = codePlus + "\tadd %edx, %eax			# exp1 + exp2\n";
		codePlus = codePlus + "\tpush %eax				# Put the result in the stack\n\n";
	}

	@Override
	public void visit(Minus n) {
		String codeMinus = new String();
		
		/* Recebe o código .s referente a expressao 1(EXP1). Joga o resultado dessa
		 * expressão no registrador ECX */
//		String codeExp1 = (String)n.e1.accept(this);
		codeMinus = codeMinus; //+ codeExp1;
		codeMinus = codeMinus + "\tmov %eax, %ecx\n";
		
		/* Recebe o código .s referente a expressao 2(EXP2). */
//		String codeExp2 = (String)n.e2.accept(this);
		codeMinus = codeMinus; //+ codeExp2;
		
		/* Subtrai o conteudo do resgistrador ecx com o do eax e joga o resultado em ecx  */
		codeMinus = codeMinus + "\tsub %eax, %ecx			# exp1 - exp2\n";
		codeMinus = codeMinus + "\tmov %ecx, %eax			# Put the result of SUB in EAX\n";
		codeMinus = codeMinus + "\tpush %ecx				# Put the result in the stack\n\n";
	}

	@Override
	public void visit(Times n) {
		String codeTimes = new String();
		
		/* Recebe o código .s referente a expressao 1(EXP1). Joga o resultado dessa
		 * expressão no registrador EBX */
//		String codeExp1 = (String)n.e1.accept(this);
		codeTimes = codeTimes; //+ codeExp1;
		codeTimes = codeTimes + "\tmov %eax, %ebx\n";
		
		/* Recebe o código .s referente a expressao 2(EXP2). */
//		String codeExp2 = (String)n.e2.accept(this);
		codeTimes = codeTimes; //+ codeExp2;
		
		/* Multiplica o conteudo do resgistrador ebx com o do eax e joga o resultado em eax  */
		codeTimes = codeTimes + "\timul %ebx, %eax			# exp1 * exp2\n";
		codeTimes = codeTimes + "\tpush %eax				# Put the result in the stack\n\n"; 
		
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
}
