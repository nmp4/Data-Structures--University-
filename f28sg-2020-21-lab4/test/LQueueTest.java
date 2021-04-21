import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LQueueTest {

	LQueue q;
	@Before
	public void setup()
	{
		q = new LQueue();
	}
	
	/*
	 * 2: complete the following test methods as specified. 
	 */
	
	/**
	 * Tests whether isEmpty() returns true.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(q.isEmpty());
	}
	
	/**
	 * Tests whether isEmpty() returns false with a non-empty stack.
	 */
	@Test
	public void testIsEmptyFalse() {
		// add an element to the queue "q"
		q.enqueue(5);
		// then test that q is not an empty queue.
		assertFalse(q.isEmpty());
	}

	/**
	 * Tests the size of an empty stack.
	 */
	@Test
	public void testSizeEmpty() {
		// test the size of an empty queue is 0
		assertEquals(0, q.size());
	}
	
	/**
	 * Tests the size of a non-empty list.
	 */
	@Test
	public void testSizeNonEmpty() {
		// add an element(s) to the queue
		q.enqueue(5);
		q.enqueue(235);
		q.enqueue(45);
		q.enqueue(75);
		
		// then test the size of the queue
		assertEquals(4, q.size());
	}

	/**
	 * Tests whether adding something to the queue works.
	 */
	@Test
	public void testEnqueue() {
		// enqueue an element(s) to the queue
		q.enqueue(3);
		q.enqueue(5);
		// then test that the correct element is at the front
		assertEquals(3, q.front());
	}
	
	/**
	 * Tests whether dequeue works on a non empty list.
	 */
	@Test
	public void testDequeue() {
		// enqueue multiple elements to the queue
		q.enqueue(5);
		q.enqueue(235);
		q.enqueue(45);
		q.enqueue(75);
		// then check that they a returned in the
		// correct order with q.dequeue()
		assertEquals(5, q.dequeue());
		assertEquals(235, q.dequeue());
		assertEquals(45, q.dequeue());
		assertEquals(75, q.dequeue());
	}
	
	/**
	 * Tests whether using dequeue() on an empty queue throws an exception.
	 */
	@Test(expected = QueueException.class)  
	public void testEmptyDequeue() {  
		// try to dequeue an empty queue
		q.dequeue();
	}
	
	/**
	 * Tests whether using front() on an empty queue throws an exception.
	 */
	@Test(expected = QueueException.class)  
	public void testEmptyFront() {
		// try to get the front value of an empty queue
		q.front();
	}
}
