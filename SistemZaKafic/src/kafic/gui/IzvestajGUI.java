package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import kafic.Kafic;
import kafic.Radnik;
import kafic.Sto;
import kafic.gui.kontroler.GUIKontroler;
import java.awt.Toolkit;

public class IzvestajGUI extends JFrame {

	public JPanel contentPane;
	private JPanel juzniPanel;
	private JScrollPane scrollPane;
	public JTextArea textArea;
	private JButton btnZavrsi;
	private JButton btnOdustani;

	public static String ceoIzvestaj;
	private IzvestajGUI izvestaj = this;
	public GlavniProzor pozvanoIz;

	/**
	 * Create the frame.
	 * 
	 * @param radnik
	 * @param sto8
	 * @param sto7
	 * @param sto6
	 * @param sto5
	 * @param sto4
	 * @param sto3
	 * @param sto2
	 * @param sto1
	 */
	public IzvestajGUI(Sto sto1, Sto sto2, Sto sto3, Sto sto4, Sto sto5, Sto sto6, Sto sto7, Sto sto8, Radnik radnik, GlavniProzor glavniProzor) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvestajGUI.class.getResource("/icons/ParadisoCaffee.jpeg")));
		setResizable(false);
		setTitle("Izvestaj");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getJuzniPanel(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		pozvanoIz = glavniProzor;
		GUIKontroler.izvuciSveRacune(sto1, sto2, sto3, sto4, sto5, sto6, sto7, sto8, izvestaj);
	}

	private JPanel getJuzniPanel() {
		if (juzniPanel == null) {
			juzniPanel = new JPanel();
			juzniPanel.setPreferredSize(new Dimension(0, 80));
			juzniPanel.setLayout(null);
			juzniPanel.add(getBtnZavrsi());
			juzniPanel.add(getBtnOdustani());
		}
		return juzniPanel;
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
			textArea.setEditable(false);
			textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		}
		return textArea;
	}

	private JButton getBtnZavrsi() {
		if (btnZavrsi == null) {
			btnZavrsi = new JButton("Zavrsi");
			btnZavrsi.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnZavrsi.setBackground(new Color(130, 224, 170));
			btnZavrsi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.dugmeZavrsiIzvestaj(izvestaj, pozvanoIz);
				}
			});
			btnZavrsi.setBounds(48, 16, 115, 48);
		}
		return btnZavrsi;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnOdustani.setBackground(new Color(236, 112, 99));
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(267, 16, 115, 48);
		}
		return btnOdustani;
	}
}
