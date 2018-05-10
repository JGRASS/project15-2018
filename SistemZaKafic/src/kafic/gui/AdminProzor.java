package kafic.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kafic.Radnik;
import kafic.gui.kontroler.GUIKontroler;

public class AdminProzor extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblAdminName;
	private JPanel panel_1;
	private JButton btnNewButton_5;
	private JButton btnDodajRadnika;
	private JButton btnDodajArtikal;
	private JButton btnObrisiRadnika;
	private JButton btnObrisiArtikal;
	private JButton btnLogout;
	
	public AdminProzor adminProzor = this;

	/**
	 * Create the frame.
	 */
	public AdminProzor(Radnik radnik) {
		setTitle("Admin stranica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		lblAdminName.setText("Administrator " + radnik.getIme() + " " + radnik.getPrezime());
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblAdminName());
		}
		return panel;
	}

	private JLabel getLblAdminName() {
		if (lblAdminName == null) {
			lblAdminName = new JLabel("");
			lblAdminName.setFont(new Font("DialogInput", Font.BOLD, 24));
			lblAdminName.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblAdminName;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(3, 2, 40, 40));
			panel_1.add(getBtnDodajRadnika());
			panel_1.add(getBtnDodajArtikal());
			panel_1.add(getBtnObrisiRadnika());
			panel_1.add(getBtnObrisiArtikal());
			panel_1.add(getBtnLogout());
			panel_1.setBorder(BorderFactory.createEmptyBorder(45, 50, 50, 50));
		}
		return panel_1;
	}

	private JButton gtBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("New button");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnNewButton_5;
	}

	private JButton getBtnDodajRadnika() {
		if (btnDodajRadnika == null) {
			btnDodajRadnika = new JButton("Dodaj Radnika");
			btnDodajRadnika.setBackground(new Color(242, 243, 244));
			btnDodajRadnika.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajRadnikaProzor dodajRadnikaProzor = new DodajRadnikaProzor();
					dodajRadnikaProzor.setVisible(true);
				}
			});
			btnDodajRadnika.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		}
		return btnDodajRadnika;
	}

	private JButton getBtnDodajArtikal() {
		if (btnDodajArtikal == null) {
			btnDodajArtikal = new JButton("Dodaj Artikal");
			btnDodajArtikal.setBackground(new Color(242, 243, 244));
			btnDodajArtikal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajArtikalProzor dodajArtikalProzor = new DodajArtikalProzor();
					dodajArtikalProzor.setVisible(true);
				}
			});
			btnDodajArtikal.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		}
		return btnDodajArtikal;
	}

	private JButton getBtnObrisiRadnika() {
		if (btnObrisiRadnika == null) {
			btnObrisiRadnika = new JButton("Obrisi Radnika");
			btnObrisiRadnika.setBackground(new Color(242, 243, 244));
			btnObrisiRadnika.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzlistajRadnikeProzor izlistajRadnikeProzor = new IzlistajRadnikeProzor();
					izlistajRadnikeProzor.setVisible(true);
				}
			});
			btnObrisiRadnika.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		}
		return btnObrisiRadnika;
	}

	private JButton getBtnObrisiArtikal() {
		if (btnObrisiArtikal == null) {
			btnObrisiArtikal = new JButton("Obrisi Artikal");
			btnObrisiArtikal.setBackground(new Color(242, 243, 244));
			btnObrisiArtikal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzlistajArtikleProzor izlistajArtikleProzor = new IzlistajArtikleProzor();
					izlistajArtikleProzor.setVisible(true);
				}
			});
			btnObrisiArtikal.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		}
		return btnObrisiArtikal;
	}

	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("Logout");
			btnLogout.setBackground(new Color(229, 232, 232));
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.startovanjePrograma();
				}
			});
			btnLogout.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		}
		return btnLogout;
	}
}
