public
    class Pawn
    extends ChessFigure
    implements FigureMove {

    public Pawn(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(int x1, int y1, int x2, int y2) {
//        // Sprawdź czy x1 i y1 są w granicach szachownicy
//        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7) {
//            return false;
//        }
//
//        // Sprawdź czy x2 i y2 są w granicach szachownicy
//        if (x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
//            return false;
//        }
//
//        // Sprawdź czy pion porusza się tylko do przodu
//        if (y2 <= y1) {
//            return false;
//        }
//
//        // Sprawdź czy pion porusza się tylko o jedno pole do przodu
//        if (y2 > y1 + 2) {
//            return false;
//        }
//
//        // Sprawdź czy pion porusza się o jedno pole do przodu
//        if (y2 == y1 + 1) {
//            // Sprawdź czy pion nie próbuje się przemieścić na zajęte pole
//            if (board[x2][y2] != null) {
//                return false;
//            }
//        }
//
//        // Sprawdź czy pion porusza się o dwa pola do przodu
//        if (y2 == y1 + 2) {
//            // Sprawdź czy pion jest na pozycji początkowej (rank 2)
//            if (y1 != 1) {
//                return false;
//            }
//
//            // Sprawdź czy nie ma przeszkód między pozycją początkową a końcową
//            if (board[x1][y1+1] != null || board[x2][y2] != null) {
//                return false;
//            }
//        }
//
//        // Sprawdź czy pion próbuje się przesunąć na ukos
//        if (x2 != x1 && y2 != y1 + 1) {
//            return false;
//        }
//
//        // Sprawdź czy pion próbuje zbić figurę przeciwnika
//        if (x2 != x1 && y2 == y1 + 1) {
//            // Sprawdź czy na pozycji docelowej znajduje się figura przeciwnika
//            if (board[x2][y2] == null || board[x2][y2].getColor() == getColor()) {
//                return false;
//            }
//        }

        // Sprawdzenie, czy ruch jest w pionie.
        if (y1 == y2) {
            // Sprawdzenie, czy pionek porusza się o jedno pole do przodu.
            if (this.getColor().equals("white") && x2 == x1 - 1) {
                return true;
            }
            // Sprawdzenie, czy pionek porusza się o dwa pola do przodu z pola startowego.
            if (this.getColor().equals("white") && x2 == x1 - 2 && x1 == 6) {
                return true;
            }
            // Sprawdzenie, czy pionek czarny porusza się o jedno pole do przodu.
            if (!this.getColor().equals("white") && x2 == x1 + 1) {
                return true;
            }
            // Sprawdzenie, czy pionek czarny porusza się o dwa pola do przodu z pola startowego.
            if (!this.getColor().equals("white") && x2 == x1 + 2 && x1 == 1) {
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
