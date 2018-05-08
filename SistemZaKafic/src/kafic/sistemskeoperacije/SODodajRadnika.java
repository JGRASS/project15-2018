package kafic.sistemskeoperacije;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kafic.Kafic;
import kafic.Radnik;

/**
 * Klasa koja sadrzi operaciju dodavanja radnika u listu radnici i koja azurira
 * radnici.json fajl u folderu podaci
 * 
 * @author nikvujic
 *
 */
public class SODodajRadnika {
	/**
	 * Dodaje radnika u listu radnici i azurira radnici.json fajl u folderu podaci, i vrsi proveriu da li taj radnik vec u listi
	 * 
	 * @param radnik
	 *            predstavlja objekat radnika koji se treba dodati
	 * @param radnici
	 *            predstavlja listu u koju se treba dodati
	 * @throws Exception ukoliko je radnik vec u listi
	 */
	public static void izvrsi(Radnik radnik, LinkedList<Radnik> radnici) throws Exception {
		for (int i = 0; i < radnici.size(); i++) {
			if (radnici.get(i).equals(radnik))
				throw new Exception("Username vec postoji");
		}
		radnici.add(radnik);
		
		Kafic.azurirajRadniciJson();
	}

}
