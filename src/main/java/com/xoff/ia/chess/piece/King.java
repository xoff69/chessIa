package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;

public class King extends Piece {

    public King(int row, int column, Color color) {
        super(row, column, PieceType.KING);
        setColor(color);
    }

    public String toString() {
        return getColor() == Color.WHITE ? "K" : "k";
    }

}
