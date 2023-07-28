package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Case;
import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.PieceMove;
import com.xoff.ia.common.Copyable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Piece implements Copyable {
    Color color;
    PieceType pieceType;
    List<Case> possiblesMoves;
    boolean hasMoved;
    // position on board
    int row;
    int column;

    public Piece(int row, int column, PieceType pieceType) {
        hasMoved = false;
        this.row = row;
        this.column = column;
        this.pieceType = pieceType;
        possiblesMoves = new ArrayList();
        color = Color.WHITE;
    }
public abstract List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess);
    public Piece copy() {
        Piece piece =null;

        switch (pieceType){
            case ROOK : piece=new Rook(row, column,color);break;
            case BISHOP:  piece=new Rook(row, column,color);break;
            case KNIGHT:  piece=new Rook(row, column,color);break;
            case QUEEN:  piece=new Queen(row, column,color);break;
            case KING:  piece=new King(row, column,color);break;
            case PAWN:  piece=new Pawn(row, column,color);break;
            default: piece=new Empty(row,column);
        }

        piece.setHasMoved(hasMoved);

        return piece;
    }


}
