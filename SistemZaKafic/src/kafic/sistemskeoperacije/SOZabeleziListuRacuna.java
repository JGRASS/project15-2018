package kafic.sistemskeoperacije;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

import kafic.Racun;
import kafic.gui.IzvestajGUI;

public class SOZabeleziListuRacuna {

	public static void main(String[] args) {
		
	}	
	
	public static void izvrsi(LinkedList<Racun> racuni) throws Exception {
		String lokacija = "podaci/izvestaji";

		Date datum = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");

		Random rand = new Random();

		String naziv = "izv_" + racuni.get(0).getRadnik().getUsername() + "_" + sdf.format(datum) + "_" + rand.nextInt(999)
				+ 1;

		try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(lokacija + "/" + naziv)));) {
			output.print(IzvestajGUI.ceoIzvestaj);
		} catch (IOException e) {
			throw new Exception("Greska, " + e.getMessage());
		}

		racuni.clear();
	}

}
