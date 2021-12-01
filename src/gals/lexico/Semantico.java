package gals.lexico;
import java.util.ArrayList;
import java.util.Stack;

import gals.sintatico.Constants;
import gals.sintatico.TipoEnum;

public class Semantico implements Constants
{
	// Declarar registros semanticos

	// operador (inicialmente igual a ""): usado para armazenar o operador relacional reconhecido pela ação #9, para uso posterior na ação #10. 
	// Ex: == <> < >
	
	// código: usado para armazenar o código objeto gerado.
	
	// pilha_tipos (inicialmente vazia): usada para determinar o tipo de uma expressão durante a compilação do programa.
	// Ex: int64 float64 string bool
	
	// lista_id (inicialmente igual a ""): usada para armazenar os identificadores reconhecidos pela ação #24, para uso posterior nas ações #23, #25 e #27.
	// pilha_rotulos (inicialmente vazia): usada na análise dos comandos de seleção e de repetição.
	
	// #5 #6 #14 #15 #16
	// #1 #17
	// #11 #12 #21
	
	private String operador;
	private ArrayList<String> codigo = new ArrayList<String>();
	private Stack<TipoEnum> pilhaTipos = new Stack<TipoEnum>();
	private ArrayList<String> listaId = new ArrayList<String>();
	private Stack<String> pilhaRotulos = new Stack<String>();
	
	public ArrayList<String> getCodigo() {
    	return codigo;
    }
	
    public void executeAction(int action, Token token)	throws SemanticError
    {
    	switch (action) {
    		case 1: acao01(); break;
    		case 2: acao02(); break;
    		case 3: acao03(); break;
    		case 4: acao04(); break;
    		case 5: acao05(token); break;
    		case 6: acao06(token); break;
    		case 7: acao07(); break;
    		case 8: acao08(); break;
    		case 9: acao09(token); break;
    		case 10: acao10(); break;
    		case 11: acao11(); break;
    		case 12: acao12(); break;
    		case 13: acao13(); break;
    		case 14: acao14(); break;
    		case 15: acao15(); break;
    		case 16: acao16(); break;
    		case 17: acao17(token); break;
    		case 18: acao18(); break;
    		case 19: acao19(); break;
    		case 20: acao20(); break;
    		case 21: acao21(); break;
    		case 22: acao22(); break;
    		case 23: acao23(token); break;
    		case 24: acao24(token); break;
    		case 25: acao25(); break;
    		case 26: acao26(); break;
    		case 27: acao27(); break;
    		case 28: acao28(); break;
    		case 29: acao29(); break;
    		case 30: acao30(); break;
    		case 31: acao31(); break;
    		case 32: acao32(); break;
    		case 33: acao33(); break;
    		case 34: acao34(token); break;
    	}
    }
    
    private void acao01() throws SemanticError {
    	TipoEnum tipo1 = pilhaTipos.pop();
    	TipoEnum tipo2 = pilhaTipos.pop();
    	
    	if ((tipo1 != TipoEnum.Int && tipo1 != TipoEnum.Float) || 
			(tipo2 != TipoEnum.Int && tipo2 != TipoEnum.Float)) {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão aritmética.");
    	}
    	
    	if (tipo1 == TipoEnum.Float || tipo2 == TipoEnum.Float) {
    		pilhaTipos.push(TipoEnum.Float);
    	} else {
    		pilhaTipos.push(TipoEnum.Int);
    	}
    	
    	codigo.add("add");
    }
    
    private void acao02() throws SemanticError {
    	TipoEnum tipo1 = pilhaTipos.pop();
    	TipoEnum tipo2 = pilhaTipos.pop();
    	
    	if ((tipo1 != TipoEnum.Int && tipo1 != TipoEnum.Float) || 
			(tipo2 != TipoEnum.Int && tipo2 != TipoEnum.Float)) {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão aritmética.");
    	}
    	
    	if (tipo1 == TipoEnum.Float || tipo2 == TipoEnum.Float) {
    		pilhaTipos.push(TipoEnum.Float);
    	} else {
    		pilhaTipos.push(TipoEnum.Int);
    	}
    	
    	codigo.add("sub");
    }
    
