package kafic;

/**
 * 
 * @author Nikola Vujic
 * @version 0.0.1
 * 
 */
public class Radnik {
	/**
	 * predstavlja ime radnika
	 */
	private String ime;
	/**
	 * predstavlja prezime radnika
	 */
	private String prezime;
	/**
	 * predstavlja jedinstveni naziv naloga radnika koji se koristi kada radnik
	 * treba da se uloguje u sistem
	 */
	private String username;
	/**
	 * lozinka naloga koju radnik koristi kada treba da se uloguje u sistem
	 */
	private String password;
	/**
	 * koristi se za proveru da li je radnik administrator. Ukoliko admin pokusa da
	 * se uloguje otvara se poseban prozor
	 */
	private boolean isAdmin = false;

	/**
	 * geter za ime radnika
	 * 
	 * @return ime radnika
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * seter za ime radnika
	 * 
	 * @param ime
	 *            predstavlja ime radnika
	 * @throws Exception
	 *             ako je:
	 *             <ul>
	 *             <li>uneto ime prazno ili null</li>
	 *             <li>uneto ime sadrzi karaktere ili brojeve</li>
	 *             <li>uneto ime ima manje od 2 slova ili vise of 20 slova</li>
	 *             </ul>
	 */
	public void setIme(String ime) throws Exception {
		if (ime == null || ime.isEmpty() || !Kafic.sadrziSamoSlova(ime))
			throw new Exception("ime mora da se sastoji samo iz slova i ne moze biti prazan String");
		if (ime.length() <= 1 || ime.length() > 20)
			throw new Exception("ime mora imati od 2 do 20 slova");
		this.ime = ime;
	}

	/**
	 * geter za prezime radnika
	 * 
	 * @return prezime radnika
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * seter za prezime radnika
	 * 
	 * @param prezime
	 *            predstavlja prezime radnika
	 * @throws Exception
	 *             ako je:
	 *             <ul>
	 *             <li>uneto prezime prazno ili null</li>
	 *             <li>uneto prezime sadrzi karaktere ili brojeve</li>
	 *             <li>uneto prezime ima manje od 2 slova ili vise of 20 slova</li>
	 *             </ul>
	 */
	public void setPrezime(String prezime) throws Exception {
		if (prezime == null || prezime.isEmpty())
			throw new Exception("prezime ne moze biti prazan String");
		String[] prezimeNiz = prezime.split(" ");
		
		int brojRazmaka = 0;
		
		for(int i = 0; i < prezime.length(); i++) {
			if (prezime.charAt(i) == ' ')
				brojRazmaka++;
			if (brojRazmaka > 2)
				throw new Exception("prezime ne moze da se sastoji od vise od dve reci");
		}
		
		for (int i = 0; i < prezimeNiz.length; i++) {
			if (!Kafic.sadrziSamoSlova(prezimeNiz[i]))
				throw new Exception("prezime mora da sadrzi samo slova");
		}
		
		if (prezime.length() <= 1 || prezime.length() > 20)
			throw new Exception("prezime mora imati od 2 do 20 slova");
		this.prezime = prezime;
	}

	/**
	 * geter za naziv naloga radnika
	 * 
	 * @return naziv naloga radnika
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * seter za naziv naloga radnika
	 * 
	 * @param username
	 *            prestavlja naziv naloga radnika
	 * @throws Exception
	 *             ako je:
	 *             <ul>
	 *             <li>uneti username prazan ili null</li>
	 *             <li>uneti username sadrzi razmak</li>
	 *             <li>uneti username pocinje karakterom</li>
	 *             <li>uneti username ima manje od 4 ili vise od 20 karaktera</li>
	 *             </ul>
	 */
	public void setUsername(String username) throws Exception {
		if (username == null || username.isEmpty() || username.contains(" "))
			throw new Exception("usename ne sme da bude prazan ili da sadrzi razmake");

		char[] nizKaraktera = username.toCharArray();
		if (!Character.isLetter(nizKaraktera[0]))
			throw new Exception("username mora poceti slovom");

		if (username.length() <= 3 || username.length() > 20)
			throw new Exception("username mora biti od 4 do 20 karatera dugacak");
		
		this.username = username;
	}

	// TODO: dodati enkripciju za password

	/**
	 * geter za lozinku naloga radnika
	 * 
	 * @return lozinku naloga radnika
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * seter za lozinku naloga radnika
	 * 
	 * @param password
	 *            predstavlja lozinku naloga randnika
	 * @throws Exception
	 *             ako je:
	 *             <ul>
	 *             <li>uneti passwrod prazan ili null</li>
	 *             <li>uneti username ima manje od 5 ili vise od 30 karaktera</li>
	 *             </ul>
	 */
	public void setPassword(String password) throws Exception {
		if (password == null || password.isEmpty())
			throw new Exception("password ne sme biti prazan");
		if (password.length() <= 4 || password.length() > 30)
			throw new Exception("password mora biti od 5 do 30 karaktera dugacak");
		this.password = password;
	}

	/**
	 * geter za proveru da li je radnik administrator
	 * 
	 * @return
	 *         <ul>
	 *         <li><b>true</b> ako je ranik administrator</li>
	 *         <li><b>false</b> ako je radnik obican radnik</li>
	 *         </ul>
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * seter za postavljanje administratora
	 * 
	 * @param isAdmin
	 *            boolean vrednost koja pokazuje da li je radnik administrator
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * vraca String sa podacima o radniku, primer:
	 * Ime: Nikola
	 * Prezime: Vujic
	 * Username: nikvujic
	 * Admin: da
	 * 
	 * @return String sa podacima o radniku
	 */
	@Override
	public String toString() {
		return "Ime: " + ime + "\nPrezime: " + prezime + "\nUsername: " + username + "\nAdmin: "
				+ (isAdmin ? "da" : "ne");
	}

	/**
	 * Proverava da li su dva ranika ista, tj. da li im je username isti
	 *
	 * @param obj
	 *            referentni objekat za poredjenje
	 *
	 * @return
	 *         <ul>
	 *         <li><b>true</b> ako su radnici isti, tj. imaju isti username</li>
	 *         <li><b>false</b> ako su radnici razliciti, tj. nemaju isti
	 *         username</li>
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
		Radnik other = (Radnik) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}