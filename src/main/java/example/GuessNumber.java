package example;

import java.util.Arrays;

public class GuessNumber {


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
            //binarySearch(Object[], int fromIndex（包含）, int toIndex(不包含), Object key) return index
            if (Arrays.binarySearch(answer, guessInput[index]) >= 0) {
                if (guessInput[index] != answer[index]) {
                    result++;
                }
            }
        }
        return result;
    }
}
