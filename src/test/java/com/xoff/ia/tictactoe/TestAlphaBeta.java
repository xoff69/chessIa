package com.xoff.ia.tictactoe;

import com.xoff.ia.common.AlphaBeta;
import com.xoff.ia.common.Eval;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    @DisplayName("game test  ab")
    public void testAGame() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(3);
        int i = 0;
        while (!gameStateTicTacToe.isTerminal()) {
            System.out.println(i + "  " + gameStateTicTacToe);
            Eval e = AlphaBeta.alphabeta(gameStateTicTacToe, 4, true, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);

            if (e.getBestMove() == null) {
                System.out.println("bm null");
                break;
            }
            gameStateTicTacToe = (GameStateTicTacToe) gameStateTicTacToe.play(e.getBestMove());
            i++;
        }
        System.out.println(" final :" + gameStateTicTacToe);
        assertTrue(gameStateTicTacToe.isTerminal());
    }
}
