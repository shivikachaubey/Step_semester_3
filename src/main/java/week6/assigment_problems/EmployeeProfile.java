package week6.assigment_problems;

public class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        EmployeeProfile emp1 = new EmployeeProfile("E-101", "Divya", 65000);
        EmployeeProfile emp2 = new EmployeeProfile("E-102", "Arjun");

        emp1.printProfile();
        emp2.printProfile();
    }
}