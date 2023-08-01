package com.xoff.ia.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameStateTicToe {
    @Test
    @DisplayName("testGameStateTTT constructor")
    public void testGameStateTTT() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(4);
        System.out.println(gameStateTicTacToe);
        assertEquals(gameStateTicTacToe.getPossibleMoves().size(), 16);
    }

}
