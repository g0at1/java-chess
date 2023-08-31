public class Rook extends ChessFigure implements FigureMove {

    public Rook(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return false;
        }

        if (!(x1 == x2 || y1 == y2)) {
            return false;
        }

        //sprawdzenie czy po drodze nie ma innych figur
        int dx = 0;
        int dy = 0;
        if (x1 != x2) {
            dx = Integer.compare(x2, x1);
        }
        if (y1 != y2) {
            dy = Integer.compare(y2, y1);
        }
        int currX = x1 + dx;
        int currY = y1 + dy;
        while (currX != x2 || currY != y2) {
            if (board[currX][currY] != null) {
                return false;
            }
            currX += dx;
            currY += dy;
        }
        return true;
    }

    @Override
    public void move(int x1, int y1, int x2, int y2) {
        ChessFigure piece = board[x1][y1];
        board[x2][y2] = piece;
    }

    @Override
    public String getSymbol() {
        return "R";
    }


}
