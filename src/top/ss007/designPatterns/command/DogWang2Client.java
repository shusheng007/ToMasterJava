package top.ss007.designPatterns.command;

public class DogWang2Client {

    //享受xa机器人的服务
    public void enjoySexRobot() {
        RobotInvoker invoker = new RobotInvoker();

        //生成脱衣命令
        FanBingBingReceiver bingBingReceiver = new FanBingBingReceiver();
        TuoXiongZhaoCommand tuoXiongZhaoCommand = new TuoXiongZhaoCommand(bingBingReceiver);
        TuoKuZiCommand tuoKuZiCommand = new TuoKuZiCommand(bingBingReceiver);
        //构建执行计划
        invoker.setTuoYiCommands(tuoXiongZhaoCommand, tuoKuZiCommand);

        //生成跳舞命令
        YangMiReceiver yangMiReceiver = new YangMiReceiver();
        TiaoLaWuCommand tiaoLaWuCommand = new TiaoLaWuCommand(yangMiReceiver, "半小时");
        //构建执行计划
        invoker.setLaWuCommand(tiaoLaWuCommand);

        //执行命令
        invoker.enjoyTuoYi();
        invoker.enjoyLaWu();

    }
}
