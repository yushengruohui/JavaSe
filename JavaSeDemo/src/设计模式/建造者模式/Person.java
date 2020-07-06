package 设计模式.建造者模式;

public class Person {
    
    private final String name;
    private final String gender;
    private final String age;

    private Person(Builder builder) {
        name = builder.name;
        gender = builder.gender;
        age = builder.age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public static final class Builder {
        private String name;
        private String gender;
        private String age;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder gender(String val) {
            gender = val;
            return this;
        }

        public Builder age(String val) {
            age = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}


