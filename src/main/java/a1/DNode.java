package a1;

public class DNode<K,E> {
    private K k; // key for this node
    private E v; // value for this node
    private DNode<K,E> next; // pointer to next node
    private DNode<K,E> prev;

    DNode(K key, E val, Node<K, E> nextval){
        k = key;
        v = val;
        next = nextval;

    }
 }
