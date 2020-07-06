package datatype;

import org.junit.Test;
import pojo.Person;

/**
 * @author: yusheng
 * @create-time 2019-10-28 09:53
 **/
public class FinalDemo {
    @Test
    public void test() {
        final int i = 10;
        //i++; 编译时候错误
        final Person person = new Person();
        person.setId(10);
        person.setId(12);
        System.out.println("=====" + person + "=====");

    }
}
