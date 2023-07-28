package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;

public class Queen extends Piece {

    public Queen(int row, int column, Color color) {
        super(row, column, PieceType.QUEEN);
        setColor(color);
    }

    public String toString() {
        return getColor() == Color.WHITE ? "Q" : "q";
    }

}
