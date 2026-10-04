package week9.class_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Connection {
    private String type;
    private double units;

    public Connection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    public String getType() { return type; }
    public double getUnits() { return units; }

    public abstract double calculateBill();
}

class HomeConnection extends Connection {
    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        double u = getUnits();
        if (u <= 100) {
            return u * 5.0;
        } else {
            return (100 * 5.0) + ((u - 100) * 7.0);
        }
    }
}

class ShopConnection extends Connection {
    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (getUnits() * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(getUnits() * 6.0, 1000.0);
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            if (type.equalsIgnoreCase("HOME")) {
                connections.add(new HomeConnection(units));
            } else if (type.equalsIgnoreCase("SHOP")) {
                connections.add(new ShopConnection(units));
            } else if (type.equalsIgnoreCase("FACTORY")) {
                connections.add(new FactoryConnection(units));
            }
        }

        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", c.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
