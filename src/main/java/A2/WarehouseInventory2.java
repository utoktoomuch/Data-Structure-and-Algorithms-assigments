package A2;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class WarehouseInventory2 implements ADTDictionary<String, Inventory2> {

    private Inventory2 inv;



    private LList<String, Inventory2> Inventory2List;

    WarehouseInventory2(){
        A2.LList<String, Inventory2> Inventory2List = new A2.LList<>();
    }

    public void clear(){
        Inventory2List.clear();
    }

    public void insert(String String, Inventory2 Inventory2){
        Inventory2List.insert(String, Inventory2);
    }

    public Inventory2 find(String String) {
        if (Inventory2List.head == null) {
            return null;
        }
        A2.Node<String, Inventory2> curr = Inventory2List.head;
        while (curr != null) {
            if (curr.k() == String) {
                System.out.println(curr.v() + " <--- is the value associated to the key");
                return curr.v();
            }
            curr = curr.next();
        }
        return curr.v();
    }
    public Inventory2 remove(String String){
        A2.Node<String, Inventory2> curr = Inventory2List.head;
        Node<String, Inventory2> tmp = null;

        if (curr != null &&  curr.k() == String){
            Inventory2List.remove();
            Inventory2List.cnt--;
            return curr.v();
        }
        while(curr != null && curr.k() != String){
            tmp = curr;
            curr = curr.next();
            if(curr == null){
                Inventory2List.remove();
                Inventory2List.cnt--;
                return curr.v();
            }

        }
        Inventory2List.cnt--;

        tmp.setNext(curr.next());
        return null;
    }

    public Inventory2 removeAny(){
        if(Inventory2List.head != null){
            Inventory2 tmp = Inventory2List.getValue();
            Inventory2List.remove();
            return tmp;

        } else{
            return null;
        }
    }


    public int size() {
        System.out.println(Inventory2List.length() + " is the length of the Inventory2 list");
        return Inventory2List.length();
    }

    @Override
    public Inventory2[] createIndex(String attribute) {
        final Inventory2[] copyInventory2 = copyInventory();

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
        return copyInventory2;
    }

    private Inventory2[] copyInventory(){

        Inventory2[] copy = new Inventory2[Inventory2List.length()];

        int i = 0;
        for (Inventory2List.moveToStart(); Inventory2List.currPos() < Inventory2List.length(); Inventory2List.next()){
            final Inventory2 value = Inventory2List.getValue();
            copy[i++] = value;
        }
        return copy;
    }

    public void quicksort (Inventory2[] copy, int start, int end, String attribute) {//ask TA about how to access specific attribute
        int qs;

        //Asymptotic Analysis:
        if (end > start){                              //Time Complexity: O(nlogn)
            qs = partition(copy, start, end);          //Space Complexity: O(n)
            quicksort(copy, start, qs);
            quicksort(copy, qs + 1, end);
        }

    }

    int partition(Inventory2[] copy, int start, int end){
        Inventory2 P = copy[start];
        int i = start;

        for(int j = start + 1; j <= end; j++){
            if(copy[j].compareTo(P) > 0) {
                i++;
                Inventory2 tmp = copy[i];
                copy[i] = copy[j];
                copy[j] = tmp;
            }
        }
        Inventory2 tmp = copy[i];
        copy[i] = copy[start];
        copy[start] = tmp;
        return i;
    }

    private void swap(Inventory2[] arr, int i, int j){
        Inventory2 tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    @Override
    public BSTNode<Inventory2> createBSTIndex(String attribute){

        BSTNode<Inventory2> BST = new BSTNode<Inventory2>();

        if(attribute.equals("UnitPrice")){
            BST
        }

        return null; //return root of the tree
    }

    public Inventory2[] ascendingOrder(BSTNode<Inventory2> root){

        //ascending order result
        return null;
    }

    @Override
    public void query(String attribute, double perct){

    }


}




