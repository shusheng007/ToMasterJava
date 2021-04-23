package top.ss007.designPatterns.command;

import java.util.ArrayList;
import java.util.List;

//调用者必须认识各种具体的命令，因为它要按照要求组织并触发这些命令
public class RobotInvoker {
    private final List<Command> sexRobotCommands = new ArrayList<>();

    public void clearCommand(){
        sexRobotCommands.clear();
    }

    //设置一套命令，不知道具体执行者是谁
    public void addCommands(Command command) {
        sexRobotCommands.add(command);
    }

    //执行脱衣系列命令
    public void executeCommand() {
        for (Command tuoYiCommand : sexRobotCommands) {
            tuoYiCommand.execute();
        }
    }

}
