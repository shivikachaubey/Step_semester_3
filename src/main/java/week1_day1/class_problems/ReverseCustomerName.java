package week1_day1.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        String reversedName = new StringBuilder(name).reverse().toString();

        System.out.println("Reversed customer name: " + reversedName);

        scanner.close();
    }
}