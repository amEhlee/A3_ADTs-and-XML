package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adts.StackADT;
import utilities.MyStack;



class MyStackTests {
	StackADT<String> list1;
	StackADT<String> list2;
	StackADT<Integer> list3;
	StackADT<Double> list4;
	
	@BeforeEach
	void setUp() throws Exception {
		list1 = new MyStack<>();
		list2 = new MyStack<>();
		list3 = new MyStack<>();
		list4 = new MyStack<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		list1 = null;
		list2 = null;
		list3 = null;
		list4 = null;
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	public void testSize() {
		list1.push("test1");
		list1.push("test2");
		list1.push("test3");
		
		assertEquals(3, list1.size());
	}
	
	/**
	 * Test method for {@link utilities/MyStack#clear()} and {@link utilities/MyStack#isEmpty()}.
	 */
	@Test
	public void testClearEmptyStack() {
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities/MyStack#peek()}.
	 */
	@Test
	public void testPeek() {
		list1.push("Test1");
		list1.push("Test2");
		list1.push("Test3");
		list1.push("Test4");
		
		assertTrue(list1.peek().equals("Test4"));
	}
	
	/**
	 * Test method for {@link utilities/MyStack#contains()}.
	 */
	@Test
	public void testContains() {
		list1.push("Test1");
		list1.push("Test2");
		list1.push("Test3");
		list1.push("Test4");
		
		assertTrue(list1.contains("Test1"));
		assertTrue(list1.contains("Test2"));
		assertTrue(list1.contains("Test3"));
		assertTrue(list1.contains("Test4"));
	}
	
	/**
	 * Test method for {@link utilities/MyStack#search()}.
	 */
	@Test
	public void testSearch() {
		list1.push("Test1");
		list1.push("Test2");
		list1.push("Test3");
		list1.push("Test4");
		
		assertTrue(list1.search("Test2") == 2);
	}
	
	/**
	 * Test method for {@link utilities/MyStack#pop()}, {@link utilities/MyStack#push()}.
	 */
	@Test
	public void testPopAndPush() {
		list1.push("Test1");
		list1.pop();
		
		list2.push("test1");
		list2.push("test2");
		list2.push("test3");
		assertTrue(list2.pop().equals("test3"));
		System.out.println(list2.peek());
		assertTrue(list2.peek().equals("test2"));
		list2.push("test4");
		assertTrue(list2.peek().equals("test4"));
		list2.pop();
		assertTrue(list2.peek().equals("test2"));
		
		assertFalse(list1.contains("Test1"));
		assertTrue(list1.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}. When size is less.
	 */
	@Test
	public void testToArrayEArraySmallSize() {
		list1.push("Test1");
		list1.push("Test2");
		list1.push("Test3");
		String[] output = list1.toArray(new String[2]);
		assertTrue(output.length == list1.size());
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}. When size is adequate.
	 */
	@Test
	public void testToArrayEArrayBigSize() {
		list1.push("Test1");
		list1.push("Test2");
		list1.push("Test3");
		String[] output = new String[6];
		output = list1.toArray(output);
		assertTrue(output.length == 6);
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}. When size is equal.
	 */
	@Test
	public void testToArrayEArrayEqualSize() {
		list1.push("Test1");
		list1.push("Test2");
		list1.push("Test3");
		String[] output = new String[3];
		output = list1.toArray(output);
		assertTrue(output.length == list1.size());
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}

}
