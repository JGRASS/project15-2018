package kafic;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import kafic.sistemskeoperacije.SOIspisiStavkeListeArtikala;

/**
 * 
 * Klasa koja predstavlja racun za narucene proizvode u kaficu.
 * 
 * @author Nikola Bakic
 *
 */

public class Racun {
	/**
	 * String koji predstavlja naziv kafica.
	 */
	private final String nazivLokala = "Paradiso Cafe";
	/**
	 * Atribut koji predstavlja datum i vreme na koje se racun izdaje.
	 */
	private GregorianCalendar datum;
	/**
	 * Lista artikala koje je gost narucio.
	 */
	private LinkedList<Artikal> stavkeRacuna = new LinkedList<Artikal>();
	/**
	 * Objekat koji prestavlja radnika koji usluzuje odredjeni sto.
	 */
	private Radnik radnik;
	/**
	 * Integer koji predstavlja broj stola koji se opsluzuje.
	 */
	private int brojStola;
	/**
	 * Integer koji predstavlja potroseni iznos za odredjeni sto.
	 */
	private int zaUplatu;
	/**
	 * Integer koji prestavlja iznos koji gost uplatio.
	 */
	private int jeUplaceno;
	/**
	 * Integer koji predstavlja kusur.
	 */
	private int kusur;
	/**
	 * String koji predstavlja sifru racuna.
	 */
	private String sifraRacuna;
	
	public Racun() {
		// TODO: POSTAVITI SIFRU RACUNA KADA SE RACUN KREIRA
	}

	/**
	 * 
	 * Metoda koja vraca naziv lokala.
	 * 
	 * @return nazivLokala
	 */
	public String getNazivLokala() {
		return nazivLokala;
	}

	/**
	 * 
	 * Metoda koja vraca vreme na koje se racun izdaje.
	 * 
	 * @return datum
	 */
	public GregorianCalendar getDatum() {
		return datum;
	}

	/**
	 *
	 * Metoda kojom se postavlja datum racuna.
	 * 
	 * @param datum
	 *            Predstavlja datum racuna.
	 * 
	 * @throws Exception
	 *             Ako je:
	 *             <ul>
	 *             <li>Unet datum koji se odnosi na proslost</li>
	 *             </ul>
	 * 
	 */
	public void setDatum(GregorianCalendar datum) throws Exception {
		if (datum.before(new GregorianCalendar())) {
			throw new Exception("Racun ne moze biti izdat za prethodni period!");
		}

		this.datum = datum;
	}

	/**
	 * 
	 * Metoda koja vraca listu svih narucenih artikala.
	 * 
	 * @return stavkeRacuna
	 */
	public LinkedList<Artikal> getStavkeRacuna() {
		return stavkeRacuna;
	}

	/**
	 * 
	 * Metoda koja vraca radnika koji izdaje racun.
	 * 
	 * @return radnik
	 */
	public Radnik getRadnik() {
		return radnik;
	}

	/**
	 * 
	 * Metoda koja postavlja radnika za odredjeni sto.
	 * 
	 * @param radnik
	 */
	public void setRadnik(Radnik radnik) {
		// TODO : Uraditi proveru za unos radnika
		this.radnik = radnik;
	}

	/**
	 * 
	 * Metoda koja vraca broj stola.
	 * 
	 * @return brojStola
	 */
	public int getBrojStola() {
		return brojStola;
	}

	/**
	 * 
	 * Metoda koje postavlja broj stola na koji se racun odnosi.
	 * 
	 * @param brojStola
	 *            Predstavlja broj stola.
	 * 
	 * @throws Exception
	 *             Ako je:
	 *             <ul>
	 *             <li>Broj stola veci od 8 ili manji od 1.</li>
	 *             </ul>
	 */
	public void setBrojStola(int brojStola) throws Exception {
		if (brojStola > 8 || brojStola <= 0)
			throw new Exception("Broj stola je van granica!");

		this.brojStola = brojStola;
	}

