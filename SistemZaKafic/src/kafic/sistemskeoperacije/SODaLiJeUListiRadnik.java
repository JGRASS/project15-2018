package kafic.sistemskeoperacije;

import java.util.LinkedList;

import kafic.Radnik;
/**
 * 
 * @author Nikola Vujic
 *
 */
public class SODaLiJeUListiRadnik {

	/**
	 * Proverava da li je radnik u listi (u json fajlu)
	 * @param radnik
	 * @param radnici
	 * @return
	 */
	public static boolean izvrsi(String username, LinkedList<Radnik> radnici) {
		for (int i = 0; i < radnici.size(); i++) {
			if (radnici.get(i).getUsername().equals(username))
				return true;
		}
		return false;
	}

}
