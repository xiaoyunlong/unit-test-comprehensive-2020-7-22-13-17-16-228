package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class GuessTest {
    private GuessNumber guessNumber;

    @BeforeEach
    void setUp() {
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.getAnswer()).thenReturn(answer);
        guessNumber = new GuessNumber(answerGenerator);
    }

    @Test
    void should_return_4A0B_when_guess_given_guess_answer_1234_and_guess_inputnumber_1234() {
        //given
        int[] guessInput = {1, 2, 3, 4};
        //when
        String result = guessNumber.guess(guessInput);
        //then
        Assertions.assertEquals("4A0B", result);
    }

    @Test
    void should_return_0A0B_when_guess_given_guess_answer_1234_and_guess_inputnumber_5678() {
        //given
        int[] guessInput = {5, 6, 7, 8};
        //when
        String result = guessNumber.guess(guessInput);
        //then
        Assertions.assertEquals("0A0B", result);
    }

    @Test
    void should_return_2A0B_when_guess_given_guess_answer_1234_and_guess_inputnumber_1278() {
        //given

        int[] guessInput = {1, 2, 7, 8};
        //when
        String result = guessNumber.guess(guessInput);
        //then
        Assertions.assertEquals("2A0B", result);
    }

    @Test
    void should_return_0A2B_when_guess_given_guess_answer_1234_and_guess_inputnumber_7128() {
        //given

        int[] guessInput = {7, 1, 2, 8};
        //when
        String result = guessNumber.guess(guessInput);
        //then
        Assertions.assertEquals("0A2B", result);
    }

    @Test
    void should_return_0A4B_when_guess_given_guess_answer_1234_and_guess_inputnumber_4123() {
        //given
        int[] guessInput = {4, 1, 2, 3};
        //when
        String result = guessNumber.guess(guessInput);
        //then
        Assertions.assertEquals("0A4B", result);
    }

    @Test
    void should_return_2A2B_when_guess_given_guess_answer_1234_and_guess_inputnumber_1243() {
        //given
        int[] guessInput = {1, 2, 4, 3};
        //when
        String result = guessNumber.guess(guessInput);
        //then
        Assertions.assertEquals("2A2B", result);
    }

    @Test
    void should_return_Game_Over_when_guessGame_given_correct_input_beyond_six_times_and_answer() {
        //given
        GameProcess gameProcess = new GameProcess();
        int[] firstGuessInput = {1, 8, 3, 4};
        int[] secondGuessInput = {5, 8, 7, 9};
        int[] thirdGuessInput = {5, 6, 7, 8};
        int[] fourGuessInput = {1, 2, 3, 4};
        int[] fiveGuessInput = {5, 8, 7, 9};
        int[] sixGuessInput = {5, 6, 7, 8};
        int[] sevenGuessInput = {1, 2, 3, 4};

        //when
        gameProcess.guessGame(firstGuessInput,guessNumber);
        gameProcess.guessGame(secondGuessInput,guessNumber);
        gameProcess.guessGame(thirdGuessInput,guessNumber);
        gameProcess.guessGame(fourGuessInput,guessNumber);
        gameProcess.guessGame(fiveGuessInput,guessNumber);
        gameProcess.guessGame(sixGuessInput,guessNumber);

        String result = gameProcess.guessGame(sevenGuessInput,guessNumber);
        //then
        Assertions.assertEquals("Game Over!",result);
    }


    @Test
    void should_return_you_win_when_guessGame_given_correct_input_within_six_times_and_answer() {
        //given
        GameProcess gameProcess = new GameProcess();
        int[] firstGuessInput = {1, 8, 3, 4};
        int[] secondGuessInput = {5, 8, 7, 9};
        int[] thirdGuessInput = {1, 2, 3, 4};

        //when
        gameProcess.guessGame(firstGuessInput,guessNumber);
        gameProcess.guessGame(secondGuessInput,guessNumber);
        String result = gameProcess.guessGame(thirdGuessInput,guessNumber);
        //then
        Assertions.assertEquals("You Win!",result);
    }
}
