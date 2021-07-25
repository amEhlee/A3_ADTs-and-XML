/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import adts.ListADT;
import utilities.MyDLL;

/**
 * 
 */
public class MyDLLTests {
    /**
     * Linked list to be manipulated in every test
     */
    private ListADT<String> DLL = new MyDLL<String>();

    @BeforeEach
    void setUp() throws Exception {
        DLL = new MyDLL<String>();
    }

	@AfterEach
	public void tearDown() throws Exception {
		DLL.clear();
	}

    @Test
    public void testIsEmpty() {
        assertTrue(DLL.isEmpty());
        assertEquals(0, DLL.size());
    }

    @Test 
    public void testSize() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");

        assertEquals(3, DLL.size()); 
    }

    @Test
    public void testClear() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");
        assertEquals(3, DLL.size());

        DLL.clear();
        assertEquals(0, DLL.size());
    }

    @Test
    public void testAdd() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");

        assertEquals(3, DLL.size());
        assertEquals("a", DLL.get(0));
    }

    @Test 
    public void testAddIndex() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");
        DLL.add(2, "z");

        assertEquals("z", DLL.get(2));
    }

    @Test
    public void testAddAll() {
        fail("Not yet implemented");
    }

    @Test
    public void testGet() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");

        assertEquals("b", DLL.get(1));
    }

    @Test
    public void testRemoveIndex() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");        
        DLL.add("d");
        DLL.add("e");
        DLL.add("f");
        assertEquals(6, DLL.size());

        DLL.remove(1);

        assertEquals(5, DLL.size());
        assertEquals("c", DLL.get(1));

        // remove head
        DLL.remove(0);
        assertFalse(DLL.contains("a"));

        // remove tail
        DLL.remove(6);
        assertFalse(DLL.contains("f"));
    }

    @Test
    public void testRemoveElement() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");        
        DLL.add("d");
        DLL.add("e");
        DLL.add("f");
        assertEquals(6, DLL.size());

        DLL.remove("b");

        assertEquals(5, DLL.size());
        assertEquals("c", DLL.get(1));

        // remove head
        DLL.remove("a");
        assertFalse(DLL.contains("a"));

        // remove tail
        DLL.remove("f");
        assertFalse(DLL.contains("f"));
    }

    @Test
    public void testSet() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");
        DLL.set(1, "z");

        assertEquals("z", DLL.get(1));

    }

    @Test
    public void testContains() {
        DLL.add("a");
        DLL.add("b");
        DLL.add("c");

        assertTrue(DLL.contains("a"));
        assertTrue(DLL.contains("b"));
    }

}
