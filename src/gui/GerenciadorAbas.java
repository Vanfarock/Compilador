package gui;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class GerenciadorAbas extends JTabbedPane {
	public GerenciadorAbas() {
		super(JTabbedPane.TOP);
		
		adicionarAba("Nova aba");
	}
	
	public void adicionarAba(String titulo) {
		JPanel panel = new JPanel();
		addTab(titulo, null, panel, null);
		
		Editor scrollPane = Editor.Inicializar();
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
		);
		
		panel.setLayout(gl_panel);
	}
}
