package kafic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * 
 * Klasa koja predstavlja racun za narucene proizvode u kaficu.
 * 
 * @author Nikola Bakic; Nikola Vujic
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
	private Date datum;
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
	 * Integer koji predstavlja potroseni iznos za odredjeni sto, tj. cenu svih
	 * artikala
	 */
	private double zaUplatu;
	/**
	 * Integer koji prestavlja iznos koji gost uplatio.
	 */
	private double jeUplaceno;
	/**
	 * Integer koji predstavlja kusur.
	 */
	private double kusur = -1;
	/**
	 * String koji predstavlja sifru racuna.
	 */
	private String sifraRacuna;

	public Racun() {
		Date datum = new Date();
		try {
			setDatum(datum);
		} catch (Exception e) {
			System.out.println("neocekivana greska: " + e.getMessage());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("YYMMddHHmmssSSS");
		sifraRacuna = "PC" + sdf.format(datum);
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
	public Date getDatum() {
		return datum;
	}

	/**
	 *
	 * Metoda kojom se postavlja datum racuna. Napomena: Datum se automatski
	 * generise u konstruktoru
	 * 
	 */
	public void setDatum(Date datum) throws Exception {
		if (datum.before(new Date())) {
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
	 * seter za stavke racuna, prima vec postojecu listu racuna svako dodavanje
	 * artikla se vrsi van klase
	 * 
	 * @param stavkeRacuna
	 */
	public void setStavkeRacuna(LinkedList<Artikal> stavkeRacuna) {
		this.stavkeRacuna = stavkeRacuna;
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
	public double getZaUplatu() {
		return zaUplatu;
	}

	/**
	 * 
	 * Metoda koja postavlja iznos koji je potrosen za odredjeni sto.
	 * 
	 * @param zaUplatu
	 *            Predstavlja potroseni iznos.
	 * @
	 * 
	 * 		@throws
	 *       Exception Ako je:
	 *       <ul>
	 *       <li>Iznos za uplatu manji od 0.</li>
	 *       </ul>
	 */
	public void updateZaUplatu() throws Exception {
		double zaUplatu = 0;
		if (stavkeRacuna == null || stavkeRacuna.size() == 0)
			throw new Exception("Moraju postojati stavke racuna pre racunanja uplate");

		for (int i = 0; i < stavkeRacuna.size(); i++) {
			zaUplatu += stavkeRacuna.get(i).getCenaArtikla();
		}

		this.zaUplatu = zaUplatu;
	}

	/**
	 * 
	 * Metoda koja vraca iznos koji je uplacen za odredjeni sto.
	 * 
	 * @return jeUplaceno
	 */
	public double getJeUplaceno() {
		return jeUplaceno;
	}

	/**
	 * 
	 * Metoda koja postavlja iznos koji je uplacen za odredjeni sto i izracunava
	 * kusur
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
	public void setJeUplaceno(double jeUplaceno) throws Exception {
		if (stavkeRacuna == null || stavkeRacuna.size() == 0)
			throw new Exception("Moraju postojati stavke racuna pre uplate");
		if (jeUplaceno < 0)
			throw new Exception("Iznos ne moze biti negativan!");
		if (jeUplaceno < zaUplatu)
			throw new Exception("Ne moze biti uplaceno manje od ukupne cene artikala!");

		this.kusur = jeUplaceno - zaUplatu;
		this.jeUplaceno = jeUplaceno;
	}

	/**
	 * 
	 * Metoda koja vraca kusur za odredjeni sto.
	 * 
	 * @return kusur
	 */
	public double getKusur() {
		return kusur;
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
	
	public void setSifraRacuna(String sifraRacuna) throws Exception {
		if (sifraRacuna.length() != 17)
			throw new Exception("nova sifra mora biti 14 karaktera dugacka");
		this.sifraRacuna = sifraRacuna;
	}

	/**
	 * 
	 * Metoda vraca string koji predstavlja racun, primer: Datum: 30.04.2018 14:28
	 * Broj stola: 5 Sifra racuna: 578941 Radnik: Marko Markovic Stavke racuna:
	 * Coca-Cola 130 Domaca kafa 100 Za uplatu: 230 Uplaceno je: 300
	 * 
	 * @return String koji prestavlja racun
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		String stavke = "";

		for (int i = 0; i < stavkeRacuna.size(); i++) {
			stavke += ">" + stavkeRacuna.get(i).getNazivArtikla() + "\n";
		}

		return "Datum: " + sdf.format(datum) + "\nBroj stola: " + brojStola + "\n" + "Sifra racuna: " + sifraRacuna
				+ "\n" + "Radnik: " + radnik.getIme() + " " + radnik.getPrezime() + "\n" + "Stavke racuna:\n" + stavke
				+ "Za uplatu: " + zaUplatu + "\n" + "Uplaceno je: " + jeUplaceno + "\n" + "Za povracaj: " + kusur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifraRacuna == null) ? 0 : sifraRacuna.hashCode());
		return result;
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
	 *         <li><b>false</b> ako su racuni razliciti, tj. nemaju iste sifre</li>
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
