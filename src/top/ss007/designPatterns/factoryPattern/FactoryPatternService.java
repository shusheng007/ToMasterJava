package top.ss007.designPatterns.factoryPattern;


import top.ss007.designPatterns.factoryPattern.abstractFactory.AbstractFactory;
import top.ss007.designPatterns.factoryPattern.abstractFactory.AppleFactory;
import top.ss007.designPatterns.factoryPattern.factory.ComputerFactory;
import top.ss007.designPatterns.factoryPattern.factory.MacComputerFactory;
import top.ss007.designPatterns.factoryPattern.simpleFactory.SimpleComputerFactory;

public class FactoryPatternService {

    public void makePcUseSimpleFactory() {
        Computer computer = SimpleComputerFactory.makeComputer("mi");
        computer.setOperationSystem();
    }

    public void makePcUseFactory(){
        //需要创建哪个品牌的电脑就使用对应的工厂，此处想生产Mac,所以使用了MacComputerFactory
        ComputerFactory factory = new MacComputerFactory();
        factory.makeComputer().setOperationSystem();
    }

    public void makePcUseAbstractFactory(){
        AbstractFactory appleFactory = new AppleFactory();
        appleFactory.makeComputer().setOperationSystem();
        appleFactory.makeMobilePhoto().setOperationSystem();
    }

}
