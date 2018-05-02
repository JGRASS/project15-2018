package kafic.sistemskeoperacije;

import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kafic.Artikal;
import kafic.Radnik;

public class SOAzurirajArtikliJson {
	public static void izvrsi(LinkedList<Artikal> artikli) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonArray jsonNiz = new JsonArray();

		for (int i = 0; i < artikli.size(); i++) {
			Artikal artikal = artikli.get(i);

			JsonObject jsonArtikal = new JsonObject();
			jsonArtikal.addProperty("sifra", artikal.getSifraArtikla());
			jsonArtikal.addProperty("naziv", artikal.getNazivArtikla());
			jsonArtikal.addProperty("cena", artikal.getCenaArtikla());
			jsonArtikal.addProperty("zemljaPorekla", artikal.getZemljaPoreklaArtikla());

			jsonNiz.add(jsonArtikal);
		}

		try (FileWriter output = new FileWriter("podaci/artikli.json")) {
			output.write(gson.toJson(jsonNiz));
		} catch (Exception e) {
			System.err.println("Greska, " + e.getMessage());
		}
	}

}
