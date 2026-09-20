package week1_day1.assigment_problems;

import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = scanner.nextLine().trim();

        classifyWordLengths(review);

        scanner.close();
    }

    public static void classifyWordLengths(String review) {
        if (review.isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            int wordLength = word.length();

            if (wordLength <= 4) {
                shortWords++;
            } else if (wordLength <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println(
                "Short: " + shortWords
                        + " | Medium: " + mediumWords
                        + " | Long: " + longWords
        );
    }
}