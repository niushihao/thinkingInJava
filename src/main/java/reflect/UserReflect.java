package reflect;


import pojo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by nsh on 2017/7/31.
 */
public class UserReflect {


    public static void demo1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //Class c =Class.forName("User"); 错误写法，必须是全路径名
        //Class c = User.class;
       /* User u = new User();
        Class c =u.getClass();*/
        Class c =Class.forName("pojo.User");
        Object o =c.newInstance();
        getFields(c,o);
        getMethods(c,o);
    }

    //获取所有属性,并为属性赋值
    public static void getFields(Class c,Object o ) throws IllegalAccessException {
        //获取所有属性
        //Field[] fieldields =c.getFields();
        //获取所有属性,要想获取所有父类的属性需要遍历
        Field[] fieldields =c.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        //通过追加的方法，将每个属性拼接到此字符串中
        //最外边的public定义
        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");
        //里边的每一个属性
        for(Field field:fieldields){
            sb.append("\t");//空格
            sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等
            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
            sb.append(field.getName()+";\n");//属性的名字+回车
            //并为这些属性赋值
            //打破封装
            field.setAccessible(true);
            field.set(o,"test");
        }

        sb.append("}");

        System.out.println(sb);
        System.out.println(o);
    }
    //获取所有方法
    public static void getMethods(Class c,Object o) throws InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
       //获取当前类和父类的所有能访问的共有方法
        //Method[] methods =c.getMethods();
        //获取当前类的所有方法
        Method[] methods =c.getDeclaredMethods();
        for(Method m:methods){
            sb.append("\t");//空格
            sb.append(Modifier.toString(m.getModifiers())+" ");
            sb.append(m.getReturnType().getSimpleName()+" ");
            sb.append(m.getName()+":\n");
            //调用方法，为属性赋值
            m.setAccessible(true);
            if(m.getName().contains("set")){
                m.invoke(o,"123");
            }
            if(m.getName().contains("get")){
                m.invoke(o,null);
            }
        }
        System.out.println(sb);
        System.out.println(o);
    }
    public static void main(String[] args) {
        try {
            demo1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
