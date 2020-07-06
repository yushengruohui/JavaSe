package 设计模式.建造者模式;

/**
 * 实际开发中建造模式的应用
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private String email;

    // 私有化构造器
    private Student(StudentBuilder studentBuilder) {
        name = studentBuilder.name;
        age = studentBuilder.age;
        id = studentBuilder.id;
        email = studentBuilder.email;
    }

    // 提供一个共有的静态builder方法
    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    // 外部调用builder类的属性接口进行设值。
    public static class StudentBuilder {
        private String name;
        private int age;
        private int id;
        private String email;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder num(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            // 将builder对象传入到学生构造函数
            return new Student(this);
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
