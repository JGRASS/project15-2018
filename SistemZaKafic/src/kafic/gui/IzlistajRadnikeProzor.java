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
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public IzlistajRadnikeProzor() {
		setResizable(false);
		setTitle("Lista Radnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 594);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel_1(), BorderLayout.WEST);
		
		this.buttons = GUIKontroler.listButtonsRadnici(izlistajRadnikeProzor);
		
		for (int i = 0; i < buttons.size(); i++) {
			panel.add(buttons.get(i));
		}
	}
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(443, 594));
		}
		return panel;
	}
}
