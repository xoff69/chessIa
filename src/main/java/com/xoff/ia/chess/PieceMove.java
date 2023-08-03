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
        else{
            if (moveType == MoveType.TAKE||moveType == MoveType.EP

            ) {
                sb.append((char) ('a' + source.getColumn()));
            }
        }
        // sb.append(source);
        if (moveType == MoveType.TAKE||moveType == MoveType.EP||moveType == MoveType.PROMOTION_ROOK_TAKE||
                moveType == MoveType.PROMOTION_QUEEN_TAKE||
                moveType == MoveType.PROMOTION_KNIGHT_TAKE||
                moveType == MoveType.PROMOTION_BISHOP_TAKE

        ) {
            sb.append("x");
        }
        sb.append(destination);
        if (moveType==MoveType.EP)
        {
            sb.append("ep");
        }
        if (moveType==MoveType.PROMOTION_BISHOP_TAKE||moveType==MoveType.PROMOTION_BISHOP)
        {
            sb.append("=B");
        }else  if (moveType==MoveType.PROMOTION_QUEEN_TAKE||moveType==MoveType.PROMOTION_QUEEN)
        {
            sb.append("=B");
        }else  if (moveType==MoveType.PROMOTION_ROOK_TAKE||moveType==MoveType.PROMOTION_ROOK)
        {
            sb.append("=R");
        }
        else  if (moveType==MoveType.PROMOTION_KNIGHT_TAKE||moveType==MoveType.PROMOTION_KNIGHT)
        {
            sb.append("=N");
        }
        return sb.toString();
    }

}
