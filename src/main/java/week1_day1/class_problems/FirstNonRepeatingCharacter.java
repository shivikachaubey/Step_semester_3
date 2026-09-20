package week1_day1.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Map<Character, Integer> frequency = new HashMap<>();

        for (char character : input.toCharArray()) {
            frequency.put(character, frequency.getOrDefault(character, 0) + 1);
        }

        Character result = null;

        for (char character : input.toCharArray()) {
            if (frequency.get(character) == 1) {
                result = character;
                break;
            }
        }

        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        scanner.close();
    }
}