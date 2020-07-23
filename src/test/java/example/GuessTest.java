package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuessTest {

    @Test
    void should_return_4A0B_when_guess_given_guess_number_1234_and_answer_1234(){
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] guessInput = {1,2,3,4};
        int[] answer = {1,2,3,4};
        //when
        String result = guessNumber.guess(guessInput,answer);
        //then
        Assertions.assertEquals("4A0B",result);
    }

    @Test
    void should_return_0A0B_when_guess_given_guess_number_1234_and_answer_5678(){
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] guessInput = {1,2,3,4};
        int[] answer = {5,6,7,8};
        //when
        String result = guessNumber.guess(guessInput,answer);
        //then
        Assertions.assertEquals("0A0B",result);
    }

    @Test
    void should_return_2A0B_when_guess_given_guess_number_1234_and_answer_1278(){
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] guessInput = {1,2,3,4};
        int[] answer = {1,2,7,8};
        //when
        String result = guessNumber.guess(guessInput,answer);
        //then
        Assertions.assertEquals("2A0B",result);
    }

}
