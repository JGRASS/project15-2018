package kafic.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class UvodniProzor extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UvodniProzor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UvodniProzor.class.getResource("/icons/ParadisoCaffee.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
	}
}
