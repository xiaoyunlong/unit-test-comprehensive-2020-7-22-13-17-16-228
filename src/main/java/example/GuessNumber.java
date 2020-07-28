package example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GuessNumber {
    private AnswerGenerator answerGenerator;



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


}
