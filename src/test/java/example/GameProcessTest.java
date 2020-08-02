package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameProcessTest {

    @Test
    void should_return_reasonable_answer_when_game_start_given_answer() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();
        GameProcess gameProcess = new GameProcess();
        //when
        int[] resultAnswer = answerGenerator.getAnswer();
        String result = gameProcess.checkGuessNumber(resultAnswer);
        //then
        Assertions.assertEquals(4, resultAnswer.length);
        Assertions.assertEquals("OK", result);

    }


    @Test
    void should_return_ok_when_input_guess_given_1234() {
        //given
        GameProcess gameProcess = new GameProcess();
        int[] guessInputNumber = {1, 2, 3, 4};
        //when
        String result = gameProcess.checkGuessNumber(guessInputNumber);
        //then
        Assertions.assertEquals("OK", result);
    }

    @Test
    void should_return_wrong_when_input_guess_given_1134() {
        //given
        GameProcess gameProcess = new GameProcess();
        int[] guessInputNumber = {1, 1, 3, 4};
        //when
        String result = gameProcess.checkGuessNumber(guessInputNumber);
        //then
        Assertions.assertEquals("Wrong Input，Input again.", result);
    }




}
