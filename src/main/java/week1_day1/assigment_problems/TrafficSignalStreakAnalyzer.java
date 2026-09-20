package week1_day1.assigment_problems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = scanner.nextLine().toUpperCase();

        findLongestStreak(signalLog);

        scanner.close();
    }

    public static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("Signal log is empty");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }

        System.out.println(
                "Longest Streak: '" + longestColor
                        + "' repeated " + longestStreak + " times"
        );
    }
}