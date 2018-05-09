package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.FlowLayout;

public class UvodniProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public UvodniProzor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UvodniProzor.class.getResource("/icons/ParadisoCaffee.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 1060);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLblNewLabel());
		setLocationRelativeTo(null);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(UvodniProzor.class.getResource("/icons/ParadisoCaffee.jpeg")));
		}
		return lblNewLabel;
	}
}
