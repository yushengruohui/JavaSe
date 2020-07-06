package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @autho yusheng
 * @create-date 2020-03-30 14:20
 **/
public class ListDemo {
    @Test
    public void demo1() {
        List<Integer> personList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            personList.add(i);
        }
    }
}
