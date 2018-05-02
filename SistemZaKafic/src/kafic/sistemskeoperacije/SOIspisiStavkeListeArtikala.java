package kafic.sistemskeoperacije;

import java.util.LinkedList;

import kafic.Artikal;

/**
 * 
 * Klasa koja izvrsava operaciju ispisivanja svih stavki liste.
 * 
 * @author Nikola Bakic
 *
 */

public class SOIspisiStavkeListeArtikala {

	public static String izvrsi(LinkedList<Artikal> artikli) {
		String stavke = null;
		
		for (int i = 0; i < artikli.size(); i++) {
			Artikal a = artikli.get(i);

			stavke += a.getNazivArtikla() + "\t\t" + a.getCenaArtikla() + "\n";
		}
		
		return stavke;
	}
}
