package proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * Created by nsh on 2017/7/19 0019.
 */
public class Test {

    public static void main(String[] args) {
        SubjectImpl impl =new SubjectImpl();
        Subject proxySubject  = (Subject) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{Subject.class},new ProxyHandler(impl));
        proxySubject.doSomething();
        createProxyClassFile();
    }

    public static void createProxyClassFile()
    {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass( name, new Class[] { Subject.class } );
        try
        {
            FileOutputStream out = new FileOutputStream( name + ".class" );
            out.write( data );
            out.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
