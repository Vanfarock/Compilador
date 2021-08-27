package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

public class Interface {

	private JFrame framePrincipal;
	private Font fontePadrao;
	private Color backgroundPadrao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.framePrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interface() {
		initializeVariables();
		initialize();
	}

	private void initializeVariables() {
		fontePadrao = new Font("Arial", 12, 14);
		backgroundPadrao = new Color(240, 240, 240);
	}

	private void initialize() {
		framePrincipal = new JFrame();
		framePrincipal.setTitle("Compilador");
		framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setMinimumSize(new Dimension(1000, 700));
		
		BarraStatus barraStatus = new BarraStatus(fontePadrao, backgroundPadrao);
		
		JSplitPane horizontalSplit = new JSplitPane();
		horizontalSplit.setEnabled(false);
		horizontalSplit.setDividerLocation(0.2);
		horizontalSplit.setResizeWeight(0.1);
		
		GroupLayout groupLayout = new GroupLayout(framePrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(barraStatus, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(horizontalSplit, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(horizontalSplit, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(barraStatus, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		
		framePrincipal.getContentPane().setLayout(groupLayout);
		
		JSplitPane verticalSplit = new JSplitPane();
		verticalSplit.setResizeWeight(0.8);
		verticalSplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		horizontalSplit.setRightComponent(verticalSplit);
		
		Editor editor = Editor.Inicializar(fontePadrao);
		verticalSplit.setLeftComponent(editor);
		
		Log log = new Log(backgroundPadrao);
		verticalSplit.setRightComponent(log);
		
		HandlerAcoes handlerAcoes = new HandlerAcoes(barraStatus, log, editor);
		
	    Menu menu = new Menu(handlerAcoes);
	    JMenuBar popular = menu.popular();
	    popular.add(Box.createRigidArea(new Dimension(80,20)));
	    popular.setPreferredSize(new Dimension(80,20));
	    
		horizontalSplit.setLeftComponent(popular);
	}

	 public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped " + e);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed " + e);
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased " + e);
    }
}
