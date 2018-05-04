package kafic.gui.kontroler;

import java.awt.EventQueue;

import kafic.Kafic;
import kafic.gui.GlavniProzor;

public class GUIKontroler {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
					Kafic.napuniListuRadnika();
					Kafic.napuniListuArtikli();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
