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
}
