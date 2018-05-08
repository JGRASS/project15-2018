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
	private JScrollPane scrollPane;
	
	public IzlistajRadnikeProzor izlistajRadnikeProzor = this;
	private JPanel panel;
	
	public JPanel buttonGrid = new JPanel(new GridLayout(0, 10));
	
	private ArrayList<JButton> buttons = new ArrayList<JButton>();

	/**
	 * Create the frame.
	 */
	public IzlistajRadnikeProzor() {
		setResizable(false);
		setTitle("Lista Radnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(350, 500));
		
		this.buttons = GUIKontroler.listButtonsRadnici(izlistajRadnikeProzor);
		
		for (int i = 0; i < buttons.size(); i++) {
			panel.add(buttons.get(i));
		}
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setViewportView(getPanel());
		}
		return scrollPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
	}
}
