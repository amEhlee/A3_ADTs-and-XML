/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import adts.ListADT;
import utilities.MyArrayList;

/**
 * 
 *
 */
public class MyArrayListTests {

	ListADT<String> list1;
	ListADT<String> list2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list1 = new MyArrayList<>();
		list2 = new MyArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		list1 = null;
		list2 = null;
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	public void testSize() {
		list1.add("test1");
		list1.add("test2");
		list1.add("test3");
		
		assertEquals(3, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	public void testClearEmptyList() {
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}

	@Test
	public void testClearNonEmptyList() {
		list1.add("Test");
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		list1.add("Test1");
		list1.add("Test2");
		list1.add("Test4");
		list1.add(2,"Test3");
		
		assertTrue(list1.get(2).equals("Test3"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE() {
		list1.add("Test1");
		assertTrue(list1.get(0).equals("Test1"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(adts.ListADT)}.
	 */
	@Test
	public void testAddAll() {
		// test if second array is initally empty
		assertTrue(list2.isEmpty());
		
		list1.add("test1");
		list1.add("test2");
		list1.add("test3");
		
		// Check if it is no longer empty and contains 3 elements 
		assertFalse(list2.isEmpty());
		assertEquals(3, list2.size());
		
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		list1.add("Test1");
		list1.add("Test2");
		
		assertTrue(list1.get(0).equals("Test1"));
		assertTrue(list1.get(1).equals("Test2"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveIndex() {
		list1.add("Test1");
		list1.remove(0);
		
		System.out.println(list1.size());
		assertFalse(list1.contains("Test1"));
		assertTrue(list1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveE() {
		list1.add("Test1");
		list1.remove("Test1");
		
		assertFalse(list1.contains("Test1"));
		assertTrue(list1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		list1.add("Test1");
		list1.set(0, "TestSet");
		assertTrue(list1.get(0).equals("TestSet"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertEquals(0, list1.size());
	}
	
	@Test
	public void testIsNotEmpty() {
		list1.add("Test");
		assertEquals(1, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		list1.add("Test1");

		assertTrue(list1.contains("Test1"));
	}

	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}. When size is less.
	 */
	@Test
	public void testToArrayEArraySmallSize() {
		list1.add("Test1");
		list1.add("Test2");
		list1.add("Test3");
		String[] output = list1.toArray(new String[2]);
		assertTrue(output.length == list1.size());
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}. When size is adequate.
	 */
	@Test
	public void testToArrayEArrayBigSize() {
		list1.add("Test1");
		list1.add("Test2");
		list1.add("Test3");
		String[] output = new String[6];
		output = list1.toArray(output);
		assertTrue(output.length == 6);
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}. When size is equal.
	 */
	@Test
	public void testToArrayEArrayEqualSize() {
		list1.add("Test1");
		list1.add("Test2");
		list1.add("Test3");
		String[] output = new String[3];
		output = list1.toArray(output);
		assertTrue(output.length == list1.size());
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		list1.add("Test1");
		list1.add("Test2");
		list1.add("Test3");
		Object[] output = list1.toArray();
		assertTrue(output.length == 3);
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

}
