package kafic;

import java.util.LinkedList;

import kafic.sistemskeoperacije.SOAzurirajArtikliJson;
import kafic.sistemskeoperacije.SOAzurirajRadniciJson;
import kafic.sistemskeoperacije.SODodajArtikal;
import kafic.sistemskeoperacije.SODodajRacun;
import kafic.sistemskeoperacije.SODodajRadnika;
import kafic.sistemskeoperacije.SONapuniListuArtikli;
import kafic.sistemskeoperacije.SONapuniListuRadnika;
import kafic.sistemskeoperacije.SOObrisiArtikal;
import kafic.sistemskeoperacije.SOObrisiRadnika;
import kafic.sistemskeoperacije.SOSadrziSamoSlova;
import kafic.sistemskeoperacije.SOZabeleziListuRacuna;

/**
 * Klasa radnik predstavlja klasu sa statickim metodama koje pozivaju sistemske
 * operacije
 * 
 * @author Nikola Vujic
 * @author Uros Veljkovic
 * @version 0.0.1
 * 
 */
public class Kafic {
	/**
	 * Lista koje se pri pokretanju programa puni radnicima iz foldera podaci
	 */
	public static LinkedList<Radnik> radnici = new LinkedList<Radnik>();

	/**
	 * Lista koja se pri pokretanju programa puni artiklima iz foldera podaci
	 */
	public static LinkedList<Artikal> artikli = new LinkedList<Artikal>();
	
	/**
	 * Lista koja sadzi sve transakcije u vidu racuna
	 */
	public static LinkedList<Racun> racuni = new LinkedList<Racun>();
	
	/**
	 * Brise radnika i iz liste i iz baze
	 * 
	 * @param radnik
	 */
	public static void obrisiRadnika(Radnik radnik) {
		SOObrisiRadnika.izvrsi(radnik, radnici);
	}

	/**
	 * Metoda koja se koristi za dodavanje novog radnika u listu radnika i json fajl
	 * u folderu podaci
	 * 
	 * @param radnik
	 *            predstavlja objekat klase Radnik
	 * @throws Exception
	 *             ukoliko je radnik vec u listi
	 */
	public static void dodajRadnika(Radnik radnik) throws Exception {
		SODodajRadnika.izvrsi(radnik, radnici);
	}

	/**
	 * Metoda koja se koristi za dodavanje novog artikla u listu artikla i json fajl
	 * u folderu podaci
	 * 
	 * @param artikal
	 *            predstavlja objekat klase Artikal
	 * @throws Exception
	 *             ukoliko je artikal vec u listi
	 */
	public static void dodajArtikal(Artikal artikal) throws Exception {
		SODodajArtikal.izvrsi(artikli, artikal);
	}

	/**
	 * Metoda koja bi trebalo da se <b>pokrece na pocetku programa</b>, koja puni
	 * listu radnici sa radnicima iz fajl radnici.json u podaci folderu
	 */
	public static void napuniListuRadnika() {
		SONapuniListuRadnika.izvrsi(radnici);
	}

	/**
	 * Metoda koja bi trebalo da se <b>pokrece na pocetku programa</b>, koja puni
	 * listu artikli sa artiklima iz fajla artikli.json u podaci folderu
	 */
	public static void napuniListuArtikli() {
		SONapuniListuArtikli.izvrsi(artikli);
	}
	
	/**
	 * Metoda koja se koristi za dodavanje novog racuna u listu racuni
	 * 
	 * @param racun
	 * @throws Exception
	 */
	public static void dodajRacun(Racun racun) throws Exception {
		SODodajRacun.izvrsi(racuni, racun);
	}
	
	/**
	 * Metoda koja upisuje izvestaj u podaci/izvestaji
	 * @throws Exception 
	 */
	public static void zabeleziListuRacuna() throws Exception {
		SOZabeleziListuRacuna.izvrsi(racuni);
	}

	/**
	 * Metoda koja azurira radnici.json fajl u folderu podaci u odnosu na listu
	 * radnici
	 */
	public static void azurirajRadniciJson() {
		SOAzurirajRadniciJson.izvrsi(radnici);
	}

	/**
	 * Metoda koja azurira artikli.json fajl u folderu podaci u odnosu na listu
	 * artikli
	 */
	public static void azurirajArtikliJson() {
		SOAzurirajArtikliJson.izvrsi(artikli);
	}

	/**
	 * poziva sistemsku operaciju koja vraca true ako je unet String sastavljen samo
	 * od slova, a false ako nije
	 * 
	 * @param naziv
	 *            predstavlja naziv String-a koji se evaluira
	 * @return
	 *         <ul>
	 *         <li><b>true</b> ako string sadrzi samo slova</li>
	 *         <li><b>false</b> ako string ne sadrzi samo slova</li>
	 *         </ul>
	 */
	public static boolean sadrziSamoSlova(String naziv) {
		return SOSadrziSamoSlova.izvrsi(naziv);
	}

	public static void obrisiArtikal(Artikal artikal) {
		SOObrisiArtikal.izvrsi(artikal, artikli);
		
	}
}
