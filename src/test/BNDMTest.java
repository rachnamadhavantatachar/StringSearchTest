package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.eaio.stringsearch.BNDM;

public class BNDMTest {
	BNDM s;
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
	public void testSearchString1(){
		int actual = this.s.searchString("Hello World! Howdy? I love Ashu!!", "Wo"); 
		assertEquals("The pattern position for Wo is 6!",6,actual);
	}
	@Test
	public void testSearchString_startIndex_0(){
		int actual = this.s.searchString("Hello World! Howdy? I love Ashu!!", 0, "h");
		assertEquals("The pattern position for h is 13!",29,actual); //Returns the last found position
	}
	@Test
	public void testSearchString_startIndex0_endIndex6(){
		int actual = this.s.searchString("Hello World! Howdy? I love Ashu!!", 0, 6, "l");
		assertEquals("The pattern position for 'e' is 2!",2,actual);
	}
	@Test
	public void testSearchString_object(){
		int actual = this.s.searchString("Hello World! Howdy? I love Ashu!!", "l", this.s.processString("l"));
		assertEquals("The pattern position for 'l' is 2!",2,actual);
	}
	@Test
	public void testSearchString_startIndex0_Object(){
		String pattern = "y?";		
		int actual = this.s.searchString("Hello World! Howdy? I love Ashu!!", 2, "y?",this.s.processString(pattern));
		assertEquals("The pattern position for 'e' is 2!",17,actual);
	}
	@Test
	public void testSearchBytes_Bytes(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "lo";
		byte[] textbytes = text.getBytes();
		byte[] textpattern = pattern.getBytes();
		int actual = this.s.searchBytes(textbytes, textpattern);
		assertEquals("The pattern position for 'lo' is 3!",3,actual);
	}
	@Test
	public void testSearchBytes_Objects(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "lo";
		byte[] textbytes = text.getBytes();
		byte[] textpattern = pattern.getBytes();
		int actual = this.s.searchBytes(textbytes, textpattern,this.s.processBytes(textpattern));
		assertEquals("The pattern position for 'lo' is 3!",3,actual);
	}
	@Test
	public void testSearchBytes_StartIndex(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "lo";
		byte[] textbytes = text.getBytes();
		byte[] textpattern = pattern.getBytes();
		int actual = this.s.searchBytes(textbytes, 1,textpattern);
		assertEquals("The pattern position for 'lo' is 3!",3,actual);
	}
	@Test
	public void testSearchBytes_StartIndexObject(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "lo";
		byte[] textbytes = text.getBytes();
		byte[] textpattern = pattern.getBytes();
		int actual = this.s.searchBytes(textbytes, 1, textpattern, this.s.processBytes(textpattern));
		assertEquals("The pattern position for 'lo' is 3!",3,actual);
	}
	@Test
	public void testSearchBytes_StartIndex_EndIndex(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "lo";
		byte[] textbytes = text.getBytes();
		byte[] textpattern = pattern.getBytes();
		int actual = this.s.searchBytes(textbytes, 1, 9, textpattern);
		assertEquals("The pattern position for 'lo' is 3!",3,actual);
	}
	@Test
	public void testSearchBytes_StartIndex_EndIndex_Objects(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "o";
		byte[] textbytes = text.getBytes();
		byte[] textpattern = pattern.getBytes();
		int actual = this.s.searchBytes(textbytes, 1, 7, textpattern, this.s.processBytes(textpattern));
		assertEquals("The pattern position for 'o' is 4!",4,actual);
	}
	@Test
	public void testSearchChars_StartIndex_EndIndex_Objects(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "o";		
		char[] textbytes = text.toCharArray();
		char[] textpattern = pattern.toCharArray();
		int actual = this.s.searchChars(textbytes, 1, 7, textpattern, this.s.processChars(textpattern));
		assertEquals("The pattern position for 'o' is 4!",4,actual);
	}
	@Test
	public void testSearchChars_StartIndex_EndIndex_Objects_PatternGt32(){
		String text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.";
		String pattern = "Aenean commodo ligula eget dolor. Aenean massa.";		
		char[] textbytes = text.toCharArray();
		char[] textpattern = pattern.toCharArray();
		int actual = this.s.searchChars(textbytes, 1, textbytes.length, textpattern, this.s.processChars(textpattern));
		assertEquals("Patter is greater than 32 characters",4,actual);
	}
	@Test
	public void testSearchChars_StartIndex_Objects(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "? I";		
		char[] textbytes = text.toCharArray();
		char[] textpattern = pattern.toCharArray();
		int actual = this.s.searchChars(textbytes, 1, textpattern, this.s.processChars(textpattern));
		assertEquals("The pattern position for '? I' is 18!",18,actual);
	}
	
	@Test
	public void testSearchChars_Objects(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "!!";		
		char[] textbytes = text.toCharArray();
		char[] textpattern = pattern.toCharArray();
		int actual = this.s.searchChars(textbytes, textpattern, this.s.processChars(textpattern));
		assertEquals("The pattern position for '!!' is 31!",31,actual);
	}
	
	@Test
	public void testSearchChars(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "!!";		
		char[] textbytes = text.toCharArray();
		char[] textpattern = pattern.toCharArray();
		int actual = this.s.searchChars(textbytes, textpattern);
		assertEquals("The pattern position for '!!' is 31!",31,actual);
	}
	
	@Test
	public void testSearchChars_StartIndex(){
		String text = "Hello World! Howdy? I love Ashu!!";
		String pattern = "!!";		
		char[] textbytes = text.toCharArray();
		char[] textpattern = pattern.toCharArray();
		int actual = this.s.searchChars(textbytes, 5,textpattern);
		assertEquals("The pattern position for '!!' is 31!",31,actual);
	}
}
