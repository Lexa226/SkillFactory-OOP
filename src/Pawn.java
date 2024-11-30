public class Pawn extends ChessPiece {
    public Pawn(String color) {
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

        int direction = this.color.equals("White") ? 1 : -1;

        if (column == toColumn) {
            if (toLine - line == direction && board.board[toLine][toColumn] == null) {
                return true;
            } else if (line == (this.color.equals("White") ? 1 : 6) && toLine - line == 2 * direction
                    && board.board[toLine][toColumn] == null) {
                return board.board[line + direction][toColumn] == null;
            }
        } else if (Math.abs(column - toColumn) == 1 && toLine - line == direction) {
            return board.board[toLine][toColumn] != null && !board.board[toLine][toColumn].color.equals(this.color);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
