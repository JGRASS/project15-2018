package kafic.sistemskeoperacije;

import java.util.LinkedList;

import kafic.Kafic;
import kafic.Racun;

/**
 * Metoda koja se koristi za dodavanje novog racuna u listu racuni
 * 
 */
public class SODodajRacun {

	public static void izvrsi(LinkedList<Racun> racuni, Racun racun) throws Exception {
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).equals(racun))
				throw new Exception("Racun je vec u listi");
		}
		racuni.add(racun);
		
		Kafic.azurirajArtikliJson();		
	}

}
