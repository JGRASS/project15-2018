package kafic.sistemskeoperacije;

/**
 * Klasa koja izvrsava operaciju provere da li se data
 * rec sastoji samo iz slova
 * 
 * @author Nikola Vujic; Uros Veljkovic
 * @version 0.0.1
 *
 */
public class SOSadrziSamoSlova {
	/**
	 * 
	 * @param rec predstavlja String koji se evaluira
	 * @return
	 *         <ul>
	 *         <li><b>true</b> ako String sadrzi samo slova</li>
	 *         <li><b>false</b> ako String ne sadrzi samo slovae</li>
	 *         </ul>
	 */
	public static boolean izvrsi(String rec) {
		char[] nizKaraktera = rec.toCharArray();

		for (int i = 0; i < nizKaraktera.length; i++) {
			if (!Character.isLetter(nizKaraktera[i]))
				return false;
		}

		return true;
	}
}
