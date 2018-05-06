package kafic.gui.kontroler;

import java.awt.EventQueue;

import kafic.Kafic;
import kafic.Radnik;
import kafic.gui.GlavniProzor;
import kafic.gui.LogInProzor;
import kafic.gui.UvodniProzor;

public class GUIKontroler {
	public static Radnik radnik;
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
		UvodniProzor start = new UvodniProzor();
		start.setVisible(true);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Greska, " + e.getMessage());
		}
		
		LogInProzor login = new LogInProzor();
		login.setVisible(true);
	}

	public static void adminIliRadnikPaDalje(Radnik noviRadnik) {
		radnik = noviRadnik;
		
		if (radnik.isAdmin()) {
			// TODO: otvori admin prozor
		} else {
			
			GlavniProzor glavniProzor = new GlavniProzor(radnik);
			glavniProzor.setVisible(true);
			
		}		
	}
}
