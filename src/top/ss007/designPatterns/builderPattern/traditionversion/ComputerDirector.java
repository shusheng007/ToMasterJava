package top.ss007.designPatterns.builderPattern.traditionversion;

/**
 * Created by Ben.Wang on 2019/1/24.
 */
public class ComputerDirector {
    public void makeComputer(ComputerBuilder builder) {
        builder.setUsbCount();
        builder.setDisplay();
        builder.setKeyboard();
    }
}
