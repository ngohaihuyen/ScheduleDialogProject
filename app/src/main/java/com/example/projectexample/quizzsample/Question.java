package com.example.projectexample.quizzsample;

import java.util.ArrayList;

public class Question {
    private int term1;
    private int term2;
    private int result;

    private ArrayList<String> options;
    private int correctOption;

    public Question(int operand1, int operand2, int result, ArrayList<String> options, int correctOption) {
        this.term1 = operand1;
        this.term2 = operand2;
        this.result = result;
        this.options = options;
        this.correctOption = correctOption;
    }

    public int getTerm1() {
        return term1;
    }

    public int getTerm2() {
        return term2;
    }

    public int getResult() {
        return result;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}
