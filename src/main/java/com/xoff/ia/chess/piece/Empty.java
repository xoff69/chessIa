package com.xoff.ia.chess.piece;

public class Empty extends Piece {

    public Empty(int row, int column) {
        super(row, column, PieceType.EMPTY);

    }

    public String toString() {
        return ".";
    }
}
