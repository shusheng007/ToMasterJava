package top.ss007.designPatterns.interfaceItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Ben.Wang on 2019/3/22.
 */
public class Shape {
    private static int length;

    private Object aeare;

    public void draw(){
        List<Object>list1=new ArrayList<>();
        List<?>list2=new ArrayList<>();
        list1.add(1);
        list1.add("hello");


        list2=list1;
        if (aeare instanceof Set<?>) {

        }
       class localClass{

       }
    }


    static class StaticInnerClass{
        private String staticInnerName;
        void printStaticInnerName(String name ){
        }
    }

    class InnerClass{
        private String innerName;
        void printInnerName(){

        }
    }
}
