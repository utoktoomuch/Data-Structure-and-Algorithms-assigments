package a1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import a1.AList;

class AListTest {

    private static AList<Integer, Double> dict;

    @BeforeAll
    public static void setUp() {
        dict = new AList<Integer, Double>();
        //dict = new LLDictionary<String, InventoryRecord>(10);

    }

    @Test
    void testClear() {
        dict.clear();
        assertEquals(0, dict.size(), "clear failed, size is non zero");
    }

    @Test
    void testInsert() {
        dict.clear();
        dict.insert(0, 5.0);
        dict.insert(1,3.0);
        dict.insert(2,3.0);
        dict.insert(3,89.0);
        assertEquals(4, dict.size(), "insert failed, size is not as expected");
    }

    @Test
    void testRemove() {

        dict.clear();
        dict.insert(0, 4.0);
        dict.insert(1, 56.0);
        dict.insert(2,2.0);
        dict.insert(3, 23.0);
        dict.remove(3);

        //assertEquals("1:blue , 2:yellow , 3:grey ,", dict.toString());

        assertEquals(23.0, dict.find(3), "remove failed");

    }

    @Test
    void testFind() {

        dict.clear();
        dict.insert(0, 3.0);
        dict.insert(1, 234.0);
        dict.insert(2,12.0);
        dict.insert(3, 94.0);

        assertEquals(94.0, dict.find(3), "find failed");
    }

    @Test
    void testSize() {
        dict.clear();
        dict.insert(0, 65.0);


        assertEquals(1, dict.size(), "size failed, size is not as expected");
    }


}