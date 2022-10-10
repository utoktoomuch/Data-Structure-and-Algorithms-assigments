package a1;

import java.sql.SQLOutput;

public class DLListDictionary<K,E> implements ADTDictionary<K,E> {

    private DLList<K,E> list = new DLList<>();

    DLListDictionary(){
        DLList<K,E> list = new DLList<>();
    }

    /** Clean*/
    public void clear(){
        list.clear();
    }

    /** Insert*/
    @Override
    public void insert(K k, E e) {
        list.insert(k,e);
    }

    public E remove(K k){
        list.remove();
        System.out.println(list.getValue() + "<--- pls be correct");
        return list.getValue();
       /** DNode<K,E> prev = null;

        if(list.head != null && list.head.k() == k){ // if head contains the key for removal
            E e = list.head.v();
            list.head = list.head.next();
            list.head.setPrev(null);
            return e;
        }


        while(list.head != null && list.head.k() != k){ // head not ok look for it
            prev = list.head;
            list.head = list.head.next();
        }

        if(list.head == k){
            list.head.setNext(list.head.next().next());
            list.head.setPrev((list.head.prev().prev()));
            System.out.println(list.head.v() + " <--- this is the val");
            return list.head.v();
        }
        return null;
        */
    }

    public E removeAny(){
        return null;
    }

    public E find(K k){
        if(list.head==null){
            return null;
        }
       DNode<K,E> curr = list.head;

        while(curr != null){
            if(curr.k() == k){
                System.out.println(curr.v() + " is the value of the key found");
                return curr.v();
            }
            curr = curr.next();
        }
        return null;
    }

    public int size(){
        System.out.println(list.length() + "<-- this is the length of DLList");
       return list.length();
    }


}
