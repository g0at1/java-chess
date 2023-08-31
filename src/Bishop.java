public class Bishop extends ChessFigure implements FigureMove {

    public Bishop(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        if (dx != dy) {
            return false;
        }

        //sprawdzenie czy po drodze nie ma innej figury
        int xDir = (x2 - x1) / Math.abs(x2 - x1);
        int yDir = (y2 - y1) / Math.abs(y2 - y1);
        int x = x1 + xDir;
        int y = y1 + yDir;
        while (x != x2 && y != y2) {
            if (board[x][y] != null) {
                return false;
            }
            x += xDir;
            y += yDir;
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
        return "B";
    }
}