	/**
	 * 
	 * Metoda koja vraca iznos koji je potrosen za odredjeni sto.
	 * 
	 * @return zaUplatu
	 */
	public int getZaUplatu() {
		return zaUplatu;
	}

	/**
	 * 
	 * Metoda koja postavlja iznos koji je potrosen za odredjeni sto.
	 * 
	 * @param zaUplatu
	 *            Predstavlja potroseni iznos.
	 * 
	 * @throws Exception
	 *             Ako je:
	 *             <ul>
	 *             <li>Iznos za uplatu manji od 0.</li>
	 *             </ul>
	 */
	public void setZaUplatu(int zaUplatu) throws Exception {
		if (zaUplatu < 0)
			throw new Exception("Iznos ne moze biti negativan!");

		this.zaUplatu = zaUplatu;
	}

	/**
	 * 
	 * Metoda koja vraca iznos koji je uplacen za odredjeni sto.
	 * 
	 * @return jeUplaceno
	 */
	public int getJeUplaceno() {
		return jeUplaceno;
	}

	/**
	 * 
	 * Metoda koja postavlja iznos koji je uplacen za odredjeni sto.
	 * 
	 * @param jeUplaceno
	 *            Predstavlja uplacen iznos.
	 * 
	 * @throws Exception
	 *             Ako je:
	 *             <ul>
	 *             <li>Uplaceni iznos manji od 0.</li>
	 *             <li>Uplaceni iznos manji od potrosenog iznosa.</li>
	 *             </ul>
	 */
	public void setJeUplaceno(int jeUplaceno) throws Exception {
		if (jeUplaceno < 0)
			throw new Exception("Iznos ne moze biti negativan!");
		if (jeUplaceno < zaUplatu)
			throw new Exception("Ne moze biti uplaceno manje od potrosenog iznosa!");

		this.jeUplaceno = jeUplaceno;
	}

	/**
	 * 
	 * Metoda koja vraca kusur za odredjeni sto.
	 * 
	 * @return kusur
	 */
	public int getKusur() {
		return kusur;
	}
	
	public void kalkulisiKusur() {
		this.kusur = this.jeUplaceno - this.zaUplatu;
	}

	/**
	 * 
	 * Metoda koja vraca sifru racuna.
	 * 
	 * @return sifraRacuna
	 */
	public String getSifraRacuna() {
		return sifraRacuna;
	}

	/**
	 * 
	 * Metoda vraca string koji predstavlja racun, primer: 
	 * Datum: 30.04.2018. 14:28 
	 * Broj stola: 5 
	 * Sifra racuna: 578941
	 * Radnik: Marko Markovic
	 * Stavke racuna:
	 * Coca-Cola 130 Domaca kafa 100
	 * Za uplatu: 230 
	 * Uplaceno je: 300
	 * 
	 * @return String koji prestavlja racun
	 */
	@Override
	public String toString() {
		return "Datum: " + datum + "\nBroj stola: " + brojStola + "\nSifra racuna: "
				+ sifraRacuna + "\nRadnik: " + radnik.getIme() + " " + radnik.getPrezime() + "\nStavke racuna:\n"
				+ SOIspisiStavkeListeArtikala.izvrsi(stavkeRacuna) + "\nZa uplatu: " + zaUplatu + "\nUplaceno je: "
				+ jeUplaceno + "\nZa povracaj: " + kusur;
	}

	/**
	 * Proverava da li su dva racuna ista, tj. da li su im sifre iste
	 *
	 * @param obj
	 *            Referentni objekat za poredjenje
	 *
	 * @return
	 *         <ul>
	 *         <li><b>true</b> ako su racuni isti, tj. imaju iste sifre</li>
	 *         <li><b>false</b> ako su racuni razliciti, tj. nemaju iste
	 *         sifre</li>
	 *         </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Racun other = (Racun) obj;
		if (sifraRacuna == null) {
			if (other.sifraRacuna != null)
				return false;
		} else if (!sifraRacuna.equals(other.sifraRacuna))
			return false;
		return true;
	}
}
