package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import kafic.Racun;
import kafic.Radnik;
import kafic.Sto;
import kafic.gui.kontroler.GUIKontroler;

public class RacunProzor extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnNapraviRacun;
	private JButton btnOdustani;
	private JScrollPane scrollPane_1;
	public JTextArea textArea;
	private JPanel panelZaArtikle;
	private JPanel panel_1;
	private JLabel lblDodajteArtikle;

	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private RacunProzor racunProzor = this;
	private Sto sto;
	private Racun racun;

	private Radnik radnik;
	private static int panelHeight;
	private static GlavniProzor glavniProzor;

	/**
	 * Create the frame.
	 */
	public RacunProzor(Sto sto, Radnik radnik, GlavniProzor glavniProzor) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane_1(), BorderLayout.CENTER);
		contentPane.add(getPanel_1_1(), BorderLayout.NORTH);
		this.glavniProzor = glavniProzor;

		this.radnik = radnik;
		this.racun = new Racun();
		racun.setRadnik(radnik);
		this.sto = sto;

		buttons = GUIKontroler.generisiDugmadZaArtikle(racunProzor, sto, racun);
		this.panelHeight = buttons.size() * 35 + 2;
		contentPane.add(getScrollPane(), BorderLayout.EAST);

		for (int i = 0; i < buttons.size(); i++) {
			panelZaArtikle.add(buttons.get(i));
		}
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(140, 100));
			scrollPane.setViewportView(getPanelZaArtikle());
		}
		return scrollPane;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnNapraviRacun());
			panel.add(getBtnOdustani());
		}
		return panel;
	}

	private JButton getBtnNapraviRacun() {
		if (btnNapraviRacun == null) {
			btnNapraviRacun = new JButton("Napravi Racun");
			btnNapraviRacun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textArea.getText().isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Morate dodati bar jedan artikal", "Obavestenje",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					LinkedList<Racun> racuni = sto.getRacuniNaStolu();
					racuni.add(racun);
					sto.setRacuniNaStolu(racuni);
					
					GUIKontroler.dugmePritisnuto(sto, glavniProzor, racun, radnik, null);
					
					dispose();
				}
			});
		}
		return btnNapraviRacun;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextArea());
		}
		return scrollPane_1;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}

	private JPanel getPanelZaArtikle() {
		if (panelZaArtikle == null) {
			panelZaArtikle = new JPanel();
			panelZaArtikle.setPreferredSize(new Dimension(114, panelHeight));
		}
		return panelZaArtikle;
	}

	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblDodajteArtikle());
		}
		return panel_1;
	}

	private JLabel getLblDodajteArtikle() {
		if (lblDodajteArtikle == null) {
			lblDodajteArtikle = new JLabel("Dodajte artikle");
			lblDodajteArtikle.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblDodajteArtikle.setFont(new Font("DialogInput", Font.BOLD, 15));
		}
		return lblDodajteArtikle;
	}
}
