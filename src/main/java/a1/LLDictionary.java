//Assignment 1, Question 1

package a1;

import java.sql.SQLOutput;

public class LLDictionary<K, E> implements ADTDictionary<K,E> {

    private LList<K,E> list;

    /** Constructors */
     LLDictionary(){
        LList<K,E> list = new LList<>();
    }

    /** Clean */
    public void clear(){
        list.head.setNext(null);
        list.curr = list.tail = list.head =new Node<K,E>(null);
        list.cnt = 0;
    }

    /** Insert */
    @Override
    public void insert(K k, E e) {
        list.insert(k,e);
    }

    public E remove(K k){
        Node<K,E> prev = null;
        if(list.head != null && list.head.k() == k){ // if head contains the key
            E e = list.head.v();
            list.head = list.head.next();
            return e;
        }

        while(list.head != null && list.head.k() != k){
            prev = list.head;
            list.head = list.head.next();

        }

        if(list.head == k){
            list.head.setNext(list.head.next().next());

            return list.head.v();
        }
        return null;
    }

    public E removeAny(){
        if(list.curr.next() == null) {

            E e = list.curr.v();
            list.cnt--;
            return e;
        } else{
            return null;
        }
    }

    public E find(K k){
        if(list.head==null){
            return null;
        }
        Node<K,E> curr = list.head;
        while(curr != null){
            if(curr.k() == k){
                System.out.println(curr.v() + " <-- Is the value of the key");
                return curr.v();
            }
            curr = curr.next();
        }
        return null;
    }

    public int size(){
        System.out.println(list.length() + " <-- This is the length");
        return list.length();
    }
}
