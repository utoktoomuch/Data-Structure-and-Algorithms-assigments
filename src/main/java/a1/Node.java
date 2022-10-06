package a1;

public class Node<K,E> {
    private K k;
    private E v;
    private Node<K,E> next;
    private Node<K, E> prev;

    Node(K key, E val, Node<K,E> nextval){
        k = key;
        v = val;
        next = nextval;

    }

    Node(Node<K,E> nextval){
        next = nextval;
    }

    Node<K,E> next(){
        return next;
    }

    Node<K,E> setNext(Node<K,E> nextval){
        return next = nextval;
    }

    Node<K, E> prev() {
        return prev;
    }

    Node<K, E> setPrev(Node<K, E> prevval){
        return prev = prevval;
    }
    K k(){
        return k;
    }

    E v(){
        return v;
    }
   /* public Node(int key,double val ){
        this.key = key;
        this.val = val;

    }


    public int getKey(){
        return key;
    }

    public void setKey(int k){
        key  = k;
    }

    public double getVal(){
        return val;
    }

    public void setVal(double v){
        val = v;
    }*/

}
