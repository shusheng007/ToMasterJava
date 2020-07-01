package top.ss007.designPatterns.factoryPattern.abstractFactory;


import top.ss007.designPatterns.factoryPattern.Computer;
import top.ss007.designPatterns.factoryPattern.MiComputer;

/**
 * Created by Ben.Wang on 2019/1/25.
 */
public class XiaoMiFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }

    @Override
    public MobilePhoto makeMobilePhoto() {
        return new MiPhoto();
    }
}
