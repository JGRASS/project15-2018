package kafic.sistemskeoperacije;

import java.util.Date;
import java.util.LinkedList;

import kafic.Racun;

public class SOVratiUkupanPrihod {

	public static double izvrsi(Date pocetni, Date krajnji, LinkedList<Racun> racuni) {
		double ukupanIznos = 0;

		for (int i = 0; i < racuni.size(); i++) {
			Racun r = racuni.get(i);
			if (r.getDatum().after(pocetni) && r.getDatum().before(krajnji)) {
				ukupanIznos += r.getZaUplatu();
			}
		}

		return ukupanIznos;
	}
}
