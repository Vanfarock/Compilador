package gals.sintatico;

public enum TipoEnum {
	Int("int64"),
	Float("float64"),
	String("string"),
	Bool("bool");
	
	private String text;
	
	TipoEnum(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
