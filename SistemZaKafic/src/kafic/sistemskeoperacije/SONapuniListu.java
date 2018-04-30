package kafic.sistemskeoperacije;

import java.io.FileReader;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kafic.Radnik;

public class SONapuniListu {

	public static void izvrsi(LinkedList<Radnik> radnici) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonArray jsonNiz = new JsonArray();

		try (FileReader input = new FileReader("podaci/radnici.json")) {
			jsonNiz = gson.fromJson(input, JsonArray.class);
		} catch (Exception e) {
			System.err.println("Greska, " + e.getMessage());
		}

		for (int i = 0; i < jsonNiz.size(); i++) {
			JsonObject jsonObject = (JsonObject) jsonNiz.get(i);

			Radnik radnik = new Radnik();

			try {
				radnik.setIme(jsonObject.get("ime").getAsString());
				radnik.setPrezime(jsonObject.get("prezime").getAsString());
				radnik.setUsername(jsonObject.get("username").getAsString());
				radnik.setPassword(jsonObject.get("password").getAsString());
				radnik.setAdmin(jsonObject.get("admin").getAsBoolean());
			} catch (Exception e) {
				System.err.println("Greska, " + e.getMessage());
			}

			radnici.add(radnik);
		}
	}

}
