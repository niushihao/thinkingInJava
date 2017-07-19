package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by nsh on 2017/7/19 0019.
 */
public class ProxyHandler implements InvocationHandler{
    private Object objProxy;
    public ProxyHandler(Object objProxy){
        this.objProxy=objProxy;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("befo.......");
        method.invoke(objProxy,args);
        System.out.println("after......");
        return null;
    }
}
