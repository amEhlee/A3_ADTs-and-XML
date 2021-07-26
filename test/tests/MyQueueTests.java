package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	@Test
	void testIterator() {
		fail("Not yet implemented");
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

	@Test
	void testToArray() {
		fail("Not yet implemented");
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