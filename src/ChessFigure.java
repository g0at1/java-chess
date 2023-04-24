public abstract
    class ChessFigure
    implements FigureMove {

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract String getSymbol();

}
