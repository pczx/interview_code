package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class CglibProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            Proxy proxy = new Proxy(value);
            Enhancer enhancer = new Enhancer();
            enhancer.setInterfaces(new Class[]{Comparable.class});
            enhancer.setCallback(proxy);
            Object o = enhancer.create();
            elements[i] = o;
        }

        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements, key);

        if (result >= 0) System.out.println(elements[result]);
    }
}

class Proxy implements MethodInterceptor {
    private Object target;

    public Proxy(Object target) {
        this.target = target;
    }

    public Object intercept(Object object, Method m, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.print(target);
        System.out.print("." + m.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");
        return methodProxy.invoke(target, args);
    }
}
