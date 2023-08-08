package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Pawn;
import com.xoff.ia.chess.piece.PieceType;
import com.xoff.ia.common.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("GameStateChessTest start state")
    public void testGameStateChessNextStateStart() {
        GameStateChess gameStateChess = new GameStateChess();


        System.out.println("moves:");
        List<Move> moves = gameStateChess.getPossibleMoves();
        for (Move move : moves) {
            System.out.println(move);
        }
        assertEquals(20, moves.size());
    }

    @Test
    @DisplayName("GameStateChessTest start state second move")
    public void testGameStateChessNextState2() {
        GameStateChess gameStateChess = new GameStateChess();
        PieceMove move1 = new PieceMove(new Pawn(1, 4, Color.WHITE));
        // e4
        {
            Case source = new Case(1, 4);
            Case destination = new Case(3, 4);

            move1.setSource(source);
            move1.setDestination(destination);
            move1.setMoveType(MoveType.NA);
        }
        gameStateChess = gameStateChess.play(move1);
        System.out.println("moves:");
        List<Move> moves = gameStateChess.getPossibleMoves();
        for (Move move : moves) {
            System.out.println(move);
        }
        assertEquals(20, moves.size());
    }

    @Test
    @DisplayName("GameStateChessTest nest state")
    public void testGameStateChessNextState() {
        GameStateChess gameStateChess = GameStateChessBuilder.build3Moves();
        System.out.println(gameStateChess);
        List<Move> moves = gameStateChess.getPossibleMoves();
        System.out.println("moves:");
        for (Move move : moves) {
            System.out.println(move);
        }
        assertTrue(moves.size() > 0);
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

    @Test
    @DisplayName("GameStateChessTest EP")
    public void testGameStateChessEP() {
        GameStateChess gameStateChess = GameStateChessBuilder.build4TestEP();
        System.out.println(gameStateChess);

        List<Move> moves = gameStateChess.getPossibleMoves();
        System.out.println("moves:");
        boolean containsEP = false;
        for (Move move : moves) {
            System.out.println(move);
            PieceMove pieceMove = (PieceMove) move;
            if (pieceMove.getMoveType() == MoveType.EP) {
                containsEP = true;
                break;
            }
        }
        assertTrue(moves.size() > 0);
        assertTrue(containsEP);
        // TODO use aspect J

    }

    @Test
    void string2GameStateChess() {
        String source = "state:BLACK-\n" + "r n b q k b n r \n" + "p p p p p p p p \n" + ". . . . . . . . \n" + ". . . . . . . . \n" + ". . . . . . . . \n" + "N . . . . . . . \n" + "P P P P P P P P \n" + "R . B Q K B N R \n" + "##moves:Na3,b6 ";
        GameStateChess gameStateChess = GameStateChess.string2GameStateChess(source);
        assertNotNull(gameStateChess);
        assertEquals(gameStateChess.getBlackPieces().size(),16);
        assertEquals(gameStateChess.getWhitePieces().size(),16);
    }
}
