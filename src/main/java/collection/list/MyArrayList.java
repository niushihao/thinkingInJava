package collection.list;

import java.util.ArrayList;
import java.util.List;

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

    public boolean add(Object o){
        value[size] =o;
        size++;
        if(size >=value.length){
            Object[] newObj = new Object[size*2];
            System.arraycopy(value,0,newObj,0,size);
            value =newObj;
            return true;
        }
        return false;
    }

    public void add(int index,Object obj){
        //检查下边是否越界
        rangeCheckForAdd(index);
        //判断是否需要扩容
        if(index ==value.length){
            Object[] newObj = new Object[size*2];
            System.arraycopy(value,0,newObj,0,size);
            value =newObj;
        }
        //将数组指定位置添加
        System.arraycopy(value,index,value,index+1,size-index);
        value[index] =obj;

    }

    public void remove(int index){
        //检查下边是否越界
        rangeCheckForAdd(index);

        System.arraycopy(value,index+1,value,index,size-index-1);
        size--;
    }

    public void remove(Object obj){
        //检查下边是否越界
        remove(indexof(obj));
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



    private void rangeCheckForAdd(int index){
        if (index >= size || index < 0) {
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add("5");
        //list.add(0,111);
        list.remove(2);
        list.remove("5");
      for (int i =0;i<list.size;i++){
          System.out.println("第"+i+"个元素为 ："+list.get(i));
      }
        List l = new ArrayList();
        l.add(1,"123");
        l.remove(1);
       l.clear();
    }
}
