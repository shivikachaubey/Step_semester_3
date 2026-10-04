package week9.class_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    private String mode;
    private double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() { return mode; }
    public double getDistanceKm() { return distanceKm; }

    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return getDistanceKm() * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return getDistanceKm() * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (getDistanceKm() * 4.0);
    }
}

public class TravelBookingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double dist = sc.nextDouble();
            if (mode.equalsIgnoreCase("BUS")) {
                bookings.add(new BusBooking(dist));
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings.add(new TrainBooking(dist));
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings.add(new FlightBooking(dist));
            }
        }

        for (TravelBooking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.calculateTotalFare());
        }
        sc.close();
    }
}