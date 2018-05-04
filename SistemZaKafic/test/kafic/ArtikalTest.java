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

	}

	/**
	 * Test method for
	 * {@link kafic.Artikal#setZemljaPoreklaArtikla(java.lang.String)}.
	 */
	@Test
	public void testSetZemljaPoreklaArtikla() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link kafic.Artikal#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link kafic.Artikal#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
