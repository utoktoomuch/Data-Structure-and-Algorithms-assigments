package A2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class WarehouseInventory<SKU,Inventory extends Comparable<Inventory>> implements ADTDictionary<SKU, Inventory> {

    //private Inventory inv;

    private LList<SKU, Inventory> InventoryList;

    WarehouseInventory(){
        A2.LList<SKU, Inventory> InventoryList = new A2.LList<>();
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
        A2.Node<SKU, Inventory> curr = InventoryList.head;
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
        A2.Node<SKU, Inventory> curr = InventoryList.head;
        Node<SKU, Inventory> tmp = null;

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


    public int size() {
        System.out.println(InventoryList.length() + " is the length of the inventory list");
        return InventoryList.length();
    }

    @Override
    public Inventory[] createIndex() {
        List<Node<SKU,Inventory>> newlist = new ArrayList<>();
        int i = 0;
        for (this.InventoryList.moveToStart(); this.InventoryList.curr != null; this.InventoryList.next()){
            newlist.add(new Node<SKU, Inventory>((SKU) Integer.valueOf(i), this.InventoryList.currPos().getData().v()));
        }
        return null;
    }

    public void quicksort (List<Node<SKU, Inventory>> InventoryList, int start, int end) {
        int qs;

        if (end > start){
            qs = partition(InventoryList, start, end);
            quicksort(InventoryList, start, qs - 1);
            quicksort(InventoryList, qs + 1, end);
        }
    }

    int partition(List<Node<SKU, Inventory>> InventoryList, int start, int end){
        Inventory P = InventoryList.get(start).v();
        int i = start;
        int j = end + 1;

        for(;;){
            while(InventoryList.get(++i).v().compareTo(P) < 0){
                if (i >= end){
                    break;
                }
            }

            while (InventoryList.get(--j).v().compareTo(P) > 0){
                if (j <= start){
                    break;
                }
            }
            if (i >= j){
                break;
            } else {
                Collections.swap(InventoryList, i , j);
            }
        }
        if (j == start){
            return j;
        }
        Collections.swap(InventoryList, start, j);
        return j;

    }

    public void query(String attribute, double perct){

    }

}



