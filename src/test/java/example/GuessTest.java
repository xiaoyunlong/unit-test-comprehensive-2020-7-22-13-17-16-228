package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuessTest {

    @Test
    void should_return_4A0B_when_guess_given_guess_answer_1234_and_guess_inputnumber_1234() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] answer = {1, 2, 3, 4};
        int[] guessInput = {1, 2, 3, 4};
        //when
        String result = guessNumber.guess(guessInput, answer);
        //then
        Assertions.assertEquals("4A0B", result);
    }

    @Test
    void should_return_0A0B_when_guess_given_guess_answer_1234_and_guess_inputnumber_5678() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] answer = {1, 2, 3, 4};
        int[] guessInput = {5, 6, 7, 8};
        //when
        String result = guessNumber.guess(guessInput, answer);
        //then
        Assertions.assertEquals("0A0B", result);
    }

    @Test
    void should_return_2A0B_when_guess_given_guess_answer_1234_and_guess_inputnumber_1278() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] answer = {1, 2, 3, 4};
        int[] guessInput = {1, 2, 7, 8};
        //when
        String result = guessNumber.guess(guessInput, answer);
        //then
        Assertions.assertEquals("2A0B", result);
    }

    @Test
    void should_return_0A2B_when_guess_given_guess_answer_1234_and_guess_inputnumber_7128() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] answer = {1, 2, 3, 4};
        int[] guessInput = {7, 1, 2, 8};
        //when
        String result = guessNumber.guess(guessInput, answer);
        //then
        Assertions.assertEquals("0A2B", result);
    }

    @Test
    void should_return_0A4B_when_guess_given_guess_answer_1234_and_guess_inputnumber_4123() {
        //given answer和guseeIput写反了，一直到现在才发现！！ 这就是CV的坏处！！
        GuessNumber guessNumber = new GuessNumber();
        int[] guessInput = {4, 1, 2, 3};
        int[] answer = {1, 2, 3, 4};
        //when
        String result = guessNumber.guess(guessInput, answer);
        //then
        Assertions.assertEquals("0A4B", result);
    }

    @Test
    void should_return_2A2B_when_guess_given_guess_answer_1234_and_guess_inputnumber_1243() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] answer = {1, 2, 3, 4};
        int[] guessInput = {1, 2, 4, 3};
        //when
        String result = guessNumber.guess(guessInput, answer);
        //then
        Assertions.assertEquals("2A2B", result);
    }

}
