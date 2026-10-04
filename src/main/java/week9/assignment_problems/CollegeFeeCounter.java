package week9.assignment_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface BusUser {
    default double getTransportFee() {
        return 12000.0;
    }
}

abstract class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public abstract double calculateTuition();

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarStudent extends Student implements BusUser {
    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students.add(new DayScholar(name));
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                students.add(new Hosteller(name));
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                students.add(new ScholarStudent(name));
            }
        }

        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}