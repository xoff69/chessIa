package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.PieceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameStateChessTest {
    @Test
    @DisplayName("GameStateChessTest constructor")
    public void testGameStateChess() {
        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.print();
        assertEquals(PieceType.EMPTY, gameStateChess.getPieces()[4][4].getPieceType());
        assertEquals(PieceType.ROOK, gameStateChess.getWhitePieces().get(0).getPieceType());
        assertEquals(PieceType.ROOK, gameStateChess.getPieces()[0][0].getPieceType());
    }

    @Test
    @DisplayName("GameStateChessTest copy")
    public void testGameStateChessCopy() {
        GameStateChess gameStateChess = new GameStateChess();
        GameStateChess gameStateChessOther = gameStateChess.copy();
        assertNotEquals(gameStateChessOther, gameStateChess);
    }
}
