package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Piece {
    Color color;
    PieceType pieceType;
    int[][] possiblesDeplacements;
    boolean hasMoved;
    // position on board
    int row;
    int column;

    public Piece(int row,int column,PieceType pieceType){
        hasMoved=false;
        this.row=row;
        this.column=column;
        this.pieceType=pieceType;
        possiblesDeplacements=new int[8][8];
        color=Color.WHITE;
    }
    public static Piece empty(int raw,int column){
        Piece piece=new Piece(raw,column,PieceType.EMPTY);
        return piece;
    }


}
