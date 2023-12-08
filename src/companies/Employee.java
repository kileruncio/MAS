package companies;

import java.util.EnumSet;
import java.util.List;

public class Employee {
    // overlapping
    private String name;
    private boolean inWork;
    private double salary;
    private int NIP;
    private boolean insurance;

    private EnumSet<EmployeeType> employeeType;

    public Employee(String name, boolean inWork, double salary, List<EmployeeType> employeeType, boolean insurance) {
        this.name = name;
        this.inWork = inWork;
        this.salary = salary;
        this.employeeType = EnumSet.copyOf(employeeType);
        if (this.employeeType.contains(EmployeeType.EMPLOYEE))
            this.insurance = insurance;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public int getNIP() {
        return this.employeeType.contains(EmployeeType.COMPANY) ? NIP : 0;
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

        if (this.employeeType.contains(EmployeeType.COMPANY)) {
            if (resoult == 0)
                resoult = this.salary * 0.7;
            else
                resoult += this.salary * 0.7;
        }

        if (this.employeeType.contains(EmployeeType.STUDENT)) {
            if (resoult == 0)
                resoult = this.salary;
            else
                resoult += this.salary;
        }

        if (this.employeeType.contains(EmployeeType.UNDERAGE)) {
            if (resoult == 0)
                resoult = this.salary;
            else
                resoult += this.salary;
        }

        if (this.employeeType.contains(EmployeeType.EMPLOYEE)) {
            if (resoult == 0)
                resoult = this.salary * 0.6;
            else
                resoult += this.salary * 0.6;
        }

        return resoult;
    }
}
