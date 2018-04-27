package kafic;

import com.sun.org.apache.bcel.internal.classfile.Attribute;

/**
 * 
 * Artikal predstavlja jedan od objekata liste u klasi Racun
 * 
 * @author Uros Veljkovic
 *
 */
public class Artikal {

	/**
	 * Sifra artikla
	 */
	private String sifraArtikla;
	/**
	 * Naziv artikla
	 */
	private String nazivArtikla;
	/**
	 * Cena artikla
	 */
	private double cenaArtikla;
	/**
	 * Zemlja porekla artikla
	 */
	private String zemljaPoreklaArtikla;

	/**
	 * Konstruktor klase Artikal
	 * 
	 * @param {@link #sifraArtikla}
	 *            - Sifra artikla
	 * @param {@link #nazivArtikla}
	 *            - Naziv artikla
	 * @param {@link #cenaArtikla}
	 *            - Cena artikla
	 * @param {@link #zemljaPoreklaArtikla}
	 *            - Zemlja porekla artikla
	 */
	public Artikal(String sifraArtikla, String nazivArtikla, double cenaArtikla, String zemljaPoreklaArtikla) {
		this.sifraArtikla = sifraArtikla;
		this.nazivArtikla = nazivArtikla;
		this.cenaArtikla = cenaArtikla;
		this.zemljaPoreklaArtikla = zemljaPoreklaArtikla;
	}

	/**
	 * Prazan konstruktor za klasu {@link #Artikal}
	 */
	public Artikal() {

	}

	/**
	 * Metoda koja vraca sifru artikla u vidu integer-a
	 * 
	 * @return sifraArtikla
	 */
	public String getSifraArtikla() {
		return sifraArtikla;
	}

	/**
	 * Metoda koja vraca naziv artikla u vidu String-a
	 * 
	 * @return nazivArtikla
	 */
	public String getNazivArtikla() {
		return nazivArtikla;
	}

	/**
	 * Metoda koja vraca cenu artikla u vidu double-a
	 * 
	 * @return cenaArtikla
	 */
	public double getCenaArtikla() {
		return cenaArtikla;
	}

	/**
	 * Metoda koja vraca zemlju porekla artikla u vidu String-a
	 * 
	 * @return zemljaPoreklaArtikla
	 */
	public String getZemljaPoreklaArtikla() {
		return zemljaPoreklaArtikla;
	}

	/**
	 * Metoda koja postavlja vrednost atributa {@link #sifraArtikla} na vrednost
	 * parametra ukoliko je duzina String parametra jednaka 6
	 * 
	 * @param sifraArtikla
	 * @throws Exception
	 *             - ako je duzina String parametra razlicita od 6 karaktera
	 */
	public void setSifraArtikla(String sifraArtikla) throws Exception {
		if (sifraArtikla.length() != 6)
			throw new Exception("Sifra artikla mora imati tacno 6 karaktera !");
		this.sifraArtikla = sifraArtikla;
	}

	/**
	 * Metoda koja postavlja vrednost atributa {@link #nazivArtikla} na vrednost
	 * parametra
	 * 
	 * @param nazivArtikla
	 * @throws Exception
	 *             - ako se unutar parametra nazivArtikla nalazi bar jedan karakter
	 *             koji nije slovo
	 */
	public void setNazivArtikla(String nazivArtikla) throws Exception {
		if (!sadrziSamoSlova(nazivArtikla))
			throw new Exception("Naziv artikla ne sme da sadrzi brojeve !");
		this.nazivArtikla = nazivArtikla;
	}

	/**
	 * Metoda koja postavlja vrednost atributa {@link #cenaArtikla} na vrednost
	 * parametra
	 * 
	 * @param cenaArtikla
	 */
	public void setCenaArtikla(double cenaArtikla) {
		this.cenaArtikla = cenaArtikla;
	}

	/**
	 * Metoda koja postavlja vrednost atributa {@link #zemljaPoreklaArtikla}na
	 * vrednost parametra
	 * 
	 * @param zemljaPoreklaArtikla
	 */
	public void setZemljaPoreklaArtikla(String zemljaPoreklaArtikla) {
		this.zemljaPoreklaArtikla = zemljaPoreklaArtikla;
	}

	/**
	 * Metoda koja vraca <code>true</code> ako parametar metode
	 * {@link #setNazivArtikla(String)} sadrzi samo slovne karaktere
	 * 
	 * @param nazivArtikla
	 * @return
	 *         <ul>
	 *         <li>true ako su svi karakteri String parametra slovni karakteri</li>
	 *         <li>false ako bar jedan karakter parametra nije slovni</li>
	 *         </ul>
	 */
	public static boolean sadrziSamoSlova(String nazivArtikla) {
		char[] nizKaraktera = nazivArtikla.toCharArray();

		for (int i = 0; i < nizKaraktera.length; i++) {
			if (!Character.isLetter(nizKaraktera[i]))
				return false;
		}

		return true;
	}

}
