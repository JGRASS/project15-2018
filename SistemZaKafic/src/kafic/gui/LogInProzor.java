package kafic.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.java.swing.plaf.windows.resources.windows;

import kafic.Kafic;
import kafic.Radnik;
import kafic.gui.kontroler.GUIKontroler;

public class LogInProzor extends JFrame {

	public JPanel contentPane;
	private JLabel lblUsername;
	public JTextField textField;
	private JLabel lblPassword;
	public JPasswordField passwordField;
	private JButton btnNewButton;
	
	private LogInProzor logInProzor = this;

	/**
	 * Create the frame.
	 */
	public LogInProzor() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getTextField());
		contentPane.add(getLblPassword());
		contentPane.add(getPasswordField());
		contentPane.add(getBtnNewButton());
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("USERNAME:");
			lblUsername.setFont(new Font("DialogInput", Font.BOLD, 16));
			lblUsername.setBounds(31, 23, 168, 15);
		}
		return lblUsername;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(31, 50, 168, 25);
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("PASSWORD:");
			lblPassword.setFont(new Font("DialogInput", Font.BOLD, 16));
			lblPassword.setBounds(31, 90, 168, 15);
		}
		return lblPassword;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(31, 117, 168, 25);
		}
		return passwordField;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("LOGIN");
			btnNewButton.setFont(new Font("DialogInput", Font.BOLD, 15));
			btnNewButton.setBackground(new Color(229, 231, 233));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.loginButton(logInProzor);
				}
			});
			btnNewButton.setBounds(117, 176, 168, 43);
		}
		return btnNewButton;
	}
}
