package com.chessia.minimax;

import com.xoff.chessia.GameStateChess;
import com.xoff.ia.common.Eval;
import com.xoff.ia.common.Minimax;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessMinimaxTest {
    @Test
    @DisplayName("Single test successful")
    public void test1() {
        GameStateChess gameStateChess = new GameStateChess();
        Eval e = Minimax.minimax(gameStateChess, 5, true);
        assertEquals(5.0, e.getScore(), 0.0f);
    }

}
