public class Pawn extends ChessFigure implements FigureMove {
    public Pawn(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(int x1, int y1, int x2, int y2) {
        if (y1 == y2) {
            //jedno do przodu bialy
            if (this.getColor().equals("white") && x2 == x1 - 1) {
                return true;
            }
            //dwa do przodu od startu bialy
            if (this.getColor().equals("white") && x2 == x1 - 2 && x1 == 6) {
                return true;
            }
            //jedno do przodu czarny
            if (this.getColor().equals("black") && x2 == x1 + 1) {
                return true;
            }
            //dwa do przodu od startu czarny
            if (this.getColor().equals("black") && x2 == x1 + 2 && x1 == 1) {
                return true;
            }
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
        return "P";
    }

}
