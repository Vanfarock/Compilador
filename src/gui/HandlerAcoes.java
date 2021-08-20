package gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

@SuppressWarnings("serial")
public class HandlerAcoes {
	private BarraStatus barraStatus;
	private Log log;
	private Editor editor;

	public HandlerAcoes(BarraStatus barraStatus, Log log, Editor editor) {
		setBarraStatus(barraStatus);
		setLog(log);
		setEditor(editor);
	}

	public BarraStatus getBarraStatus() {
		return barraStatus;
	}

	public void setBarraStatus(BarraStatus barraStatus) {
		this.barraStatus = barraStatus;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public Action criarArquivo() {
		return new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	editor.limpar();
		    	log.limpar();
		    	barraStatus.limpar();
		    }
		};
	}

	public Action abrirArquivo() {
		return new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Abrir arquivo.");
		    }
		};
	}
	
	public Action salvarArquivo() {
		return new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("Salvar arquivo.");
		    }
		};
	}
	
	public Action copiar() {
		return new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(editor.getConteudoSelecionado());
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		};
	}
	
	public Action colar() {
		return new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Colar.");
			}
		};
	}
	
	public Action recortar() {
		return new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String conteudoRecortado = editor.removerConteudoSelecionado();
				StringSelection stringSelection = new StringSelection(conteudoRecortado);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		};
	}
	
	public Action compilar() {
		return new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Compilar.");
		    }
		};
	}
	
	public Action mostrarEquipe() {
		return new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Mostrar equipe.");
		    }
		};
	}
}
