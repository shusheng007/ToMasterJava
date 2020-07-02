package top.ss007;

import top.ss007.designPatterns.builderPattern.BuilderPatternService;
import top.ss007.reflection.ReflectionService;

public class Main {

    public static void main(String[] args) {
        //构建者模式调用
        new BuilderPatternService().assemblePcUseSimpleBuilder();

        //method handle使用
        new ReflectionService().invokeNameGetterMethod();
    }
}
