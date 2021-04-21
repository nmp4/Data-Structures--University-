import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {

	/*
	 * Part 1: complete
	 */
	
	PriorityQueue pq;
	
	@Before
	public void setup(){
		pq = new PriorityQueue(20);
	}
	
	@Test
	public void insertTestMin() {
		// insert a few numbers then test pq.min()
		pq.insert(10);
		pq.insert(6);
		pq.insert(72);
		pq.insert(8);
		
		assertEquals(6, pq.min());
	}
	
	@Test
	public void insertTestSize() {
		// insert a few numbers then test pq.size()
		pq.insert(10);
		pq.insert(6);
		pq.insert(72);
		pq.insert(8);
		
		assertEquals(4, pq.size());
	}

	@Test
	public void removeMinTest() {
		// step 1: add a few numbers to pq
		pq.insert(10);
		pq.insert(6);
		pq.insert(72);
		pq.insert(8);
		// step 2: call pq.removeMin() a few times to check
		//         numbers are returned in ascending order 
		assertEquals(6, pq.removeMin());
		assertEquals(8, pq.removeMin());
		assertEquals(10, pq.removeMin());
	}
	
	
	@Test(expected=PriorityQueueException.class)
	public void removeMinEmptyTest() {
		pq.removeMin();
	}
}	
