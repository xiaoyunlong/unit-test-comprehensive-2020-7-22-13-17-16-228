package example;

public class GuessNumber {


    public String guess(int[] guessInput, int[] answer) {
        int count= this.getCountOfGuessInputCorrectNumberAndPosition(guessInput,answer);
        return count+"A0B";
    }

    public int getCountOfGuessInputCorrectNumberAndPosition(int[] guessInput,int[] answer){
        int result = 0;
        for (int index = 0; index < guessInput.length; index++) {
            if (guessInput[index] == answer[index]){
                result ++;
            }
        }
        return  result;
    }
}
