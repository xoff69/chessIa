package com.xoff.ia.chess.builder;

import com.xoff.ia.chess.GameStateChess;

public class GameStateChessBuilder {
    public static GameStateChess build4TestEP() {
        GameStateChess gameStateChess = new GameStateChess();


        gameStateChess = gameStateChess.play(MoveBuilder.buildMovee4());
        gameStateChess = gameStateChess.play(MoveBuilder.buildMovee6());
        gameStateChess = gameStateChess.play(MoveBuilder.buildeMoveWhiteE5());
        gameStateChess = gameStateChess.play(MoveBuilder.buildMoved5());
        return gameStateChess;
    }

    public static GameStateChess build4MovesPetrov() {
        GameStateChess gameStateChess = new GameStateChess();


        gameStateChess = gameStateChess.play(MoveBuilder.buildMovee4());
        gameStateChess = gameStateChess.play(MoveBuilder.buildeMoveBlackeE5());
        gameStateChess = gameStateChess.play(MoveBuilder.buildeMoveWhiteNf3());
        gameStateChess = gameStateChess.play(MoveBuilder.buildeMoveBlackeNf6());
        return gameStateChess;
    }

    public static GameStateChess build3Moves() {
        GameStateChess gameStateChess = new GameStateChess();

        gameStateChess = gameStateChess.play(MoveBuilder.buildMovee4());
        gameStateChess = gameStateChess.play(MoveBuilder.buildeMoveBlackeE5());
        gameStateChess = gameStateChess.play(MoveBuilder.buildeMoveWhiteNf3());
        return gameStateChess;
    }
}
