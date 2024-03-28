package com.example.projectexample.quizzsample;

import java.util.ArrayList;
import java.util.Random;

public class QuestionManager {
    private int maxNumber;
    private int numberOfOptions;
    private Random random;

    public QuestionManager(int maxNumber, int numberOfOptions) {
        this.maxNumber = maxNumber;
        this.numberOfOptions = numberOfOptions;
        random = new Random();
    }

    public Question createQuestion() {
        int term1 = random.nextInt(maxNumber + 1);
        int term2 = random.nextInt(maxNumber + 1);
        int result = term1 + term2;

        int correctOption = random.nextInt(numberOfOptions);
        ArrayList<String> options = createOption(result, correctOption);
        return new Question(term1, term2, result, options, correctOption);
    }

    private ArrayList<String> createOption(int result, int correctOptionIndex) {
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < numberOfOptions; i++) {
            if (i == correctOptionIndex) {
                options.add(String.valueOf(result));
            } else {
                int incorrectResult = createIncorrectOption(result);
                options.add(String.valueOf(incorrectResult));
            }
        } return options;
    }

    private int createIncorrectOption(int correctResult) {
        int incorrectResult = correctResult + random.nextInt(5) - 2;
        if (incorrectResult == correctResult) {
            if (random.nextBoolean()) {
                incorrectResult++;
            } else {
                incorrectResult--;
            }
        } return incorrectResult;
    }
}
