package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.PieceMove;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess){
        return new ArrayList<>();
    }
    public Bishop(int row, int column, Color color) {
        super(row, column, PieceType.BISHOP);
        setColor(color);
    }

    public String toString() {
        return getColor() == Color.WHITE ? "B" : "b";
    }

}
