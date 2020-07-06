package 设计模式.建造者模式;

import org.junit.Test;

/**
 * @author: yusheng
 * @create-date: 2019-12-20 12:26
 **/
public class DemoTest {
    @Test
    public void demo1() {
        Builder bld = new ConcreteBuilder();
        Director director = new Director(bld);
        director.produceCar();
        Car car = director.getCar();
        System.out.println(car);

        bld = new ConcreteBuilder2();
        director = new Director(bld);
        director.produceCar();
        car = director.getCar();
        System.out.println(car);
    }

    @Test
   public void demo2() {
        Student student = Student.builder()
                .age(1)
                .email("1111")
                .build();
        System.out.println("student = " + student);
    }

    @Test
    public void demo3() {
        Employee employee = Employee.builder().account("2222").id(111).build();
        Employee employee1 = Employee.builder()
                .id(1111)
                .account("1111").build();
        System.out.println("employee1 = " + employee1);
        System.out.println("employee = " + employee);
    }

    @Test
    public void demo4() {
        Person p = new Person.Builder().age("1111").gender("333").build();
        System.out.println("p = " + p);
    }
}
