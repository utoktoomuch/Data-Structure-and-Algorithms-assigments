package a1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseInventoryTest {

    private static WarehouseInventory<String,Inventory> inv;

    @BeforeAll

    public static void setUp() {
        inv = new WarehouseInventory<>();
        //dict = new LLDictionary<String, InventoryRecord>(10);
    }

    @Test
    void clear() {
        Inventory inv1 = new Inventory("Item 1", "T345" , "Row 2, slot 1", "Each", 20, 10, 30.0, 600.0);
        inv.insert("SP7875",inv1);
        inv.clear();
        assertEquals(0, inv.size(), "clear failed, size is non zero");
    }

    @Test
    void insert() {
        inv.clear();
        Inventory inv1 = new Inventory("Item 4", "T9876" , "Row 3, slot 2", "Box(10 ct)", 40, 10, 15.0, 600.0);
        Inventory inv2 = new Inventory("Item 5", "T098" , "Row 3, slot 1", "Each", 12, 10, 26.0, 312.0);
        Inventory inv3 = new Inventory("Item 6", "T345" , "Row 2, slot 1", "Each", 7, 10, 50.0, 350.0);
        inv.insert("YE98762", inv1);
        inv.insert("XR23423", inv2);
        inv.insert("PW98762", inv3);
        assertEquals(3, inv.size(), "insert failed, size is not as expected");
    }

    @Test
    void find() {
        inv.clear();
        Inventory inv1 = new Inventory("Item 4", "T9876" , "Row 3, slot 2", "Box(10 ct)", 40, 10, 15.0, 600.0);
        Inventory inv2 = new Inventory("Item 5", "T098" , "Row 3, slot 1", "Each", 12, 10, 26.0, 312.0);
        Inventory inv3 = new Inventory("Item 6", "T345" , "Row 2, slot 1", "Each", 7, 10, 50.0, 350.0);
        inv.insert("YE98762", inv1);

        inv.insert("XR23423", inv2);
        inv.insert("PW98762", inv3);




        assertEquals(inv3, inv.find("PW98762"), "find failed" );

    }

    @Test
    void remove() {
        inv.clear();
        Inventory inv1 = new Inventory("Item 4", "T9876" , "Row 3, slot 2", "Box(10 ct)", 40, 10, 15.0, 600.0);
        Inventory inv2 = new Inventory("Item 5", "T098" , "Row 3, slot 1", "Each", 12, 10, 26.0, 312.0);
        Inventory inv3 = new Inventory("Item 6", "T345" , "Row 2, slot 1", "Each", 7, 10, 50.0, 350.0);
        inv.insert("YE98762", inv1);
        inv.insert("XR23423", inv2);
        inv.insert("PW98762", inv3);
        inv.remove("XR23423");
        inv.find("YE98762");
        inv.find("XR23423");
        inv.find("PW98762");
        assertEquals(2, inv.size(), "remove failed, size is not as expected");
    }

    @Test
    void removeAny() {
        inv.clear();
        Inventory inv1 = new Inventory("Item 4", "T9876" , "Row 3, slot 2", "Box(10 ct)", 40, 10, 15.0, 600.0);
        Inventory inv2 = new Inventory("Item 5", "T098" , "Row 3, slot 1", "Each", 12, 10, 26.0, 312.0);
        Inventory inv3 = new Inventory("Item 6", "T345" , "Row 2, slot 1", "Each", 7, 10, 50.0, 350.0);
        inv.insert("YE98762", inv1);
        inv.insert("XR23423", inv2);
        inv.insert("PW98762", inv3);
        inv.removeAny();
        inv.find("PW98762");

        assertEquals(2, inv.size(), "remove failed, size is not as expected");

    }

    @Test
    void size() {
        inv.clear();
        Inventory inv1 = new Inventory("Item 4", "T9876" , "Row 3, slot 2", "Box(10 ct)", 40, 10, 15.0, 600.0);
        Inventory inv2 = new Inventory("Item 5", "T098" , "Row 3, slot 1", "Each", 12, 10, 26.0, 312.0);
        Inventory inv3 = new Inventory("Item 6", "T345" , "Row 2, slot 1", "Each", 7, 10, 50.0, 350.0);
        inv.insert("YE98762", inv1);
        inv.insert("XR23423", inv2);
        inv.insert("PW98762", inv3);

        assertEquals( 3, inv.size(), "size failed, size is not as expected");

    }
}