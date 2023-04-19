public
    class Knight
    extends ChessFigure {


    Knight(String color) {
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
        return "KN";
    }
}
