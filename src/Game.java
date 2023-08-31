import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    public Game() {
        new GameBoard();
        System.out.println("Choose your move: ");
        scanner.nextLine();
    }
}
