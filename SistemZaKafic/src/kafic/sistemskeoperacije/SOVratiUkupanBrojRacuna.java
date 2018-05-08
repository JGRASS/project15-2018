package kafic.sistemskeoperacije;

import java.util.Date;
import java.util.LinkedList;

import kafic.Racun;

public class SOVratiUkupanBrojRacuna {

	public static int izvrsi(Date pocetni, Date krajnji, LinkedList<Racun> racuni) {
		int ukupnoRacuna = 0;

		for (int i = 0; i < racuni.size(); i++) {
			Racun r = racuni.get(i);
			if (r.getDatum().after(pocetni) && r.getDatum().before(krajnji)) {
				ukupnoRacuna += 1;
			}
		}

		return ukupnoRacuna;
	}
}
