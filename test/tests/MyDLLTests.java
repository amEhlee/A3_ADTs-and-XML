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
    public void testAppendNode() {
        DLL.add("a");
        DLL.add("b");

        assertEquals(2, DLL.size());
        assertEquals("a",DLL.get(0));
    }

}
