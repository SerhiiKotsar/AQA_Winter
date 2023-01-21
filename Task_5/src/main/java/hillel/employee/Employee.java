package hillel.employee;

public class Employee {
    private String fullName;
    protected long mSalary;

    public Employee(String fullName, long mSalary) {
        this.fullName = fullName;
        this.mSalary = mSalary;
    }

    public double getSalaryUah() {
        return mSalary / 100f;
    }
}
