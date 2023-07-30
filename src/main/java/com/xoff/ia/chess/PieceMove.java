package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Piece;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PieceMove implements Move {
    Case source;
    Case destination;
    MoveType moveType;

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(piece.toString());
        sb.append(source);
        if (moveType==MoveType.TAKE){
            sb.append("x");
        }
        sb.append(destination);
        return sb.toString();
    }

}
