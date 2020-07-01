package top.ss007.designPatterns.factoryPattern.factory;


import top.ss007.designPatterns.factoryPattern.Computer;

/**
 * Created by Ben.Wang on 2019/1/25.
 *
 * 工厂方法模式，同一种产品不同品牌，例如苹果PC和小米PC，都是PC
 */
public interface ComputerFactory {
     Computer makeComputer();
}
