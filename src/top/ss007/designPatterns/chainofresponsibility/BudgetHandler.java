package top.ss007.designPatterns.chainofresponsibility;

/**
 * Created by Ben.Wang
 * <p>
 * author     : Ben.Wang
 * date       : 2021/4/23 13:15
 * description:
 */
public interface BudgetHandler {
    void setNextHandler(BudgetHandler nextHandler);

    boolean handle(int amount);
}
