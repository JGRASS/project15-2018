package kafic.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kafic.gui.kontroler.GUIKontroler;

public class DodajArtikalProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblNaziv;
	private JLabel lblCena;
	public JTextField textField;
	public JTextField textField_1;
	private JLabel lblSifra;
	private JLabel lblZemljaPorekla;
	public JTextField textField_2;
	public JTextField textField_3;
	private JButton btnDodajArtikal;
	private JButton btnOdustani;
	
	DodajArtikalProzor dodajArtikalProzor = this;

	/**
	 * Create the frame.
	 */
	public DodajArtikalProzor() {
		setTitle("Dodaj Artikal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 30, 15));
		contentPane.add(getLblNaziv());
		contentPane.add(getLblCena());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getLblSifra());
		contentPane.add(getLblZemljaPorekla());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_3());
		contentPane.add(getBtnDodajArtikal());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv:");
			lblNaziv.setFont(new Font("DialogInput", Font.BOLD, 17));
		}
		return lblNaziv;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena:");
			lblCena.setFont(new Font("DialogInput", Font.BOLD, 17));
		}
		return lblCena;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("DialogInput", Font.PLAIN, 18));
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setText("");
			textField_1.setFont(new Font("DialogInput", Font.PLAIN, 18));
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra:");
			lblSifra.setFont(new Font("DialogInput", Font.BOLD, 17));
		}
		return lblSifra;
	}
	private JLabel getLblZemljaPorekla() {
		if (lblZemljaPorekla == null) {
			lblZemljaPorekla = new JLabel("Zemlja Porekla");
			lblZemljaPorekla.setFont(new Font("DialogInput", Font.BOLD, 17));
		}
		return lblZemljaPorekla;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setFont(new Font("DialogInput", Font.PLAIN, 18));
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setText("");
			textField_3.setFont(new Font("DialogInput", Font.PLAIN, 18));
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JButton getBtnDodajArtikal() {
		if (btnDodajArtikal == null) {
			btnDodajArtikal = new JButton("Dodaj Artikal");
			btnDodajArtikal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dodajArtikal(dodajArtikalProzor);
				}
			});
			btnDodajArtikal.setFont(new Font("DialogInput", Font.BOLD, 16));
			btnDodajArtikal.setBackground(new Color(242, 243, 244));
		}
		return btnDodajArtikal;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setFont(new Font("DialogInput", Font.BOLD, 16));
			btnOdustani.setBackground(new Color(242, 243, 244));
		}
		return btnOdustani;
	}
}
