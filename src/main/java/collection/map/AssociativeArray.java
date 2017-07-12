package collection.map;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

/**
 * 此对象模拟了基本的map 实现，首先构建一个二维数组，以为数组用来控制长度，二维的长度为2用来放key,value。
 * Created by nsh on 2017/7/12 0012.
 */
public class AssociativeArray<K,V> {

    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length){
        pairs =new Object[length][2];
    }

    public void put(K key,V value){
        if(index >=pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key,value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        }
        return null;
    }

     public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<index;i++){
            sb.append(pairs[i][0].toString());
            sb.append(" : ");
            sb.append(pairs[i][1].toString());
            if(i<index-1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        testSelfMap();
        testHashMap();
    }

    /**
     * 测试自己实现的map
     */
    private static void testSelfMap() {
        AssociativeArray<String,String> map =new AssociativeArray<String, String>(6);
        map.put("sky","blue");
        map.put("grass","green");
        map.put("ocean","dancing");
        map.put("tree","tall");
        map.put("earth","brown");
        map.put("sun","warm");
        try{
            map.put("extra","object");
        }catch (ArrayIndexOutOfBoundsException e){
            print("Too many objects");

        }
        print(map);
        print(map.get("ocean"));
        print("**************************selfMap END***********************");
    }


    private static void testHashMap(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("sky","blue");
        map.put("grass","green");
        map.put("ocean","dancing");
        map.put("tree","tall");
        map.put("earth","brown");
        map.put("sun","warm");
        try{
            map.put("extra","object");
        }catch (ArrayIndexOutOfBoundsException e){
            print("Too many objects");

        }
        print(map);
        print(map.get("ocean"));
    }
}
