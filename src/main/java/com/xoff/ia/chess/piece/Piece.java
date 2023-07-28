package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Piece {
    Color color;
    PieceType pieceType;
    int [][] possiblesDeplacements;
    boolean hasMoved;


}
