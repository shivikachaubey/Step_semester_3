package week1_day1.assigment_problems;

import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int numberOfItems = scanner.nextInt();

        int[] sectionA = new int[numberOfItems];
        int[] sectionB = new int[numberOfItems];

        System.out.println("Enter quantities for Section A:");
        for (int i = 0; i < numberOfItems; i++) {
            sectionA[i] = scanner.nextInt();
        }

        System.out.println("Enter quantities for Section B:");
        for (int i = 0; i < numberOfItems; i++) {
            sectionB[i] = scanner.nextInt();
        }

        analyzeInventory(sectionA, sectionB);

        scanner.close();
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sectionATotal = 0;
        int sectionBTotal = 0;

        for (int quantity : sectionA) {
            sectionATotal += quantity;
        }

        for (int quantity : sectionB) {
            sectionBTotal += quantity;
        }

        String status = sectionATotal == sectionBTotal
                ? "Balanced"
                : "Not Balanced";

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Section A Total: " + sectionATotal);
        System.out.println("Section B Total: " + sectionBTotal);
        System.out.println("Status: " + status);
        System.out.println(
                "Highest Quantity: " + highestQuantity
                        + " (" + highestSection
                        + ", Item " + (highestIndex + 1) + ")"
        );
    }
}