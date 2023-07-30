package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.PieceMove;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(int row, int column, Color color) {
        super(row, column, PieceType.KING);
        setColor(color);
    }

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {


        List<PieceMove> moves = new ArrayList<>();
        evaluateAndNext(gameStateChess, row, column + 1, moves);
        evaluateAndNext(gameStateChess, row, column - 1, moves);
        evaluateAndNext(gameStateChess, row + 1, column + 1, moves);
        evaluateAndNext(gameStateChess, row + 1, column - 1, moves);
        evaluateAndNext(gameStateChess, row + 1, column, moves);
        evaluateAndNext(gameStateChess, row + 1, column, moves);
        evaluateAndNext(gameStateChess, row - 1, column + 1, moves);
        evaluateAndNext(gameStateChess, row - 1, column - 1, moves);

        if (!isHasMoved()) {
            // FIXME ne pas etre en echec pendant le roque
            /* TODO CASTLE
            PieceMove pieceMove = new PieceMove(this);
            Case source = new Case(row, column);
            pieceMove.setSource(source);

            Piece piece = gameStateChess.getPieces()[r][c];

                Case destination = new Case(r, c);

                pieceMove.setDestination(destination);
                pieceMove.setMoveType(MoveType.NA);

                moves.add(pieceMove);

             */
        }
        return moves;
    }

    public String toString() {
        return getColor() == Color.WHITE ? "K" : "k";
    }

}
