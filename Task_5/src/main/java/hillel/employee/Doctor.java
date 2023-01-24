package hillel.employee;

public class Doctor extends Employee {

    private int category;

    public Doctor(String fullName, long salary, int category) {
        super(fullName, salary);
        this.category = category;
    }

    @Override
    public double getSalaryUah() {
        return mSalary / 100f * 1.2;
    }
}
