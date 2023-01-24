package hillel;
import hillel.employee.Admin;
import hillel.employee.Doctor;
import hillel.employee.Employee;
import hillel.employee.Lawer;


public class Main {
    public static void main(String args[]) {

        Employee [] emps = new Employee[3];
        emps [0] = new Doctor ("Igor Petrovich", 300000, 1);
        emps [1] = new Lawer ("Serhii Ivanovich", 900000, "Criminal");
        emps [2] = new Admin("Oleh Markovich", 500000, 3.5);

        double totalSalary = 0;
        for (int i = 0; i < emps.length; i++) {
            totalSalary = totalSalary + emps[i].getSalaryUah();
            }
        System.out.println("Total salary of all employees = " + totalSalary);
    }
}
