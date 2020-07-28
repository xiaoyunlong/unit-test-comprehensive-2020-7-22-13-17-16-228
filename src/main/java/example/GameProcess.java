package example;

public class GameProcess {
    private int availableGameTimes = 6;
    //TODO
    private GuessNumber guessnumber;

    public GameProcess(GuessNumber guessnumber) {
        this.guessnumber = guessnumber;
    }

    // TODO magic string
    public String guessGame(int[] guessInput, int[] answer) {
        // TODO
        String thisGameResult;
        if (!isAvailableGameTimesMoreThenZero(availableGameTimes)) {
            return "Game Over!";
        }


        thisGameResult = guessnumber.guess(guessInput, answer);
        //TODO logic error
        this.availableGameTimes--;
        System.out.println("本次游戏的output:" + thisGameResult);
        if (thisGameResult.equals("4A0B")) {
            return "You Win!";
        }

        return "The game continues...";
    }

    public boolean isAvailableGameTimesMoreThenZero(int availableGameTimes) {
        return availableGameTimes > 0;
    }
}
