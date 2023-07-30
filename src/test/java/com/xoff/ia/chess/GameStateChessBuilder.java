package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Knight;
import com.xoff.ia.chess.piece.Pawn;

public class GameStateChessBuilder {

    public static GameStateChess build3Moves() {
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
        PieceMove move2 = new PieceMove(new Pawn(4, 4, Color.BLACK)); //e5
        {
            Case source = new Case(6, 4);
            Case destination = new Case(4, 4);

            move2.setSource(source);
            move2.setDestination(destination);
            move2.setMoveType(MoveType.NA);
        }
        PieceMove move3 = new PieceMove(new Knight(0, 6, Color.WHITE));
        {
            Case source = new Case(0, 6);
            Case destination = new Case(2, 5);

            move3.setSource(source);
            move3.setDestination(destination);
            move3.setMoveType(MoveType.NA);
        }

        gameStateChess = gameStateChess.play(move1);
        gameStateChess = gameStateChess.play(move2);
        gameStateChess = gameStateChess.play(move3);
        return gameStateChess;
    }
}
