package kafic;

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
	 *             - ako je dat prazan String
	 */
	public void setSifraArtikla(String sifraArtikla) throws Exception {
		if (sifraArtikla == null || sifraArtikla.isEmpty()) {
			throw new Exception("Sifra ne sme da bude prazna");
		}
		if (sifraArtikla.length() != 6)
			throw new Exception("Sifra artikla mora imati tacno 6 karaktera !");
		// TODO: proveriti da li je jedinstvena
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
		if (nazivArtikla == null || nazivArtikla.length() < 2 || nazivArtikla.length() > 40)
			throw new Exception("Naziv artikla mora imati vise od jednog, a manje od 40 karaktera!");
		this.nazivArtikla = nazivArtikla;
	}

	/**
	 * Metoda koja postavlja vrednost atributa {@link #cenaArtikla} na vrednost
	 * parametra
	 * 
	 * @param cenaArtikla
	 * @throws Exception
	 *             u slucaju da je parametar cenaArtikla manji od 0
	 */

	public void setCenaArtikla(double cenaArtikla) throws Exception {
		if (cenaArtikla < 1)
			throw new Exception("Cena artikla mora biti veca od 1!");
		this.cenaArtikla = cenaArtikla;
	}

	/**
	 * Metoda koja postavlja vrednost atributa {@link #zemljaPoreklaArtikla}na
	 * vrednost parametra
	 * 
	 * @param zemljaPoreklaArtikla
	 * @throws Exception
	 *             u slucaju da parametar zemljaPoreklaArtikla sadrzi bar jedan
	 *             karakter koji nije slovni ili je uneti parametar prazan String
	 *             ili null
	 */
	public void setZemljaPoreklaArtikla(String zemljaPoreklaArtikla) throws Exception {
		if (zemljaPoreklaArtikla.isEmpty())
			throw new Exception("Zemlja porekla ne sme biti prazna");
		if (zemljaPoreklaArtikla.length() < 1)
			throw new Exception("Zemlja porekla mora sadrzati samo slovne karaktere!");
		
		String[] zemljaPoreklaNiz = zemljaPoreklaArtikla.split(" ");
		
		for (int i = 0; i < zemljaPoreklaNiz.length; i++) {
			if (!Kafic.sadrziSamoSlova(zemljaPoreklaNiz[i]))
				throw new Exception("Zemlja porekla ne sme da sadrzi slovne karaktere");
		}
		
		this.zemljaPoreklaArtikla = zemljaPoreklaArtikla;
	}

	/**
	 * Metoda koja vraca podatke o artiklu. <br>
	 * Primer:<br>
	 * Artikal: Sifra artikla: sar32fds Naziv artikla: Coca-cola Cena artikla:
	 * 175.00 Zemlja porekla artila: USA
	 * 
	 */
	@Override
	public String toString() {
		return "Sifra artikla: " + sifraArtikla + "\nNaziv artikla: " + nazivArtikla + "\nCena artikla: "
				+ cenaArtikla + "\nZemlja porekla: " + zemljaPoreklaArtikla;
	}

	/**
	 * Metoda koja proverava parametar metode jednak objektu koji poziva ovu metodu
	 * 
	 * @param obj
	 *            objekat koji poredimo sa objektom koji poziva ovu metodu
	 * @return
	 *         <ul>
	 *         <li>true ako su sifre artikala jednake</li>
	 *         <li>false ako se sifre razlikuju</li>
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
		Artikal other = (Artikal) obj;

		if (sifraArtikla == null) {
			if (other.sifraArtikla != null)
				return false;
		} else if (!sifraArtikla.equals(other.sifraArtikla))
			return false;

		return true;
	}

}