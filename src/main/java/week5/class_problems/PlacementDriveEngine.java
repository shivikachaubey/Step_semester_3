package week5.class_problems;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PlacementDriveEngine {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public double getCompositeScore() {
            return (this.cgpa * 10) + this.codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }

        public String getName() {
            return name;
        }
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null) {
            return "";
        }

        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            result.append(i + 1).append(". ").append(shortlistedArray[i].getName())
                  .append(" (").append(shortlistedArray[i].getCompositeScore()).append(")");
            if (i < shortlistedArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(batch));
    }
}