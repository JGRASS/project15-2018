package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kafic.Racun;
import kafic.Radnik;
import kafic.Sto;
import kafic.gui.kontroler.GUIKontroler;
import javax.swing.JScrollPane;

public class RacunManagementProzor extends JFrame {

	public JPanel contentPane;
	private JPanel panel;
	
	private RacunManagementProzor rmp = this;
	private JPanel panelGlavni;
	private JPanel panel_1;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JSeparator separator;
	public JLabel lblDatum;
	public JLabel lblRadnik;
	public JLabel lblBrojStola;
	public JLabel lblZaUplatu;
	private JLabel lblUplata;
	public JTextField txtUplata;
	private JButton btnUplati;
	public JLabel lblKusur;
	
	public Racun racun;
	private JScrollPane scrollPane;
	public JTextArea textArea;
	public JButton pritisnutoDugme;
	
	public boolean validan = false;

	/**
	 * Create the frame.
	 */
	public RacunManagementProzor(GlavniProzor glavniProzor, Sto sto,
			Racun racun, JButton button, Radnik radnik) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setPreferredSize(new Dimension(250, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getPanelGlavni(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		this.pritisnutoDugme = button;
		this.racun = racun;
		racun.setRadnik(radnik);
		try {
			racun.setBrojStola(sto.getBrojStola());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Neocekivana greska", "Obavestenje",
					JOptionPane.WARNING_MESSAGE);
		}
		GUIKontroler.dodajArtikleUProzor(rmp, racun);
		GUIKontroler.setOsnovnePodatkeRacun(rmp, racun, glavniProzor);
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(200, 400));
			panel.add(getScrollPane());
		}
		return panel;
	}
	private JPanel getPanelGlavni() {
		if (panelGlavni == null) {
			panelGlavni = new JPanel();
			panelGlavni.setPreferredSize(new Dimension(250, 10));
			panelGlavni.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelGlavni.add(getLblDatum());
			panelGlavni.add(getLblRadnik());
			panelGlavni.add(getLblBrojStola());
			panelGlavni.add(getLblZaUplatu());
			panelGlavni.add(getLblUplata());
			panelGlavni.add(getTxtUplata());
			panelGlavni.add(getBtnUplati());
			panelGlavni.add(getLblKusur());
		}
		return panelGlavni;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(10, 50));
			FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.CENTER, 5, 5);
			panel_1.setLayout(fl_panel_1);
			panel_1.add(getBtnPotvrdi());
			panel_1.add(getSeparator());
			panel_1.add(getBtnOdustani());
		}
		return panel_1;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.setFont(new Font("DialogInput", Font.BOLD, 16));
			btnPotvrdi.setBackground(new Color(229, 232, 232));
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.potvrdiKrajRacuna(rmp, pritisnutoDugme);
				}
			});
			btnPotvrdi.setPreferredSize(new Dimension(120, 40));
		}
		return btnPotvrdi;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setFont(new Font("DialogInput", Font.BOLD, 16));
			btnOdustani.setBackground(new Color(229, 232, 232));
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setPreferredSize(new Dimension(120, 40));
		}
		return btnOdustani;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setPreferredSize(new Dimension(120, 2));
			separator.setVisible(false);
		}
		return separator;
	}
	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("Datum");
			lblDatum.setFont(new Font("DialogInput", Font.BOLD, 12));
			lblDatum.setPreferredSize(new Dimension(200, 35));
		}
		return lblDatum;
	}
	private JLabel getLblRadnik() {
		if (lblRadnik == null) {
			lblRadnik = new JLabel("Radnik");
			lblRadnik.setFont(new Font("DialogInput", Font.BOLD, 14));
			lblRadnik.setPreferredSize(new Dimension(200, 35));
		}
		return lblRadnik;
	}
	private JLabel getLblBrojStola() {
		if (lblBrojStola == null) {
			lblBrojStola = new JLabel("Broj Stola");
			lblBrojStola.setFont(new Font("DialogInput", Font.BOLD, 12));
			lblBrojStola.setPreferredSize(new Dimension(200, 35));
		}
		return lblBrojStola;
	}
	private JLabel getLblZaUplatu() {
		if (lblZaUplatu == null) {
			lblZaUplatu = new JLabel("Za uplatu");
			lblZaUplatu.setFont(new Font("DialogInput", Font.BOLD, 14));
			lblZaUplatu.setPreferredSize(new Dimension(200, 35));
		}
		return lblZaUplatu;
	}
	private JLabel getLblUplata() {
		if (lblUplata == null) {
			lblUplata = new JLabel("Uplata:");
			lblUplata.setFont(new Font("DialogInput", Font.BOLD, 14));
			lblUplata.setPreferredSize(new Dimension(80, 35));
		}
		return lblUplata;
	}
	private JTextField getTxtUplata() {
		if (txtUplata == null) {
			txtUplata = new JTextField();
			txtUplata.setPreferredSize(new Dimension(120, 35));
			txtUplata.setColumns(10);
		}
		return txtUplata;
	}
	private JButton getBtnUplati() {
		if (btnUplati == null) {
			btnUplati = new JButton("Uplati");
			btnUplati.setFont(new Font("DialogInput", Font.BOLD, 16));
			btnUplati.setPreferredSize(new Dimension(80, 35));
			btnUplati.setBackground(new Color(229, 232, 232));
			btnUplati.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.obracunajUplatu(rmp, racun);
				}
			});
			btnUplati.setPreferredSize(new Dimension(120, 35));
		}
		return btnUplati;
	}
	private JLabel getLblKusur() {
		if (lblKusur == null) {
			lblKusur = new JLabel("Kusur:");
			lblKusur.setFont(new Font("DialogInput", Font.BOLD, 14));
			lblKusur.setPreferredSize(new Dimension(200, 35));
		}
		return lblKusur;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(200, 300));
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
}
