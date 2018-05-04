/**
 * 
 */
package kafic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author nikvujic
 *
 */
public class RadnikTest {
	private Radnik radnik;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		radnik = new Radnik();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		radnik = null;
	}

	/**
	 * Test method for {@link kafic.Radnik#setIme(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetIme() throws Exception {
		radnik.setIme("Nikola");
		assertEquals("Nikola", radnik.getIme());
	}

	/**
	 * Test method for {@link kafic.Radnik#setIme(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetImeEmpty() throws Exception {
		radnik.setIme("");
	}

	/**
	 * Test method for {@link kafic.Radnik#setIme(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetImeNull() throws Exception {
		radnik.setIme(null);
	}

	/**
	 * Test method for {@link kafic.Radnik#setIme(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetImeSlova() throws Exception {
		radnik.setIme("Nik0la");
	}

	/**
	 * Test method for {@link kafic.Radnik#setIme(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetImeBrKarakteraDug() throws Exception {
		radnik.setIme("Nikolalalalalalalalalalalalalalalala");
	}

	/**
	 * Test method for {@link kafic.Radnik#setIme(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetImeBrKarakteraKratak() throws Exception {
		radnik.setIme("N");
	}

	/**
	 * Test method for {@link kafic.Radnik#setPrezime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetPrezime() throws Exception {
		radnik.setPrezime("Vujic");
		assertEquals("Vujic", radnik.getPrezime());
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPrezime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPrezimeEmpty() throws Exception {
		radnik.setPrezime("");
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPrezime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPrezimeNull() throws Exception {
		radnik.setPrezime(null);
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPrezime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPrezimeSlova() throws Exception {
		radnik.setPrezime("Vuj1c");
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPrezime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetPrezimeSlovaRazmak() throws Exception {
		radnik.setPrezime("Vujic Vujic");
		assertEquals("Vujic Vujic", radnik.getPrezime());
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPrezime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPrezimeSlovaRazmakDva() throws Exception {
		radnik.setPrezime("Vujic Vujic Vujic");
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPrezime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPrezimeBrKarakteraDug() throws Exception {
		radnik.setPrezime("Vujiciciciciicicicicicicicicicicicicicic");
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPrezime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPrezimeBrKarakteraKratak() throws Exception {
		radnik.setPrezime("V");
	}

	/**
	 * Test method for {@link kafic.Radnik#setUsername(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetUsername() throws Exception {
		radnik.setUsername("nikvujic123");
		assertEquals("nikvujic123", radnik.getUsername());
	}

	/**
	 * Test method for {@link kafic.Radnik#setUsername(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetUsernameEmpty() throws Exception {
		radnik.setUsername("");
	}

	/**
	 * Test method for {@link kafic.Radnik#setUsername(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetUsernameNull() throws Exception {
		radnik.setUsername(null);
	}

	/**
	 * Test method for {@link kafic.Radnik#setUsername(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = java.lang.Exception.class)
	public void testSetUsernameBrKarakteraDug() throws Exception {
		radnik.setUsername("nikvujiciciciciciciciciciciciciciicicicicic");
	}

	/**
	 * Test method for {@link kafic.Radnik#setUsername(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetUsernameBrKarakteraKratak() throws Exception {
		radnik.setUsername("nik");
	}

	/**
	 * Test method for {@link kafic.Radnik#setUsername(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetUsernameRazmak() throws Exception {
		radnik.setUsername("nik vujic");
	}

	/**
	 * Test method for {@link kafic.Radnik#setUsername(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetUsernamePocinjeKarakterom() throws Exception {
		radnik.setUsername("$nikvujic");
	}
	

	/**
	 * Test method for {@link kafic.Radnik#setUsername(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetUsernamePocinjeBrojem() throws Exception {
		radnik.setUsername("55nikvujic");
	}

	/**
	 * Test method for {@link kafic.Radnik#setPassword(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetPassword() throws Exception {
		radnik.setPassword("lozinka123");
		assertEquals("lzinka123", radnik.getPassword());
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPassword(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPasswordEmpty() throws Exception {
		radnik.setPassword("");
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPassword(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPasswordNull() throws Exception {
		radnik.setPassword(null);
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPassword(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPasswordBrKarakteraDug() throws Exception {
		radnik.setPassword("predugackalozinkapredugackalozinkapredugckalozinka");
	}
	
	/**
	 * Test method for {@link kafic.Radnik#setPassword(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test (expected = java.lang.Exception.class)
	public void testSetPasswordBrKarakteraKratak() throws Exception {
		radnik.setPassword("pass");
	}

	/**
	 * Test method for {@link kafic.Radnik#toString()}.
	 * @throws Exception 
	 */
	@Test
	public void testToString() throws Exception {
		radnik.setIme("Nikola");
		radnik.setPrezime("Vujic");
		radnik.setUsername("nikvujic");
		radnik.setPassword("lozinka123");
		radnik.setAdmin(true);
		
		assertEquals("Ime: Nikola\n" + 
				"Prezime: Vujic\n" + 
				"Username: nikvujic\n" + 
				"Admin: da", radnik.toString());
	}

	/**
	 * Test method for {@link kafic.Radnik#equals(java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	public void testEqualsObjectFail() throws Exception {
		radnik.setIme("Nikola");
		radnik.setPrezime("Vujic");
		radnik.setUsername("nikvujic");
		radnik.setPassword("lozinka123");
		radnik.setAdmin(true);
		
		Radnik radnik2 = new Radnik();
		radnik2.setIme("Nikola");
		radnik2.setPrezime("Bakic");
		radnik2.setUsername("nikbakic");
		radnik2.setPassword("bestpassever");
		radnik2.setAdmin(false);
		
		assertFalse(radnik.equals(radnik2));
	}
	
	/**
	 * Test method for {@link kafic.Radnik#equals(java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	public void testEqualsObject() throws Exception {
		radnik.setIme("Nikola");
		radnik.setPrezime("Vujic");
		radnik.setUsername("nikvujic");
		radnik.setPassword("lozinka123");
		radnik.setAdmin(true);
		
		Radnik radnik2 = new Radnik();
		radnik2.setIme("Nikola");
		radnik2.setPrezime("Bakic");
		radnik2.setUsername("nikvujic");
		radnik2.setPassword("bestpassever");
		radnik2.setAdmin(false);
		
		assertFalse(radnik.equals(radnik2));
	}

}
