public abstract
    class ChessFigure
    implements FigureMove {

    String color;

    ChessFigure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
