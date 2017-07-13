package collection.map;

import net.mindview.util.Countries;

import java.util.*;

/**
 * 不考虑性能的map完整实现
 * Created by nsh on 2017/7/12 0012.
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values =new ArrayList<V>();

    public V put(K k,V v){
        V oldValue =get(k);
        if(!keys.contains(k)){
            keys.add(k);
            values.add(v);
        }else{
            values.set(keys.indexOf(k),v);
        }
        return oldValue;
    }

    public V get(Object k){
        if(!keys.contains(k))
            return null;
        return values.get(keys.indexOf(k));
    }
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> ki =keys.iterator();
        Iterator<V> vi =values.iterator();
        while (ki.hasNext())
            set.add(new MapEntry<K,V>(ki.next(), vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String,String> m =new SlowMap<String, String>();
        m.putAll(Countries.capitals(15));
        m.put("1","1");
        System.out.println( m.put("1","2"));
        System.out.println(m);
        System.out.println(m.get("BENIN"));
        System.out.println(m.entrySet());
        for(Map.Entry<String,String> m1:m.entrySet()){
            System.out.print(m1.getKey() +"**");
        }
    }
}
