package top.ss007.designPatterns.command;

import java.util.ArrayList;
import java.util.List;

//调用者必须认识各种具体的命令，因为它要按照要求组织并触发这些命令
public class RobotInvoker {
    private final List<Command> tuoYiCommands = new ArrayList<>();
    private TiaoLaWuCommand laWuCommand;

    //设置一套脱衣命令，不知道具体执行者是谁
    public void setTuoYiCommands(TuoXiongZhaoCommand xzCommand, TuoKuZiCommand kzCommand) {
        tuoYiCommands.clear();
        tuoYiCommands.add(xzCommand);
        tuoYiCommands.add(kzCommand);
    }

    //设置跳辣舞的命令
    public void setLaWuCommand(TiaoLaWuCommand laWuCommand) {
        this.laWuCommand = laWuCommand;
    }

    //执行脱衣系列命令
    public void enjoyTuoYi() {
        for (Command tuoYiCommand : tuoYiCommands) {
            tuoYiCommand.execute();
        }
    }

    //执行跳辣舞命令
    public void enjoyLaWu(){
        if(laWuCommand!=null){
            laWuCommand.execute();
        }
    }
}
