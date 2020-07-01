package top.ss007.designPatterns.factoryPattern.abstractFactory;


import top.ss007.designPatterns.factoryPattern.Computer;
import top.ss007.designPatterns.factoryPattern.MacComputer;

/**
 * Created by Ben.Wang on 2019/1/25.
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MacComputer();
    }

    @Override
    public MobilePhoto makeMobilePhoto() {
        return new IPhoto();
    }
}
