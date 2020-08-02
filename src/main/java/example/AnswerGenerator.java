package example;

import java.util.Random;

public class AnswerGenerator {
    private final int ANSWER_LENGTH = 4;
    private final int[] answer;

    public AnswerGenerator() {
        answer = new int[ANSWER_LENGTH];


    }

    public int[] getAnswer() {
        Random rand = new Random();
        int MAX_NUMBER_IN_RANGE = 9;
        boolean[] bool = new boolean[MAX_NUMBER_IN_RANGE];
        int randomInt ;
        for (int index = 0; index < ANSWER_LENGTH; index++) {
            do {
                randomInt = rand.nextInt(MAX_NUMBER_IN_RANGE);
            } while (bool[randomInt]);
            answer[index] = randomInt;
            bool[randomInt] = true;
        }
        return answer;
    }



}


