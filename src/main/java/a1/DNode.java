package a1;

public class DNode<K,E> {

    private K k; // key for this node
    private E v; // value for this node

    private DNode<K,E> next; // for next node
    private DNode<K,E> prev; // for previous node

    DNode(K key, E val,DNode<K, E> prevval, DNode<K, E> nextval){ //Constructor #1
        k = key;
        v = val;
        prev =  prevval;
        next = nextval;
    }

    DNode(DNode<K, E> prevval, DNode<K, E> nextval){ //Constructor #2
        prev = prevval;
        next = nextval;
    }

    //Get & Set methods
    DNode<K,E> prev() {
        return prev;
    }
    DNode<K,E> setPrev(DNode<K, E> prevval){
        return prev = prevval;
    }

    DNode<K,E> next() {
        return next;
    }
    DNode<K,E> setNext(DNode<K, E> nextval){
        return next = nextval;
    }

    K k() {
        return k;
    }
    K setK(K key){
        return key = k;
    }

    E v(){
        return v;
    }
    E setV(E val){
        return val = v;
    }

 }
