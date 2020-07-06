package 设计模式.策略模式;

/**
 * 基本的策略模式，以后需要增加策略，只需要添加实现策略接口的实现类即可
 * @author yusheng
 * Created on 2020-06-30 21:34
 **/
public class StrategySelector {
    CashStrategy cashStrategy;

    public StrategySelector(CashStrategy cashStrategy) {
        // 选择某种策略
        this.cashStrategy=cashStrategy;
    }


    public Double calc(Double money) {
       // 执行策略
       return cashStrategy.acceptCash(money);
    }

}
