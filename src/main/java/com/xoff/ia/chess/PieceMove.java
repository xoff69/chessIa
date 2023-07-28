package com.xoff.ia.chess;

import com.xoff.ia.common.Copyable;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PieceMove implements Move, Copyable {
    Case source;
    Case destination;
    MoveType moveType;

    public PieceMove copy() {
        PieceMove pieceMove = new PieceMove();
        pieceMove.setSource(source.copy());
        pieceMove.setDestination(destination.copy());
        pieceMove.setMoveType(moveType);
        return pieceMove;
    }


}
