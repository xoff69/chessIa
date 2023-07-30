package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.PieceMove;

import java.util.ArrayList;
import java.util.List;

public class Empty extends Piece {
    public Empty(int row, int column) {
        super(row, column, PieceType.EMPTY);

    }

    public float estimateValue() {
        return 0.f;
    }

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {
        return new ArrayList<>();
    }

    public String toString() {
        return ".";
    }
}
