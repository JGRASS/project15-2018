package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.ImageIcon;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblRealIme;
	private JLabel lblNewLabel;
	private JButton btnLogOut;
	private JLabel label;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 1000);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setForeground(new Color(255, 0, 0));
			panel_1.setPreferredSize(new Dimension(120, 120));
			panel_1.setLayout(null);
			panel_1.add(getLblIme());
			panel_1.add(getLblPrezime());
			panel_1.add(getLblRealIme());
			panel_1.setBackground(new Color(200,200,200));
			panel_1.add(getLblNewLabel());
			panel_1.add(getBtnLogOut());
			panel_1.add(getLabel());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(237, 187, 153));
			panel.setLayout(null);
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime:");
			lblIme.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblIme.setBounds(15, 33, 69, 20);
		}
		return lblIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime:");
			lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblPrezime.setBounds(15, 69, 100, 20);
		}
		return lblPrezime;
	}
	
	private JLabel getLblRealIme() {
		if (lblRealIme == null) {
			lblRealIme = new JLabel("");
			lblRealIme.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblRealIme.setBounds(147, 37, 198, 20);
		}
		return lblRealIme;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel.setBounds(147, 73, 198, 20);
		}
		return lblNewLabel;
	}
	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton("Log out");
			btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnLogOut.setBounds(1442, 33, 115, 50);
		}
		return btnLogOut;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setAlignmentX(Component.RIGHT_ALIGNMENT);
			label.setBounds(1259, 50, 150, 20);
		}
		return label;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/coffee-table.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(100, 98, 247, 137);
		}
		return btnNewButton;
	}
}
