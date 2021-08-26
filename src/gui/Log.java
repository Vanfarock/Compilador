package gui;

import java.awt.Color;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Log extends JTextArea {
	public Log(Color backgroundPadrao) {
		setBackground(backgroundPadrao);
		setEditable(false);
	}
	
	public void limpar() {
		setText("");
	}
}
