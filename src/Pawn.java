public
    class Pawn
    extends ChessFigure
    implements FigureMove {


    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return false;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
