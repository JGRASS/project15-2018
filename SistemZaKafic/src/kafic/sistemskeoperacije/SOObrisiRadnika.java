package kafic.sistemskeoperacije;

import java.util.LinkedList;

import kafic.Kafic;
import kafic.Radnik;

public class SOObrisiRadnika {

	/**
	 * Brise radnika i iz liste i iz baze
	 * 
	 * @param radnik
	 * @param radnici 
	 */
	public static void izvrsi(Radnik radnik, LinkedList<Radnik> radnici) {
		for (int i = 0; i < radnici.size(); i++) {
			if (radnici.get(i).getUsername().equals(radnik.getUsername())) {
				radnici.remove(radnici.get(i));
				break;
			}
		}
		
		Kafic.azurirajRadniciJson();
	}

}
