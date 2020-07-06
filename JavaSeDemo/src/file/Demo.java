package file;


import java.io.Serializable;

/**
 * @autho yusheng
 * @create-date 2020-03-26 22:44
 **/
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
