package week9.assignment_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface SaverModeSupported {
    default double applySaverDiscount(double baseUnits) {
        return baseUnits * 0.75;
    }
}

abstract class Appliance {
    private String name;
    private double hours;

    public Appliance(String name, double hours) {
        this.name = name;
        this.hours = hours;
    }

    public String getName() { return name; }
    public double getHours() { return hours; }

    public abstract double getPowerRatingWatts();

    public double calculateStandardUnits() {
        return (getPowerRatingWatts() * getHours()) / 1000.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) { super("FRIDGE", hours); }
    @Override public double getPowerRatingWatts() { return 150.0; }
}

class AirConditioner extends Appliance implements SaverModeSupported {
    public AirConditioner(double hours) { super("AC", hours); }
    @Override public double getPowerRatingWatts() { return 1500.0; }
}

class TV extends Appliance {
    public TV(double hours) { super("TV", hours); }
    @Override public double getPowerRatingWatts() { return 100.0; }
}

class WashingMachine extends Appliance implements SaverModeSupported {
    public WashingMachine(double hours) { super("WASHER", hours); }
    @Override public double getPowerRatingWatts() { return 500.0; }
}

public class ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<ApplianceRequest> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double hours = sc.nextDouble();
            boolean isSaver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                isSaver = true;
            }

            Appliance app = null;
            if (name.equalsIgnoreCase("FRIDGE")) app = new Fridge(hours);
            else if (name.equalsIgnoreCase("AC")) app = new AirConditioner(hours);
            else if (name.equalsIgnoreCase("TV")) app = new TV(hours);
            else if (name.equalsIgnoreCase("WASHER")) app = new WashingMachine(hours);

            if (app != null) {
                requests.add(new ApplianceRequest(app, isSaver));
            }
        }

        double totalCost = 0;
        for (ApplianceRequest req : requests) {
            Appliance app = req.appliance;
            if (req.isSaver && !(app instanceof SaverModeSupported)) {
                System.out.printf("%s: saver mode not supported%n", app.getName());
            } else {
                double units = app.calculateStandardUnits();
                if (req.isSaver) {
                    units = ((SaverModeSupported) app).applySaverDiscount(units);
                }
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getName(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }

    static class ApplianceRequest {
        Appliance appliance;
        boolean isSaver;

        ApplianceRequest(Appliance appliance, boolean isSaver) {
            this.appliance = appliance;
            this.isSaver = isSaver;
        }
    }
}