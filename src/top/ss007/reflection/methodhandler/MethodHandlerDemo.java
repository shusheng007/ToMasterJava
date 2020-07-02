package top.ss007.reflection.methodhandler;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodHandlerDemo {

    public void handleNameGetter() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            //无参数构造器
            MethodType con1Mt = MethodType.methodType(void.class);
            MethodHandle con1Mh= lookup.findConstructor(HandleTarget.class,con1Mt);
            //有参数构造器
            MethodType con2Mt = MethodType.methodType(void.class, String.class);
            MethodHandle con2Mh= lookup.findConstructor(HandleTarget.class,con2Mt);

            //调用非private实例方法
            MethodType getterMt = MethodType.methodType(String.class);
            MethodHandle getterMh = lookup.findVirtual(HandleTarget.class, "getName", getterMt);
            String name = (String) getterMh.invoke(con2Mh.invokeWithArguments("书生007"));
            System.out.println(name);

            //调用静态方法
            MethodType decMt= MethodType.methodType(String.class,String.class);
            MethodHandle decMh= lookup.findStatic(HandleTarget.class,"declaration",decMt);
            String dec= (String) decMh.invoke("庄子");
            System.out.println(dec);


            //访问非private属性
//            MethodHandle nameMh= lookup.findGetter(HandleTarget.class,"name", String.class);
//            System.out.println((String) nameMh.invoke(con1Mh.invoke()));

            //访问private的属性，需要借助反射
            Field nameField= HandleTarget.class.getDeclaredField("name");
            nameField.setAccessible(true);
            MethodHandle nameFromRefMh= lookup.unreflectGetter(nameField);
            System.out.println((String) nameFromRefMh.invoke(con1Mh.invoke()));

            //访问private方法
            Method learnMethod= HandleTarget.class.getDeclaredMethod("learnPrograming",String.class);
            learnMethod.setAccessible(true);
            MethodHandle learnProMh= lookup.unreflect(learnMethod);
            learnProMh.invoke(con1Mh.invoke(),"Java");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
