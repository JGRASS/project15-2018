/**
 * 
 */
package kafic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikola Vujic
 *
 */
public class RacunTest {
	Racun racun;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		racun = new Racun();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		racun = null;
	}

	/**
	 * Test method for {@link kafic.Racun#setDatum(java.util.Date)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetDatum() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date datum = sdf.parse("2025/5/12 00:00:01");
		racun.setDatum(datum);
	}

	/**
	 * Test method for {@link kafic.Racun#setDatum(java.util.Date)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetDatumPre() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date datum = sdf.parse("2018/1/12 00:00:01");
		racun.setDatum(datum);
	}

	/**
	 * Test method for {@link kafic.Racun#setStavkaRacuna(java.util.LinkedList)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetStavkaRacuna() throws Exception {
		LinkedList<Artikal> artikli = new LinkedList<Artikal>();

		Artikal artikal = new Artikal();
		artikal.setCenaArtikla(119.99);
		artikal.setNazivArtikla("Coca-Cola");
		artikal.setSifraArtikla("SRCCTT");
		artikal.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal);

		Artikal artikal2 = new Artikal();
		artikal2.setCenaArtikla(119.99);
		artikal2.setNazivArtikla("Coca-Cola");
		artikal2.setSifraArtikla("SRBCRR");
		artikal2.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal2);

		racun.setStavkeRacuna(artikli);

		LinkedList<Artikal> novaLista = racun.getStavkeRacuna();

		for (int i = 0; i < artikli.size(); i++) {
			if (!(artikli.get(i).getSifraArtikla().equals(novaLista.get(i).getSifraArtikla())))
				fail("nisu jednake");
		}
	}

	/**
	 * Test method for {@link kafic.Racun#setRadnik(kafic.Radnik)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetRadnik() throws Exception {
		Radnik radnik = new Radnik();
		radnik.setIme("Nikola");
		radnik.setPrezime("Vujic");
		radnik.setUsername("nikvujic");
		radnik.setPassword("lozinka123");
		radnik.setAdmin(true);

		racun.setRadnik(radnik);

		assertTrue(racun.getRadnik().equals(radnik));
	}

	/**
	 * Test method for {@link kafic.Racun#setBrojStola(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetBrojStola() throws Exception {
		racun.setBrojStola(5);
	}

	/**
	 * Test method for {@link kafic.Racun#setBrojStola(int)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetBrojStolaPrevelik() throws Exception {
		racun.setBrojStola(11);
	}

	/**
	 * Test method for {@link kafic.Racun#setBrojStola(int)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetBrojStolaPremali() throws Exception {
		racun.setBrojStola(0);
	}

	/**
	 * Test method for {@link kafic.Racun#setZaUplatu(double)}.
	 * @throws Exception 
	 */
	@Test
	public void testUpdateZaUplatu() throws Exception {
		LinkedList<Artikal> artikli = new LinkedList<Artikal>();

		Artikal artikal = new Artikal();
		artikal.setCenaArtikla(120);
		artikal.setNazivArtikla("Coca-Cola");
		artikal.setSifraArtikla("SRCCTT");
		artikal.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal);

		Artikal artikal2 = new Artikal();
		artikal2.setCenaArtikla(150);
		artikal2.setNazivArtikla("Ne-Cola");
		artikal2.setSifraArtikla("SRBCRR");
		artikal2.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal2);
		
		racun.setStavkeRacuna(artikli);
		
		racun.updateZaUplatu();
		assertEquals(270.00, racun.getZaUplatu(), 0);
	}

	/**
	 * Test method for {@link kafic.Racun#setZaUplatu(double)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testUpdateZaUplatuFail() throws Exception {
		LinkedList<Artikal> artikli = new LinkedList<Artikal>();
		racun.setStavkeRacuna(artikli);
		racun.updateZaUplatu();
	}

	/**
	 * Test method for {@link kafic.Racun#setJeUplaceno(double)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetJeUplaceno() throws Exception {
		LinkedList<Artikal> artikli = new LinkedList<Artikal>();

		Artikal artikal = new Artikal();
		artikal.setCenaArtikla(120);
		artikal.setNazivArtikla("Coca-Cola");
		artikal.setSifraArtikla("SRCCTT");
		artikal.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal);

		Artikal artikal2 = new Artikal();
		artikal2.setCenaArtikla(150);
		artikal2.setNazivArtikla("Ne-Cola");
		artikal2.setSifraArtikla("SRBCRR");
		artikal2.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal2);
		
		racun.setStavkeRacuna(artikli);
		
		racun.updateZaUplatu();
		
		racun.setJeUplaceno(600);
		assertEquals(600, racun.getJeUplaceno(), 0);
	}
	
	/**
	 * Test method for {@link kafic.Racun#setJeUplaceno(double)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetJeUplacenoMalo() throws Exception {
		LinkedList<Artikal> artikli = new LinkedList<Artikal>();

		Artikal artikal = new Artikal();
		artikal.setCenaArtikla(120);
		artikal.setNazivArtikla("Coca-Cola");
		artikal.setSifraArtikla("SRCCTT");
		artikal.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal);

		Artikal artikal2 = new Artikal();
		artikal2.setCenaArtikla(150);
		artikal2.setNazivArtikla("Ne-Cola");
		artikal2.setSifraArtikla("SRBCRR");
		artikal2.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal2);
		
		racun.setStavkeRacuna(artikli);
		
		racun.updateZaUplatu();
		
		racun.setJeUplaceno(250);
	}
	
	/**
	 * Test method for {@link kafic.Racun#setJeUplaceno(double)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetJeUplacenoBezStavki() throws Exception {
		racun.setJeUplaceno(250);
	}

	@Test
	public void testGetKusur() throws Exception {
		LinkedList<Artikal> artikli = new LinkedList<Artikal>();

		Artikal artikal = new Artikal();
		artikal.setCenaArtikla(120);
		artikal.setNazivArtikla("Coca-Cola");
		artikal.setSifraArtikla("SRCCTT");
		artikal.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal);

		Artikal artikal2 = new Artikal();
		artikal2.setCenaArtikla(150);
		artikal2.setNazivArtikla("Ne-Cola");
		artikal2.setSifraArtikla("SRBCRR");
		artikal2.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal2);
		
		racun.setStavkeRacuna(artikli);
		
		racun.updateZaUplatu();
		
		racun.setJeUplaceno(280);

		assertEquals(10, racun.getKusur(), 0);
	}

	/**
	 * Test method for {@link kafic.Racun#toString()}.
	 * @throws Exception 
	 */
	@Test
	public void testToString() throws Exception {
		LinkedList<Artikal> artikli = new LinkedList<Artikal>();

		Artikal artikal = new Artikal();
		artikal.setCenaArtikla(120);
		artikal.setNazivArtikla("Coca-Cola");
		artikal.setSifraArtikla("SRCCTT");
		artikal.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal);

		Artikal artikal2 = new Artikal();
		artikal2.setCenaArtikla(150);
		artikal2.setNazivArtikla("Ne-Cola");
		artikal2.setSifraArtikla("SRBCRR");
		artikal2.setZemljaPoreklaArtikla("Srbija");
		artikli.add(artikal2);
		
		Radnik radnik = new Radnik();
		radnik.setIme("Nikola");
		radnik.setPrezime("Vujic");
		radnik.setUsername("nikvujic");
		radnik.setPassword("lozinka123");
		radnik.setAdmin(true);
		
		racun.setRadnik(radnik);
		racun.setStavkeRacuna(artikli);
		racun.updateZaUplatu();
		racun.setJeUplaceno(600);
		racun.setBrojStola(2);
	}
	
	@Test
	public void TesSetSifraRacuna() throws Exception {
		racun.setSifraRacuna("12345678901234567");
		assertEquals("12345678901234567", racun.getSifraRacuna());
	}
	
	@Test (expected = java.lang.Exception.class)
	public void TesSetSifraRacunaFail() throws Exception {
		racun.setSifraRacuna("aaaaaaaaaa");
	}

	/**
	 * Test method for {@link kafic.Racun#equals(java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	public void testEqualsObject() throws Exception {
		
		Racun racun2 = new Racun();

		// racuni se ne smeju generisati prebrzo (sifra se generise na osnovu datuma
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 1000000; j++) {
				
			}
		}
		
		racun2.setSifraRacuna(racun.getSifraRacuna());
		
		assertTrue(racun.equals(racun2));
	}
	
	/**
	 * Test method for {@link kafic.Racun#equals(java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	public void testEqualsObjectFalse() throws Exception {
		
		// racuni se ne smeju generisati prebrzo (sifra se generise na osnovu datuma
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 1000000; j++) {
				
			}
		}
		
		Racun racun2 = new Racun();
		
		assertFalse(racun.equals(racun2));
	}

}
