package kafic.sistemskeoperacije;

import java.util.LinkedList;

import kafic.Artikal;
import kafic.Kafic;

public class SODodajArtikal {
	/**
	 * Dodaje artikal u listu artikli i azurira aritkli.json fajl u folderu podaci,
	 * i vrsi proveru da li taj artikal vec u listi
	 * 
	 * @param artikal
	 *            predstavlja objekat artikal koji se treba dodati u listu
	 * @param artikli
	 *            predstavlja listu u koju se treba dodati artikal
	 * @throws Exception
	 *             ukoliko je artikal vec u listi
	 */
	public static void izvrsi(LinkedList<Artikal> artikli, Artikal artikal) throws Exception {
		for (int i = 0; i < artikli.size(); i++) {
			if (artikli.get(i).equals(artikal))
				throw new Exception("radnik je vec u listi");
		}
		artikli.add(artikal);
		
		Kafic.azurirajArtikliJson();
	}

}
