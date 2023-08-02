package com.xoff.ia.chess;

import com.xoff.ia.common.Eval;
import com.xoff.ia.common.Minimax;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessMinimaxTest {
    @Test
    @DisplayName("basic test Minimax")
    public void testMinimax() {
        GameStateChess gameStateChess = GameStateChessBuilder.build4Moves();
        long start = System.currentTimeMillis();
        Eval e = Minimax.minimax(gameStateChess, 4, true);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("elasped time " + timeElapsed / 1000.); // 34s
        assertEquals(0.0, e.getScore(), 0.0f);
    }

    @Test
    @DisplayName("basic test testGameMinimax")
    public void testGameMinimax() {
        GameStateChess gameStateChess = new GameStateChess();
        for (int i = 0; i < 10; i++) {
            Eval e = Minimax.minimax(gameStateChess, 2, true);

            gameStateChess = gameStateChess.play(e.getBestMove());

        }
        System.out.println(gameStateChess.toString());
    }

}
