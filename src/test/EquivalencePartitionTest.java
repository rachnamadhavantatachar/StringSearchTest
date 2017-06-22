package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eaio.stringsearch.BNDM;

public class EquivalencePartitionTest {
	private BNDM s;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.s = new BNDM();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSearchString_EnglishAlphabets() {
		int actual = this.s.searchString("Hello 123 Who is this 667? No one", "one");
		assertEquals("Pattern should be in index 30",30,actual);
	}

	@Test
	public void testSearchString_Numbers() {
		int actual = this.s.searchString("Hello 123 Who is this 667? No one", "67");
		assertEquals("Pattern should be in index 23",23,actual);
	}
	
	@Test
	public void testSearchString_SpecialChars() {
		int actual = this.s.searchString("Hello 123 Who is this 66? !! No one", "? !");
		assertEquals("Pattern should be in index 24",24,actual);
	}
	
	@Test
	public void testSearchString_NonASCII() {
		int actual = this.s.searchString("nön äsçii", "ä");
		assertEquals("Pattern should be in index 4",4,actual);
	}
}
