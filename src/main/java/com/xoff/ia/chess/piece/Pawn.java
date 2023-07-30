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

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {

        List<PieceMove> moves = new ArrayList<>();
        // step +1
        // TODO :LES PROMOTIONS
        {
            boolean isMovePossible = color == Color.WHITE ? row < 7 : row > 0;
            if (isMovePossible) {
                PieceMove pieceMove = new PieceMove(this);
                Case source = new Case(row, column);
                pieceMove.setSource(source);

                Piece piece = gameStateChess.getPieces()[color == Color.WHITE ? row + 1 : row - 1][column];
                if (piece.getPieceType() == PieceType.EMPTY) {
                    Case destination = new Case(color == Color.WHITE ? row + 1 : row - 1, column);

                    pieceMove.setDestination(destination);
                    pieceMove.setMoveType(MoveType.NA);

                    moves.add(pieceMove);
                }
            }
        }

        // step +2
        {
            boolean isMovePossible = color == Color.WHITE ? row == 1 : row == 6;
            if (isMovePossible) {


                PieceMove pieceMove = new PieceMove(this);
                Case source = new Case(row, column);
                pieceMove.setSource(source);

                Piece piece = gameStateChess.getPieces()[color == Color.WHITE ? row + 2 : row - 1][column];
                if (piece.getPieceType() == PieceType.EMPTY) {
                    Case destination = new Case(color == Color.WHITE ? row + 2 : row - 1, column);

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
