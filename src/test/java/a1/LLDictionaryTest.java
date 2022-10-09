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
    }

    @Test
    void removeAny() {
    }

    @Test
    void find() {
    }

    @Test
    void size() {
    }
}