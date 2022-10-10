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


    }

    public E removeAny(){

    }

    public E find(K k){

    }

    public int size(){
        System.out.println(list.length() + "<-- this is the length of DLList");
       return list.length();
    }


}
