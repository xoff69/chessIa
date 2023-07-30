package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Piece;
import com.xoff.ia.chess.piece.PieceType;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PieceMove implements Move {
    private Case source;
    private Case destination;
    private MoveType moveType;

    private Piece piece;

    public PieceMove(Piece piece) {
        this.piece = piece;
    }

    public PieceMove copy() {
        PieceMove pieceMove = new PieceMove(this.piece.copy());
        pieceMove.setSource(source.copy());
        pieceMove.setDestination(destination.copy());
        pieceMove.setMoveType(moveType);
        return pieceMove;
    }

    public String completeInfo() {
        StringBuilder sb = new StringBuilder();
        if (piece.getPieceType() != PieceType.PAWN) {
            sb.append(piece.toString());
        }
        sb.append(source);
        sb.append(moveType);

        sb.append(destination);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (piece.getPieceType() != PieceType.PAWN) {
            sb.append(piece.toString());
        }
        // sb.append(source); // TODO si c est une prise et que c est un pion mettre la column
        if (moveType == MoveType.TAKE) {
            sb.append("x");
        }
        sb.append(destination);
        return sb.toString();
    }

}
