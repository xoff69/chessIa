package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.PieceMove;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(int row, int column, Color color) {
        super(row, column, PieceType.KNIGHT);
        setColor(color);
    }

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {
        List<PieceMove> moves = new ArrayList<>();

        evaluateAndNext(gameStateChess, row - 1, column - 2, moves);
        evaluateAndNext(gameStateChess, row + 1, column - 2, moves);
        evaluateAndNext(gameStateChess, row - 1, column + 2, moves);
        evaluateAndNext(gameStateChess, row + 1, column + 2, moves);

        evaluateAndNext(gameStateChess, row - 2, column - 1, moves);
        evaluateAndNext(gameStateChess, row + 2, column - 1, moves);
        evaluateAndNext(gameStateChess, row - 2, column + 1, moves);
        evaluateAndNext(gameStateChess, row + 2, column + 1, moves);

        return moves;


    }

    public String toString() {
        return getColor() == Color.WHITE ? "N" : "n";
    }

}
