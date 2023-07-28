package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;

public class Bishop extends Piece {

    public Bishop(int row, int column, Color color) {
        super(row, column, PieceType.BISHOP);
        setColor(color);
    }

    public String toString() {
        return getColor() == Color.WHITE ? "B" : "b";
    }

}
