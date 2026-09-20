package strings.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class StopWordFrequencyReport {

    private String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

    private boolean isStopWord(String word) {
        for (String stopWord : stopWords) {
            if (stopWord.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.isEmpty()) {
            return;
        }

        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "").replace("!", "").replace("?", "");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StopWordFrequencyReport report = new StopWordFrequencyReport();
        report.printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}