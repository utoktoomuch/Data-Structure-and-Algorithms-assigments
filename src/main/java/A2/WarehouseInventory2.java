package A2;

import java.sql.SQLOutput;

public class WarehouseInventory2 implements ADTDictionary<String, Inventory2> {

    private Inventory2 inv;
    private String String;

    private LList<String, Inventory2> Inventory2List = new LList<>();

    WarehouseInventory2(){
        A2.LList<String, Inventory2> Inventory2List = new A2.LList<>();
    }

    public void clear(){
        Inventory2List.clear();
    }

    public void insert(String string, Inventory2 inventory2){
        Inventory2List.insert(string, inventory2);

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
            quicksort(copyInventory2,0, copyInventory().length-1, "UnitPrice");
            return copyInventory2;
        } else if (attribute.equals("QtyInStock")){
            quicksort(copyInventory2,0, copyInventory().length-1, "QtyInStock");
            return copyInventory2;
        } else if (attribute.equals("InvValue")){
            quicksort(copyInventory2,0, copyInventory().length-1, "InvValue");
            return copyInventory2;
        } else if(attribute.equals("ReorderL")){
            quicksort(copyInventory2,0, copyInventory().length-1, "ReorderL");
            return copyInventory2;
        } else if(attribute.equals("ReorderT")){
            quicksort(copyInventory2,0, copyInventory().length-1, "ReorderT");
            return copyInventory2;
        } else if(attribute.equals("QtyReorder")){
            quicksort(copyInventory2,0, copyInventory().length-1, "QtyReorder");
            return copyInventory2;
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
        if (end > start){                                         //Time Complexity: O(nlogn)
            qs = partition(copy, start, end, attribute);          //Space Complexity: O(n)
            quicksort(copy, start, qs, attribute);
            quicksort(copy, qs + 1, end, attribute);
        }

    }


    int partition(Inventory2[] copy, int start, int end,String attribute){
        Inventory2 P = copy[start];
        int i = start;

        if(attribute.equals("UnitPrice")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].p() > copy[start].p()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("QtyInStock")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].q() > copy[start].q()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("InvValue")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].i() > copy[start].i()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("ReorderL")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].rl() > copy[start].rl()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("ReorderT")){
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].rt() > copy[start].rt()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("QtyReorder")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].rq() > copy[start].rq()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        }
        swap(copy, i, start);
        return i;
    }

    private void swap(Inventory2[] arr, int i, int j){
        Inventory2 tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    @Override
   /* public BSTNode<Inventory2> createBSTIndex(String attribute){

        BSTNode<Inventory2> BST = new BSTNode<Inventory2>();
        final Inventory2[] inventory = copyInventory(); // array of inventories that become BST

       //BST.setElement(inventory[0]); initial root
        int i = 0;
        if(attribute.equals("UnitPrice")){
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].p() < inventory[i-1].p() ) {
                        BST.setLeft(inventory[i]);  //check if this work in unit testing
                } else {
                    BST.setRight(inventory[i]); //check if this work in unit testing
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("QtyInStock")) {
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].q() < inventory[i-1].q() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("InvValue")) {
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                for (i=)
                if (inventory[i].i() < inventory[i-1].i() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("ReorderL")) {
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].rl() < inventory[i-1].rl() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("ReorderT")) {
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].rt() < inventory[i-1].rt() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("QtyReorder")) {

            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].rq() < inventory[i-1].rq() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        }

        return BST; //return root of the tree
    }*/

   /** private BSTNode addRecursive(Inventory2[] arr,BSTNode current, String attribute,int i){
        if(current==null){
            return new BSTNode(attribute);
        }

        if (attribute.equals("UnitPrice")){
            if(arr[i+1].p() < arr[i].p()){
                current.setLeft(addRecursive(arr,current.left(),attribute,i));
            }
            else if (arr[i+1].p() > arr[i].p()){
                current.setRight(addRecursive(arr,current.right(),attribute,i));
            } else {
                return current;
            }
        }
        return current;
    }**/

    public void ascendingOrder(BSTNode<Inventory2> root){
        inOrderTraversing(root);
        //ascending order result
        //return null;
    }

    public void inOrderTraversing(BSTNode<Inventory2> BST){
        if (BST != null){
            inOrderTraversing(BST.left());
            inOrderTraversing(BST.right());
        }
    }

    @Override
    public void query(String attribute, double perct){

        Inventory2[] qInv = createIndex(attribute);

        int N = qInv.length;
        int pivot = (int) (N * perct); //no need for lower bound because int truncates no matter the value after the dot

        if ( attribute.equals("UnitPrice")){
            if (perct == 0){
                double result = qInv[0].p();
                System.out.println("The percentile "+ perct +" of Unit Price is: " + result);
            } else if (perct == 1){
                double result = qInv[N-1].p();
                System.out.println("The percentile "+ perct +" of Unit Price is: " + result);
            } else {
                double result = qInv[pivot - 1].p();
                System.out.println("The percentile "+ perct +" of Unit Price is: " + result);
            }
        } else if (attribute.equals("QtyInStock")) {
            if (perct == 0){
                int result = qInv[0].q();
                System.out.println("The percentile "+ perct +" of Quantity in Stock is: " + result);
            } else if (perct == 1){
                int result = qInv[N-1].q();
                System.out.println("The percentile "+ perct +" of Quantity in Stock is: " + result);
            } else {
                int result = qInv[pivot - 1].q();
                System.out.println("The percentile "+ perct +" of Quantity in Stock is: " + result);
            }
        } else if (attribute.equals("InvValue")){
            if (perct == 0){
                double result = qInv[0].i();
                System.out.println("The percentile "+ perct +" of Inventory Value is: " + result);
            } else if (perct == 1){
                double result = qInv[N-1].i();
                System.out.println("The percentile "+ perct +" of Inventory Value is: " + result);
            } else {
                double result = qInv[pivot - 1].i();
                System.out.println("The percentile "+ perct +" of Inventory Value is: " + result);
            }
        } else if (attribute.equals("ReorderL")) {
            if (perct == 0){
                int result = qInv[0].rl();
                System.out.println("The percentile "+ perct +" of Reorder Level is: " + result);
            } else if (perct == 1){
                int result = qInv[N-1].rl();
                System.out.println("The percentile "+ perct +" of Reorder Level is: " + result);
            } else {
                int result = qInv[pivot - 1].rl();
                System.out.println("The percentile "+ perct +" of Reorder Level is: " + result);
            }
        } else if (attribute.equals("ReorderT")) {
            if (perct == 0){
                int result = qInv[0].rt();
                System.out.println("The percentile "+ perct +" of Reorder Time is: " + result);
            } else if (perct == 1){
                int result = qInv[N-1].rt();
                System.out.println("The percentile "+ perct +" of Reorder Time is: " + result);
            } else {
                int result = qInv[pivot - 1].rt();
                System.out.println("The percentile "+ perct +" of Reorder Time is: " + result);
            }
        } else if (attribute.equals("QtyReorder")) {
            if (perct == 0){
                int result = qInv[0].rq();
                System.out.println("The percentile "+ perct +" of Reorder Quantity is: " + result);
            } else if (perct == 1){
                int result = qInv[N-1].rq();
                System.out.println("The percentile "+ perct +" of Reorder Quantity is: " + result);
            } else {
                int result = qInv[pivot - 1].rq();
                System.out.println("The percentile "+ perct +" of Reorder Quantity is: " + result);
            }
        } else {
            System.out.println("Invalid attribute, please type an attribute that is an integer or double");
        }

    }



}




