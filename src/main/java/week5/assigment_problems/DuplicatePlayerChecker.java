package week5.assigment_problems;

public class DuplicatePlayerChecker {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Kohli", "Rohit"}));
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Rohit"}));
    }
}