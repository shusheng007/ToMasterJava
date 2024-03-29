package top.ss007.reflection.type;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Shusheng007 on 2019/4/25.
 * 泛型类，参数为T 和 V
 */
public class TypeTest<T, V extends @Custom Number & Serializable> {
    private Number number;

    public T t;
    public V v;
    public List<T> list;
    public Map<String, T> map;

    public T[] tArray;
    public List<T>[] ltArray;

    public TypeTest testClass;
    public TypeTest<T, Integer> testClass2;

    public Map<? super String, ? extends Number> mapWithWildcard;

    //泛型构造函数,泛型参数为X
    public <X extends Number> TypeTest(X x, T t) {
        number = x;
        this.t = t;
    }

    //泛型方法，泛型参数为Y
    public <Y extends T> void method(Y y) {
        t = y;
    }
}
