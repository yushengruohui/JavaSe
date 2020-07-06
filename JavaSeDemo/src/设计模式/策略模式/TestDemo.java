package 设计模式.策略模式;

import org.junit.Test;

/**
 * @author yusheng
 * Created on 2020-06-30 21:43
 **/
public class TestDemo {
    @Test
    public void demo() {
        // 普通策略模式测试
        StrategySelector strategySelector = new StrategySelector(new CashAcceptModeA());
        Double calc = strategySelector.calc( 100.00);
        System.out.println("calc = " + calc);
    }
}