    private void acao03() throws SemanticError {
    	TipoEnum tipo1 = pilhaTipos.pop();
    	TipoEnum tipo2 = pilhaTipos.pop();
    	
    	if ((tipo1 != TipoEnum.Int && tipo1 != TipoEnum.Float) || 
			(tipo2 != TipoEnum.Int && tipo2 != TipoEnum.Float)) {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão aritmética.");
    	}
    	
    	if (tipo1 == TipoEnum.Float || tipo2 == TipoEnum.Float) {
    		pilhaTipos.push(TipoEnum.Float);
    	} else {
    		pilhaTipos.push(TipoEnum.Int);
    	}
    	
    	codigo.add("mul");
    }
    
    private void acao04() throws SemanticError {
    	TipoEnum tipo1 = pilhaTipos.pop();
    	TipoEnum tipo2 = pilhaTipos.pop();
    	
    	if ((tipo1 != TipoEnum.Int && tipo1 != TipoEnum.Float) || 
			(tipo2 != TipoEnum.Int && tipo2 != TipoEnum.Float)) {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão aritmética.");
    	}
    	
    	if (tipo1 == TipoEnum.Float || tipo2 == TipoEnum.Float) {
    		pilhaTipos.push(TipoEnum.Float);
    	} else {
    		pilhaTipos.push(TipoEnum.Int);
    	}
    	
    	codigo.add("div");
    }
    
    private void acao05(Token token) {
    	pilhaTipos.push(TipoEnum.Int);
		codigo.add("ldc.i8 " + token.getLexeme());
		codigo.add("conv.r8");
    }

    private void acao06(Token token) {
    	pilhaTipos.push(TipoEnum.Float);
		codigo.add("ldc.r8 " + token.getLexeme());
    }
    
    private void acao07() throws SemanticError {
    	TipoEnum tipo = pilhaTipos.pop();
    	if (tipo == TipoEnum.Float || tipo == TipoEnum.Int) {
    		pilhaTipos.push(tipo);
    	} else {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão aritmética.");
    	}
    }
    
    private void acao08() throws SemanticError {
    	TipoEnum tipo = pilhaTipos.pop();
    	if (tipo == TipoEnum.Float || tipo == TipoEnum.Int) {
    		pilhaTipos.push(tipo);
    	} else {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão aritmética.");
    	}
    	
    	codigo.add("ldc.i8 -1");
    	codigo.add("conv.r8");
    	codigo.add("mul");
    }
    
    private void acao09(Token token) {
    	operador = token.getLexeme();
    }
    
    private void acao10() throws SemanticError {
    	TipoEnum tipo1 = pilhaTipos.pop();
    	TipoEnum tipo2 = pilhaTipos.pop();
    	
    	if (tipo1 != tipo2) {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão lógica.");
    	}
    	
    	pilhaTipos.push(TipoEnum.Bool);
    	
    	switch (operador) {
	    	case ">": codigo.add("cgt"); break;
	    	case "<": codigo.add("clt"); break;
	    	case "==": codigo.add("ceq"); break;
	    	case "<>":
	    		codigo.add("ceq");
	    		codigo.add("ldc.i4.0");
	    		codigo.add("ceq");
	    		break;
    	}
    }
    
    private void acao11() {
    	pilhaTipos.push(TipoEnum.Bool);
    	codigo.add("ldc.i4.1");
    }
    
    private void acao12() {
    	pilhaTipos.push(TipoEnum.Bool);
    	codigo.add("ldc.i4.0");
    }
    
    private void acao13() throws SemanticError {
    	TipoEnum tipo = pilhaTipos.pop();
    	if (tipo == TipoEnum.Bool) {
    		pilhaTipos.push(TipoEnum.Bool);
    	} else {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão lógica.");
    	}
    	
    	codigo.add("ldc.i4.1");
    	codigo.add("xor");
    }
    
    private void acao14() {
    	TipoEnum tipo = pilhaTipos.pop();
		if (tipo == TipoEnum.Int) {
			codigo.add("conv.i8");
		}
		codigo.add("call void [mscorlib]System.Console::Write(" + tipo + ")");
    }
    
    private void acao15() {
    	codigo.add(".assembly extern mscorlib {}");
		codigo.add(".assembly _codigo_objeto{}");
		codigo.add(".module _codigo_objeto.exe ");
		codigo.add(".class public _UNICA{");
		codigo.add(".method static public void _principal() {");
		codigo.add(".entrypoint");
    }
    
