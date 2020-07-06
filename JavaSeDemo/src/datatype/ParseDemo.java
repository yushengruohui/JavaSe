package datatype;

import org.junit.Test;
import pojo.Person;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-29 17:50
 **/
public class ParseDemo {
    @Test
    public void demo() {
        //int temp = 111;
        //String s1 = String.valueOf(temp);
        //int t2 = Integer.parseInt(s1);
        //System.out.println("=====" + t2 + "=====");

        Person person = new Person();
        System.out.println(person.getClass().getName());
    }

    @Test
    public void demo1() {
        Person person = new Person();
        person.setRoom(null);
        person.setId(22);
        person.setNames(1123);
        Object o = person;
        System.out.println("o = " + o.toString());
    }
}
