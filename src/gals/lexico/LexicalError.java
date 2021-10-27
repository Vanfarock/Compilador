package gals.lexico;

@SuppressWarnings("serial")
public class LexicalError extends AnalysisError
{
	private String palavra;
	
    public LexicalError(String msg, int position, String palavra)
	 {
        super(msg, position);
        this.palavra = palavra;
    }

    public LexicalError(String msg)
    {
        super(msg);
    }


	public LexicalError(String string, int start) {
		super(string, start);
	}

	public String getPalavra() {
		return palavra;
	}    
}
