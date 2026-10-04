package week9.class_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class LibraryItem {
    private String title;
    private int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() { return title; }
    public int getDaysLate() { return daysLate; }

    public abstract double calculateFine();
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 2.0;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(getDaysLate() * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 1.0;
    }
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            if (type.equalsIgnoreCase("BOOK")) {
                items.add(new Book(title, days));
            } else if (type.equalsIgnoreCase("DVD")) {
                items.add(new DVD(title, days));
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items.add(new Magazine(title, days));
            }
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
        sc.close();
    }
}