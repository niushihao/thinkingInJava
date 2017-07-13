package collection.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nsh on 2017/7/13 0013.
 */
public class Sets {

    public static void main(String[] args) {
        Set<User> set = new HashSet<User>();
       User u =new User();
       u.setAge("5");
        set.add(u);
        u.setAge("7");
        System.out.println(set.add(u));
        System.out.println(set);
        for (User str:set) {
            System.out.println(str.getAge());
        }
    }
}
