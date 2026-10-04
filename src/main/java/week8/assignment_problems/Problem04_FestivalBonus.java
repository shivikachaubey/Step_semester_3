package week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();
    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

public class Problem04_FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME")) {
                employees.add(new FullTimeEmployee(name, salary));
            } else if (type.equals("PARTTIME")) {
                employees.add(new PartTimeEmployee(name, salary));
            } else if (type.equals("INTERN")) {
                employees.add(new InternEmployee(name, salary));
            }
        }

        double totalBonus = 0.0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f\n", e.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        sc.close();
    }
}