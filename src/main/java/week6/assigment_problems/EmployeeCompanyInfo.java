package week6.assigment_problems;

public class EmployeeCompanyInfo {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeCompanyInfo emp1 = new EmployeeCompanyInfo("Divya", 65000);
        EmployeeCompanyInfo emp2 = new EmployeeCompanyInfo("Arjun", 25000);
        EmployeeCompanyInfo emp3 = new EmployeeCompanyInfo("Kiran", 45000);

        EmployeeCompanyInfo.printCompanyInfo();
    }
}