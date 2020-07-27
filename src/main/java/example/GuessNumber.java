package example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GuessNumber {
    private AnswerGenerator answerGenerator;
    private int availableGameTimes = 6;


    public GuessNumber(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    public AnswerGenerator getAnswerGenerator() {
        return answerGenerator;
    }

    public String guess(int[] guessInput, int[] answer) {
        int countA = this.getCountOfGuessInputCorrectNumberAndPosition(guessInput, answer);
        int countB = this.getCountOfGuessInputCorrectNumber(guessInput, answer);
        return countA + "A" + countB + "B";
    }

    public int getCountOfGuessInputCorrectNumberAndPosition(int[] guessInput, int[] answer) {
        int result = 0;
        for (int index = 0; index < guessInput.length; index++) {
            if (guessInput[index] == answer[index]) {
                result++;
            }
        }
        return result;
    }

    public int getCountOfGuessInputCorrectNumber(int[] guessInput, int[] answer) {
        int result = 0;
        for (int index = 0; index < guessInput.length; index++) {
            if (Arrays.binarySearch(answer, guessInput[index]) >= 0) {
                if (guessInput[index] != answer[index]) {
                    result++;
                }
            }
        }
        return result;
    }


    public String checkGuessInputNumber(int[] guessInputNumber) {
        if (guessInputNumber.length != 4) {
            return "Wrong Input，Input again.";
        }
        int distinctSizeofInputNumber = Arrays.asList(guessInputNumber)
                .stream()
                .distinct()
                .collect(Collectors.toList())
                .size();

        if (distinctSizeofInputNumber != guessInputNumber.length) {
            return "Wrong Input，Input again.";
        }
        return "OK";
    }

    public String guessGame(int[] guessInput, int[] answer) {
        String thisGameResult;
        if (!isAvailableGameTimesMoreThenZero(availableGameTimes)) {
            return "Game Over!";
        }

        thisGameResult = guess(guessInput, answer);
        this.availableGameTimes--;
        System.out.println("本次游戏的output:" + thisGameResult);
        if (thisGameResult.equals("4A0B")) {
            return "You Win!";
        }

        return "The game continues...";
    }

    public boolean isAvailableGameTimesMoreThenZero(int availableGameTimes) {
        if (availableGameTimes <= 0) {
            return false;
        }
        return true;
    }
}
