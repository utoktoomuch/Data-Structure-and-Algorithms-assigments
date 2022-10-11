package a1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LLDictionaryTest {

    private static LLDictionary<Integer,Double> dict;

    @BeforeAll

    public static void setUp() {
        dict = new LLDictionary<Integer,Double>();
        //dict = new LLDictionary<String, InventoryRecord>(10);
    }

    @Test
    void clear() {
        dict.clear();
        assertEquals(0, dict.size(), "clear failed, size is non zero");
    }

    @Test
    void insert() {
        dict.clear();
        dict.insert(0, 2.5);
        dict.insert(1,30000.9 );
        dict.insert(2,77.82);
        dict.insert(3, 6.9);
        assertEquals(4, dict.size(), "insert failed, size is not as expected");
    }

    @Test
    void removeAny() {
        dict.clear();
        dict.insert(0, 2.5);
        dict.insert(1,30000.9 );
        dict.insert(2,77.82);
        dict.insert(3, 6.9);
        dict.removeAny();
        assertEquals(3, dict.size(), "removeAny failed");

    }

    @Test
    void find() {
        dict.clear();
        dict.insert(0, 2.5);
        dict.insert(1,30000.9 );
        dict.insert(2,77.82);
        dict.insert(3, 6.9);
        dict.insert(5, 6.91);
        dict.insert(6, 6.92);

        assertEquals(6.91, dict.find(5), "find failed");
    }

    @Test
    void size() {
        dict.clear();
        dict.insert(0, 7.6);

        assertEquals(1, dict.size(), "size failed, size is not as expected");
    }
    @Test
    void testRemove() {

        dict.clear();
        dict.insert(0, 6.7);
        dict.insert(1, 3.3);
        dict.insert(2, 7.89);
        dict.insert(3, 1.234);
        dict.insert(4, 5.234);
        dict.remove(3);
        dict.find(0);
        dict.find(1);
        dict.find(2);
        dict.find(3);
        dict.find(4);

        assertEquals(4, dict.size(), "remove failed");


    }
}