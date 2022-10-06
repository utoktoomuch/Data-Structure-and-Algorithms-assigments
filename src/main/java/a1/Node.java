package a1;

public class Node {
    private int key;
    private double val;


    public Node(int key,double val ){
        this.key = key;
        this.val = val;

    }


    public int getKey(){
        return key;
    }

    public void setKey(int k){
        key  = k;
    }

    public double getVal(){
        return val;
    }

    public void setVal(double v){
        val = v;
    }

}
