package kafic.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class IzvestajProzor extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;
	private JButton jtfSacuvaj;
	private JButton jtfOdustani;
	private JLabel lblPocetniDatum;
	private JTextField jtfPocetniDan;
	private JTextField jtfPocetniMesec;
	private JTextField jtfPocetnaGodina;
	private JLabel lblKrajnjiDatum;
	private JTextField jtfKrajnjiDan;
	private JTextField jtfKrajnjiMesec;
	private JTextField jtfKrajnjaGodina;
	private JCheckBox chckbxTrenutniDatum;
	private JButton btnIspis;

	/**
	 * Create the frame.
	 */
	public IzvestajProzor() {
		setResizable(false);
		setTitle("Izvestaj");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(150, 10));
			panel.setLayout(null);
			panel.add(getJtfSacuvaj());
			panel.add(getJtfOdustani());
			panel.add(getLblPocetniDatum());
			panel.add(getJtfPocetniDan());
			panel.add(getJtfPocetniMesec());
			panel.add(getJtfPocetnaGodina());
			panel.add(getLblKrajnjiDatum());
			panel.add(getJtfKrajnjiDan());
			panel.add(getJtfKrajnjiMesec());
			panel.add(getJtfKrajnjaGodina());
			panel.add(getChckbxTrenutniDatum());
			panel.add(getBtnIspis());
		}
		return panel;
	}
	private JButton getJtfSacuvaj() {
		if (jtfSacuvaj == null) {
			jtfSacuvaj = new JButton("Sacuvaj");
			jtfSacuvaj.setBackground(SystemColor.control);
			jtfSacuvaj.setBounds(14, 187, 126, 29);
			jtfSacuvaj.setFont(new Font("Dialog", Font.PLAIN, 15));
		}
		return jtfSacuvaj;
	}
	private JButton getJtfOdustani() {
		if (jtfOdustani == null) {
			jtfOdustani = new JButton("Odustani");
			jtfOdustani.setBackground(SystemColor.control);
			jtfOdustani.setBounds(14, 227, 126, 29);
			jtfOdustani.setFont(new Font("Dialog", Font.PLAIN, 15));
		}
		return jtfOdustani;
	}
	private JLabel getLblPocetniDatum() {
		if (lblPocetniDatum == null) {
			lblPocetniDatum = new JLabel("Pocetni datum");
			lblPocetniDatum.setBounds(14, 45, 116, 14);
		}
		return lblPocetniDatum;
	}
	private JTextField getJtfPocetniDan() {
		if (jtfPocetniDan == null) {
			jtfPocetniDan = new JTextField();
			jtfPocetniDan.setBounds(14, 70, 21, 20);
			jtfPocetniDan.setColumns(10);
		}
		return jtfPocetniDan;
	}
	private JTextField getJtfPocetniMesec() {
		if (jtfPocetniMesec == null) {
			jtfPocetniMesec = new JTextField();
			jtfPocetniMesec.setBounds(45, 70, 21, 20);
			jtfPocetniMesec.setColumns(10);
		}
		return jtfPocetniMesec;
	}
	private JTextField getJtfPocetnaGodina() {
		if (jtfPocetnaGodina == null) {
			jtfPocetnaGodina = new JTextField();
			jtfPocetnaGodina.setBounds(76, 70, 54, 20);
			jtfPocetnaGodina.setColumns(10);
		}
		return jtfPocetnaGodina;
	}
	private JLabel getLblKrajnjiDatum() {
		if (lblKrajnjiDatum == null) {
			lblKrajnjiDatum = new JLabel("Krajnji datum");
			lblKrajnjiDatum.setBounds(14, 101, 116, 14);
		}
		return lblKrajnjiDatum;
	}
	private JTextField getJtfKrajnjiDan() {
		if (jtfKrajnjiDan == null) {
			jtfKrajnjiDan = new JTextField();
			jtfKrajnjiDan.setColumns(10);
			jtfKrajnjiDan.setBounds(14, 126, 21, 20);
		}
		return jtfKrajnjiDan;
	}
	private JTextField getJtfKrajnjiMesec() {
		if (jtfKrajnjiMesec == null) {
			jtfKrajnjiMesec = new JTextField();
			jtfKrajnjiMesec.setColumns(10);
			jtfKrajnjiMesec.setBounds(45, 126, 21, 20);
		}
		return jtfKrajnjiMesec;
	}
	private JTextField getJtfKrajnjaGodina() {
		if (jtfKrajnjaGodina == null) {
			jtfKrajnjaGodina = new JTextField();
			jtfKrajnjaGodina.setColumns(10);
			jtfKrajnjaGodina.setBounds(76, 126, 54, 20);
		}
		return jtfKrajnjaGodina;
	}
	private JCheckBox getChckbxTrenutniDatum() {
		if (chckbxTrenutniDatum == null) {
			chckbxTrenutniDatum = new JCheckBox("Trenutni datum");
			chckbxTrenutniDatum.setBackground(SystemColor.control);
			chckbxTrenutniDatum.setBounds(14, 153, 126, 23);
		}
		return chckbxTrenutniDatum;
	}
	private JButton getBtnIspis() {
		if (btnIspis == null) {
			btnIspis = new JButton("Ispis");
			btnIspis.setFont(new Font("Dialog", Font.PLAIN, 15));
			btnIspis.setBounds(10, 11, 130, 29);
		}
		return btnIspis;
	}
}
