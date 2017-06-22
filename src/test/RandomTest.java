package test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eaio.stringsearch.BNDM;

public class RandomTest {
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
	public void testSearchString() {
		String text = getRandomString();
		int actual = this.s.searchString(text, text.substring(1,10));
		assertFalse(actual == -1);
	}
	
	public String getRandomString(){
		SecureRandom random = new SecureRandom();
		return new BigInteger(200, random).toString(32);
	}

}
