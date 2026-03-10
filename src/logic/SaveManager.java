package logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveManager {

    public static void saveGame(String fileName,
                                ChessFigure[][] board,
                                boolean whiteTurn,
                                boolean gameOver,
                                boolean isDrawOffer,
                                boolean blackDraw,
                                boolean whiteDraw) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

            dos.writeBoolean(whiteTurn);
            dos.writeBoolean(gameOver);
            dos.writeBoolean(isDrawOffer);
            dos.writeBoolean(blackDraw);
            dos.writeBoolean(whiteDraw);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    ChessFigure figure = board[i][j];

                    if (figure == null) {
                        dos.writeBoolean(false);
                    } else {
                        dos.writeBoolean(true);
                        dos.writeUTF(figure.getClass().getSimpleName());
                        dos.writeUTF(figure.getColor());
                    }
                }
            }

            System.out.println("Game saved successfully to binary file: " + fileName);

        } catch (IOException e) {
            System.out.println("Error while saving game: " + e.getMessage());
        }
    }

    public static LoadedGame loadGame(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {

            boolean whiteTurn = dis.readBoolean();
            boolean gameOver = dis.readBoolean();
            boolean isDrawOffer = dis.readBoolean();
            boolean blackDraw = dis.readBoolean();
            boolean whiteDraw = dis.readBoolean();

            ChessFigure[][] board = new ChessFigure[8][8];

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    boolean hasFigure = dis.readBoolean();

                    if (hasFigure) {
                        String type = dis.readUTF();
                        String color = dis.readUTF();
                        board[i][j] = createFigure(type, color, i, j);
                    } else {
                        board[i][j] = null;
                    }
                }
            }

            System.out.println("Game loaded successfully from binary file: " + fileName);

            return new LoadedGame(
                    board,
                    whiteTurn,
                    gameOver,
                    isDrawOffer,
                    blackDraw,
                    whiteDraw
            );

        } catch (IOException e) {
            System.out.println("Error while loading game: " + e.getMessage());
            return null;
        }
    }

    private static ChessFigure createFigure(String type, String color, int x, int y) {
        return switch (type) {
            case "Pawn" -> new Pawn(color, x, y);
            case "Rook" -> new Rook(color, x, y);
            case "Knight" -> new Knight(color, x, y);
            case "Bishop" -> new Bishop(color, x, y);
            case "Queen" -> new Queen(color, x, y);
            case "King" -> new King(color, x, y);
            default -> throw new IllegalArgumentException("Unknown figure type: " + type);
        };
    }
}
