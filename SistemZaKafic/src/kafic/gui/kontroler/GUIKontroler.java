package kafic.gui.kontroler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

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
import kafic.gui.IzvestajGUI;
import kafic.gui.LogInProzor;
import kafic.gui.ObrisiArtikalProzor;
import kafic.gui.ObrisiRadnikaProzor;
import kafic.gui.RacunManagementProzor;
import kafic.gui.RacunProzor;
import kafic.gui.UvodniProzor;

public class GUIKontroler {
	public static Radnik radnik;
	public static UvodniProzor start;
	public static int panelRacuniHeight = 0;
	public static JButton prethodnoDugme = new JButton();

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

	public static void dugmePritisnuto(Sto sto, GlavniProzor glavniProzor, Racun racun, Radnik radnik, JButton dugme) {
		if (dugme != null) {
			prethodnoDugme.setBackground(new Color(237, 187, 153));
			prethodnoDugme.setBorder(null);
			dugme.setBorder(new LineBorder(new Color(84, 153, 199), 2));
			dugme.setBackground(new Color(127, 179, 213));
			prethodnoDugme = dugme;
		}

		glavniProzor.lblBrojstola.setText("Selektovani sto: " + sto.getBrojStola());
		glavniProzor.selektovanSto = sto;

		if (racun == null)
			return;

		if (sto.getRacuniNaStolu().size() == 0)
			return;

		String tekstDugmeta = "";
		tekstDugmeta += "Sto " + sto.getBrojStola() + ":";

		for (int i = 0; i < racun.getStavkeRacuna().size(); i++) {
			if (i == 0)
				tekstDugmeta += " " + racun.getStavkeRacuna().get(i).getNazivArtikla();
			else
				tekstDugmeta += ", " + racun.getStavkeRacuna().get(i).getNazivArtikla();
		}

		JButton button = new JButton(tekstDugmeta);
		if (racun.getKusur() == -1)
			button.setBackground(new Color(241, 148, 138));
		else
			button.setBackground(new Color(130, 224, 170));
		button.setPreferredSize(new Dimension(350, 50));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button.getText().startsWith("Sto"))
					GUIKontroler.otvoriRacunManagementProzor(glavniProzor, sto, racun, button, radnik);
			}
		});
		panelRacuniHeight += 55;
		glavniProzor.panelZaRacune.setPreferredSize(new Dimension(180, panelRacuniHeight));
		glavniProzor.panelZaRacune.add(button);
		glavniProzor.panelZaRacune.validate();
	}

	protected static void otvoriRacunManagementProzor(GlavniProzor glavniProzor, Sto sto, Racun racun, JButton button,
			Radnik radnik) {
		RacunManagementProzor rmp = new RacunManagementProzor(glavniProzor, sto, racun, button, radnik);
		rmp.setVisible(true);
	}

	public static void otvoriRacunProzor(Sto sto, Radnik radnik, GlavniProzor glavniProzor) {
		RacunProzor racunProzor = new RacunProzor(sto, radnik, glavniProzor);
		racunProzor.setVisible(true);
	}

	public static ArrayList<JButton> generisiDugmadZaArtikle(RacunProzor racunProzor, Sto sto, Racun racun) {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		LinkedList<Artikal> artikli = Kafic.artikli;

		for (int i = 0; i < artikli.size(); i++) {
			JButton button = new JButton(artikli.get(i).getNazivArtikla());
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

	public static void dodajArtikleUProzor(RacunManagementProzor rmp, Racun racun) {
		for (int i = 0; i < racun.getStavkeRacuna().size(); i++) {
			rmp.textArea.append(racun.getStavkeRacuna().get(i).getNazivArtikla() + " = "
					+ racun.getStavkeRacuna().get(i).getCenaArtikla() + "\n");
		}

	}

	public static void setOsnovnePodatkeRacun(RacunManagementProzor rmp, Racun racun, GlavniProzor gp) {

		try {
			racun.updateZaUplatu();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rmp.contentPane, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
		}

		String datum = "";

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");

		datum = sdf.format(racun.getDatum());

		rmp.lblDatum.setText(datum);
		rmp.lblRadnik.setText("Radnik: " + racun.getRadnik().getIme() + " " + racun.getRadnik().getPrezime());
		rmp.lblBrojStola.setText("Broj stola: " + racun.getBrojStola());
		rmp.lblZaUplatu.setText("Za uplatu: " + racun.getZaUplatu());
	}

	public static void obracunajUplatu(RacunManagementProzor rmp, Racun racun) {
		double uplata = 0;
		try {

			uplata = Double.parseDouble(rmp.txtUplata.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rmp.contentPane, "Morate uneti ispravan broj!", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			rmp.txtUplata.setText("");
			return;
		}

		try {
			racun.setJeUplaceno(uplata);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rmp.contentPane, e.getMessage(), "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		rmp.lblKusur.setText("Kusur: " + racun.getKusur());
		rmp.validan = true;
	}

	public static void potvrdiKrajRacuna(RacunManagementProzor rmp, JButton pritisnutoDugme) {
		if (rmp.validan) {
			pritisnutoDugme.setBackground(new Color(88, 214, 141));
			pritisnutoDugme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pritisnutoDugme.setText("Racun obradjen :)");
				}
			});
			rmp.dispose();
		} else {
			JOptionPane.showMessageDialog(rmp.contentPane, "Morate uneti placenu vrednost", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void izvuciSveRacune(Sto sto1, Sto sto2, Sto sto3, Sto sto4, Sto sto5, Sto sto6, Sto sto7, Sto sto8, IzvestajGUI izvestaj) {
		LinkedList<Racun> racuniSto1 = sto1.getRacuniNaStolu();
		LinkedList<Racun> racuniSto2 = sto2.getRacuniNaStolu();
		LinkedList<Racun> racuniSto3 = sto3.getRacuniNaStolu();
		LinkedList<Racun> racuniSto4 = sto4.getRacuniNaStolu();
		LinkedList<Racun> racuniSto5 = sto5.getRacuniNaStolu();
		LinkedList<Racun> racuniSto6 = sto6.getRacuniNaStolu();
		LinkedList<Racun> racuniSto7 = sto7.getRacuniNaStolu();
		LinkedList<Racun> racuniSto8 = sto8.getRacuniNaStolu();

		for (int i = 0; i < racuniSto1.size(); i++) {
			try {
				Kafic.dodajRacun(racuniSto1.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < racuniSto2.size(); i++) {
			try {
				Kafic.dodajRacun(racuniSto2.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < racuniSto3.size(); i++) {
			try {
				Kafic.dodajRacun(racuniSto3.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < racuniSto4.size(); i++) {
			try {
				Kafic.dodajRacun(racuniSto4.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < racuniSto5.size(); i++) {
			try {
				Kafic.dodajRacun(racuniSto5.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < racuniSto6.size(); i++) {
			try {
				Kafic.dodajRacun(racuniSto6.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < racuniSto7.size(); i++) {
			try {
				Kafic.dodajRacun(racuniSto7.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < racuniSto8.size(); i++) {
			try {
				Kafic.dodajRacun(racuniSto1.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String izvestajString = "";
		
	}
}