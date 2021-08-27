package gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Component;

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
		    	FileFilter filter = new FileNameExtensionFilter("Arquivo de texto (.txt)","txt");
		    	Component c = null;
		        JFileChooser fc = new JFileChooser();
		        fc.setFileFilter(filter);
		        fc.addChoosableFileFilter(filter);
		        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		        
		        int n = fc.showOpenDialog(c);
		        File f = fc.getSelectedFile();
		        
		        if(n == JFileChooser.APPROVE_OPTION) {
					String dados;
					try {
						dados = new String(Files.readAllBytes(f.toPath()));
						editor.getEditorTexto().setText(dados);
						log.limpar();
				        barraStatus.setText(f.getPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
		    }
		};
	}
	
	public Action salvarArquivo() {
		return new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	File f = new File(barraStatus.getText());
		    	try {
					PrintWriter pw = new PrintWriter(f);
					pw.println(editor.getEditorTexto().getText());
					pw.close();
				} catch (FileNotFoundException e1) {
					FileFilter filter = new FileNameExtensionFilter("Arquivo de texto (.txt)","txt");
					JFileChooser fc = new JFileChooser(new File("C:\\"));
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setFileFilter(filter);
					fc.addChoosableFileFilter(filter);
					fc.setDialogTitle("Salvar Arquivo");
					int save = fc.showSaveDialog(null);
					if (save == JFileChooser.APPROVE_OPTION) {
						String conteudo = editor.getConteudo();
						f = fc.getSelectedFile();
						try {
							FileWriter fw = new FileWriter(f.getPath()+".txt");
							fw.write(conteudo);
							fw.flush();
							fw.close();
							barraStatus.setText(f.getPath());
							log.limpar();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
				}
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
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Clipboard clipboard = toolkit.getSystemClipboard();
				String conteudoColar;
				try {
					conteudoColar = (String)clipboard.getData(DataFlavor.stringFlavor);
				} catch (UnsupportedFlavorException | IOException e1) {
					conteudoColar = "";
					e1.printStackTrace();
				}
				
				if (editor.getConteudoSelecionado().equals("")) {
					int posicao = editor.getEditorTexto().getCaretPosition();
					String result;
					
					String texto = editor.getEditorTexto().getText();
					
					result = (String) texto.substring(0, posicao) + conteudoColar + texto.substring(posicao, texto.length());
					editor.getEditorTexto().setText(result);
					editor.getEditorTexto().setCaretPosition(result.length() - texto.substring(posicao, texto.length()).length());					
				} else {
					editor.substituirConteudoSelecionado(conteudoColar);
				}
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
		    	log.setText("Compilação de programas ainda não foi implementada.");
		    }
		};
	}
	
	public Action mostrarEquipe() {
		return new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        log.setText("Gustavo Kistner\n\nJoão Bragantino\n\nVinicius Martins");
		    }
		};
	}
}
