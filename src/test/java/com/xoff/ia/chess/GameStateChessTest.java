package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.PieceType;
import com.xoff.ia.common.Eval;
import com.xoff.ia.common.Minimax;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateChessTest {
    @Test
    @DisplayName("GameStateChessTest constructor")
    public void testGameStateChess() {
        GameStateChess gameStateChess = new GameStateChess();

        assertEquals(PieceType.EMPTY, gameStateChess.getPieces()[4][4].getPieceType());
    }

}
