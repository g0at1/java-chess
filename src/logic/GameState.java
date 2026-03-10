package logic;

import java.io.Serializable;

public class GameState implements Serializable {

    private static final long serialVersionUID = 1L;

    private ChessFigure[][] board;
    private boolean whiteTurn;
    private boolean gameOver;
    private boolean isDrawOffer;
    private boolean blackDraw;
    private boolean whiteDraw;

    public GameState(ChessFigure[][] board, boolean whiteTurn, boolean gameOver,
                     boolean isDrawOffer, boolean blackDraw, boolean whiteDraw) {
        this.board = board;
        this.whiteTurn = whiteTurn;
        this.gameOver = gameOver;
        this.isDrawOffer = isDrawOffer;
        this.blackDraw = blackDraw;
        this.whiteDraw = whiteDraw;
    }

    public ChessFigure[][] getBoard() {
        return board;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isDrawOffer() {
        return isDrawOffer;
    }

    public boolean isBlackDraw() {
        return blackDraw;
    }

    public boolean isWhiteDraw() {
        return whiteDraw;
    }
}
