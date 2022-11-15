package A2;

import a1.Inventory;
import a1.WarehouseInventory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseInventory2Test {
    private static WarehouseInventory2 inv;

    @BeforeAll

    public static void setUp() {
        inv = new WarehouseInventory2();
        //dict = new LLDictionary<String, InventoryRecord>(10);
    }

    @Test
    void query1() {

        Inventory2 inv1 = new Inventory2("Item 1", "Desc 2", 51.0, 25, 1275.0, 29, 13, 50);
        Inventory2 inv2 = new Inventory2("Item 5", "Desc 5" , 76.0, 62, 4650.0, 39, 12, 50);
        Inventory2 inv3 = new Inventory2("Item 6", "Desc 6" , 11.0, 5, 55.0, 9, 13, 150);
        inv.insert("YE98762", inv1);
        inv.insert("XR23423", inv2);
        inv.insert("PW98762", inv3);

        inv.query("UnitPrice", 0.5);
        // we should get 51 as the result
        //assertEquals(51.0, inv.query("UnitPrice", 0.5), "failed blah blah");

    }
    @Test
    void query2() {

        Inventory2 inv1 = new Inventory2("Item 1", "Desc 2", 51.0, 25, 1275.0, 29, 13, 50);
        Inventory2 inv2 = new Inventory2("Item 5", "Desc 5" , 76.0, 62, 4650.0, 39, 12, 50);
        Inventory2 inv3 = new Inventory2("Item 6", "Desc 6" , 11.0, 5, 55.0, 9, 13, 150);
        inv.insert("YE98762", inv1);
        inv.insert("XR23423", inv2);
        inv.insert("PW98762", inv3);

        // Inventory is indexed in descending order so [0] is the biggest ...[N] is the smallest
        inv.query("QtyInStock", 0.0);
        // we should get 5 as the result
        //assertEquals(5, inv.query("QtyInStock", 0.5), "failed blah blah");

        inv.query("UnitPrice", 0.7);
        // we should get 11 as the result
    }

}