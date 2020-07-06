package base;

import org.junit.Test;
import pojo.ConfigUtils;
import pojo.Person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @autho yusheng
 * @create-date 2020-04-09 09:36
 **/
public class TimeDemo {
    @Test
    public void demo1(){
        long start = System.currentTimeMillis();
        List<Integer> people=new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            people.add(i);
        }
        long end = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(end);
        System.out.println("format1 = " + format1);
        long runTime=end-start;
        System.out.println(runTime);
    }

    @Test
    public void demo2(){
        System.out.println(ConfigUtils.time);
        List<Integer> people=new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            people.add(i);
        }
        System.out.println(ConfigUtils.time);
        System.out.println(ConfigUtils.time);
        System.out.println(ConfigUtils.time);
    }
}
