package week8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
    public abstract String getType();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02;
    }

    @Override
    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01;
    }

    @Override
    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }
}

public class Problem01_PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        List<PaymentMethod> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            if (type.equals("CARD")) {
                transactions.add(new CardPayment(amount));
            } else if (type.equals("WALLET")) {
                transactions.add(new WalletPayment(amount));
            } else if (type.equals("BANKTRANSFER")) {
                transactions.add(new BankTransferPayment(amount));
            }
        }

        double total = 0.0;
        for (PaymentMethod pm : transactions) {
            double adjusted = pm.calculateAdjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f\n", pm.getType(), adjusted);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}