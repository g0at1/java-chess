package logic;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private final JButton[][] squares = new JButton[8][8];
    private final ChessGame game;
    private final JLabel statusLabel;

    private int selectedX = -1;
    private int selectedY = -1;

    public BoardPanel(ChessGame game, JLabel statusLabel) {
        this.game = game;
        this.statusLabel = statusLabel;

        setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                button.setFont(new Font("SansSerif", Font.PLAIN, 32));
                button.setFocusPainted(false);

                int x = i;
                int y = j;

                button.addActionListener(e -> handleClick(x, y));

                squares[i][j] = button;
                add(button);
            }
        }

        refreshBoard();
    }

    private void handleClick(int x, int y) {
        if (selectedX == -1 && selectedY == -1) {
            ChessFigure figure = game.getGameBoard().getFigure(x, y);
            if (figure == null) {
                statusLabel.setText("No figure selected.");
                return;
            }

            selectedX = x;
            selectedY = y;
            statusLabel.setText("Selected: " + toChessNotation(x, y));
        } else {
            String result = game.makeMove(selectedX, selectedY, x, y);
            selectedX = -1;
            selectedY = -1;

            refreshBoard();
            statusLabel.setText(result + " Turn: " + game.getTurnColor());
        }
    }

    public void refreshBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = squares[i][j];

                if ((i + j) % 2 == 0) {
                    button.setBackground(new Color(240, 217, 181));
                } else {
                    button.setBackground(new Color(181, 136, 99));
                }

                ChessFigure figure = GameBoard.getBoard()[i][j];
                if (figure == null) {
                    button.setText("");
                } else {
                    button.setText(getPieceSymbol(figure));
                }
            }
        }
    }

    private String toChessNotation(int x, int y) {
        char file = (char) ('a' + y);
        int rank = 8 - x;
        return "" + file + rank;
    }

    private String getPieceSymbol(ChessFigure figure) {
        String symbol = figure.getSymbol();

        if (figure.getColor().equals("white")) {
            return switch (symbol) {
                case "R" -> "\u2656";
                case "KN" -> "\u2658";
                case "B" -> "\u2657";
                case "Q" -> "\u2655";
                case "K" -> "\u2654";
                default -> "\u2659";
            };
        } else {
            return switch (symbol) {
                case "R" -> "\u265C";
                case "KN" -> "\u265E";
                case "B" -> "\u265D";
                case "Q" -> "\u265B";
                case "K" -> "\u265A";
                default -> "\u265F";
            };
        }
    }
}
