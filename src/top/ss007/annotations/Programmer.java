package top.ss007.annotations;

/**
 * Created by Ben.Wang on 2019/10/18.
 */
public class Programmer {

    @ExplainAnnotation(value = "就是让你秒懂")
    public void explainAnnotationToSome(){
        System.out.println("我费了这么大的力气，哔哔了这么多，你懂了吧？");
    }

}
