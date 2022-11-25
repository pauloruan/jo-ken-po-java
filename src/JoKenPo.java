import java.util.Random;
import java.util.Scanner;

public record JoKenPo(
        Player user,
        Player IA,
        int rounds
) {
    public void toPlay() {
        System.out.println("\n Welcome to JoKenPo, " + user.getName() + "!\n");
        for(int index = 1; index <= rounds; index++){
            int choiceUser = choiceUser();
            int choiceIA = choiceIA();
            if (choiceUser < 1 || choiceUser > 3) {
                System.out.println("Invalid choice! Please, choose a number between 1 and 3.\n");
                IA.incrementScore();
                System.out.println("Point for " + IA.getName() + "\n");
                continue;
            }
            int result = choiceUser - choiceIA;
            winnerRound(result);
            showRoundResult(choiceUser, choiceIA);
        }
    }

    private int choiceUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your move: \n\t 1 - Rock \n\t 2 - Paper \n\t 3 - Scissors");
        return scan.nextInt();
    }

    private int choiceIA() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    private void winnerRound(int result) {
        String winnerRound;
        if(result == 0) {
            winnerRound = "Tie";
        } else {
            if (result == -1 || result == 2) {
                IA.incrementScore();
                winnerRound = IA.getName();
            } else {
                user.incrementScore();
                winnerRound = user.getName();
            }
        }
    }

    public void showRoundResult(int choiceUser, int choiceIA) {
        Integer roundScoreUser = user.getScore();
        Integer roundScoreIA = IA.getScore();
        System.out.println("ROUND SCORE: " + user.getName() + " " + choiceUser + " X " + choiceIA + " " + IA.getName() + "\n");
        if (roundScoreUser.equals(roundScoreIA)) {
            System.out.println("The round ended in a draw\n");
        } else {
            String finalWinner = (roundScoreUser > roundScoreIA) ? user.getName() : IA.getName();
            System.out.println("Point for " + finalWinner +"\n");
        }
    }

    public void showFinalResult() {
        System.out.println("\n\t==================================\n");
        Integer finalScoreUser = user.getScore();
        Integer finalScoreIA = IA.getScore();
        System.out.println("\n\tFINAL SCORE: " + user.getName() + " " +  finalScoreUser + " X " + finalScoreIA + " " + IA.getName() + "\n");
        if (finalScoreUser.equals(finalScoreIA)) {
            System.out.println("\n\tThe game ended in a draw\n");
        } else {
            String finalWinner = (finalScoreUser > finalScoreIA) ? user.getName() : IA.getName();
            System.out.println("\n\t" + finalWinner + " WINNER!\n");
        }
        System.out.println("\n\t==================================\n");
    }
}
