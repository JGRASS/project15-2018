package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import kafic.gui.kontroler.GUIKontroler;
import javax.swing.ScrollPaneConstants;

public class IzlistajRadnikeProzor extends JFrame {

	private JPanel contentPane;
	
	public IzlistajRadnikeProzor izlistajRadnikeProzor = this;
	
	public JPanel buttonGrid = new JPanel(new GridLayout(0, 10));
	
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JScrollPane scrollPane;
	private JPanel panel;
	
	private static int panelHeight;

	/**
	 * Create the frame.
	 */
	public IzlistajRadnikeProzor() {
		setResizable(false);
		setTitle("Lista Radnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.buttons = GUIKontroler.listButtonsRadnici(izlistajRadnikeProzor);
		this.panelHeight = buttons.size() * 55 + 2;
		setBounds(100, 100, 443, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.NORTH);
		
		
		for (int i = 0; i < buttons.size(); i++) {
			panel.add(buttons.get(i));
		}
		
		
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getPanel());
			scrollPane.setPreferredSize(new Dimension(350, 425));
		}
		return scrollPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(350, panelHeight));
		}
		return panel;
	}
}
