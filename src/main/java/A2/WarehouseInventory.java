package A2;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class WarehouseInventory<SKU,Inventory extends Comparable<Inventory>> implements ADTDictionary<SKU, Inventory> {

    private Inventory inv;



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
    public A2.Inventory[] createIndex(String attribute) {
        final Inventory[] copyInventory = copyInventory();

        if(attribute.equals("UnitPrice")){
            return null;
        } else if (attribute.equals("QtyInStock")){
            return null;
        } else if (attribute.equals("InvValue")){
            return null;
        } else if(attribute.equals("ReorderL")){
            return null;
        } else if(attribute.equals("ReorderT")){
            return null;
        } else if(attribute.equals("QtyReorder")){
            return null;
        }
        return copyInventory;
    }

    private Inventory[] copyInventory(){

        Inventory[] copy = new Inventory[InventoryList.length()];

        int i = 0;
        for (InventoryList.moveToStart(); InventoryList.currPos() < InventoryList.length(); InventoryList.next()){
            final Inventory value = InventoryList.getValue();
            copy[i++] = value;
        }
        return copy;
    }

    public void quicksort (Inventory[] copy, int start, int end, String attribute) {//ask TA about how to access specific attribute
        int qs;
                                                       //Asymptotic Analysis:
        if (end > start){                              //Time Complexity: O(nlogn)
            qs = partition(copy, start, end);          //Space Complexity: O(n)
            quicksort(copy, start, qs);
            quicksort(copy, qs + 1, end);
        }

    }

    int partition(Inventory[] copy, int start, int end){
        Inventory P = copy[start];
        int i = start;

        for(int j = start + 1; j <= end; j++){
            if(copy[j].compareTo(P) > 0) {
                i++;
                Inventory tmp = copy[i];
                copy[i] = copy[j];
                copy[j] = tmp;
            }
        }
        Inventory tmp = copy[i];
        copy[i] = copy[start];
        copy[start] = tmp;
        return i;
    }

    private void swap(Inventory[] arr, int i, int j){
        Inventory tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    @Override
    public BSTNode<Inventory> createBSTIndex(String attribute){

        //build bst

        return null; //return root of the tree
    }

    public Inventory[] ascendingOrder(BSTNode<Inventory> root){

        //ascending order result
        return null;
    }

    @Override
    public void query(String attribute, double perct){

    }


}



