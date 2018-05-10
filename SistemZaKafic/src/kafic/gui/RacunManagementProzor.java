package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import kafic.Racun;
import kafic.Sto;
import kafic.gui.kontroler.GUIKontroler;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class RacunManagementProzor extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	public JTextArea textArea;
	
	private RacunManagementProzor rmp = this;
	private JPanel panelGlavni;
	private JPanel panel_1;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JSeparator separator;

	/**
	 * Create the frame.
	 */
	public RacunManagementProzor(GlavniProzor glavniProzor, Sto sto,
			Racun racun, JButton button) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		setLocationRelativeTo(glavniProzor.panelZaRacune);
		contentPane.setPreferredSize(new Dimension(250, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getPanelGlavni(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		GUIKontroler.dodajArtikleUProzor(rmp, racun);
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(200, 400));
			panel.add(getTextArea());
		}
		return panel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setPreferredSize(new Dimension(200, 400));
		}
		return textArea;
	}
	private JPanel getPanelGlavni() {
		if (panelGlavni == null) {
			panelGlavni = new JPanel();
			panelGlavni.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
			btnPotvrdi.setBackground(new Color(229, 232, 232));
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnPotvrdi.setPreferredSize(new Dimension(120, 40));
		}
		return btnPotvrdi;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
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
}
