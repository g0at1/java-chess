public abstract class ChessFigure implements FigureMove {

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
