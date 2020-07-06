package 设计模式.策略模式;

/**
 * 收取现金的策略
 * @author yusheng
 * Created on 2020-06-29 23:10
 **/
public interface CashStrategy {
    Double acceptCash(Double money);
}
