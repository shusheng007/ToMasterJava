package top.ss007.designPatterns.factoryPattern.simpleFactory;


import top.ss007.designPatterns.factoryPattern.Computer;
import top.ss007.designPatterns.factoryPattern.MacComputer;
import top.ss007.designPatterns.factoryPattern.MiComputer;

/**
 * Created by Ben.Wang on 2019/1/25.
 * 增加新的产品需要修改此工厂类，违反开闭原则，降低内聚性
 */
public class SimpleComputerFactory {
    public static Computer makeComputer(String brand) {
        Computer computer = null;
        switch (brand) {
            case "mac":
                computer = new MacComputer();
                break;
            case "mi":
                computer = new MiComputer();
                break;
            default:
                break;
        }
        return computer;
    }
}
