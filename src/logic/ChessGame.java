package logic;

public class ChessGame {
    private GameBoard gameBoard;
    private boolean whiteTurn = true;
    private boolean gameOver = false;
    private boolean isDrawOffer = false;
    private boolean blackDraw = false;
    private boolean whiteDraw = false;

    public ChessGame() {
        gameBoard = new GameBoard();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getTurnColor() {
        return whiteTurn ? "white" : "black";
    }

    public String makeMove(int x1, int y1, int x2, int y2) {
        if (gameOver) {
            return "Game is over.";
        }

        ChessFigure figure = gameBoard.getFigure(x1, y1);
        if (figure == null) {
            return "No figure on selected field.";
        }

        String turnColor = getTurnColor();

        if (!figure.getColor().equals(turnColor)) {
            return "Wrong figure. Try again.";
        }

        ChessFigure capturedFigure = gameBoard.getFigure(x2, y2);
        if (capturedFigure != null && capturedFigure.getColor().equals(turnColor)) {
            return "You cannot capture your own piece.";
        }

        String oppositeColor = figure.getColor().equals("white") ? "black" : "white";

        if (capturedFigure instanceof King && capturedFigure.getColor().equals(oppositeColor)) {
            gameOver = true;
        }

        if (!figure.isMoveValid(x1, y1, x2, y2)) {
            return "Invalid move.";
        }

        figure.move(x1, y1, x2, y2);
        gameBoard.removeFigure(x1, y1);

        if (gameOver) {
            return turnColor + " wins!";
        }

        whiteTurn = !whiteTurn;
        return "Move done.";
    }

    public void saveGame(String fileName) {
        SaveManager.saveGame(
                fileName,
                GameBoard.getBoard(),
                whiteTurn,
                gameOver,
                isDrawOffer,
                blackDraw,
                whiteDraw
        );
    }

    public void loadGame(String fileName) {
        LoadedGame loadedGame = SaveManager.loadGame(fileName);
        if (loadedGame != null) {
            GameBoard.setBoard(loadedGame.getBoard());
            whiteTurn = loadedGame.isWhiteTurn();
            gameOver = loadedGame.isGameOver();
            isDrawOffer = loadedGame.isDrawOffer();
            blackDraw = loadedGame.isBlackDraw();
            whiteDraw = loadedGame.isWhiteDraw();
        }
    }
}
