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
        head.setNext(null);
        curr = head = new DNode<>(null,null);
        tail = new DNode<>(head,null);
        head.setNext(tail);
        cnt = 0;
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        curr = tail.prev();
    }

    @Override
    public void insert(K key, E val) {
        curr.setNext(new DNode<K,E>(key,val, curr, curr.next()));
        curr.next().next().setPrev(curr.next());
        cnt++;
    }

    @Override
    public void append(K key, E val) {
        tail.setPrev(new DNode<K,E>(key,val, tail.prev(), tail));
        tail.prev().prev().setNext(tail.prev());
        cnt++;
    }

    @Override
    public E remove() {
        if (curr.next() == tail) return null; // Nothing to remove
        E it = curr.next().v();      // Remember value
        curr.next().next().setPrev(curr);
        curr.setNext(curr.next().next());  // Remove from list
        cnt--;			     // Decrement the count
        return it;                         // Return value removed
    }

    public void prev(){
        if (curr != head)   // Can't back up from list head
            curr = curr.prev();
    }


    @Override
    public void next() {
        if (curr != tail.prev())
            curr = curr.next();
    }

    @Override
    public int length() {
        return cnt;
    }

    @Override
    public int currPos() {
        DNode<K,E> temp = head;

        int i;
        for (i=0; curr != temp; i++)
            temp = temp.next();
        return i;
    }

    @Override
    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=cnt) : "Position out of range";
        curr = head;
        for(int i=0; i<pos; i++)
            curr = curr.next();

    }

    @Override
    public E getValue() {
        if (curr.next() == tail)
            return null;
        return curr.next().v();

    }

}
