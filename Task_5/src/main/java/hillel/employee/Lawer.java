package hillel.employee;

 public class Lawer extends Employee {

    private String department;

    public Lawer(String fullName, long salary, String department) {
        super(fullName, salary);
        this.department = department;
    }
}
