package week8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluateScore();
    public abstract String getType();
}

class MCQQuestion extends Question {
    public MCQQuestion(String qText, String cAns, String sAns, double points) {
        super(qText, cAns, sAns, points);
    }

    @Override
    public double evaluateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    public TFQuestion(String qText, String cAns, String sAns, double points) {
        super(qText, cAns, sAns, points);
    }

    @Override
    public double evaluateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String qText, String cAns, String sAns, double points) {
        super(qText, cAns, sAns, points);
    }

    @Override
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchedCount = 0;
        String studentAnsLower = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && studentAnsLower.contains(trimmedKw)) {
                matchedCount++;
            }
        }

        if (matchedCount >= 2) {
            return 0.75 * points;
        } else if (matchedCount == 1) {
            return 0.50 * points;
        }
        return 0.0;
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class Problem04_QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        sc.nextLine();

        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            List<String> tokens = parseLineTokens(line);

            String type = tokens.get(0);
            String qText = tokens.get(1);
            String cAns = tokens.get(2);
            String sAns = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            if (type.equals("MCQ")) {
                questions.add(new MCQQuestion(qText, cAns, sAns, points));
            } else if (type.equals("TF")) {
                questions.add(new TFQuestion(qText, cAns, sAns, points));
            } else if (type.equals("ESSAY")) {
                questions.add(new EssayQuestion(qText, cAns, sAns, points));
            }
        }

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
        sc.close();
    }

    private static List<String> parseLineTokens(String line) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("([^\"]\\S*|\"[^\"]*\")").matcher(line);
        while (m.find()) {
            String token = m.group(1);
            if (token.startsWith("\"") && token.endsWith("\"")) {
                token = token.substring(1, token.length() - 1);
            }
            list.add(token);
        }
        return list;
    }
}