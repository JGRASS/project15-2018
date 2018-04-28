package kafic;

import kafic.sistemskeoperacije.SOSadrziSamoSlova;

/**
 * 
 * @author Nikola Vujic
 * @version 0.0.1
 * 
 */
public class Kafic {
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
