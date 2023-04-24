public
    class Queen
    extends ChessFigure
    implements FigureMove {


    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        if (dx == dy) {
            // Ruch jest legalny dla gonca
            return true;
        }

        // Sprawdzenie, czy ruch jest w pionie lub poziomie
        if (x1 == x2 || y1 == y2) {
            // Ruch jest legalny dla wieży
            return true;
        }


        // Sprawdzenie, czy ruch jest poza planszą
        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7 || x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
            return false;
        }

        // Ruch jest nielegalny dla hetmana
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
