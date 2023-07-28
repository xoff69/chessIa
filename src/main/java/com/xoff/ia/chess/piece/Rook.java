package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;

public class Rook extends Piece {

    public Rook(int row, int column, Color color) {
        super(row, column, PieceType.ROOK);
        setColor(color);
    }

    public String toString() {
        return getColor() == Color.WHITE ? "R" : "r";
    }

}
