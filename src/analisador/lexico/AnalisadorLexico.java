package analisador.lexico;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

import gals.LexicalError;
import gals.Lexico;
import gals.ScannerConstants;
import gals.Token;

public class AnalisadorLexico {
	
	public static String analisar(String text) {		
	   Lexico lexico = new Lexico();
  	   lexico.setInput(new StringReader(text));
  	   
  	   
  	   try {
  		   List<String> palavrasReservadas = Arrays.asList(ScannerConstants.SPECIAL_CASES_KEYS);
  		
  		   String analise = String.format("%-10s", "linha") 
  				   + String.format("%-50s", "classe") 
  				   + String.format("%-10s", "lexema")
  				   + "\r\n";

  		   Token t = null;
		   while ((t = lexico.nextToken()) != null ) {
			   String classeToken = ClasseToken.porExtenso(t.getId());
			   String lexema = t.getLexeme();
			   int posicao = t.getPosition();
			   
			   if (classeToken.equals("palavra reservada") && !palavrasReservadas.contains(lexema)) {
				   throw new LexicalError(ScannerConstants.SCANNER_ERROR[33], posicao, lexema);				   
			   }

			   analise += String.format("%-10s", getLinha(text, t.getPosition())) 
					   + String.format("%-50s", classeToken) 
					   + String.format("%-10s", lexema)
					   + "\r\n";
		   }
		   return analise.toString() + "\r\nPrograma compilado com sucesso!";
  	   } catch (LexicalError ex) {
  		   return "Erro na linha " + getLinha(text, ex.getPosition()) + " - " + ex.getMessage().replace("{lexema}", ex.getPalavra());
  	   }
	}
	
	private static String getLinha(String text, int posicao) {
		return String.valueOf(text
				.substring(0, posicao + 1)
				.split("\r\n|\r|\n")
				.length);
	}
}
