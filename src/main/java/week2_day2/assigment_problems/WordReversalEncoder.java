package strings.assigment_problems;

public class WordReversalEncoder {

    public String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            result.append(wordBuilder.reverse().toString());
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        WordReversalEncoder encoder = new WordReversalEncoder();
        System.out.println(encoder.reverseEachWord("hello club"));
    }
}