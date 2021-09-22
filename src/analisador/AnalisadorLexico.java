package analisador;

import java.io.StringReader;

import gals.LexicalError;
import gals.Lexico;
import gals.Token;

public class AnalisadorLexico {

	
	
	public void analisar(String text) {
	   Lexico lex = new Lexico();
  	   lex.setInput( new StringReader(text));
  	   try {
	    	   Token t = null;
	    	   while ( (t = lex.nextToken()) != null ) {
	    	     System.out.println(t.getLexeme()); 
	    	   }
  	   } catch ( LexicalError e2 ) {  
  	     System.out.println(e2.getMessage() + " em " + e2.getPosition());
  	   }
	}
	
	
}
