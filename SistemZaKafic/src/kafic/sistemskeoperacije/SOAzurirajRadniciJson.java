package kafic.sistemskeoperacije;

import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kafic.Radnik;

/**
 * Klasa koja sadrzi operaciju kojom se radnici iz liste radnika serijalizuju u
 * podaci/radnici.json fajl
 * 
 * @author nikvujic
 *
 */
public class SOAzurirajRadniciJson {

	/**
	 * 
	 * @param radnici
	 */
	public static void izvrsi(LinkedList<Radnik> radnici) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonArray jsonNiz = new JsonArray();

		for (int i = 0; i < radnici.size(); i++) {
			Radnik radnik = radnici.get(i);

			JsonObject jsonRadnik = new JsonObject();
			jsonRadnik.addProperty("ime", radnik.getIme());
			jsonRadnik.addProperty("prezime", radnik.getPrezime());
			jsonRadnik.addProperty("username", radnik.getUsername());
			jsonRadnik.addProperty("password", radnik.getPassword());
			jsonRadnik.addProperty("admin", radnik.isAdmin());

			jsonNiz.add(jsonRadnik);
		}

		try (FileWriter output = new FileWriter("podaci/radnici.json")) {
			output.write(gson.toJson(jsonNiz));
		} catch (Exception e) {
			System.err.println("Greska, " + e.getMessage());
		}
	}

}
