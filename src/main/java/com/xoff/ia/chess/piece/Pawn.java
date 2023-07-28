package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;

public class Pawn extends Piece {

    public Pawn(int row, int column, Color color) {
        super(row, column, PieceType.PAWN);
        setColor(color);
    }

    public String toString() {
        return getColor() == Color.WHITE ? "P" : "p";
    }

}
