
public class Worker {
    private String name;
    private String role;
    private double salary;

    public Worker(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Role: " + role + ", Salary: " + salary;
    }
}
