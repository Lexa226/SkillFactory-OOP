public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!isPositionValid(line, column, toLine, toColumn))
            return false;

        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            int stepLine = Integer.compare(toLine, line);
            int stepColumn = Integer.compare(toColumn, column);

            for (int i = line + stepLine, j = column + stepColumn; i != toLine
                    || j != toColumn; i += stepLine, j += stepColumn) {
                if (board.board[i][j] != null)
                    return false;
            }

            ChessPiece target = board.board[toLine][toColumn];
            return target == null || !target.color.equals(this.color);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
