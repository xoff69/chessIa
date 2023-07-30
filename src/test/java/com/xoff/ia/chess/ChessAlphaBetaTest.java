package com.xoff.ia.chess;

import com.xoff.ia.common.AlphaBeta;
import com.xoff.ia.common.Eval;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessAlphaBetaTest {
    @Test
    @DisplayName("basic test AlphaBeta")
    public void testAlphaBeta() {
        GameStateChess gameStateChess = GameStateChessBuilder.build3Moves();
        long start = System.nanoTime();

        Eval e = AlphaBeta.alphabeta(gameStateChess, 5, true, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Temps "+timeElapsed);
        assertEquals(5.0, e.getScore(), 0.0f);
    }

}
