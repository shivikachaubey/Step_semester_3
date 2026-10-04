package week9.assignment_problems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class SeatBooking {
    private static final double CONVENIENCE_FEE = 20.0;
    private String seatType;
    private int count;

    public SeatBooking(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() { return seatType; }
    public int getCount() { return count; }

    public abstract double getBasePricePerTicket();

    public double calculateTotalAmount() {
        return getCount() * (getBasePricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularSeat extends SeatBooking {
    public RegularSeat(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 150.0;
    }
}

class PremiumSeat extends SeatBooking {
    public PremiumSeat(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 250.0;
    }
}

class ReclinerSeat extends SeatBooking {
    public ReclinerSeat(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getBasePricePerTicket() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<SeatBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            if (type.equalsIgnoreCase("REGULAR")) {
                bookings.add(new RegularSeat(count));
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                bookings.add(new PremiumSeat(count));
            } else if (type.equalsIgnoreCase("RECLINER")) {
                bookings.add(new ReclinerSeat(count));
            }
        }

        double total = 0;
        for (SeatBooking b : bookings) {
            double amt = b.calculateTotalAmount();
            total += amt;
            System.out.printf("%s: %.2f%n", b.getSeatType(), amt);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}