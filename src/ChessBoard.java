public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public ChessPiece getPiece(int row, int column) {
        if (ChessPiece.isWithinBounds(row, column)) {
            return board[row][column];
        } else {
            return null;
        }
    }

    public boolean moveToPosition(int fromLine, int fromColumn, int toLine, int toColumn) {
        if (board[fromLine][fromColumn] != null &&
                board[fromLine][fromColumn].canMoveToPosition(this, fromLine, fromColumn, toLine, toColumn)) {

            ChessPiece piece = board[fromLine][fromColumn];

            board[toLine][toColumn] = piece;
            board[fromLine][fromColumn] = null;

            if (piece instanceof King || piece instanceof Rook) {
                piece.check = false;
            }

            nowPlayer = nowPlayer.equals("White") ? "Black" : "White";
            return true;
        }
        return false;
    }

    public boolean castling0() {
        if (nowPlayer.equals("White")) {

            ChessPiece kingPiece = board[0][4];

            if (kingPiece != null && kingPiece.getSymbol().equals("K") &&
                    board[0][0] != null && board[0][0].getSymbol().equals("R") &&
                    board[0][0].check && kingPiece.check &&
                    board[0][1] == null && board[0][2] == null && board[0][3] == null &&
                    !((King) kingPiece).isUnderAttack(this, 0, 2)) {

                board[0][2] = kingPiece;
                board[0][4] = null;
                board[0][3] = board[0][0];
                board[0][0] = null;

                nowPlayer = "Black";
                return true;
            }
        }
        return false;
    }

    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            ChessPiece kingPiece = board[0][4];

            if (kingPiece != null && kingPiece.getSymbol().equals("K") &&
                    board[0][7] != null && board[0][7].getSymbol().equals("R") &&
                    board[0][7].check && kingPiece.check &&
                    board[0][5] == null && board[0][6] == null &&
                    !((King) kingPiece).isUnderAttack(this, 0, 6)) {

                board[0][6] = kingPiece;
                board[0][4] = null;
                board[0][5] = board[0][7];
                board[0][7] = null;

                nowPlayer = "Black";
                return true;
            }
        }
        return false;
    }

    public void printBoard() {
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.print("Ходит Player 2(Black) -> ");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(
                            board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.print("Ходит Player 1(White) -> ");
    }
}
