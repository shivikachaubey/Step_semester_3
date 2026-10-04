package week8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getType();
}

class BusTransport extends Transport {
    public BusTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class MetroTransport extends Transport {
    private double peakFactor;

    public MetroTransport(double distance, double peakFactor) {
        super(distance);
        this.peakFactor = peakFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }
}

public class Problem05_TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            if (type.equals("BUS")) {
                journeys.add(new BusTransport(distance));
            } else if (type.equals("TRAIN")) {
                journeys.add(new TrainTransport(distance));
            } else if (type.equals("METRO")) {
                double peakFactor = sc.nextDouble();
                journeys.add(new MetroTransport(distance, peakFactor));
            }
        }

        double totalFare = 0.0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            totalFare += fare;
            System.out.printf("%s: %.2f\n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f\n", totalFare);
        sc.close();
    }
}