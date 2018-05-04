package kafic;

import java.util.LinkedList;

import kafic.sistemskeoperacije.SOAzurirajArtikliJson;
import kafic.sistemskeoperacije.SOAzurirajRadniciJson;
import kafic.sistemskeoperacije.SODaLiJeUListiRadnik;
import kafic.sistemskeoperacije.SODodajArtikal;
import kafic.sistemskeoperacije.SODodajRadnika;
import kafic.sistemskeoperacije.SONapuniListuArtikli;
import kafic.sistemskeoperacije.SONapuniListuRadnika;
import kafic.sistemskeoperacije.SOSadrziSamoSlova;

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
	 * Proverava da li je radnik u listi na osnovu naziva naloga
	 * 
	 * @param username
	 *            naziv naloga
	 * @return
	 *         <ul>
	 *         <li><b>True</b ako jeste u listi></li>
	 *         <li><b>False</b> ako nije u listi</li>
	 *         </ul>
	 */
	public static boolean daLiJeUListiRadnik(String username) {
		napuniListuRadnika();
		return SODaLiJeUListiRadnik.izvrsi(username, radnici);
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
}
