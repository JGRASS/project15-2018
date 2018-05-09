package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kafic.Artikal;
import kafic.Kafic;
import kafic.Radnik;
import kafic.gui.kontroler.GUIKontroler;

public class ObrisiArtikalProzor extends JFrame {


	private JPanel contentPane;
	private JLabel lblNaziv;
	private JLabel lblCena;
	public JTextField textNaziv;
	public JTextField textCena;
	private JLabel lblSifra;
	private JLabel lblZemljaPorekla;
	public JTextField textSifra;
	public JTextField textZemljaPorekla;
	public JCheckBox chckbxPotvrda;
	private JSeparator separator;
	private JButton btnObrisiArtikal;
	private JButton btnOdustani;
	
	private ObrisiArtikalProzor obrisiArtikalProzor = this;
	private Artikal artikal = new Artikal();
	
	/**
	 * Create the frame.
	 * @param adminProzor 
	 */
	public  ObrisiArtikalProzor(String sifra) {
		setResizable(false);
		setTitle("Dodaj Radnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(25, 25, 15, 15));
		contentPane.setLayout(new GridLayout(6, 2, 30, 15));
		contentPane.add(getLblNaziv());
		contentPane.add(getLblCena());
		contentPane.add(getTextNaziv());
		contentPane.add(getTextCena());
		contentPane.add(getLblSifra());
		contentPane.add(getLblZemljaPorekla());
		contentPane.add(getTextSifra());
		contentPane.add(getTextZemljaPorekla());
		contentPane.add(getChckbxPotvrda());
		contentPane.add(getSeparator());
		contentPane.add(getBtnObrisiArtikal());
		contentPane.add(getBtnOdustani());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		LinkedList<Artikal> artikli= Kafic.artikli;
		
		for (int i = 0; i < artikli.size(); i++) {
			if (artikli.get(i).getSifraArtikla().equals(sifra)) {
				artikal = artikli.get(i);
				break;
			}
		}
		
		GUIKontroler.napuniObrisiArtikalProzor(obrisiArtikalProzor, artikal);
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv:");
			lblNaziv.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return lblNaziv;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena:");
			lblCena.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return lblCena;
	}
	private JTextField getTextNaziv() {
		if (textNaziv == null) {
			textNaziv = new JTextField();
			textNaziv.setEditable(false);
			textNaziv.setFont(new Font("DialogInput", Font.PLAIN, 16));
			textNaziv.setColumns(10);
		}
		return textNaziv;
	}
	private JTextField getTextCena() {
		if (textCena == null) {
			textCena = new JTextField();
			textCena.setEditable(false);
			textCena.setFont(new Font("DialogInput", Font.PLAIN, 16));
			textCena.setText("");
			textCena.setColumns(10);
		}
		return textCena;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra:");
			lblSifra.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return lblSifra;
	}
	private JLabel getLblZemljaPorekla() {
		if (lblZemljaPorekla == null) {
			lblZemljaPorekla = new JLabel("Zemlja Porekla:");
			lblZemljaPorekla.setFont(new Font("DialogInput", Font.BOLD, 16));
		}
		return lblZemljaPorekla;
	}
	private JTextField getTextSifra() {
		if (textSifra == null) {
			textSifra = new JTextField();
			textSifra.setEditable(false);
			textSifra.setFont(new Font("DialogInput", Font.PLAIN, 16));
			textSifra.setColumns(10);
		}
		return textSifra;
	}
	private JTextField getTextZemljaPorekla() {
		if (textZemljaPorekla == null) {
			textZemljaPorekla = new JTextField();
			textZemljaPorekla.setEditable(false);
			textZemljaPorekla.setFont(new Font("DialogInput", Font.PLAIN, 16));
			textZemljaPorekla.setText("");
			textZemljaPorekla.setColumns(10);
		}
		return textZemljaPorekla;
	}
	private JCheckBox getChckbxPotvrda() {
		if (chckbxPotvrda == null) {
			chckbxPotvrda = new JCheckBox("Potvrda za brisanje");
			chckbxPotvrda.setFont(new Font("DialogInput", Font.BOLD, 14));
		}
		return chckbxPotvrda;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setVisible(false);
		}
		return separator;
	}
	private JButton getBtnObrisiArtikal() {
		if (btnObrisiArtikal == null) {
			btnObrisiArtikal = new JButton("Obrisi Artikal");
			btnObrisiArtikal.setFont(new Font("DialogInput", Font.BOLD, 16));
			btnObrisiArtikal.setBackground(new Color(242, 243, 244));
			btnObrisiArtikal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.obrisiArtikalIzListe(obrisiArtikalProzor, artikal);
				}
			});
		}
		return btnObrisiArtikal;
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
