package kafic.sistemskeoperacije;

import java.util.LinkedList;

import kafic.Artikal;
import kafic.Kafic;

/**
 * Klasa koja brise artikal
 * 
 * @author nikvujic
 *
 */
public class SOObrisiArtikal {

	public static void izvrsi(Artikal artikal, LinkedList<Artikal> artikli) {
		for (int i = 0; i < artikli.size(); i++) {
			if (artikli.get(i).getSifraArtikla().equals(artikal.getSifraArtikla())) {
				artikli.remove(artikli.get(i));
				break;
			}
		}
		
		Kafic.azurirajArtikliJson();
	}

}
