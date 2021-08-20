package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class BarraStatus extends JTextArea {

	public BarraStatus(Font fontePadrao, Color backgroundPadrao) {
		setBackground(backgroundPadrao);
		setFont(fontePadrao);
		setText("Barra status");
		setEditable(false);		
	}
	
	public void limpar() {
		setText("");
	}
}
