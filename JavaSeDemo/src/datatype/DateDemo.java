package datatype;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-13 23:57
 **/
public class DateDemo {
    @Test
    public void test() {
        Date date = new Date();
        System.out.println("=====" + date + "=====");

    }

    @Test
    public void test0() throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(d);
        Date date = sdf.parse(format);
        System.out.println("当前时间：" + format);
        System.out.println(date);
    }

    @Test
    public void test1() {
        Date now = new Date();
        DateFormat dtf = DateFormat.getTimeInstance();
        DateFormat ddf = DateFormat.getDateInstance();
        DateFormat ddtf = DateFormat.getDateTimeInstance();

        System.out.println(now);
        System.out.println(dtf.format(now));
        System.out.println(ddf.format(now));
        System.out.println(ddtf.format(now));
    }
}
