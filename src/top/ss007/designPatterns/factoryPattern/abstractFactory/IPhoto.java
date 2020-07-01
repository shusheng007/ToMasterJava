package top.ss007.designPatterns.factoryPattern.abstractFactory;

/**
 * Created by Ben.Wang on 2019/1/25.
 */
public class IPhoto extends MobilePhoto {
    @Override
    public void setOperationSystem() {
        System.out.println("苹果手机安装IOS系统");
    }
}
