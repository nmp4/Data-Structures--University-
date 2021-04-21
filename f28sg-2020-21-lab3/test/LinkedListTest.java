import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	LinkedList l;

	@Before
	public void setup() {
		l = new LinkedList();
	}

	
	/**
	 * Tests the size of any empty list
	 */
	@Test
	public void testSizeEmpty() {
		// test l.size() for an empty linked list
		assertEquals(0, l.size());
	}

	/**
	 * tests the size of a list w/ multiple elements.
	 */
	@Test
	public void testSizeMany() {
		// test l.size() after adding some numbers to the linked list
		l.addAtHead(3);
		l.addAtTail(7);
		l.addAtTail(26);
		l.addAtTail(67);
		l.addAtTail(88);
		assertEquals(5, l.size());
	}

	/**
	 * tests the sum of all the values in an empty list.
	 */
	@Test
	public void testTotalEmpty() {
		// test l.total() for an empty linked list
		assertEquals(0, l.total());
	}

	/**
	 * tests the sum of all the values in a list w/ multiple values.
	 */
	@Test
	public void testTotalMany() {
		// test l.total() after adding some numbers to the linked list
		l.addAtHead(3);
		l.addAtTail(7);
		l.addAtTail(26);
		l.addAtTail(67);
		l.addAtTail(88);
		assertEquals(191, l.total());
	}

	/*
	 * Optional part
	 */

//	@Test
//	public void testReverse() {
//		l.addAtHead(5);
//		l.addAtHead(2);
//		l.addAtHead(10);
//		l.reverse();
//		assertEquals(5, l.removeAtHead());
//		assertEquals(2, l.removeAtHead());	
//		assertEquals(10, l.removeAtHead());	
//	}

}
