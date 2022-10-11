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
        DNode<K, E> curr = list.head;
        DNode<K, E> tmp = null;

        if (curr != null &&  curr.k() == k){
            list.remove();
            list.cnt--;
            return curr.v();
        }
        while(curr != null && curr.k() != k){
            tmp = curr;
            curr = curr.next();
            if(curr == null){
                list.remove();
                list.cnt--;
                return curr.v();
            }

        }
        list.cnt--;

        tmp.setNext(curr.next());
        tmp.setPrev(curr.prev());
        return null;
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
        if(list.head != null){
            E tmp = list.getValue();
            list.remove();
            System.out.println(tmp +" was the value of the current node removed");
            return tmp;

        } else{
            return null;
        }
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
