package example;

import java.util.HashSet;
import java.util.Set;

public class GuessNumber {

    private final Set<Integer> answerSet = new HashSet<>();
    private final int[] answerGenerator;

    public GuessNumber(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator.getAnswer();
    }



    public String guess(int[] guessInput) {
        int countA = 0;
        int countB = 0;
        for (int answerItem : answerGenerator) {
            answerSet.add(answerItem);
        }
        for (int guessIndex = 0; guessIndex < guessInput.length; guessIndex++) {
            if (guessInput[guessIndex] == answerGenerator[guessIndex]) {
                countA++;
            }
            if (answerSet.contains(guessInput[guessIndex])) {
                countB++;
            }
        }

        if (countA != 0 && countB != 0) {
            countB = countB - countA;
        }

        return String.format("%sA%sB", countA, countB);
    }



}
