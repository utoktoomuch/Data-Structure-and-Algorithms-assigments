package a1;

public class Node<K,E> {
    private K k;
    private E v;
    private Node<K,E> next;

    Node(K key, E val, Node<K, E> nextval){
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

    Node<K,E> setNext(Node<K,E> nextval) {
        return next = nextval;
    }
    K k(){
        return k;
    }

    K setK(K key){
        return k = key;
    }

    E v(){
        return v;
    }

    E setV(E val){
        return v = val;
    }


}
