package week1_day1.class_problems;

import java.util.Scanner;

public class BmiCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of team members: ");
        int numberOfMembers = scanner.nextInt();

        double totalBmi = 0;

        for (int i = 1; i <= numberOfMembers; i++) {
            System.out.print("Enter weight in kg for member " + i + ": ");
            double weight = scanner.nextDouble();

            System.out.print("Enter height in meters for member " + i + ": ");
            double height = scanner.nextDouble();

            double bmi = weight / (height * height);
            totalBmi += bmi;

            System.out.println("BMI of member " + i + ": " + bmi);
        }

        double averageBmi = totalBmi / numberOfMembers;

        System.out.println("Average BMI: " + averageBmi);

        scanner.close();
    }
}