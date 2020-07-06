package 设计模式.建造者模式;

/**
 * @author yusheng
 * Created on 2020-05-02 16:10
 **/
public class Employee {
    private Integer id;
    private String name;
    private String account;

    public Employee() {
    }

    public Employee(Integer id, String name, String account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public static EmployeeBuilder builder() {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        employeeBuilder.employee = new Employee();
        return employeeBuilder;
    }

    public static EmployeeBuilder builder(Employee employee) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        employeeBuilder.employee = employee == null ? new Employee() : employee;
        return employeeBuilder;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "'" +
                ", name='" + name + "'" +
                ", account='" + account + "'" +
                "}";
    }

    public static class EmployeeBuilder {

        private Employee employee;

        public EmployeeBuilder id(Integer id) {
            employee.id = id;
            return this;
        }

        public EmployeeBuilder name(String name) {
            employee.name = name;
            return this;
        }

        public EmployeeBuilder account(String account) {
            employee.account = account;
            return this;
        }

        public Employee build() {
            return this.employee;
        }

    }

}