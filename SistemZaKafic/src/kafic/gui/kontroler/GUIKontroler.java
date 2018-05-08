package kafic.gui.kontroler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import kafic.Kafic;
import kafic.Radnik;
import kafic.gui.AdminProzor;
import kafic.gui.DodajRadnikaProzor;
import kafic.gui.GlavniProzor;
import kafic.gui.IzlistajRadnikeProzor;
import kafic.gui.IzvestajProzor;
import kafic.gui.LogInProzor;
import kafic.gui.ObrisiRadnikaProzor;
import kafic.gui.UvodniProzor;

public class GUIKontroler {
	public static Radnik radnik;
	public static UvodniProzor start;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kafic.napuniListuRadnika();
					Kafic.napuniListuArtikli();

					startovanjePrograma();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void startovanjePrograma() {
		start = new UvodniProzor();
		start.setVisible(true);

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println("Greska, " + e.getMessage());
		}

		LogInProzor login = new LogInProzor();
		login.setVisible(true);
	}

	public static void adminIliRadnikPaDalje(Radnik noviRadnik) {
		radnik = noviRadnik;

		if (radnik.isAdmin()) {
			AdminProzor adminProzor = new AdminProzor(radnik);
			adminProzor.setVisible(true);
			start.dispose();
		} else {
			GlavniProzor glavniProzor = new GlavniProzor(radnik);
			glavniProzor.setVisible(true);
			start.dispose();
		}
	}

	public static void prikaziIzvestajProzor() {
		IzvestajProzor prozor = new IzvestajProzor();
		prozor.setVisible(true);
	}

	public static void dodajRadnika(DodajRadnikaProzor dodajRadnikaProzor) {
		Radnik radnik = new Radnik();

		String ime = dodajRadnikaProzor.textImeRadnika.getText();
		try {
			radnik.setIme(ime);
		} catch (Exception e1) {
			dodajRadnikaProzor.textImeRadnika.setText("");
			JOptionPane.showMessageDialog(dodajRadnikaProzor, e1.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String prezime = dodajRadnikaProzor.textPrezimeRadnika.getText();
		try {
			radnik.setPrezime(prezime);
		} catch (Exception e) {
			dodajRadnikaProzor.textPrezimeRadnika.setText("");
			JOptionPane.showMessageDialog(dodajRadnikaProzor, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String username = dodajRadnikaProzor.textUsername.getText();
		try {
			radnik.setUsername(username);
		} catch (Exception e) {
			dodajRadnikaProzor.textUsername.setText("");
			JOptionPane.showMessageDialog(dodajRadnikaProzor, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String password = dodajRadnikaProzor.textPassword.getText();
		try {
			radnik.setPassword(password);
		} catch (Exception e) {
			dodajRadnikaProzor.textPassword.setText("");
			JOptionPane.showMessageDialog(dodajRadnikaProzor, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		boolean admin = dodajRadnikaProzor.chckbxAdmin.isSelected();
		radnik.setAdmin(admin);

		try {
			Kafic.dodajRadnika(radnik);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(dodajRadnikaProzor, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		JOptionPane.showMessageDialog(dodajRadnikaProzor, "Radnik " + ime + " uspesno dodat!", "Obavestenje",
				JOptionPane.INFORMATION_MESSAGE);
		dodajRadnikaProzor.dispose();
	}

	public static ArrayList listButtonsRadnici(IzlistajRadnikeProzor izlistajRadnikeProzor) {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		LinkedList<Radnik> radnici = Kafic.radnici;

		for (int i = 0; i < radnici.size(); i++) {
			JButton button = new JButton(
					radnici.get(i).getIme() + " " + radnici.get(i).getPrezime() + ", " + radnici.get(i).getUsername());
			button.setBackground(new Color(242, 243, 244));
			button.setActionCommand(radnici.get(i).getUsername());
			button.setPreferredSize(new Dimension(350, 50));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriObrisiRadnikaProzor(button.getActionCommand());
					izlistajRadnikeProzor.dispose();
				}
			});
			buttons.add(button);
		}

		return buttons;
	}

	public static void otvoriObrisiRadnikaProzor(String username) {
		ObrisiRadnikaProzor obrisiRadnikaProzor = new ObrisiRadnikaProzor(username);
		obrisiRadnikaProzor.setVisible(true);
	}

	public static void napuniObrisiProzor(ObrisiRadnikaProzor obrisiRadnikaProzor, Radnik radnik) {
		obrisiRadnikaProzor.textImeRadnika.setText(radnik.getIme());
		obrisiRadnikaProzor.textPrezimeRadnika.setText(radnik.getPrezime());
		obrisiRadnikaProzor.textUsername.setText(radnik.getUsername());
		obrisiRadnikaProzor.textPassword.setText(radnik.getPassword());
	}

	public static void obrisiRadnikaIzListe(ObrisiRadnikaProzor obrisiRadnikaProzor, Radnik radnik) {
		if (obrisiRadnikaProzor.chckbxPotvrda.isSelected()) {
			Kafic.obrisiRadnika(radnik);
			JOptionPane.showMessageDialog(obrisiRadnikaProzor, "Radnik " + radnik.getIme() + " uspesno obrisan!",
					"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			obrisiRadnikaProzor.dispose();
		} else {
			JOptionPane.showMessageDialog(obrisiRadnikaProzor, "Neophodno je potvrditi brisanje", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
