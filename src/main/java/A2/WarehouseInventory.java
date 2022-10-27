package A2;

public class WarehouseInventory<SKU,Inventory> implements ADTDictionary<SKU, Inventory> {

    //private Inventory inv;

    private A2.DLList<SKU, Inventory> InventoryList = new A2.DLList<>();

    WarehouseInventory(){
        A2.DLList<SKU, Inventory> InventoryList = new A2.DLList<>();
    }

    public void clear(){
        InventoryList.clear();
    }

    public void insert(SKU sku, Inventory inventory){
        InventoryList.insert(sku, inventory);
    }

    public Inventory find(SKU sku) {
        if (InventoryList.head == null) {
            return null;
        }
        A2.DNode<SKU, Inventory> curr = InventoryList.head;
        while (curr != null) {
            if (curr.k() == sku) {
                System.out.println(curr.v() + " <--- is the value associated to the key");
                return curr.v();
            }
            curr = curr.next();
        }
        return curr.v();
    }
    public Inventory remove(SKU sku){
        A2.DNode<SKU, Inventory> curr = InventoryList.head;
        DNode<SKU, Inventory> tmp = null;

        if (curr != null &&  curr.k() == sku){
            InventoryList.remove();
            InventoryList.cnt--;
            return curr.v();
        }
        while(curr != null && curr.k() != sku){
            tmp = curr;
            curr = curr.next();
            if(curr == null){
                InventoryList.remove();
                InventoryList.cnt--;
                return curr.v();
            }

        }
        InventoryList.cnt--;

        tmp.setNext(curr.next());
        return null;
    }

    public Inventory removeAny(){
        if(InventoryList.head != null){
            Inventory tmp = InventoryList.getValue();
            InventoryList.remove();
            return tmp;

        } else{
            return null;
        }
    }


    /**public double totalValue(){
        Node<SKU,Inventory> prev = null;
        Node<SKU,Inventory> curr = InventoryList.head;


        while(InventoryList.head != null && InventoryList.curr != null){
            prev = curr;
            curr = curr.next();

        }
        //a1.Inventory a = new a1.Inventory("Item 1", "T345" , "Row 2, slot 1", "Each", 20, 10, 30.0, 600.0);
        //System.out.println(a.i());
        //return a.i();
    }*/

    public int size() {
        System.out.println(InventoryList.length() + " is the length of the inventory list");
        return InventoryList.length();
    }

    @Override
    public Inventory[] createIndex(String attribute) {
        return null;
    }

    public void query(String attribute, double perct){

    }

}

