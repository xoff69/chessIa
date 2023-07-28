package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;

public class Knight extends Piece {

    public Knight(int row, int column, Color color) {
        super(row, column, PieceType.KNIGHT);
        setColor(color);
    }

    public String toString() {
        return getColor() == Color.WHITE ? "N" : "n";
    }

}