    private void acao16() {
    	codigo.add("ret");
		codigo.add("}");
		codigo.add("}");
    }
    
    private void acao17(Token token) {
    	pilhaTipos.push(TipoEnum.String);
		codigo.add("ldstr " + token.getLexeme());
    }
    
    private void acao18() {
    	pilhaTipos.push(TipoEnum.String);
		codigo.add("ldstr " + "\"\\n\"");
    }
    
    private void acao19() {
    	pilhaTipos.push(TipoEnum.String);
		codigo.add("ldstr " + "\" \"");
    }
    
    private void acao20() {
    	pilhaTipos.push(TipoEnum.String);
		codigo.add("ldstr " + "\"\\t\"");
    }
    
    private void acao21() throws SemanticError {
    	TipoEnum tipo1 = pilhaTipos.pop();
    	TipoEnum tipo2 = pilhaTipos.pop();
    	
    	if (tipo1 != TipoEnum.Bool || tipo2 != TipoEnum.Bool ) {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão lógica.");
    	}
		
    	pilhaTipos.push(TipoEnum.Bool);
    	codigo.add("and");
    }
    
    private void acao22() throws SemanticError {
    	TipoEnum tipo1 = pilhaTipos.pop();
    	TipoEnum tipo2 = pilhaTipos.pop();
    	
    	if (tipo1 != TipoEnum.Bool || tipo2 != TipoEnum.Bool ) {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão lógica.");
    	}
		
    	pilhaTipos.push(TipoEnum.Bool);
    	codigo.add("or");
    }
    
    private void acao23(Token token) {
    	for (String id : listaId) {
    		codigo.add(".locals (" + obterTipoIdentificador(id) + " " + id + ")");
    	}
    	listaId.clear();
    }
    
    private void acao24(Token token) {
    	listaId.add(token.getLexeme());
    }
    
    private void acao25() {
    	String id = listaId.get(listaId.size() - 1);
    	TipoEnum tipo = obterTipoIdentificador(id);
    	
    	if (tipo == TipoEnum.Int) {
    		codigo.add("conv.i8");
    	}
    	
    	codigo.add("stloc " + id);
    }
    
    private void acao26() throws SemanticError {
    	TipoEnum tipo = pilhaTipos.pop();
    	String rotulo = pilhaRotulos.pop();
    	
    	if (tipo == TipoEnum.Bool) {
    		throw new SemanticError("Tipo(s) incompatível(is) em expressão lógica.");
    	}
    	
    	codigo.add("brfalse " + rotulo);
    }
    
    private void acao27() {
    	for (String id : listaId) {
    		TipoEnum tipoId = obterTipoIdentificador(id);
    		if (tipoId == null) continue;
    		
    		codigo.add("call string [mscorlib]System.Console::ReadLine()");
    		
    		if (tipoId == TipoEnum.Int) {
    			codigo.add("call " + tipoId + " [mscorlib]System.Int64::Parse(string)");
    		} else if (tipoId == TipoEnum.Float) {
    			codigo.add("call " + tipoId + " [mscorlib]System.Double::Parse(string)");
    		} else if (tipoId == TipoEnum.Bool) {
    			codigo.add("call " + tipoId + " [mscorlib]System.Boolean::Parse(string)");
    		}
    		
    		codigo.add("stloc " + id);
    	}
    	listaId.clear();
    }
    
    private void acao28() {
    }
    
    private void acao29() {
    }
    
    private void acao30() {
    }
    
    private void acao31() {
    }
    
    private void acao32() {
    }
    
    private void acao33() {
    }
    
    private void acao34(Token token) {
    	String id = token.getLexeme();
    	codigo.add("ldloc " + id);
    	
    	TipoEnum tipo = obterTipoIdentificador(id);
    	if (tipo == null) return;
    	
    	pilhaTipos.push(tipo);
    	
    	if (tipo == TipoEnum.Int) {
    		codigo.add("conv.r8");    		
    	}
    }
    
    private TipoEnum obterTipoIdentificador(String id) {
    	if (id.startsWith("I")) return TipoEnum.Int;
    	if (id.startsWith("F")) return TipoEnum.Float;
    	if (id.startsWith("S")) return TipoEnum.String;
    	if (id.startsWith("B")) return TipoEnum.Bool;
    	return null;
    }
}
