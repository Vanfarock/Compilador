package gui;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class Editor extends JScrollPane {
	private JTextArea editorTexto;

	private Editor(JTextArea textArea) {
		super(textArea);

		setEditorTexto(textArea);
		
		TextLineNumber tln = new TextLineNumber(textArea);
		setRowHeaderView(tln);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	}

	public static Editor Inicializar() {
		JTextArea textArea = new JTextArea();
		textArea.setTabSize(1);

		return new Editor(textArea);
	}

	public JTextArea getEditorTexto() {
		return editorTexto;
	}

	public void setEditorTexto(JTextArea editorTexto) {
		this.editorTexto = editorTexto;
	}

	public String getConteudo() {
		return editorTexto.getText();
	}
	
	public String getConteudoSelecionado() {
		return editorTexto.getText();
	}
	
	public String removerConteudoSelecionado() {
		int start = editorTexto.getSelectionStart();
		int end = editorTexto.getSelectionEnd();
		
		String conteudo = getConteudo();
		String primeiraParte = conteudo.substring(0, start);
		String segundaParte = conteudo.substring(end, conteudo.length());
		editorTexto.setText(primeiraParte + segundaParte);
		
		return conteudo.substring(start, end);
	}
	
	public void limpar() {
		editorTexto.setText("");
	}
}
