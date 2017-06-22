package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eaio.stringsearch.BNDM;
import com.eaio.stringsearch.BNDMWildcards;

public class BNDMWildCardsTest {
	private BNDMWildcards bndmWC;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.bndmWC = new BNDMWildcards();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProcessBytes() {
		String text = "Hello";
		byte[] textbytes = text.getBytes();		
		assertNotNull(this.bndmWC.processBytes(textbytes));
	}

	@Test
	public void testSearchString_ProcessString_WC() {
		int actual = this.bndmWC.searchString("Hello World! Howdy? I love Ashu 88!!", "8", this.bndmWC.processString("8",'+'));
		assertEquals("The pattern position for '8' is 32!",32,actual);
	}

	@Test
	public void testProcessStringStringChar() {
		fail("Not yet implemented");
	}

}
