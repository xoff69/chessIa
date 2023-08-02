package com.xoff.ia.tictactoe;

import com.xoff.ia.common.AlphaBeta;
import com.xoff.ia.common.Eval;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlphaBeta {
    @Test
    @DisplayName("basic test alphabeta tictactoie")
    public void testAB() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(3);
        long start = System.currentTimeMillis();
        Eval e = AlphaBeta.alphabeta(gameStateTicTacToe, 4, true, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("elasped time " + timeElapsed / 1000.); // 34s
        assertEquals(0.0, e.getScore(), 0.0f);
    }
}
