package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Case;
import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.MoveType;
import com.xoff.ia.chess.PieceMove;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(int row, int column, Color color) {
        super(row, column, PieceType.PAWN);
        setColor(color);
    }

    public float estimateValue() {
        return 1.0f;
    }

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {

        List<PieceMove> moves = new ArrayList<>();
        // step +1
        // TODO :LES PROMOTIONS
        {
            boolean isMovePossible = getColor() == Color.WHITE ? getRow() < 7 : getRow() > 0;
            if (isMovePossible) {
                PieceMove pieceMove = new PieceMove(this);
                Case source = new Case(getRow(), getColumn());
                pieceMove.setSource(source);

                Piece piece = gameStateChess.getPieces()[getColor() == Color.WHITE ? getRow() + 1 : getRow() - 1][getColumn()];
                if (piece.getPieceType() == PieceType.EMPTY) {
                    Case destination = new Case(getColor() == Color.WHITE ? getRow() + 1 : getRow() - 1, getColumn());

                    pieceMove.setDestination(destination);
                    pieceMove.setMoveType(MoveType.NA);

                    moves.add(pieceMove);
                }
            }
        }

        // step +2
        {
            boolean isMovePossible = getColor() == Color.WHITE ? getRow() == 1 : getRow() == 6;
            if (isMovePossible) {


                PieceMove pieceMove = new PieceMove(this);
                Case source = new Case(getRow(), getColumn());
                pieceMove.setSource(source);

                Piece piece = gameStateChess.getPieces()[getColor() == Color.WHITE ? getRow() + 2 : getRow() - 2][getColumn()];
                if (piece.getPieceType() == PieceType.EMPTY) {
                    Case destination = new Case(getColor() == Color.WHITE ? getRow() + 2 : getRow() - 2, getColumn());

                    pieceMove.setDestination(destination);
                    pieceMove.setMoveType(MoveType.NA);

                    moves.add(pieceMove);
                }
            }
        }
        // TODO
        // les prises dont prises EP
        // les prises avec promotion
        return moves;

    }

    public String toString() {
        return getColor() == Color.WHITE ? "P" : "p";
    }

}
