package example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static int MAX_GAME_TIMES = 6;

    public String guess(int[] guessInput, int[] answer) {
        int countA = this.getCountOfGuessInputCorrectNumberAndPosition(guessInput, answer);
        int countB = this.getCountOfGuessInputCorrectNumber(guessInput, answer);
        return countA + "A" + countB + "B";
    }

    public int getCountOfGuessInputCorrectNumberAndPosition(int[] guessInput, int[] answer) {
        int result = 0;
        for (int index = 0; index < guessInput.length; index++) {
            if (guessInput[index] == answer[index]) {
                result++;
            }
        }
        return result;
    }

    public int getCountOfGuessInputCorrectNumber(int[] guessInput, int[] answer) {
        int result = 0;
        for (int index = 0; index < guessInput.length; index++) {
            //binarySearch(Object[], int fromIndex（包含）, int toIndex(不包含), Object key) return index
            if (Arrays.binarySearch(answer, guessInput[index]) >= 0) {
                if (guessInput[index] != answer[index]) {
                    result++;
                }
            }
        }
        return result;
    }

    public int[] gameStrat() {
        //写到这里的时候着急了，忘了小步提交！！！
        Random random = new Random();
        int[] result = new int[4] ;
        for (int index = 0; index < result.length; index++) {
            result[index] = random.nextInt(10); //随机数可能会重复！
//            System.out.println(result[index]);
        }
        return result;
    }

    public String checkGuessInputNumber(int[] guessInputNumber) {
        if(guessInputNumber.length < 4 && guessInputNumber!=null){
            return "Wrong Input，Input again.";
        }
        for (int index = 0; index < guessInputNumber.length; index++) {
            for (int index2 = index+1; index2 < guessInputNumber.length; index2++) {
                if (guessInputNumber[index] == guessInputNumber[index2]){
                    return "Wrong Input，Input again.";
                }
            }
        }
        return "OK";
    }

    public String game() {
        Scanner sc = new Scanner(System.in);
        int[] answer = this.gameStrat();
        int[] guessInput = new int[answer.length];
        String result;
        for (int gameTime = 0; gameTime < MAX_GAME_TIMES; gameTime++) {
            for (int index = 0; index < answer.length; index++) {
                guessInput[index] = sc.nextInt();
            }
            if(checkGuessInputNumber(guessInput).equals("OK")){
                result = guess(guessInput,answer);
                System.out.println("第"+gameTime+"次游戏的output:"+result);
                if (result.equals("4A0B")){
                    return "You Win!";
                }
            }
        }
        return "Game Over!";
    }

    public boolean isGameTimesLessThanMaxTimes(int gameTimes){
        if(gameTimes > 6){
            return false;
        }
        return true;
    }
}
