package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Pawn;
import com.xoff.ia.chess.piece.PieceType;
import com.xoff.ia.common.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameStateChessTest {
    @Test
    @DisplayName("GameStateChessTest constructor")
    public void testGameStateChess() {
        GameStateChess gameStateChess = new GameStateChess();
        System.out.println(gameStateChess);
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
        assertEquals(gameStateChessOther.toString(), gameStateChess.toString());

    }

    @Test
    @DisplayName("GameStateChessTest nest state")
    public void testGameStateChessNextState() {
        GameStateChess gameStateChess = GameStateChessBuilder.build3Moves();
        System.out.println(gameStateChess);

        System.out.println("moves:");
        for (Move move : gameStateChess.getPossibleMoves()) {
            System.out.println(move);
        }
    }

    @Test
    @DisplayName("GameStateChessTest play")
    public void testGameStateChessNextPlay() {
        GameStateChess gameStateChess = new GameStateChess();
        PieceMove move1 = new PieceMove(new Pawn(1, 4, Color.WHITE));
        // e4

        Case source = new Case(1, 4);
        Case destination = new Case(3, 4);

        move1.setSource(source);
        move1.setDestination(destination);
        move1.setMoveType(MoveType.NA);

        GameStateChess gameStateChessAfterPlay = gameStateChess.play(move1);
        for (String p : gameStateChessAfterPlay.getPositions())
            System.out.println(p);
        assertEquals(gameStateChessAfterPlay.getPositions().size(), gameStateChess.getPositions().size() + 1);
        assertNotEquals(gameStateChessAfterPlay.getCurrentPlayer(), gameStateChess.getCurrentPlayer());
    }
}
