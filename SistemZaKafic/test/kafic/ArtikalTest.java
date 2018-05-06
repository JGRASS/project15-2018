/**
 * 
 */
package kafic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikola Vujic
 * @author Uros Veljkovic
 *
 */
public class ArtikalTest {

	private Artikal artikal;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		artikal = new Artikal();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		artikal = null;
	}

	/**
	 * Test method for {@link kafic.Artikal#setSifraArtikla(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetSifraArtikla() throws Exception {
		artikal.setSifraArtikla("q11e22");
		assertEquals("q11e22", artikal.getSifraArtikla());

	}
	
	/**
	 * Test method for {@link kafic.Artikal#setSifraArtikla(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetSifraArtiklaEmpty() throws Exception {
		artikal.setSifraArtikla("");
	}
	
	/**
	 * Test method for {@link kafic.Artikal#setSifraArtikla(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetSifraArtiklaNull() throws Exception {
		artikal.setSifraArtikla(null);
	}
	
	/**
	 * Test method for {@link kafic.Artikal#setSifraArtikla(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetSifraArtiklaSmallerLen() throws Exception {
		artikal.setSifraArtikla("sdfa");
	}
	
	/**
	 * Test method for {@link kafic.Artikal#setSifraArtikla(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetSifraArtiklaBiggerLen() throws Exception {
		artikal.setSifraArtikla("sdfa3r2r32r3fsdf");
	}

	/**
	 * Test method for {@link kafic.Artikal#setNazivArtikla(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetNazivArtikla() throws Exception {
		artikal.setNazivArtikla("Coca-cola");
		assertEquals("Coca-cola", artikal.getNazivArtikla());
	}
	
	/**
	 * Test method for {@link kafic.Artikal#setNazivArtikla(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetNazivArtiklaNull() throws Exception {
		artikal.setNazivArtikla(null);
	}
	
	/**
	 * Test method for {@link kafic.Artikal#setNazivArtikla(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetNazivArtiklaSmallerLen() throws Exception {
		artikal.setNazivArtikla("A");
	}
	
	/**
	 * Test method for {@link kafic.Artikal#setNazivArtikla(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetNazivArtiklaBiggerLen() throws Exception {
		artikal.setNazivArtikla("fdsfdjasjdfdshfashjfksaldhkfsahfkalshfkashflkashjfksalfashfkjdshfaskl");
	}

	/**
	 * Test method for {@link kafic.Artikal#setCenaArtikla(double)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetCenaArtikla() throws Exception {
		artikal.setCenaArtikla(55.66);
		assertEquals(55.66, artikal.getCenaArtikla(), 0);
	}
	
	/**
	 * Test method for {@link kafic.Artikal#setCenaArtikla(double)}.
	 * @throws Exception 
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetCenaArtiklaManjaOdJedan() throws Exception {
		artikal.setCenaArtikla(-1.0);
	}
	
	/**
	 * Test method for
	 * {@link kafic.Artikal#setZemljaPoreklaArtikla(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetZemljaPoreklaArtikla() throws Exception {

		artikal.setZemljaPoreklaArtikla("Bosna");
		assertEquals("Bosna", artikal.getZemljaPoreklaArtikla());
	}

	/**
	 * Test method for
	 * {@link kafic.Artikal#setZemljaPoreklaArtikla(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetZemljaPoreklaArtiklaRazmak() throws Exception {

		artikal.setZemljaPoreklaArtikla("Bosna i Hercegovina");
		assertEquals("Bosna i Hercegovina", artikal.getZemljaPoreklaArtikla());
	}

	/**
	 * Test method for {@link kafic.Artikal#toString()}.
	 * @throws Exception 
	 */
	@Test
	public void testToString() throws Exception {
		artikal.setCenaArtikla(55.66);
		artikal.setNazivArtikla("Coca-cola");
		artikal.setSifraArtikla("543sfd");
		artikal.setZemljaPoreklaArtikla("Bosna");
		
		System.out.println(artikal.toString());
		
		assertEquals("Sifra artikla: 543sfd\n" + 
				"Naziv artikla: Coca-cola\n" + 
				"Cena artikla: 55.66\n" + 
				"Zemlja porekla: Bosna", artikal.toString());
		
	}

	/**
	 * Test method for {@link kafic.Artikal#equals(java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	public void testEqualsObject() throws Exception {

		artikal.setCenaArtikla(55.66);
		artikal.setNazivArtikla("Coca-cola");
		artikal.setSifraArtikla("543sfd");
		artikal.setZemljaPoreklaArtikla("Bosna");
		
		Artikal artikal2 = new Artikal();
		artikal2 = artikal;
		
		assertTrue(artikal.equals(artikal2));	
	}
	
	/**
	 * Test method for {@link kafic.Artikal#equals(java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	public void testEqualsObjectFalse() throws Exception {

		artikal.setCenaArtikla(55.66);
		artikal.setNazivArtikla("Coca-cola");
		artikal.setSifraArtikla("543sfd");
		artikal.setZemljaPoreklaArtikla("Bosna");
		
		Artikal artikal2 = new Artikal();
		artikal2 = artikal;
		artikal2.setSifraArtikla("322ggg");
		
		assertTrue(artikal.equals(artikal2));	
	}

}
