import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ASearchTest {

	ASearch as;
	/*
	 * Part 1: complete unit tests
	 */
	@Before
	public void setup(){
		as = new ASearch();
		as.addEntry(new Entry("Andrew",111));
		as.addEntry(new Entry("Ewen",321));
		as.addEntry(new Entry("Peter",123));
		as.addEntry(new Entry("Roger",222));
		
	}
	
	/**
	 * Test asserts whether the number returned by calling the linearSearch method is the proper number for the given name.
	 */
	@Test
	public void testLinearSearchOK() {
		
		assertEquals(111, as.linearSearch("Andrew"));
	}

	/**
	 * Test asserts that the number returned is -1 if the linearSearch does not find an entry with a specific name
	 */
	@Test
	public void testLinearSearchFail() {
		
		assertEquals(-1, as.linearSearch("Emily"));
	}
	
	/**
	 * Test asserts that a number assigned to a name is returned when a binarySearch is performed with said name.
	 */
	@Test
	public void testBinarySearchOK() {
		
		assertEquals(222, as.binarySearch("Roger"));
	}
	
	/**
	 * Tests asserts that -1 is returned if a name is not present.
	 */
	@Test
	public void testBinarySearchFail() {
		
		assertEquals(-1, as.binarySearch("Gaston"));
	}

}
