package top.ss007.reflection.methodhandler;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class HandleTarget extends HandleTargetFather{
    private String name = "hello world";

    public HandleTarget() {
    }

    public HandleTarget(String name) {
        this.name = name;
    }

    public void connectName(String name) {
        this.name = this.name + " " + name;
    }

    @Override
    public String getName() {
        return name;
    }

    private void learnPrograming(String lang) {
        System.out.println(String.format("I am learning %s ", lang));
    }

    public static String declaration(String author) {
        return author + ": " + "吾生也有涯，而知也无涯。以有涯随无涯，殆己";
    }

    public void invokeSpecial(){
        MethodHandles.Lookup lookup=MethodHandles.lookup();
        MethodType learnMt = MethodType.methodType(String.class);
        try {
            MethodHandle learnMh= lookup.findSpecial(HandleTargetFather.class,"getName",learnMt, HandleTarget.class);
            System.out.println(learnMh.invoke(MethodHandles.lookup().findConstructor(HandleTarget.class,MethodType.methodType(void.class)).invoke()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "HandleTarget{" +
                "name='" + name + '\'' +
                '}';
    }
}
