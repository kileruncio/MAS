package companies;

import java.util.EnumSet;
import java.util.List;

public class Employee {
    private String name;
    private boolean inWork;
    private double salary;

    private EnumSet<EmployeeType> employeeType;

    public Employee(String name, boolean inWork, double salary, List<EmployeeType> employeeType) {
        this.name = name;
        this.inWork = inWork;
        this.salary = salary;
        this.employeeType = EnumSet.copyOf(employeeType);
    }

    public String getName() {
        return name;
    }

    public boolean isInWork() {
        return inWork;
    }

    public double getSalary() {
        return salary;
    }

    public double getRealSalary() {
        double resoult = 0;

        if (this.employeeType.add(EmployeeType.Company)) {
            if (resoult == 0)
                resoult = this.salary * 0.7;
            else
                resoult += this.salary * 0.7;
        }

        if (this.employeeType.add(EmployeeType.Student)) {
            if (resoult == 0)
                resoult = this.salary;
            else
                resoult += this.salary;
        }

        if (this.employeeType.add(EmployeeType.Underage)) {
            if (resoult == 0)
                resoult = this.salary;
            else
                resoult += this.salary;
        }

        if (this.employeeType.add(EmployeeType.Employee)) {
            if (resoult == 0)
                resoult = this.salary * 0.6;
            else
                resoult += this.salary * 0.6;
        }

        return resoult;
    }
}
