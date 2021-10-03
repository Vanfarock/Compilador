package gals;

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

	public String getPalavra() {
		return palavra;
	}    
}
