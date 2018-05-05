/**
 * 
 */
package kafic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author nikvujic
 *
 */
public class KaficTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		Kafic.radnici.clear();
		Kafic.artikli.clear();
	}

	/**
	 * Test method for {@link kafic.Kafic#dodajRadnika(kafic.Radnik)}.
	 * 
	 * Za ovaj test radnik ne sme vec biti u listi
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDodajRadnika() throws Exception {
		Radnik radnik = new Radnik();
		radnik.setIme("Marko");
		radnik.setPrezime("Petrovic");
		radnik.setUsername("marko.petrovic");
		radnik.setPassword("lozinka123");
		radnik.setAdmin(false);

		Kafic.dodajRadnika(radnik);

		LinkedList<Radnik> radnici = Kafic.radnici;

		for (int i = 0; i < radnici.size(); i++) {
			if (radnik.getUsername().equals(radnici.get(i).getUsername()))
				break;
			if (i == radnici.size() - 1)
				fail("Radnik nije u listi");
		}
	}

	/**
	 * Test method for {@link kafic.Kafic#dodajRadnika(kafic.Radnik)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testDodajRadnikaVecUListi() throws Exception {
		Kafic.napuniListuRadnika();

		Radnik radnik = new Radnik();
		radnik.setIme("Marko");
		radnik.setPrezime("Petrovic");
		radnik.setUsername("marko.petrovic");
		radnik.setPassword("lozinka123");
		radnik.setAdmin(false);

		Kafic.dodajRadnika(radnik);

		Radnik radnik2 = new Radnik();
		radnik2.setIme("Marko");
		radnik2.setPrezime("Petrovic");
		radnik2.setUsername("marko.petrovic");
		radnik2.setPassword("lozinka123");
		radnik2.setAdmin(false);

		Kafic.dodajRadnika(radnik2);
	}

	/**
	 * Test method for {@link kafic.Kafic#dodajArtikal(kafic.Artikal)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDodajArtikal() throws Exception {		
		 LinkedList<Artikal> artikli = Kafic.artikli;
		
		 Artikal artikal = new Artikal();
		 artikal.setNazivArtikla("Banana shake");
		 artikal.setCenaArtikla(200);
		 artikal.setSifraArtikla("BSHKSR");
		 artikal.setZemljaPoreklaArtikla("Zimbabve");
		
		 Kafic.dodajArtikal(artikal);
		
		
		 for (int i = 0; i < artikli.size(); i++) {
		 if (artikal.getSifraArtikla().equals(artikli.get(i).getSifraArtikla()))
		 break;
		 if (i == artikli.size() - 1)
		 fail("Artikal nije u listi");
		 }
	}

	/**
	 * Test method for {@link kafic.Kafic#dodajArtikal(kafic.Artikal)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testDodajArtikalVecUListi() throws Exception {
		 Artikal artikal = new Artikal();
		 artikal.setNazivArtikla("Banana shake");
		 artikal.setCenaArtikla(200);
		 artikal.setSifraArtikla("BSHKSR");
		 artikal.setZemljaPoreklaArtikla("Zimbabve");
		
		 Kafic.dodajArtikal(artikal);
		
		 Artikal artikal2 = new Artikal();
		 artikal2.setNazivArtikla("Banana shake");
		 artikal2.setCenaArtikla(200);
		 artikal2.setSifraArtikla("BSHKSR");
		 artikal2.setZemljaPoreklaArtikla("Zimbabve");
		
		 Kafic.dodajArtikal(artikal2);
	}

	/**
	 * Test method for {@link kafic.Kafic#napuniListuRadnika()}.
	 */
	@Test
	public void testNapuniListuRadnika() {
		// Testirano, dodatni testovi mogu zavisiti od drugih testova
		//
		// Kafic.napuniListuRadnika();
		//
		// LinkedList<Radnik> radnici = Kafic.radnici;
		//
		// for (int i = 0; i < radnici.size(); i++) {
		// 		System.out.println(radnici.get(i).toString());
		// }
	}

	/**
	 * Test method for {@link kafic.Kafic#napuniListuArtikli()}.
	 */
	@Test
	public void testNapuniListuArtikli() {
		// Testirano, dodatni testovi mogu zavisiti od drugih testova
		//
		// Kafic.napuniListuArtikli();
		//
		// LinkedList<Artikal> artikli = Kafic.artikli;
		//
		//
		// for (int i = 0; i < artikli.size(); i++) {
		// System.out.println(artikli.get(i).toString());
		// }
	}

	/**
	 * Test method for {@link kafic.Kafic#azurirajRadniciJson()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAzurirajRadniciJson() throws Exception {
		// Testirano, dodatni testovi mogu zavisiti od drugih testova ili uticati na
		// druge testove. Testiranje moze da poremeti bazu podataka
		//
		// Radnik radnik = new Radnik();
		// radnik.setIme("Nikola");
		// radnik.setPrezime("Vujic");
		// radnik.setUsername("nikola.vujic");
		// radnik.setPassword("lozinka");
		// radnik.setAdmin(false);
		//
		// Radnik radnik2 = new Radnik();
		// radnik2.setIme("Uros");
		// radnik2.setPrezime("Veljkovic");
		// radnik2.setUsername("uros.veljkovic");
		// radnik2.setPassword("lozinka");
		// radnik2.setAdmin(false);
		//
		// Radnik radnik3 = new Radnik();
		// radnik3.setIme("Nikola");
		// radnik3.setPrezime("Bakic");
		// radnik3.setUsername("nikola.bakic");
		// radnik3.setPassword("lozinka");
		// radnik3.setAdmin(false);
		//
		// LinkedList<Radnik> radnici = Kafic.radnici;
		// radnici.add(radnik);
		// radnici.add(radnik2);
		// radnici.add(radnik3);
		//
		// Kafic.azurirajRadniciJson();
	}

	/**
	 * Test method for {@link kafic.Kafic#azurirajArtikliJson()}.
	 * @throws Exception 
	 */
	@Test
	public void testAzurirajArtikliJson() throws Exception {
//		Testirano, dodatni testovi mogu zavisiti od drugih testova ili uticati na
//		druge testove. Testiranje moze da poremeti bazu podataka
//		
//		Artikal artikal = new Artikal();
//		artikal.setNazivArtikla("Coca-Cola");
//		artikal.setCenaArtikla(150);
//		artikal.setSifraArtikla("qwerty");
//		artikal.setZemljaPoreklaArtikla("Mogolija");
//		
//		Artikal artikal2 = new Artikal();
//		artikal2.setNazivArtikla("Pepsi");
//		artikal2.setCenaArtikla(140);
//		artikal2.setSifraArtikla("qwertu");
//		artikal2.setZemljaPoreklaArtikla("Nepal");
//		
//		Artikal artikal3 = new Artikal();
//		artikal3.setNazivArtikla("Limunada");
//		artikal3.setCenaArtikla(160);
//		artikal3.setSifraArtikla("qwerti");
//		artikal3.setZemljaPoreklaArtikla("Zimbabve");
//		
//		LinkedList<Artikal> artikli = Kafic.artikli;
//		artikli.add(artikal);
//		artikli.add(artikal2);
//		artikli.add(artikal3);
//		
//		Kafic.azurirajArtikliJson();
	}

	/**
	 * Test method for {@link kafic.Kafic#sadrziSamoSlova(java.lang.String)}.
	 */
	@Test
	public void testSadrziSamoSlova() {
		assertTrue(Kafic.sadrziSamoSlova("Mongolija"));		
	}
	
	/**
	 * Test method for {@link kafic.Kafic#sadrziSamoSlova(java.lang.String)}.
	 */
	@Test
	public void testSadrziSamoSlovaZnak() {
		assertFalse(Kafic.sadrziSamoSlova("El_Salvador"));
	}
	
	/**
	 * Test method for {@link kafic.Kafic#sadrziSamoSlova(java.lang.String)}.
	 */
	@Test
	public void testSadrziSamoSlovaKarakter() {
		assertFalse(Kafic.sadrziSamoSlova("5arma"));
	}

}
