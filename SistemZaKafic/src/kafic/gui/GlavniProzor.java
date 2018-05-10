package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import kafic.Radnik;
import kafic.Sto;
import kafic.gui.kontroler.GUIKontroler;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel severniPanel;
	private JPanel centralniPanel;
	private JPanel istocniPanel;
	private JButton btnPrviSto;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnOsmiSto;
	private JButton btnDrugiSto;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JButton btnSedmiSto;
	private JButton btnTreciSto;
	private JButton btnCetvrtiSto;
	private JButton btnPetiSto;
	private JButton btnSestiSto;
	private JPanel panel;
	
	private static Radnik radnik;
	private JButton btnNoviRacun;
	private JButton btnSuperDugme;
	private JPanel panelGornji;
	public JLabel lblBrojstola;
	
	public Sto sto1 = new Sto();
	public Sto sto2 = new Sto();
	public Sto sto3 = new Sto();
	public Sto sto4 = new Sto();
	public Sto sto5 = new Sto();
	public Sto sto6 = new Sto();
	public Sto sto7 = new Sto();
	public Sto sto8 = new Sto();
	
	public Sto selektovanSto = null;
	
	
	private GlavniProzor glavniProzor = this;
	private JScrollPane scrollPane;
	public JPanel panelZaRacune;

	/**
	 * Create the frame.
	 */
	public GlavniProzor(Radnik randik) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1266, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getSeverniPanel(), BorderLayout.NORTH);
		contentPane.add(getCentralniPanel(), BorderLayout.CENTER);
		contentPane.add(getIstocniPanel(), BorderLayout.EAST);
		
		this.radnik = radnik;
		
		sto1.setBrojStola(1);
		sto2.setBrojStola(2);
		sto3.setBrojStola(3);
		sto4.setBrojStola(4);
		sto5.setBrojStola(5);
		sto6.setBrojStola(6);
		sto7.setBrojStola(7);
		sto8.setBrojStola(8);
		
	}

	private JPanel getSeverniPanel() {
		if (severniPanel == null) {
			severniPanel = new JPanel();
			severniPanel.setBackground(new Color(229, 231, 233));
			severniPanel.setPreferredSize(new Dimension(0, 120));
			severniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return severniPanel;
	}
	private JPanel getCentralniPanel() {
		if (centralniPanel == null) {
			centralniPanel = new JPanel();
			centralniPanel.setBackground(new Color(237, 187, 153));
			centralniPanel.setLayout(new GridLayout(3, 4, 0, 0));
			centralniPanel.add(getBtnPrviSto());
			centralniPanel.add(getSeparator());
			centralniPanel.add(getSeparator_1());
			centralniPanel.add(getBtnOsmiSto());
			centralniPanel.add(getBtnDrugiSto());
			centralniPanel.add(getSeparator_2());
			centralniPanel.add(getSeparator_3());
			centralniPanel.add(getBtnSedmiSto());
			centralniPanel.add(getBtnTreciSto());
			centralniPanel.add(getBtnCetvrtiSto());
			centralniPanel.add(getBtnPetiSto());
			centralniPanel.add(getBtnSestiSto());
		}
		return centralniPanel;
	}
	private JPanel getIstocniPanel() {
		if (istocniPanel == null) {
			istocniPanel = new JPanel();
			istocniPanel.setBackground(new Color(253, 254, 254));
			istocniPanel.setPreferredSize(new Dimension(440, 0));
			istocniPanel.setLayout(new BorderLayout(0, 0));
			istocniPanel.add(getPanel(), BorderLayout.SOUTH);
			istocniPanel.add(getPanelGornji(), BorderLayout.NORTH);
			istocniPanel.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return istocniPanel;
	}
	private JButton getBtnPrviSto() {
		if (btnPrviSto == null) {
			btnPrviSto = new JButton("1");
			btnPrviSto.setBorder(null);
			btnPrviSto.setBackground(new Color(237, 187, 153));
			btnPrviSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.dugmePritisnuto(sto1, glavniProzor, null);
				}
			});
			btnPrviSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnPrviSto;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setVisible(false);
			separator.setBorder(null);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setVisible(false);
			separator_1.setBorder(null);
		}
		return separator_1;
	}
	private JButton getBtnOsmiSto() {
		if (btnOsmiSto == null) {
			btnOsmiSto = new JButton("8");
			btnOsmiSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dugmePritisnuto(sto8, glavniProzor, null);
				}
			});
			btnOsmiSto.setBorder(null);
			btnOsmiSto.setBackground(new Color(237, 187, 153));
			btnOsmiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnOsmiSto;
	}
	private JButton getBtnDrugiSto() {
		if (btnDrugiSto == null) {
			btnDrugiSto = new JButton("2");
			btnDrugiSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dugmePritisnuto(sto2, glavniProzor, null);
				}
			});
			btnDrugiSto.setBorder(null);
			btnDrugiSto.setBackground(new Color(237, 187, 153));
			btnDrugiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnDrugiSto;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setVisible(false);
			separator_2.setBorder(null);
		}
		return separator_2;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setVisible(false);
			separator_3.setBorder(null);
		}
		return separator_3;
	}
	private JButton getBtnSedmiSto() {
		if (btnSedmiSto == null) {
			btnSedmiSto = new JButton("7");
			btnSedmiSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dugmePritisnuto(sto7, glavniProzor, null);
				}
			});
			btnSedmiSto.setBorder(null);
			btnSedmiSto.setBackground(new Color(237, 187, 153));
			btnSedmiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnSedmiSto;
	}
	private JButton getBtnTreciSto() {
		if (btnTreciSto == null) {
			btnTreciSto = new JButton("3");
			btnTreciSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dugmePritisnuto(sto3, glavniProzor, null);
				}
			});
			btnTreciSto.setBorder(null);
			btnTreciSto.setBackground(new Color(237, 187, 153));
			btnTreciSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnTreciSto;
	}
	private JButton getBtnCetvrtiSto() {
		if (btnCetvrtiSto == null) {
			btnCetvrtiSto = new JButton("4");
			btnCetvrtiSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dugmePritisnuto(sto4, glavniProzor, null);
				}
			});
			btnCetvrtiSto.setBorder(null);
			btnCetvrtiSto.setBackground(new Color(237, 187, 153));
			btnCetvrtiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnCetvrtiSto;
	}
	private JButton getBtnPetiSto() {
		if (btnPetiSto == null) {
			btnPetiSto = new JButton("5");
			btnPetiSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dugmePritisnuto(sto5, glavniProzor, null);
				}
			});
			btnPetiSto.setBorder(null);
			btnPetiSto.setBackground(new Color(237, 187, 153));
			btnPetiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnPetiSto;
	}
	private JButton getBtnSestiSto() {
		if (btnSestiSto == null) {
			btnSestiSto = new JButton("6");
			btnSestiSto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dugmePritisnuto(sto6, glavniProzor, null);
				}
			});
			btnSestiSto.setBorder(null);
			btnSestiSto.setBackground(new Color(237, 187, 153));
			btnSestiSto.setIcon(new ImageIcon(GlavniProzor.class.getResource("/icons/smallCaffeeTable.png")));
		}
		return btnSestiSto;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(600, 70));
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getBtnNoviRacun());
			panel.add(getBtnSuperDugme());
		}
		return panel;
	}
	private JButton getBtnNoviRacun() {
		if (btnNoviRacun == null) {
			btnNoviRacun = new JButton("Novi Racun");
			btnNoviRacun.setBackground(new Color(229, 232, 232));
			btnNoviRacun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (selektovanSto == null) {
						JOptionPane.showMessageDialog(glavniProzor, "Prvo selektujte sto!", "Obavestenje",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					GUIKontroler.otvoriRacunProzor(selektovanSto, radnik, glavniProzor);
				}
			});
			btnNoviRacun.setPreferredSize(new Dimension(170, 45));
		}
		return btnNoviRacun;
	}
	private JButton getBtnSuperDugme() {
		if (btnSuperDugme == null) {
			btnSuperDugme = new JButton("Bas super dugme");
			btnSuperDugme.setBackground(new Color(229, 232, 232));
			btnSuperDugme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (selektovanSto == null) {
						JOptionPane.showMessageDialog(glavniProzor, "Prvi selektujte sto!", "Obavestenje",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
			});
			btnSuperDugme.setPreferredSize(new Dimension(170, 45));
		}
		return btnSuperDugme;
	}
	private JPanel getPanelGornji() {
		if (panelGornji == null) {
			panelGornji = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelGornji.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelGornji.setAlignmentY(Component.TOP_ALIGNMENT);
			panelGornji.setPreferredSize(new Dimension(10, 35));
			panelGornji.add(getLblBrojstola());
		}
		return panelGornji;
	}
	private JLabel getLblBrojstola() {
		if (lblBrojstola == null) {
			lblBrojstola = new JLabel("Broj stola: ");
			lblBrojstola.setFont(new Font("DialogInput", Font.PLAIN, 20));
		}
		return lblBrojstola;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(350, 425));
			scrollPane.setViewportView(getPanelZaRacune());
		}
		return scrollPane;
	}
	private JPanel getPanelZaRacune() {
		if (panelZaRacune == null) {
			panelZaRacune = new JPanel();
			panelZaRacune.setPreferredSize(new Dimension(350, 10));
		}
		return panelZaRacune;
	}
}
