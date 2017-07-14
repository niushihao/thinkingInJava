package collection.list;

import java.util.LinkedList;

/**
 * Created by nsh on 2017/7/14 0014.
 */
public class MyLinkedList {

    private Node first;
    private Node last;

    private int size;

    public void add(Object obj){
        Node n = new Node();
        if(first == null){
            n.self =obj;
            first =n;
            last =n;
        }else{
            n.self =obj;
            n.before =last;
            last.affter =n;
            last =n;
        }
        size++;
    }

    public Object get(int index){

        return null;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        //LinkedList
    }
}
