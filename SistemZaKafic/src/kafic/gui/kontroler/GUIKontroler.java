package kafic.gui.kontroler;

import java.awt.EventQueue;
import java.sql.Date;

import javax.swing.JPanel;

import kafic.Kafic;
import kafic.Radnik;
import kafic.gui.AdminProzor;
import kafic.gui.GlavniProzor;
import kafic.gui.IzvestajProzor;
import kafic.gui.LogInProzor;
import kafic.gui.UvodniProzor;
import kafic.sistemskeoperacije.SOVratiUkupanBrojRacuna;
import kafic.sistemskeoperacije.SOVratiUkupanPrihod;

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
	
	public static String vratiIzvestaj(String pocetniDan, String pocetniMesec, String pocetnaGodina,
			String krajnjiDan, String krajnjiMesec, String krajnjaGodina) {
		int pocetniD = Integer.parseInt(pocetniDan);
		int pocetniM = Integer.parseInt(pocetniMesec);
		int pocetnaG = Integer.parseInt(pocetnaGodina);

		Date pocetni = new Date(pocetnaG, pocetniM, pocetniD);

		int krajnjiD = Integer.parseInt(krajnjiDan);
		int krajnjiM = Integer.parseInt(krajnjiMesec);
		int krajnjaG = Integer.parseInt(krajnjaGodina);

		Date krajnji = new Date(krajnjaG, krajnjiM, krajnjiD);

		return "Izvestaj za period od " + pocetni.getDate() + "/" + pocetni.getMonth() + "/"
				+ pocetni.getYear() + " do " + krajnji.getDate() + "/" + krajnji.getMonth() + "/"
				+ krajnji.getYear() + "\n\nUkupan prihod za dati period: "
				+ SOVratiUkupanPrihod.izvrsi(pocetni, krajnji, Kafic.racuni)
				+ "\n\nUkupan broj racuna za dati period: "
				+ SOVratiUkupanBrojRacuna.izvrsi(pocetni, krajnji, Kafic.racuni);
	}
}
