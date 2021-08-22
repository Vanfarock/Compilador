package gui;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

public class Menu {
	private final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private HandlerAcoes handler;
	
	public Menu(HandlerAcoes handler) {
		this.handler = handler;
	}
	
	public JMenuBar popular() {
		JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new GridLayout(0,1));
		JButton btnNovo = montarBotao("new.png", "Novo (Ctrl + n)",
				KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK),
				"criarArquivo",
				handler.criarArquivo());
		menuBar.add(btnNovo);
		
		JButton btnAbrir = montarBotao("open.png",
				"Abrir (Ctrl + o)",
				KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK),
				"abrirArquivo",
				handler.abrirArquivo());
		menuBar.add(btnAbrir);
		
		JButton btnSalvar = montarBotao("save.png",
				"Salvar (Ctrl + s)",
				KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK),
				"salvarArquivo",
				handler.salvarArquivo());
		menuBar.add(btnSalvar);
		
		JButton btnCopiar = montarBotao("copy.png",
				"Copiar (Ctrl + c)",
				KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK),
				"copiar",
				handler.copiar());
		menuBar.add(btnCopiar);
		
		JButton btnColar = montarBotao("paste.png",
				"Colar (Ctrl + v)",
				KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK),
				"colar",
				handler.colar());
		menuBar.add(btnColar);
		
		JButton btnRecortar = montarBotao("cut.png",
				"Recortar (Ctrl + x)",
				KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK),
				"recortar",
				handler.recortar());
		menuBar.add(btnRecortar);
		
		JButton btnCompilar = montarBotao("compile.png",
				"Compilar (F7)",
				KeyStroke.getKeyStroke("F7"),
				"compilar",
				handler.compilar());
		menuBar.add(btnCompilar);
		
		JButton btnEquipe = montarBotao("members.png",
				"Equipe (F1)",
				KeyStroke.getKeyStroke("F1"),
				"mostrarEquipe",
				handler.mostrarEquipe());
		menuBar.add(btnEquipe);
		return menuBar;
	}
	
	private JButton montarBotao(String icone, String label, KeyStroke atalho, String nomeAcao, Action acao) {
		JButton botao = new JButton(label, new ImageIcon("resources/" + icone));
		botao.getInputMap(IFW).put(atalho, nomeAcao);
		botao.getActionMap().put(nomeAcao, acao);
		botao.addActionListener(acao);
		return botao;
	}
}
