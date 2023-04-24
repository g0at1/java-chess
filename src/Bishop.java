public
    class Bishop
    extends ChessFigure
    implements FigureMove {


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

        // Check if there are any pieces in the way
        int xDir = (x2 - x1) / Math.abs(x2 - x1); // 1 or -1
        int yDir = (y2 - y1) / Math.abs(y2 - y1); // 1 or -1
        int x = x1 + xDir;
        int y = y1 + yDir;
        while (x != x2 && y != y2) {
            if (board[x][y] != null) {
                // There is a piece in the way
                return false;
            }
            x += xDir;
            y += yDir;
        }

        // Check if destination square is empty or has an enemy piece


        // Sprawdzenie, czy ruch jest poza planszą
        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7 || x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
            return false;
        }

        // Ruch jest legalny dla gonca
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
