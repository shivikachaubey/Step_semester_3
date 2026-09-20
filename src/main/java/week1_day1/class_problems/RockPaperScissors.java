package week1_day1.class_problems;

import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice (rock, paper, scissors): ");
        String playerChoice = scanner.nextLine().toLowerCase();

        String computerChoice = "rock";

        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (
                (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }

        scanner.close();
    }
}