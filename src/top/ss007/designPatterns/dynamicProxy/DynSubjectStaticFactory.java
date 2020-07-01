package top.ss007.designPatterns.dynamicProxy;


import top.ss007.designPatterns.proxy.RealSubject;
import top.ss007.designPatterns.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Ben.Wang on 2018/6/27.
 */
public class DynSubjectStaticFactory {
    public static Subject getInstance() {
        Subject delegate = new RealSubject();
        InvocationHandler handler = new SubjectInvocationHandler(delegate);
        Subject proxy = (Subject) Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), handler);
        return proxy;
    }
}
