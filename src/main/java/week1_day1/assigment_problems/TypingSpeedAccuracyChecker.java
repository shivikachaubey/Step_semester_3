package week1_day1.assigment_problems;

import java.util.Scanner;

public class TypingSpeedAccuracyChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);

        scanner.close();
    }

    public static void checkTypingAccuracy(String original, String typed) {
        int totalCharacters = Math.max(original.length(), typed.length());
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        int comparisonLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < comparisonLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i;
            }
        }

        if (original.length() != typed.length() && firstMismatchPosition == -1) {
            firstMismatchPosition = comparisonLength;
        }

        double accuracy = totalCharacters == 0
                ? 100.0
                : (matchedCharacters * 100.0) / totalCharacters;

        if (firstMismatchPosition == -1) {
            System.out.printf(
                    "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matchedCharacters,
                    totalCharacters,
                    accuracy
            );
            return;
        }

        char originalCharacter = firstMismatchPosition < original.length()
                ? original.charAt(firstMismatchPosition)
                : '-';

        char typedCharacter = firstMismatchPosition < typed.length()
                ? typed.charAt(firstMismatchPosition)
                : '-';

        System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                matchedCharacters,
                totalCharacters,
                accuracy,
                firstMismatchPosition + 1,
                originalCharacter,
                typedCharacter
        );
    }
}