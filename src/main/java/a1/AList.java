package a1;

import java.sql.SQLOutput;

public class AList<K, E> implements ADTList<K,E>{

    private Node<K, E> head;
    private Node<K,E> tail;
    protected Node<K,E> curr;

    private Node<K,E> next;

    private static int counter;
    //private Node head;

    public AList(){
        next = curr = tail = head = new Node<K, E>(null);
        counter = 0;
    }


    public void clear(){
        head.setNext(null);
        curr=tail=head=new Node<K,E>(null);
        counter = 0;
    }

    public void insert(K k, E e){

        curr.setNext(new Node<K,E>(k, e, curr.next()));

        if (tail==curr)
            tail = curr.next();
        counter++;

    }

    public E remove(K k){
        /*if(curr.next() == null)
            return null;

        E e = curr.next().v();

        if (tail == curr.next())
            tail = curr; */
        Node<K, E> curr = head;
        Node <K,E> prev = null;

        if(curr != null && curr.k() == k){ //if the header has the specified key
            E e = head.v();
            head = curr.next();

            System.out.println(k + " found and deleted");
            System.out.println(e + " was the value");
            return e;
        }

        while(curr != null && curr.k() != k){ //if k value is not in the header
            prev = curr;
            curr = curr.next();

            if(curr == k){
                prev.next().setNext(curr.next());
                counter--;
                System.out.println(k + " found and deleted");
                System.out.println(curr.v() + " was the value");
                return curr.v();

            }
        }


        if(curr == null) { // if key is not present
            System.out.println(k + " not found");
            return null;
        }
        return null;
    }

    public E removeAny(){

        if(curr.next() == null) {

            E e = curr.v();
            counter--;
            return e;
        } else{
            return null;
        }
    }

    public E find(K k){
        Node<K, E> curr = head, prev = null;

        if(curr != null && curr.k() == k){ //if the curr already has the specified key

            System.out.println(k + " found");
            System.out.println(curr.v() + " is the value");
            return curr.v();

        }

        while(curr != null && curr.k() != k){ //if k value is not in the header
            prev = curr;
            curr = curr.next();
        }
        if(curr != null){
            System.out.println(k + " found");
            System.out.println(curr.v() + " is the value");
            return curr.v();

        }

        if(curr == null){ // if key is not present
            System.out.println(k + " not found");
            return null;
        }
        return null;
    }

    public int size(){
        System.out.println("Size: "+ counter );
        return counter;
    }

}

