package enum_package;

import org.junit.Test;

/**
 * @author: yusheng
 * @create-date: 2019-12-18 22:02
 **/
public class EnumTest {
    @Test
    public void demo1() {
        ColorEnum colorEnum = ColorEnum.RED;
        System.out.println(colorEnum);
        //输出 RED
    }

    @Test
    public void demo2() {
        for (int i = 0; i < ColorEnum.values().length; i++) {
            ColorEnum temp = ColorEnum.values()[i];
            System.out.println(temp);
        }
        for (ColorEnum temp : ColorEnum.values()) {
            System.out.println(temp);
        }
    }

    @Test
    public void demo3() {
            System.out.println(SeasonEnum.getNameByCode(1));
    }
}
