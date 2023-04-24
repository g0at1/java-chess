import java.io.*;

public
    class GameBoard {

    private static ChessFigure[][] board;


    public GameBoard() {
        board = new ChessFigure[8][8];
        initBoard();
        printBoard();
    }

    private void initBoard() {
        board[0][0] = new Rook("black", 0, 0);
        board[0][1] = new Knight("black", 0, 1);
        board[0][2] = new Bishop("black",0, 2);
        board[0][3] = new Queen("black",0, 3);
        board[0][4] = new King("black", 0, 4);
        board[0][5] = new Bishop("black", 0, 5);
        board[0][6] = new Knight("black", 0, 6);
        board[0][7] = new Rook("black", 0, 7);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black", 1, i);
            board[6][i] = new Pawn("white", 6, i);
        }

//        for (int i = 0; i < 8; i++) {
//            board[6][i] = new Pawn("white", 6, i);
//        }

        board[7][0] = new Rook("white", 7, 0);
        board[7][1] = new Knight("white", 7, 1);
        board[7][2] = new Bishop("white", 7, 2);
        board[7][3] = new Queen("white", 7, 3);
        board[7][4] = new King("white", 7, 4);
        board[7][5] = new Bishop("white", 7, 5);
        board[7][6] = new Knight("white", 7, 6);
        board[7][7] = new Rook("white", 7, 7);
    }

    public void printBoard() {
        System.out.println("   a  b  c  d  e  f  g  h");
        for (int i = 0; i < board.length; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < board[i].length; j++) {
                ChessFigure piece = board[i][j];
                if (piece == null) {
                    System.out.print(" - "); // puste pole
                }
                else {
                    String symbol = piece.getSymbol();
                    if (piece.getColor().equals("white")) {
                        symbol = switch (symbol) {
                            case "K" -> "\u265A"; // król
                            case "Q" -> "\u265B"; // hetman
                            case "R" -> "\u265C"; // wieża
                            case "B" -> "\u265D"; // goniec
                            case "KN" -> "\u265E"; // skoczek
                            default -> "\u265F"; // pionek
                        };
                    }
                    else {
                        symbol = switch (symbol) {
                            case "K" -> "\u2654"; // król
                            case "Q" -> "\u2655"; // hetman
                            case "R" -> "\u2656"; // wieża
                            case "B" -> "\u2657"; // goniec
                            case "KN" -> "\u2658"; // skoczek
                            default -> "\u2659"; // pionek
                        };
                    }
                    System.out.print(" " + symbol + " ");
                }
            }
            System.out.println(8 - i);
        }
        System.out.println("   a  b  c  d  e  f  g  h");
    }

    public ChessFigure getFigure(int x, int y) {
        return board[x][y];
    }

    public void removeFigure(int x, int y) {
        board[x][y] = null;
    }

    public static ChessFigure[][] getBoard() {
        return board;
    }

}
