package file;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: yusheng
 * @create-date: 2020-03-14 22:56
 **/
public class FileTest {
    @Test
    public void demo() throws IOException {
        Path temp = Paths.get("src/file");
        Path path1 = temp.toAbsolutePath().resolve("火影/1").resolve("1");
        System.out.println(path1);
    }


    @Test
    public void demo2() {
        Demo demo = new Demo();
        Demo demo1 = new Demo();
        Object o = new Object();
    }

    @Test
    public void demo3() {
        String sum = sum(100);
        System.out.println(sum);
    }

    private String sum(int temp) {
        for (int i = 1; i < temp; i++) {
            if (i == 10) {
                return "成功了";
            }
            System.out.println("i = " + i);
        }
        return "false";
    }
}
