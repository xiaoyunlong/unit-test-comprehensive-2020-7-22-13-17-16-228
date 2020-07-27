package example;

import java.util.Random;

public class AnswerGenerator {
    private final int maxNumberInRange = 9;
    private final int minNumberInRange = 0;
    private final int answerLength = 4;
    private int[] answer;

    public AnswerGenerator() {
        answer = new int[answerLength];
        Random rand = new Random();
        boolean[] bool = new boolean[maxNumberInRange];
        int randomInt ;
        for (int index = 0; index < answerLength; index++) {
            do {
                randomInt = rand.nextInt(maxNumberInRange);
            } while (bool[randomInt]);
            answer[index] = randomInt;
            bool[randomInt] = true;
        }

    }

    public int[] getAnswer() {
        return answer;
    }



}


