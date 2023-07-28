package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Case;
import com.xoff.ia.chess.Color;
import com.xoff.ia.common.Copyable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Piece implements Copyable {
    Color color;
    PieceType pieceType;
    List<Case> possiblesDeplacements;
    boolean hasMoved;
    // position on board
    int row;
    int column;

    public Piece(int row, int column, PieceType pieceType) {
        hasMoved = false;
        this.row = row;
        this.column = column;
        this.pieceType = pieceType;
        possiblesDeplacements = new ArrayList();
        color = Color.WHITE;
    }

    public Piece copy() {
        Piece piece = new Piece(row, column, pieceType);
        piece.setColor(color);
        piece.setHasMoved(hasMoved);
        for (Case caset : possiblesDeplacements) {
            piece.getPossiblesDeplacements().add(caset);
        }

        return piece;
    }


}
