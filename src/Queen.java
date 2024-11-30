public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isWithinBounds(line, column) || !isWithinBounds(toLine, toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        if (line == toLine || column == toColumn ||
                Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
