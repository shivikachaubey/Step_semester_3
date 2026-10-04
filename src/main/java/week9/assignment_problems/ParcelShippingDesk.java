package week9.assignment_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    private String type;
    private double weightKg;
    private double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() { return type; }
    public double getWeightKg() { return weightKg; }
    public double getDeclaredValue() { return declaredValue; }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * getWeightKg());
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * getWeightKg());
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * getWeightKg()) + 50.0;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double val = sc.nextDouble();
            if (type.equalsIgnoreCase("STANDARD")) {
                parcels.add(new StandardParcel(weight, val));
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcels.add(new ExpressParcel(weight, val));
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcels.add(new FragileParcel(weight, val));
            }
        }

        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = 0.0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).calculateInsurance(p.getDeclaredValue());
            }
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}