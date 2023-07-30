package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Bishop;
import com.xoff.ia.chess.piece.King;
import com.xoff.ia.chess.piece.Pawn;
import com.xoff.ia.chess.piece.Queen;
import com.xoff.ia.chess.piece.Rook;
import com.xoff.ia.common.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiecesTest {
    @Test
    @DisplayName("testBishop")
    public void testBishop() {
        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.empty();
        Bishop bishopW1 = new Bishop(4, 4, Color.WHITE);
        gameStateChess.getWhitePieces().add(bishopW1);
        gameStateChess.getPieces()[4][4] = bishopW1;
        System.out.println(gameStateChess);
        List<Move> moves = gameStateChess.getPossibleMoves();
        for (Move move : moves) {
            PieceMove pieceMove = (PieceMove) move;
            System.out.println(pieceMove);
        }
        assertEquals(moves.size(), 13);
    }

    @Test
    @DisplayName("testRook")
    public void testRook() {
        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.empty();
        Rook piece = new Rook(4, 4, Color.WHITE);
        gameStateChess.getWhitePieces().add(piece);
        gameStateChess.getPieces()[4][4] = piece;
        System.out.println(gameStateChess);
        List<Move> moves = gameStateChess.getPossibleMoves();
        for (Move move : moves) {
            PieceMove pieceMove = (PieceMove) move;
            System.out.println(pieceMove);
        }
        assertEquals(moves.size(), 14);
    }

    @Test
    @DisplayName("testQueen")
    public void testQueen() {
        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.empty();
        Queen piece = new Queen(4, 4, Color.WHITE);
        gameStateChess.getWhitePieces().add(piece);
        gameStateChess.getPieces()[4][4] = piece;
        System.out.println(gameStateChess);
        List<Move> moves = gameStateChess.getPossibleMoves();
        for (Move move : moves) {
            PieceMove pieceMove = (PieceMove) move;
            System.out.println(pieceMove);
        }
        assertEquals(moves.size(), 27);
    }

    @Test
    @DisplayName("testPawn1step")
    public void testPawn1step() {
        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.empty();
        Pawn piece = new Pawn(4, 4, Color.WHITE);
        gameStateChess.getWhitePieces().add(piece);
        gameStateChess.getPieces()[4][4] = piece;
        System.out.println(gameStateChess);
        List<Move> moves = gameStateChess.getPossibleMoves();
        for (Move move : moves) {
            PieceMove pieceMove = (PieceMove) move;
            System.out.println(pieceMove);
        }
        assertEquals(moves.size(), 1);
    }

    @Test
    @DisplayName("testPawn1step")
    public void testPawn2step() {
        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.empty();
        Pawn piece = new Pawn(1, 4, Color.WHITE);
        gameStateChess.getWhitePieces().add(piece);
        gameStateChess.getPieces()[1][4] = piece;
        System.out.println(gameStateChess);
        List<Move> moves = gameStateChess.getPossibleMoves();
        for (Move move : moves) {
            PieceMove pieceMove = (PieceMove) move;
            System.out.println(pieceMove);
        }
        assertEquals(moves.size(), 2);
    }

    @Test
    @DisplayName("testKing")
    public void testKing() {
        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.empty();
        King piece = new King(4, 4, Color.WHITE);
        gameStateChess.getWhitePieces().add(piece);
        gameStateChess.getPieces()[4][4] = piece;
        System.out.println(gameStateChess);
        List<Move> moves = gameStateChess.getPossibleMoves();
        for (Move move : moves) {
            PieceMove pieceMove = (PieceMove) move;
            System.out.println(pieceMove);
        }
        assertEquals(moves.size(), 8);
    }
}
