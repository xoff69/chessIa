package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Case;
import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.MoveType;
import com.xoff.ia.chess.PieceMove;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class King extends Piece {
    private boolean hasCastled;

    public King(int row, int column, Color color) {
        super(row, column, PieceType.KING);
        setColor(color);
        hasCastled = false;
    }

    public float estimateValue() {
        return 1000f;
    }

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {


        List<PieceMove> moves = new ArrayList<>();
        evaluateAndNext(gameStateChess, getRow(), getColumn() + 1, moves);
        evaluateAndNext(gameStateChess, getRow(), getColumn() - 1, moves);
        evaluateAndNext(gameStateChess, getRow() + 1, getColumn() + 1, moves);
        evaluateAndNext(gameStateChess, getRow() + 1, getColumn() - 1, moves);
        evaluateAndNext(gameStateChess, getRow() + 1, getColumn(), moves);
        evaluateAndNext(gameStateChess, getRow() + 1, getColumn(), moves);
        evaluateAndNext(gameStateChess, getRow() - 1, getColumn() + 1, moves);
        evaluateAndNext(gameStateChess, getRow() - 1, getColumn() - 1, moves);

        if (!isHasMoved()) {
            // FIXME ne pas etre en echec pendant le roque
            if (gameStateChess.getPieces()[getRow()][4].getPieceType() == PieceType.KING && gameStateChess.getPieces()[getRow()][5].getPieceType() == PieceType.EMPTY && gameStateChess.getPieces()[getRow()][6].getPieceType() == PieceType.EMPTY && gameStateChess.getPieces()[getRow()][7].getPieceType() == PieceType.ROOK && !gameStateChess.getPieces()[getRow()][7].isHasMoved()) {
                PieceMove pieceMove = new PieceMove(this);
                Case source = new Case(getRow(), 4);
                pieceMove.setSource(source);


                Case destination = new Case(getRow(), 6);

                pieceMove.setDestination(destination);
                pieceMove.setMoveType(MoveType.SHORT_CASTLE);

                moves.add(pieceMove);
            }
            if (gameStateChess.getPieces()[getRow()][4].getPieceType() == PieceType.KING && gameStateChess.getPieces()[getRow()][3].getPieceType() == PieceType.EMPTY && gameStateChess.getPieces()[getRow()][2].getPieceType() == PieceType.EMPTY && gameStateChess.getPieces()[getRow()][1].getPieceType() == PieceType.EMPTY && gameStateChess.getPieces()[getRow()][0].getPieceType() == PieceType.ROOK && !gameStateChess.getPieces()[getRow()][0].isHasMoved()) {
                PieceMove pieceMove = new PieceMove(this);
                Case source = new Case(getRow(), 4);
                pieceMove.setSource(source);


                Case destination = new Case(getRow(), 2);

                pieceMove.setDestination(destination);
                pieceMove.setMoveType(MoveType.LONG_CASTLE);

                moves.add(pieceMove);
            }

        }
        return moves;
    }

    public String toString() {
        return getColor() == Color.WHITE ? "K" : "k";
    }

}
