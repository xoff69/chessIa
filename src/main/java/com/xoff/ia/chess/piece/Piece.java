package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Case;
import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.MoveType;
import com.xoff.ia.chess.PieceMove;
import com.xoff.ia.common.Copyable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Piece implements Copyable {
    private Color color;
    private PieceType pieceType;
    private boolean hasMoved;
    // position on board
    private int row;
    private int column;

    public Piece(int row, int column, PieceType pieceType) {
        hasMoved = false;
        this.row = row;
        this.column = column;
        this.pieceType = pieceType;
        color = Color.WHITE;
    }

    protected boolean isInBounds(int value) {
        return (value >= 0 && value < 8);
    }

    protected boolean evaluateAndNext(GameStateChess gameStateChess, int r, int c, List<PieceMove> moves) {
        if (!isInBounds(r) || !isInBounds(c)) {
            return false;
        }
        PieceMove pieceMove = new PieceMove(this);
        Case source = new Case(row, column);
        pieceMove.setSource(source);

        Piece piece = gameStateChess.getPieces()[r][c];
        if (piece.getPieceType() == PieceType.EMPTY) {

            Case destination = new Case(r, c);

            pieceMove.setDestination(destination);
            pieceMove.setMoveType(MoveType.NA);

            moves.add(pieceMove);
            return true;
        } else if (piece.getColor() != this.color) {

            Case destination = new Case(r, c);

            pieceMove.setDestination(destination);
            pieceMove.setMoveType(MoveType.TAKE);
            moves.add(pieceMove);
            return false;
        } else {
            return false;
        }
    }

    public abstract float estimateValue();

    public abstract List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess);

    public boolean validateMove(PieceMove pieceMove, GameStateChess gameStateChess) {

        gameStateChess.play(pieceMove);
        return (!gameStateChess.isCheck());
    }

    public Piece copy() {
        Piece piece = null;

        switch (pieceType) {
            case ROOK:
                piece = new Rook(row, column, color);
                break;
            case BISHOP:
                piece = new Bishop(row, column, color);
                break;
            case KNIGHT:
                piece = new Knight(row, column, color);
                break;
            case QUEEN:
                piece = new Queen(row, column, color);
                break;
            case KING:
                piece = new King(row, column, color);
                break;
            case PAWN:
                piece = new Pawn(row, column, color);
                break;
            default:
                piece = new Empty(row, column);
        }

        piece.setHasMoved(hasMoved);

        return piece;
    }


}
