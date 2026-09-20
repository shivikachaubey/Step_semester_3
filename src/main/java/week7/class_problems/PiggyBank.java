package week7.class_problems;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public String getId() {
        return id;
    }

    public double getSavings() {
        return savings;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("deposit(" + (int)amount + ") -> savings = " + (int)savings);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            return;
        }
        if (amount > savings) {
            System.out.println("withdraw(" + (int)amount + ") -> rejected, savings stays " + (int)savings);
        } else {
            savings -= amount;
            System.out.println("withdraw(" + (int)amount + ") -> savings = " + (int)savings);
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}