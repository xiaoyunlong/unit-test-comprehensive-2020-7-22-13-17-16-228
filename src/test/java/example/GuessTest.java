package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuessTest {

    @Test
    void should_return_4A0B_when_guess_given_guess_answer_1234_and_guess_inputnumber_1234() {
        //given
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
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
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
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
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
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
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
        int[] answer = {1, 2, 3, 4};
        int[] guessInput = {7, 1, 2, 8};
        //when
        String result = guessNumber.guess(guessInput, answer);
        //then
        Assertions.assertEquals("0A2B", result);
    }

    @Test
    void should_return_0A4B_when_guess_given_guess_answer_1234_and_guess_inputnumber_4123() {
        //given
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
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
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
        int[] answer = {1, 2, 3, 4};
        int[] guessInput = {1, 2, 4, 3};
        //when
        String result = guessNumber.guess(guessInput, answer);
        //then
        Assertions.assertEquals("2A2B", result);
    }

    @Test
    void should_return_reasonable_length_answer_when_game_start_given_answer() {
        //given
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
        //when
        int[] result = guessNumber.getAnswerGenerator().getAnswer();
        //then
        Assertions.assertEquals(4, result.length);

    }


    @Test
    void should_return_ok_when_input_guess_given_1234() {
        //given
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
        int[] guessInputNumber = {1, 2, 3, 4};
        //when
        String result = guessNumber.checkGuessInputNumber(guessInputNumber);
        //then
        Assertions.assertEquals("OK", result);
    }

    @Test
    void should_return_wrong_when_input_guess_given_1134() {
        //given
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
        int[] guessInputNumber = {1, 1, 3, 4};
        //when
        String result = guessNumber.checkGuessInputNumber(guessInputNumber);
        //then
        Assertions.assertEquals("Wrong Input，Input again.", result);
    }

    @Test
    void should_return_false_when_input_guess_number_more_than_6_time() {
        //given
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
        int gameTimes = 0;
        //when
        boolean result = guessNumber.isAvailableGameTimesMoreThenZero(gameTimes);
        //then
        Assertions.assertEquals(false, result);
    }

    @Test
    void should_return_true_when_input_guess_number_less_than_6_time() {
        //given
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
        int gameTimes = 3;
        //when
        boolean result = guessNumber.isAvailableGameTimesMoreThenZero(gameTimes);
        //then
        Assertions.assertEquals(true, result);
    }

    @Test
    void should_return_you_win_when_guessGame_given_correct_input_within_six_times_and_answer() {
        //given
        GuessNumber guessNumber = new GuessNumber(new AnswerGenerator());
        int[] answer = {5, 6, 7, 8};
        int[] firstGuessInput = {1, 2, 3, 4};
        int[] secondGuessInput = {5, 8, 7, 9};
        int[] thirdGuessInput = {5, 6, 7, 8};

        //when
        guessNumber.guessGame(firstGuessInput,answer);
        guessNumber.guessGame(secondGuessInput,answer);
        String result = guessNumber.guessGame(thirdGuessInput,answer);
        //then
        Assertions.assertEquals("You Win!",result);
    }
}
