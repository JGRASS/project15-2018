package kafic.sistemskeoperacije;

import java.io.FileReader;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kafic.Artikal;
import kafic.Radnik;

public class SONapuniListuArtikli {
	
	public static void izvrsi(LinkedList<Artikal> artikli) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonArray jsonNiz = new JsonArray();

		try (FileReader input = new FileReader("podaci/artikli.json")) {
			jsonNiz = gson.fromJson(input, JsonArray.class);
		} catch (Exception e) {
			System.err.println("Greska, " + e.getMessage());
		}

		for (int i = 0; i < jsonNiz.size(); i++) {
			JsonObject jsonObject = (JsonObject) jsonNiz.get(i);

			Artikal artikal = new Artikal();

			try {
				artikal.setNazivArtikla(jsonObject.get("naziv").getAsString());
				artikal.setCenaArtikla(jsonObject.get("cena").getAsInt());
				artikal.setSifraArtikla(jsonObject.get("sifra").getAsString());
				artikal.setZemljaPoreklaArtikla(jsonObject.get("zemljaPorekla").getAsString());
			} catch (Exception e) {
				System.err.println("Greska, " + e.getMessage());
			}

			artikli.add(artikal);
		}
	}

}
