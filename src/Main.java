import java.util.Scanner;

public
    class Main {

    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        boolean whiteTurn = true;
        boolean gameOver = false;
        boolean isDrawOffer = false;
        boolean blackDraw = false;
        boolean whiteDraw = false;

        while (!gameOver) {
            String turnColor = whiteTurn ? "white" : "black";
            System.out.println(turnColor + " turn");

            System.out.print("Enter move (a2 a3 format or type draw): ");
            String input = scanner.nextLine();

            if (input.equals("draw")) {
                if (turnColor.equals("white")) {
                    whiteDraw = true;
                }
                else {
                    blackDraw = true;
                }

                if (whiteDraw && blackDraw) {
                    System.out.println("Game ended in a draw!");
                    gameOver = true;
                }
                else {
                    System.out.println(turnColor + " offered a draw.");
                    whiteTurn = !whiteTurn;
                    isDrawOffer = true;
                }
                continue;
            }
            if (isDrawOffer) {
                System.out.println("Draw offer declined.");
                isDrawOffer = false;

            }

            String[] moves = input.split(" ");
            int x1 = 8 - (moves[0].charAt(1) - '0');
            System.out.println(x1);
            int y1 = moves[0].charAt(0) - 'a';
            System.out.println(y1);
            int x2 = 8 - (moves[1].charAt(1) - '0');
            int y2 = moves[1].charAt(0) - 'a';


            ChessFigure figure = board.getFigure(x1, y1);
            String oppositeColor = figure.getColor().equals("white") ? "black" : "white";

            if (!figure.getColor().equals(turnColor)) {
                board.printBoard();
                System.out.println("Wrong figure. Try again.");
                continue;
            }

            ChessFigure capturedFigure = board.getFigure(x2, y2);
            if (capturedFigure instanceof King && capturedFigure.getColor().equals(oppositeColor)) {
                gameOver = true;
                System.out.println(turnColor + " wins!");
            }
            if (capturedFigure != null) {
                System.out.println(
                    "Captured " + capturedFigure.getColor() + " " + capturedFigure.getSymbol() + "!"
                );
            }
            if (figure.isMoveValid(x1, y1, x2, y2)) {
                figure.move(x1, y1, x2, y2);
                board.removeFigure(x1, y1);
                board.printBoard();
            }
            else {
                board.printBoard();
                System.out.println("Invalid move. Try again.");
                continue;
            }

            whiteTurn = !whiteTurn;
        }
    }
}
