public
    class Queen
    extends ChessFigure
    implements FigureMove {


    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(int x1, int y1, int x2, int y2) {
        //bishop check
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        if (dx == dy) {
            return true;
        }

        //rook check
        if (x1 == x2 || y1 == y2) {
            return true;
        }
        return false;
    }

    @Override
    public void move(int x1, int y1, int x2, int y2) {
        ChessFigure piece = board[x1][y1];
        board[x2][y2] = piece;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
