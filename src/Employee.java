import lombok.Data;

@Data
public class Employee {
    private static int max_id = 1;

    private final int id;
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
        this.id = max_id++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
