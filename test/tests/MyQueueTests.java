package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adts.Iterator;
import adts.QueueADT;
import exceptions.EmptyQueueException;
import utilities.MyQueue;

class MyQueueTests {
	QueueADT<String> list1;
	QueueADT<String> list2;

	@BeforeEach
	void setUp() throws Exception {		
		list1 = new MyQueue<>(); // unlimited
		list2 = new MyQueue<>(4); // limited
	}

	@AfterEach
	void tearDown() throws Exception {
		list1 = null;
		list2 = null;
	}

	@Test
	void testEnqueue() {
		list1.enqueue("a");
		list1.enqueue("b");
		try {
			assertTrue(list1.peek().equals("a"));
		} catch (EmptyQueueException e1) {
			e1.printStackTrace();
		}
	}

	@Test
	void testDequeue() {
        list1.enqueue("a");
        list1.enqueue("b");
        try {
            String output = list1.dequeue();
            assertTrue(output.equals("a"));

            output = list1.dequeue();
            assertTrue(output.equals("b"));
        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }
	}

	@Test
	void testPeek() {
        try {
            list1.enqueue("a");
            assertTrue(list1.peek().equals("a"));

            list1.enqueue("b");
            assertTrue(list1.peek().equals("a"));
            
            list1.dequeue();
            assertTrue(list1.peek().equals("b"));
        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }
	}

	@Test
	void testDequeueAll() {
		list1.enqueue("a");
		list1.enqueue("b");
		list1.dequeueAll();
		list1.enqueue("c");
		try {
			assertTrue(list1.peek().equals("c"));
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testIsEmpty() {
		assertTrue(list1.isEmpty());
		list1.enqueue("something");
		assertFalse(list1.isEmpty());
		list1.dequeueAll();
		assertTrue(list1.isEmpty());
	}


	/**
	 * Test method for Test method for MyQueue#iterator() method..
	 */
	@Test
	public void testIteratorHasNext() {
		list1.enqueue("Test1");
		list1.enqueue("Test2");
		Iterator<String> it = list1.iterator();
		assertTrue(it.hasNext());
		list1.dequeueAll();
		assertFalse(it.hasNext());
	}
	
	/**
	 * Test method for MyQueue#iterator() method.
	 */
	@Test
	public void testIteratorNext() {
		list1.enqueue("Test1");
		list1.enqueue("Test2");
		list1.enqueue("Test3");
		Iterator<String> it = list1.iterator();
		
		assertTrue(it.next().equals("Test1"));
		assertTrue(it.next().equals("Test2"));
	}

	@Test
	void testEquals() {
		list1.enqueue("a");
		list1.enqueue("b");
		list2.enqueue("a");

		// number of their items is different
		assertFalse(list1.equals(list2));

		list2.enqueue("b");
		// now number is the same
		assertTrue(list1.equals(list2));

		list1.enqueue("c");
		list1.enqueue("d");
		list2.enqueue("d");
		list2.enqueue("c");
		// number's the same but the order's different
		assertFalse(list1.equals(list2));
	}

	/**
	 * Test method toArray(E[]). When size is less.
	 */
	@Test
	public void testToArrayEArraySmallSize() {
		list1.enqueue("Test1");
		list1.enqueue("Test2");
		list1.enqueue("Test3");
		String[] output = list1.toArray(new String[2]);
		assertTrue(output.length == list1.size());
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	
	
	/**
	 * Test method for toArray(E[]). When size is adequate.
	 */
	@Test
	public void testToArrayEArrayBigSize() {
		list1.enqueue("Test1");
		list1.enqueue("Test2");
		list1.enqueue("Test3");
		String[] output = new String[6];
		output = list1.toArray(output);
		assertTrue(output.length == 6);
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	
	/**
	 * Test method for toArray(E[]). When size is equal.
	 */
	@Test
	public void testToArrayEArrayEqualSize() {
		list1.enqueue("Test1");
		list1.enqueue("Test2");
		list1.enqueue("Test3");
		String[] output = new String[3];
		output = list1.toArray(output);
		assertTrue(output.length == list1.size());
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	

	/**
	 * Test method for toArray().
	 */
	@Test
	public void testToArray() {
		list1.enqueue("Test1");
		list1.enqueue("Test2");
		list1.enqueue("Test3");
		Object[] output = list1.toArray();
		assertTrue(output.length == 3);
		assertTrue(output[0].equals("Test1"));
		assertTrue(output[1].equals("Test2"));
		assertTrue(output[2].equals("Test3"));
	}
	
	@Test
	void testIsFull() {
		//unlimited list
		assertFalse(list1.isFull());
		list1.enqueue("a");
		assertFalse(list1.isFull());
		
		// limited(4) list
		assertFalse(list2.isFull());
		list2.enqueue("a");
		list2.enqueue("b");
		list2.enqueue("c");
		assertFalse(list2.isFull());
		list2.enqueue("d");
		assertTrue(list2.isFull());
	}

	@Test
	void testSize() {
		assertEquals(0, list1.size());
		list1.enqueue("a");
		list1.enqueue("b");
		list1.enqueue("c");
		assertEquals(3, list1.size());
		try {
			list1.dequeue();
			assertEquals(2, list1.size());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list1.dequeueAll();
		assertEquals(0, list1.size());
	}

}