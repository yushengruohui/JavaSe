package 设计模式.策略模式;

/**
 * 具体的收费模式
 * @author yusheng
 * Created on 2020-06-30 21:30
 **/
public class CashAcceptModeC implements CashStrategy {
    @Override
    public Double acceptCash(Double money) {

        return money*0.7;
    }
}
