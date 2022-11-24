import java.util.Scanner;

public class Main {
    public static JoKenPo startGame() {
        System.out.println("Welcome to JoKenPo! \n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String playerName = scan.next().toUpperCase();
        Player user = new Player(playerName);
        Player IA = new Player("IA");
        System.out.println(playerName + ", how many rounds do you want to play? ");
        int rounds = scan.nextInt();
        return new JoKenPo(user, IA, rounds);
    }

    public static void main(String[] args) {
        startGame();
    }
}