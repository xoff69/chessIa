package com.xoff.ia.chess;

import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PieceMove implements Move {
    Case source;
    Case destination;
    MoveType moveType;
}
