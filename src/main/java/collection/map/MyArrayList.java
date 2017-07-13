package collection.map;

/**
 * mini arrayList
 * Created by nsh on 2017/7/13.
 */
public class MyArrayList {

    int size;
     static  Object[] value;
    public MyArrayList(){
        value = new Object[16];
    }

    public MyArrayList(int size){
        value = new Object[size];
    }

    public void add(Object o){
        value[size] =o;
        size++;
        if(size >=value.length){
            Object[] newObj = new Object[size*2];
            System.arraycopy(value,0,newObj,0,size);
            value =newObj;
        }
    }

    public Object get(int index){
        return value[index];
    }

    public int size(){
        return size;
    }

    public int indexof(Object o){
        if(value.length >0){
            for(int i=0;i<=size;i++){
                if(o ==value[i]){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(2);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        System.out.println(value.length);
        System.out.println(list.indexof(5));
    }
}
