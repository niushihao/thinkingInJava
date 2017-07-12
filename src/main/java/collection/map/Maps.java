package collection.map;

import net.mindview.util.CountingMapData;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * Created by nsh on 2017/7/12 0012.
 */
public class Maps {

    public static void prientKeys(Map<Integer,String> map){

        printnb("size ="+ map.size() + ",");
        printnb("keys :");
        print(map.keySet());
    }

    public static void test(Map<Integer,String> map){
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));

        map.putAll(new CountingMapData(25));
        prientKeys(map);
        print("values: ");
        print(map.values());
        print(map);
        print("map.containsKey(11): "+map.containsKey(11));
        print(map.get(11));
        print("map.containsValue() :"+map.containsValue("F0"));
        Integer key =map.keySet().iterator().next();
        print("First key in map: "+key);
        map.remove(key);
        prientKeys(map);
        map.clear();
        print("map.isempty(): "+map.isEmpty());
        map.putAll(new CountingMapData(25));

        map.keySet().removeAll(map.keySet());
        print("map.isempty(): "+map.isEmpty());
    }

    public static void main(String[] args) {
        //test(new HashMap<Integer, String>());
        //test(new TreeMap<Integer, String>());
        //testTreeMap(new TreeMap<Integer,String>());
        testLinkedHashMap(new LinkedHashMap<Integer,String>(16, (float) 0.75,true));
    }

    /**
     * 测试linkedHashMap,最少访问排序
     * 默认按照插入顺序访问，在构造方法指定基于访问排序后他会在插入顺序的基础上把最近访问的放在最后
     * @param linkedHashMap
     */
    private static void testLinkedHashMap(LinkedHashMap<Integer, String> linkedHashMap) {
        linkedHashMap.putAll(new CountingMapData(10));
        print(linkedHashMap);
        for(int i =0;i<=6;i++)
            linkedHashMap.get(i);
        print(linkedHashMap);
        linkedHashMap.get(0);
        print(linkedHashMap);
    }

    /**
     * treeMap是按照键的值排序
     * @param treeMap
     */
    private static void testTreeMap(TreeMap<Integer, String> treeMap) {

        treeMap.put(15,"15");
        treeMap.put(8,"8");
        treeMap.put(3,"3");
        treeMap.put(10,"10");
        treeMap.put(1,"1");
        prientKeys(treeMap);
    }

}
