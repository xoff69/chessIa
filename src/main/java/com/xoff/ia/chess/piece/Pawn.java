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
        {
            boolean isMovePossible = getColor() == Color.WHITE ? getRow() < 7 : getRow() > 0 && isInBounds(getColor() == Color.WHITE ? getRow() + 1 : getRow() - 1);
            if (isMovePossible) {
                PieceMove pieceMove = new PieceMove(this);
                Case source = new Case(getRow(), getColumn());
                pieceMove.setSource(source);

                Piece piece = gameStateChess.getPieces()[getColor() == Color.WHITE ? getRow() + 1 : getRow() - 1][getColumn()];
                if (piece.getPieceType() == PieceType.EMPTY) {


                    Case destination = new Case(piece.getRow(),piece.getColumn());

                    if (destination.getRow() == 7 || destination.getRow() == 0) {
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_BISHOP);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_ROOK);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_KNIGHT);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_QUEEN);
                            moves.add(pieceMovePromotion);
                        }
                    } else {
                        pieceMove.setMoveType(MoveType.NA);
                        pieceMove.setDestination(destination);
                        moves.add(pieceMove);
                    }

                }
            }
            // take 1
            if (isInBounds(getColor() == Color.WHITE ? getRow() + 1 : getRow() - 1) && isInBounds(getColumn() + 1)) {

                Piece piece = gameStateChess.getPieces()[getColor() == Color.WHITE ? getRow() + 1 : getRow() - 1][getColumn() + 1];
                if (piece.getColor() != getColor()&&piece.getPieceType()!=PieceType.EMPTY) {
                    PieceMove pieceMove = new PieceMove(this);
                    Case source = new Case(getRow(), getColumn());
                    pieceMove.setSource(source);
                    Case destination = new Case(piece.getRow(),piece.getColumn());

                    if (destination.getRow() == 7 || destination.getRow() == 0) {
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_BISHOP_TAKE);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_ROOK_TAKE);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_KNIGHT_TAKE);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_QUEEN_TAKE);
                            moves.add(pieceMovePromotion);
                        }
                    } else {
                        pieceMove.setDestination(destination);

                        pieceMove.setMoveType(MoveType.TAKE);
                        moves.add(pieceMove);
                    }

                }
            }
            // take 2
            if (isInBounds(getColor() == Color.WHITE ? getRow() + 1 : getRow() - 1) && isInBounds(getColumn() - 1)) {

                Piece piece = gameStateChess.getPieces()[getColor() == Color.WHITE ? getRow() + 1 : getRow() - 1][getColumn() - 1];
                if (piece.getColor() != getColor()&&piece.getPieceType()!=PieceType.EMPTY) {
                    PieceMove pieceMove = new PieceMove(this);
                    Case source = new Case(getRow(), getColumn());
                    pieceMove.setSource(source);
                    Case destination = new Case(piece.getRow(),piece.getColumn());

                    if (destination.getRow() == 7 || destination.getRow() == 0) {
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_BISHOP_TAKE);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_ROOK_TAKE);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_KNIGHT_TAKE);
                            moves.add(pieceMovePromotion);
                        }
                        {
                            PieceMove pieceMovePromotion = new PieceMove(this);
                            pieceMovePromotion.setSource(source);
                            pieceMovePromotion.setSource(destination);
                            pieceMove.setMoveType(MoveType.PROMOTION_QUEEN_TAKE);
                            moves.add(pieceMovePromotion);
                        }
                    } else {
                        pieceMove.setDestination(destination);

                        pieceMove.setMoveType(MoveType.TAKE);
                        moves.add(pieceMove);
                    }

                }
            }
        }

        // step +2
        {
            boolean isMovePossible = getColor() == Color.WHITE ? getRow() == 1 : getRow() == 6 && isInBounds(getColor() == Color.WHITE ? getRow() + 2 : getRow() - 2);
            if (isMovePossible) {


                PieceMove pieceMove = new PieceMove(this);
                Case source = new Case(getRow(), getColumn());
                pieceMove.setSource(source);

                Piece piece = gameStateChess.getPieces()[getColor() == Color.WHITE ? getRow() + 2 : getRow() - 2][getColumn()];
                if (piece.getPieceType() == PieceType.EMPTY) {
                    Case destination = new Case(piece.getRow(),piece.getColumn());

                    pieceMove.setDestination(destination);
                    pieceMove.setMoveType(MoveType.NA);

                    moves.add(pieceMove);
                }
            }
        }
        // TODO
        // les prises EP
    if (gameStateChess.getLastMove()!=null)
    {
        PieceMove lastMove=gameStateChess.getLastMove();
        if (lastMove.getPiece().getPieceType()==PieceType.PAWN&&Math.abs(lastMove.getDestination().getRow()-lastMove.getSource().getRow())==2){
            int pas=getColor() == Color.WHITE ?1:-1;
            if (getRow()==lastMove.getDestination().getRow()){
                 if (getColumn()+1==lastMove.getDestination().getColumn()){


                     PieceMove pieceMove = new PieceMove(this);
                     Case source = new Case(getRow(), getColumn());
                     pieceMove.setSource(source);

                     Piece piece = gameStateChess.getPieces()[getColor() == Color.WHITE ? getRow() + 1: getRow() - 1][getColumn()+1];
                     if (piece.getPieceType() == PieceType.EMPTY) {
                         Case destination = new Case(piece.getRow(),piece.getColumn());

                         pieceMove.setDestination(destination);
                         pieceMove.setMoveType(MoveType.EP);

                         moves.add(pieceMove);
                     }

                }else  if (getColumn()-1==lastMove.getDestination().getColumn()){
                     PieceMove pieceMove = new PieceMove(this);
                     Case source = new Case(getRow(), getColumn());
                     pieceMove.setSource(source);

                     Piece piece = gameStateChess.getPieces()[getColor() == Color.WHITE ? getRow() + 1: getRow() - 1][getColumn()-1];
                     if (piece.getPieceType() == PieceType.EMPTY) {
                         Case destination = new Case(piece.getRow(),piece.getColumn());

                         pieceMove.setDestination(destination);
                         pieceMove.setMoveType(MoveType.EP);

                         moves.add(pieceMove);
                     }
                }

            }
        }
    }
        return moves;

    }

    public String toString() {
        return getColor() == Color.WHITE ? "P" : "p";
    }

}
