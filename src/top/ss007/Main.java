package top.ss007;

import top.ss007.designPatterns.chainofresponsibility.DogWang2Cor;

public class Main {

    public static void main(String[] args) {
        //构建者模式调用
//        new BuilderPatternService().assemblePcUseSimpleBuilder();
        //method handle使用
//        new ReflectionService().invokeNameGetterMethod();

//        MethodReference methodReference=new MethodReference();
//        methodReference.testStaticMethodRef();
//        methodReference.testInstanceMethodRef1();
//        methodReference.testInstanceMethodRef2();
//        methodReference.testConstructorMethodRef();

        // 命令模式
//        DogWang2Client dogWang2=new DogWang2Client();
//        dogWang2.enjoySexRobot();

        //责任连模式
        DogWang2Cor dogWang2Cor=new DogWang2Cor();
        dogWang2Cor.applyBudget();


    }
}
