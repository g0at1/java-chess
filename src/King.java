public
    class King
    extends ChessFigure
    implements FigureMove {

    public King(String color, int x, int y) {
        super(color, x, y);
    }


    @Override
    public boolean isMoveValid(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
        if (dx <= 1 && dy <= 1) {
            return true;
        }
        if (dx == 0 && dy == 2) {
            if (y2 == 6) {
                return board[x1][7].getColor().equals("white");
            } else if (y2 == 2) {
                return board[x1][0].getColor().equals("white");
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
        return "K";
    }

    public boolean isCheckmate(String color) {
        // Pobieramy pozycję króla koloru podanego w argumencie
        int kingX = -1, kingY = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessFigure piece = board[i][j];
                if (piece instanceof King && piece.getColor().equals(color)) {
                    kingX = i;
                    kingY = j;
                    break;
                }
            }
        }

        // Sprawdzamy, czy król może się obronić lub uniknąć szacha
        for (int i = kingX - 1; i <= kingX + 1; i++) {
            for (int j = kingY - 1; j <= kingY + 1; j++) {
                if (i < 0 || i > 7 || j < 0 || j > 7) {
                    continue;
                }

                if (board[i][j] == null || board[i][j].getColor().equals(color)) {
                    // Sprawdzamy, czy król nie będzie już w szachu po wykonaniu ruchu
                    ChessFigure originalPiece = board[i][j];
                    board[i][j] = board[kingX][kingY];
                    board[kingX][kingY] = null;
                    board[kingX][kingY] = board[i][j];
                    board[i][j] = originalPiece;
                }
            }
        }

        // Jeśli nie ma możliwości obrony lub uniknięcia szacha, to mamy szach-mat
        return true;
    }

}
