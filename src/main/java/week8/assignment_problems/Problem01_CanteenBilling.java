package week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }

    @Override
    public String getType() {
        return "GUEST";
    }
}

public class Problem01_CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("STUDENT")) {
                bills.add(new StudentCustomer(amount));
            } else if (type.equals("STAFF")) {
                bills.add(new StaffCustomer(amount));
            } else if (type.equals("GUEST")) {
                bills.add(new GuestCustomer(amount));
            }
        }

        double grandTotal = 0.0;
        for (Customer c : bills) {
            double finalAmt = c.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f\n", c.getType(), finalAmt);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}