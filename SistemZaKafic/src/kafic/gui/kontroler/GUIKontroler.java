package kafic.gui.kontroler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import kafic.Artikal;
import kafic.Kafic;
import kafic.Racun;
import kafic.Radnik;
import kafic.Sto;
import kafic.gui.AdminProzor;
import kafic.gui.DodajArtikalProzor;
import kafic.gui.DodajRadnikaProzor;
import kafic.gui.GlavniProzor;
import kafic.gui.IzlistajArtikleProzor;
import kafic.gui.IzlistajRadnikeProzor;
import kafic.gui.IzvestajProzor;
import kafic.gui.LogInProzor;
import kafic.gui.ObrisiArtikalProzor;
import kafic.gui.ObrisiRadnikaProzor;
import kafic.gui.RacunProzor;
import kafic.gui.UvodniProzor;
import kafic.sistemskeoperacije.SOVratiUkupanBrojRacuna;
import kafic.sistemskeoperacije.SOVratiUkupanPrihod;

public class GUIKontroler {
	public static Radnik radnik;
	public static UvodniProzor start;

	private static Timer timer = new Timer(2000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			otvoriLoginProzor();
		}
	});

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

		timer.start();
	}

	public static void otvoriLoginProzor() {
		timer.stop();
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

	public static String vratiIzvestaj(String pocetniDan, String pocetniMesec, String pocetnaGodina, String krajnjiDan,
			String krajnjiMesec, String krajnjaGodina) {
		int pocetniD = Integer.parseInt(pocetniDan);
		int pocetniM = Integer.parseInt(pocetniMesec);
		int pocetnaG = Integer.parseInt(pocetnaGodina);

		Date pocetni = new Date(pocetnaG, pocetniM, pocetniD);

		int krajnjiD = Integer.parseInt(krajnjiDan);
		int krajnjiM = Integer.parseInt(krajnjiMesec);
		int krajnjaG = Integer.parseInt(krajnjaGodina);

		Date krajnji = new Date(krajnjaG, krajnjiM, krajnjiD);

		return "Izvestaj za period od " + pocetni.getDate() + "/" + pocetni.getMonth() + "/" + pocetni.getYear()
				+ " do " + krajnji.getDate() + "/" + krajnji.getMonth() + "/" + krajnji.getYear()
				+ "\n\nUkupan prihod za dati period: " + SOVratiUkupanPrihod.izvrsi(pocetni, krajnji, Kafic.racuni)
				+ "\n\nUkupan broj racuna za dati period: "
				+ SOVratiUkupanBrojRacuna.izvrsi(pocetni, krajnji, Kafic.racuni);
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
					radnici.get(i).getIme() + " " + radnici.get(i).getPrezime() + ", " + radnici.get(i).getUsername());// samo
																														// getNaziv
																														// za
																														// artikal
			button.setBackground(new Color(242, 243, 244));
			button.setActionCommand(radnici.get(i).getUsername());
			button.setPreferredSize(new Dimension(400, 50));
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

	public static void napuniObrisiRadnikaProzor(ObrisiRadnikaProzor obrisiRadnikaProzor, Radnik radnik) {
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

	public static void dodajArtikal(DodajArtikalProzor dodajArtikalProzor) {
		Artikal artikal = new Artikal();

		String naziv = dodajArtikalProzor.textField.getText();
		try {
			artikal.setNazivArtikla(naziv);
		} catch (Exception e1) {
			dodajArtikalProzor.textField.setText("");
			JOptionPane.showMessageDialog(dodajArtikalProzor, e1.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		double cena = -1;
		try {
			cena = Double.parseDouble(dodajArtikalProzor.textField_1.getText());
		} catch (Exception e2) {
			dodajArtikalProzor.textField_1.setText("");
			JOptionPane.showMessageDialog(dodajArtikalProzor, "Neispravan unos broja!", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		try {
			artikal.setCenaArtikla(cena);
		} catch (Exception e) {
			dodajArtikalProzor.textField_1.setText("");
			JOptionPane.showMessageDialog(dodajArtikalProzor, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String sifra = dodajArtikalProzor.textField_2.getText();
		try {
			artikal.setSifraArtikla(sifra);
		} catch (Exception e) {
			dodajArtikalProzor.textField_2.setText("");
			JOptionPane.showMessageDialog(dodajArtikalProzor, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String zemljaPorekla = dodajArtikalProzor.textField_3.getText();
		try {
			artikal.setZemljaPoreklaArtikla(zemljaPorekla);
		} catch (Exception e) {
			dodajArtikalProzor.textField_3.setText("");
			JOptionPane.showMessageDialog(dodajArtikalProzor, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try {
			Kafic.dodajArtikal(artikal);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(dodajArtikalProzor, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		JOptionPane.showMessageDialog(dodajArtikalProzor, "Artikal " + naziv + " uspesno dodat!", "Obavestenje",
				JOptionPane.INFORMATION_MESSAGE);
		dodajArtikalProzor.dispose();
	}

	public static ArrayList<JButton> listButtonsArtikli(IzlistajArtikleProzor izlistajArtikleProzor) {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		LinkedList<Artikal> artikli = Kafic.artikli;

		for (int i = 0; i < artikli.size(); i++) {
			JButton button = new JButton(artikli.get(i).getNazivArtikla()); // za
			button.setBackground(new Color(242, 243, 244));
			button.setActionCommand(artikli.get(i).getSifraArtikla());
			button.setPreferredSize(new Dimension(400, 50));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriObrisiArtikalProzor(button.getActionCommand());
					izlistajArtikleProzor.dispose();
				}
			});
			buttons.add(button);
		}
		return buttons;
	}

	protected static void otvoriObrisiArtikalProzor(String actionCommand) {
		ObrisiArtikalProzor obrisiArtikalProzor = new ObrisiArtikalProzor(actionCommand);
		obrisiArtikalProzor.setVisible(true);
	}

	public static void napuniObrisiArtikalProzor(ObrisiArtikalProzor obrisiArtikalProzor, Artikal artikal) {
		obrisiArtikalProzor.textNaziv.setText(artikal.getNazivArtikla());
		obrisiArtikalProzor.textCena.setText("" + artikal.getCenaArtikla());
		obrisiArtikalProzor.textSifra.setText(artikal.getSifraArtikla());
		obrisiArtikalProzor.textZemljaPorekla.setText(artikal.getZemljaPoreklaArtikla());
	}

	public static void obrisiArtikalIzListe(ObrisiArtikalProzor obrisiArtikalProzor, Artikal artikal) {
		if (obrisiArtikalProzor.chckbxPotvrda.isSelected()) {
			Kafic.obrisiArtikal(artikal);
			JOptionPane.showMessageDialog(obrisiArtikalProzor,
					"Artikal " + artikal.getNazivArtikla() + " uspesno obrisan!", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			obrisiArtikalProzor.dispose();
		} else {
			JOptionPane.showMessageDialog(obrisiArtikalProzor, "Neophodno je potvrditi brisanje", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void loginButton(LogInProzor logInProzor) {
		String username = logInProzor.textField.getText();
		String password = logInProzor.passwordField.getText();

		LinkedList<Radnik> radnici = Kafic.radnici;
		Radnik radnik = new Radnik();

		boolean pronadjenRadnik = false;
		for (int i = 0; i < radnici.size(); i++) {
			if (radnici.get(i).getUsername().equals(username)) {
				if (radnici.get(i).getPassword().equals(password)) {
					radnik = radnici.get(i);
					pronadjenRadnik = true;
				}
			}
		}

		if (!pronadjenRadnik) {
			JOptionPane.showMessageDialog(logInProzor.contentPane, "Pogresan username ili lozinka", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			logInProzor.passwordField.setText("");
		}

		if (pronadjenRadnik) {
			GUIKontroler.adminIliRadnikPaDalje(radnik);
			logInProzor.dispose();
		}
	}

	public static void dugmePritisnuto(Sto sto, GlavniProzor glavniProzor) {
		glavniProzor.lblBrojstola.setText("Broj stola: " + sto.getBrojStola());
		glavniProzor.selektovanSto = sto;
	}

	public static void otvoriRacunProzor(Sto sto, Radnik radnik) {
		RacunProzor racunProzor = new RacunProzor(sto, radnik);
		racunProzor.setVisible(true);
	}

	public static ArrayList<JButton> generisiDugmadZaArtikle(RacunProzor racunProzor, Sto sto, Racun racun) {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		LinkedList<Artikal> artikli = Kafic.artikli;

		for (int i = 0; i < artikli.size(); i++) {
			JButton button = new JButton(artikli.get(i).getNazivArtikla()); // za
			button.setBackground(new Color(242, 243, 244));
			button.setActionCommand(artikli.get(i).getSifraArtikla());
			button.setPreferredSize(new Dimension(120, 30));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.dodajArtikalUTextArea(button.getActionCommand(), racunProzor, sto, racun);

				}
			});
			buttons.add(button);
		}
		return buttons;
	}

	protected static void dodajArtikalUTextArea(String actionCommand, RacunProzor racunProzor, Sto sto, Racun racun) {
		LinkedList<Artikal> artikli = Kafic.artikli;
		Artikal artikal = new Artikal();
		
		for (int i = 0; i < artikli.size(); i++) {
			if (artikli.get(i).getSifraArtikla().equals(actionCommand)) {
				artikal = artikli.get(i);
			}
		}
		
		LinkedList<Artikal> artikliNaRacunu = racun.getStavkeRacuna();
		artikliNaRacunu.add(artikal);
		racun.setStavkeRacuna(artikliNaRacunu);
		
		racunProzor.textArea.append(artikal.getNazivArtikla() + "\n");
	}

}
