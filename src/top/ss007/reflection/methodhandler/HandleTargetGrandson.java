package top.ss007.reflection.methodhandler;

public class HandleTargetGrandson extends HandleTarget {

    @Override
    public void connectName(String name) {
        System.out.println("I come from grandson: "+name);
    }
}
