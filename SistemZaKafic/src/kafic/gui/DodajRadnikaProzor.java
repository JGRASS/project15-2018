package kafic.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kafic.gui.kontroler.GUIKontroler;

public class DodajRadnikaProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblImeRadnika;
	private JLabel lblPrezimeRadnika;
	public JTextField textImeRadnika;
	public JTextField textPrezimeRadnika;
	private JLabel lblUsername;
	private JLabel lblPassword;
	public JTextField textUsername;
	public JTextField textPassword;
	public JCheckBox chckbxAdmin;
	private JSeparator separator;
	private JButton btnDodajRadnika;
	private JButton btnOdustani;
	
	private DodajRadnikaProzor dodajRadnikaProzor = this;
	
	/**
	 * Create the frame.
	 * @param adminProzor 
	 */
	public DodajRadnikaProzor() {
		setResizable(false);
		setTitle("Dodaj Radnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(25, 25, 15, 15));
		contentPane.setLayout(new GridLayout(6, 2, 30, 15));
		contentPane.add(getLblImeRadnika());
		contentPane.add(getLblPrezimeRadnika());
		contentPane.add(getTextImeRadnika());
		contentPane.add(getTextPrezimeRadnika());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getTextUsername());
		contentPane.add(getTextPassword());
		contentPane.add(getChckbxAdmin());
		contentPane.add(getSeparator());
		contentPane.add(getBtnDodajRadnika());
		contentPane.add(getBtnOdustani());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	private JLabel getLblImeRadnika() {
		if (lblImeRadnika == null) {
			lblImeRadnika = new JLabel("Ime:");
			lblImeRadnika.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return lblImeRadnika;
	}
	private JLabel getLblPrezimeRadnika() {
		if (lblPrezimeRadnika == null) {
			lblPrezimeRadnika = new JLabel("Prezime:");
			lblPrezimeRadnika.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return lblPrezimeRadnika;
	}
	private JTextField getTextImeRadnika() {
		if (textImeRadnika == null) {
			textImeRadnika = new JTextField();
			textImeRadnika.setFont(new Font("DialogInput", Font.PLAIN, 16));
			textImeRadnika.setColumns(10);
		}
		return textImeRadnika;
	}
	private JTextField getTextPrezimeRadnika() {
		if (textPrezimeRadnika == null) {
			textPrezimeRadnika = new JTextField();
			textPrezimeRadnika.setFont(new Font("DialogInput", Font.PLAIN, 16));
			textPrezimeRadnika.setText("");
			textPrezimeRadnika.setColumns(10);
		}
		return textPrezimeRadnika;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return lblPassword;
	}
	private JTextField getTextUsername() {
		if (textUsername == null) {
			textUsername = new JTextField();
			textUsername.setFont(new Font("DialogInput", Font.PLAIN, 16));
			textUsername.setColumns(10);
		}
		return textUsername;
	}
	private JTextField getTextPassword() {
		if (textPassword == null) {
			textPassword = new JTextField();
			textPassword.setFont(new Font("DialogInput", Font.PLAIN, 16));
			textPassword.setText("");
			textPassword.setColumns(10);
		}
		return textPassword;
	}
	private JCheckBox getChckbxAdmin() {
		if (chckbxAdmin == null) {
			chckbxAdmin = new JCheckBox("Admin");
			chckbxAdmin.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return chckbxAdmin;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setVisible(false);
		}
		return separator;
	}
	private JButton getBtnDodajRadnika() {
		if (btnDodajRadnika == null) {
			btnDodajRadnika = new JButton("Dodaj Radnika");
			btnDodajRadnika.setFont(new Font("DialogInput", Font.BOLD, 16));
			btnDodajRadnika.setBackground(new Color(242, 243, 244));
			btnDodajRadnika.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dodajRadnika(dodajRadnikaProzor);
				}
			});
		}
		return btnDodajRadnika;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setFont(new Font("DialogInput", Font.BOLD, 16));
			btnOdustani.setBackground(new Color(242, 243, 244));
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
}
