package logic;

import java.io.Serializable;

public abstract class ChessFigure implements FigureMove, Serializable {

    private static final long serialVersionUID = 1L;

    private String color;
    private int x, y;

    ChessFigure[][] board = GameBoard.getBoard();

    ChessFigure(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public abstract String getSymbol();
}
