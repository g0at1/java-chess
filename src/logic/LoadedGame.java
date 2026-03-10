package logic;

public class LoadedGame {
    private final ChessFigure[][] board;
    private final boolean whiteTurn;
    private final boolean gameOver;
    private final boolean isDrawOffer;
    private final boolean blackDraw;
    private final boolean whiteDraw;

    public LoadedGame(ChessFigure[][] board,
                      boolean whiteTurn,
                      boolean gameOver,
                      boolean isDrawOffer,
                      boolean blackDraw,
                      boolean whiteDraw) {
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
