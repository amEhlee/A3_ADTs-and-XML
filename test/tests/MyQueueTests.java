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
		list1 = new MyQueue<>();
		list2 = new MyQueue<>();
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
		fail("Not yet implemented");
	}

	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	void testIsFull() {
		fail("Not yet implemented");
	}

	@Test
	void testSize() {
		fail("Not yet implemented");
	}

}