package a1;

public class WarehouseInventory<SKU,Inventory> implements ADTDictionary<SKU, Inventory> {

    private LList<SKU, Inventory> InventoryList = new LList<>();

    WarehouseInventory(){
        LList<SKU, Inventory> InventoryList = new LList<>();
    }

    public void clear(){
        InventoryList.clear();
    }

    public void insert(SKU sku, Inventory inventory){
        InventoryList.insert(sku, inventory);
    }

    public Inventory find(SKU sku){
        if(InventoryList.head==null){
            return null;
        }
        Node<SKU,Inventory> curr = InventoryList.head;
        while(curr != null){
            if(curr.k() == sku){
                System.out.println(curr.v() + " is the value of the key found");
                return curr.v();
            }
            curr = curr.next();
        }
        return null;
    }

    public Inventory remove(SKU sku){
        return null;
    }
    
    public Inventory removeAny(){
        return null;
    }

    public int size(){
        System.out.println(InventoryList.length() + " is the length of the linked list");
        return InventoryList.length();
    }
}
