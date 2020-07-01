package top.ss007.designPatterns.factoryPattern.factory;


import top.ss007.designPatterns.factoryPattern.Computer;
import top.ss007.designPatterns.factoryPattern.MiComputer;

/**
 * Created by Ben.Wang on 2019/1/25.
 */
public class MiComputerFactory implements ComputerFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }
}
