public
    class Rook
    extends ChessFigure
    implements FigureMove {


    public Rook(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(int x1, int y1, int x2, int y2) {
//        if (x1 == x2) {
//            int minColumn = Math.min(y1, y2);
//            int maxColumn = Math.max(y1, y2);
//            for (int i = minColumn + 1; i < maxColumn; i++) {
//                if (!board[x1][i].equals(" - ")) {
//                    return false;
//                }
//            }
//            return true;
//        } else if (y1 == y2) {
//            int minRow = Math.min(x1, x2);
//            int maxRow = Math.max(x1, x2);
//            for (int i = minRow + 1; i < maxRow; i++) {
//                if (!board[i][y1].equals(" - ")) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;

        if (x1 == x2) {
            return true;
        }
        else if (y1 == y2) {
            return true;
        }
        int xDir = x1 == x2 ? 0 : (x2 - x1) / Math.abs(x2 - x1);
        int yDir = y1 == y2 ? 0 : (y2 - y1) / Math.abs(y2 - y1);
        int x = x1 + xDir;
        int y = y1 + yDir;
        while (x != x2 || y != y2) {
            if (board[x][y] != null) {
                // There is a piece in the way
                return false;
            }
            x += xDir;
            y += yDir;
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
        return "R";
    }


}
