package week9.assignment_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface NightServiceable {
    double applyNightSurcharge(double baseFare);
}

abstract class Cab {
    private String type;
    private double distanceKm;

    public Cab(String type, double distanceKm) {
        this.type = type;
        this.distanceKm = distanceKm;
    }

    public String getType() { return type; }
    public double getDistanceKm() { return distanceKm; }

    public abstract double getRatePerKm();

    public double calculateBaseFare() {
        double rawFare = getDistanceKm() * getRatePerKm();
        return Math.max(rawFare, 100.0);
    }
}

class MiniCab extends Cab {
    public MiniCab(double distanceKm) {
        super("MINI", distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double distanceKm) {
        super("SEDAN", distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double distanceKm) {
        super("SUV", distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<CabRequest> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab = null;
            if (type.equalsIgnoreCase("MINI")) cab = new MiniCab(km);
            else if (type.equalsIgnoreCase("SEDAN")) cab = new SedanCab(km);
            else if (type.equalsIgnoreCase("SUV")) cab = new SUVCab(km);

            if (cab != null) {
                requests.add(new CabRequest(cab, time));
            }
        }

        double totalFare = 0;
        for (CabRequest req : requests) {
            Cab c = req.cab;
            boolean isNight = req.time.equalsIgnoreCase("NIGHT");

            if (isNight && !(c instanceof NightServiceable)) {
                System.out.printf("%s: night service not available%n", c.getType());
            } else {
                double fare = c.calculateBaseFare();
                if (isNight) {
                    fare = ((NightServiceable) c).applyNightSurcharge(fare);
                }
                totalFare += fare;
                System.out.printf("%s: %.2f%n", c.getType(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", totalFare);
        sc.close();
    }

    static class CabRequest {
        Cab cab;
        String time;

        CabRequest(Cab cab, String time) {
            this.cab = cab;
            this.time = time;
        }
    }
}
