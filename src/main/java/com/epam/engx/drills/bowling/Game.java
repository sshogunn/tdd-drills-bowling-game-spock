package com.epam.engx.drills.bowling;

public class Game {

    private static final int MAX_SCORE = 10;
    private int[] rolls = new int[21];
    private int lastRole;

    public void roll(int pins) {
        rolls[lastRole++] = pins;
    }

    public int getScore() {
        int score = 0;
        int roll = 0;
        for (int i = 0; i < 10; i++) {
            if (isSpare(roll)) {
                score += calculateSpare(roll);
                roll += 2;
            } else if (isStrike(rolls[roll])) {
                score += calculateStrike(roll);
                roll++;
            } else {
                score += rolls[roll] + rolls[roll + 1];
                roll += 2;
            }
        }
        return score;
    }

    private int calculateStrike(int roll) {
        return MAX_SCORE + rolls[roll + 1] + rolls[roll + 2];
    }

    private int calculateSpare(int roll) {
        return MAX_SCORE + rolls[roll + 2];
    }

    private boolean isStrike(int roll) {
        return roll == MAX_SCORE;
    }

    private boolean isSpare(int roll) {
        return rolls[roll] + rolls[roll + 1] == MAX_SCORE;
    }
}
