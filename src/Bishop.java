public
    class Bishop
    extends ChessFigure {


    public Bishop(String color) {
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
        return "B";
    }
}
