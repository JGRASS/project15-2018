package kafic.gui.kontroler;

import java.awt.EventQueue;

import javax.swing.JPanel;

import kafic.Kafic;
import kafic.Radnik;
import kafic.gui.AdminProzor;
import kafic.gui.GlavniProzor;
import kafic.gui.IzvestajProzor;
import kafic.gui.LogInProzor;
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
	
	public static void prikaziIzvestajProzor(JPanel contentPane) {
		IzvestajProzor prozor = new IzvestajProzor();
		prozor.setLocationRelativeTo(contentPane);
		prozor.setVisible(true);
	}
}
