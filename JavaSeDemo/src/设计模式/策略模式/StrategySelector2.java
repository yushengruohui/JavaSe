package 设计模式.策略模式;

/**
 * @author yusheng
 * Created on 2020-06-30 21:34
 **/
public class StrategySelector2 {
    CashStrategy cashStrategy=null;

    public StrategySelector2(String inputParam) {
        switch (inputParam) {
            case "8折":
                this.cashStrategy=new CashAcceptModeA();
                break;
            case "9折":
                this.cashStrategy=new CashAcceptModeB();
                break;
            default:
                this.cashStrategy = new CashAcceptModeC();
        }
    }


    public Double calc(Double money) {
       // 执行策略
       return cashStrategy.acceptCash(money);
    }

}
