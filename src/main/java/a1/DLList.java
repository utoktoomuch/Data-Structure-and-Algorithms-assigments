package a1;

public class DLList<K,E> implements ADTList<K,E>{

    public DNode<K,E> head;
    public DNode<K,E> tail;
    public DNode<K,E> curr;
    public int cnt; // size of list

    public DLList(int size) {
        this();
    }

    public DLList(){
        curr = head = new DNode<>(null,null);
        tail = new DNode<>(head,null);
        head.setNext(tail);
        cnt = 0;
    }

    public void clear(){

    }

    @Override
    public void moveToStart() {

    }

    @Override
    public void moveToEnd() {

    }

    @Override
    public void insert(K key, E val) {

    }

    @Override
    public void append(K key, E val) {

    }

    @Override
    public E remove() {

    }

    public void prev(){

    }


    @Override
    public void next() {

    }

    @Override
    public int length() {

    }

    @Override
    public int currPos() {

    }

    @Override
    public void moveToPos(int pos) {

    }

    @Override
    public E getValue() {

    }

}
