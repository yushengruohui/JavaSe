package base;

import pojo.Var;

/**
 * @author: yusheng
 * @create-date: 2019-11-13 01:37
 **/
public class StringTest {

    public static String function(final Var var, String to) {
        var.str = to;
        to = "test";
        return to;
    }

    public static void main(String[] args) {
        Var var = new Var();
        String from = "main";
        String to = function(var, from);
        System.out.println(var.str);
        System.out.println(from);
        System.out.println(to);
    }
}
