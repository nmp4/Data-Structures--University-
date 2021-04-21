import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StackTest {

	Stack st;
	@Before
	public void setup()
	{
		st = new Stack(2);
	}
	
	/*
	 * Part1: complete the following test methods as specified. 
	 * Note that you will need to add new methods in order to test that exceptions are thrown
	 */
	
	@Test
	public void testPushEmptySize() {
		assertEquals(0,st.size());
		// test the size of an empty stack (hint: test st.size() )
	}
	
	@Test
	public void testPushNonEmptySize() {
		st.push("A");
		st.push("B");
		
		assertEquals(2, st.size());
		// test the size of a non-empty stack
		//fail("not implemented yet");
	}
	
	@Test
	public void testPopTwo() {
		st.push("A");
		st.push("B");
		
		assertEquals("B",st.pop());
		// step 1: test what st.pop() returns
		assertEquals("A", st.pop());
		// step 2: test what st.pop() returns
	}
	
	@Test
	public void testTopTwo() {
		st.push("A");
		// step 1: test what st.top() returns
		assertEquals("A",st.top());
		// step 2: test what st.top() returns
		st.push("B");
		assertEquals("B",st.top());
	}
	
	
	@Test(expected = StackException.class)
	public void testEmptyPop() {
		st.pop();
		// try popping from an empty stack
	}

	@Test(expected = StackException.class)
	public void testFullPush() {
		st.push("A");
		st.push("B");
		st.push("C");
		// try pushing too many elements to the stack
		// (which has a capacity of 2 elements)
	}

}
