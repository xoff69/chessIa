package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Case;
import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.MoveType;
import com.xoff.ia.chess.PieceMove;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(int row, int column, Color color) {
        super(row, column, PieceType.BISHOP);
        setColor(color);
    }

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {
        List<PieceMove> moves=new ArrayList<>();
        // validateMove
        int r=row;int c=column;
        while (r>-1&&c>-1){

            PieceMove pieceMove=new PieceMove();
            Case source = new Case(row, column);
            pieceMove.setSource(source);

            Piece piece=gameStateChess.getPieces()[r][c];
            if (piece.getPieceType()==PieceType.EMPTY){
                Case destination = new Case(r, c);

                pieceMove.setDestination(destination);
                pieceMove.setMoveType(MoveType.NA);
            }
            else if (piece.getColor()!=this.color){

                Case destination = new Case(r, c);

                pieceMove.setDestination(destination);
                pieceMove.setMoveType(MoveType.NA);
                break;
            }
            r--;
            c--;
        }

        return moves;
    }

    public String toString() {
        return getColor() == Color.WHITE ? "B" : "b";
    }

}
