package gui;

import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	private final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private HandlerAcoes handler;
	
	public Menu(HandlerAcoes handler) {
		this.handler = handler;
	}
	
	public void popular() {
		JButton btnNovo = montarBotao(
				"Novo (Ctrl + n)",
				KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK),
				"criarArquivo",
				handler.criarArquivo());
		add(btnNovo);
		
		JButton btnAbrir = montarBotao(
				"Abrir (Ctrl + o)",
				KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK),
				"abrirArquivo",
				handler.abrirArquivo());
		add(btnAbrir);
		
		JButton btnSalvar = montarBotao(
				"Salvar (Ctrl + s)",
				KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK),
				"salvarArquivo",
				handler.salvarArquivo());
		add(btnSalvar);
		
		JButton btnCopiar = montarBotao(
				"Copiar (Ctrl + c)",
				KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK),
				"copiar",
				handler.copiar());
		add(btnCopiar);
		
		JButton btnColar = montarBotao(
				"Colar (Ctrl + v)",
				KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK),
				"colar",
				handler.colar());
		add(btnColar);
		
		JButton btnRecortar = montarBotao(
				"Recortar (Ctrl + x)",
				KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK),
				"recortar",
				handler.recortar());
		add(btnRecortar);
		
		JButton btnCompilar = montarBotao(
				"Compilar (F7)",
				KeyStroke.getKeyStroke("F7"),
				"compilar",
				handler.compilar());
		add(btnCompilar);
		
		JButton btnEquipe = montarBotao(
				"Equipe (F1)",
				KeyStroke.getKeyStroke("F1"),
				"mostrarEquipe",
				handler.mostrarEquipe());
		add(btnEquipe);
	}
	
	private JButton montarBotao(String label, KeyStroke atalho, String nomeAcao, Action acao) {
		JButton botao = new JButton(label);
		botao.getInputMap(IFW).put(atalho, nomeAcao);
		botao.getActionMap().put(nomeAcao, acao);
		botao.addActionListener(acao);
		return botao;
	}
}
