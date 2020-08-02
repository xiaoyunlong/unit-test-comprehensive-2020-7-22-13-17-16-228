package example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameProcess {
    private int availableGameTimes = 6;

    public String guessGame(int[] guessInput,GuessNumber guessNumber) {
        this.availableGameTimes --;
        if (availableGameTimes <=0) {
            return "Game Over!";
        }
        String thisGameResult;
        thisGameResult = guessNumber.guess(guessInput);

        if (thisGameResult.equals("4A0B")) {
            return "You Win!";
        }
        System.out.println("the output of this time is:" + thisGameResult);
        return "The game continues...";
    }

    private int[] getInputArrays() {
        System.out.println("please input four number from 0 to 9");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        return Arrays.stream(inputStr.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public String checkGuessNumber(int[] inputArrays) {
        if (inputArrays.length != 4) {
            return "Wrong Input,Input again.";
        }
        int distinctSizeofInputNumber = Arrays.asList(inputArrays)
                .stream()
                .distinct()
                .collect(Collectors.toList())
                .size();

        if (distinctSizeofInputNumber != inputArrays.length) {
            return "Wrong Input,Input again.";
        }
        return "OK";
    }


}
