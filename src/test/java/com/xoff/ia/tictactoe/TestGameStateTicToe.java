package com.xoff.ia.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGameStateTicToe {
    @Test
    @DisplayName("testGameStateTTT constructor")
    public void testGameStateTTT() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(4);
        System.out.println(gameStateTicTacToe);
        assertEquals(gameStateTicTacToe.getPossibleMoves().size(), 16);
    }
    @Test
    @DisplayName("testGameStateTTT testFullColun")
    public void testFullColun() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(3);
        gameStateTicTacToe.getBoard()[0][1]='X';
        gameStateTicTacToe.getBoard()[1][1]='X';
        gameStateTicTacToe.getBoard()[2][1]='X';
        assertTrue(gameStateTicTacToe.isTerminal());
        gameStateTicTacToe.getBoard()[1][1]='O';
        assertFalse(gameStateTicTacToe.isTerminal());
    }
    @Test
    @DisplayName("testGameStateTTT testFullRow")
    public void testFullRow() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(3);
        gameStateTicTacToe.getBoard()[1][0]='X';
        gameStateTicTacToe.getBoard()[1][1]='X';
        gameStateTicTacToe.getBoard()[1][2]='X';
        assertTrue(gameStateTicTacToe.isTerminal());
        gameStateTicTacToe.getBoard()[1][2]='O';
        assertFalse(gameStateTicTacToe.isTerminal());
    }
    @Test
    @DisplayName("testGameStateTTT testDiagonale")
    public void testDiagonale() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(3);
        gameStateTicTacToe.getBoard()[0][0]='X';
        gameStateTicTacToe.getBoard()[1][1]='X';
        gameStateTicTacToe.getBoard()[2][2]='X';
        assertTrue(gameStateTicTacToe.isTerminal());
        gameStateTicTacToe.getBoard()[1][1]='O';
        assertFalse(gameStateTicTacToe.isTerminal());
    }

}
