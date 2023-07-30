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
        long start = System.nanoTime();
        Eval e = Minimax.minimax(gameStateChess, 5, true);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Temps " + timeElapsed);
        assertEquals(5.0, e.getScore(), 0.0f);
    }

}
