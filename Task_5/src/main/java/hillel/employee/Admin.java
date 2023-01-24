package hillel.employee;

final public class Admin extends Employee{

    private double experience;

    public Admin(String fullName, long mSalary, double experience) {
        super(fullName, mSalary);
        this.experience = experience;
    }
}
