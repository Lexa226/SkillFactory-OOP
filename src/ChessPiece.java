public abstract class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    protected boolean isPositionValid(int line, int column, int toLine, int toColumn) {
        return line >= 0 && line < 8 && column >= 0 && column < 8 &&
                toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8 &&
                !(line == toLine && column == toColumn);
    }

    public static boolean isWithinBounds(int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();
}
