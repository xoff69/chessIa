package com.xoff.ia.tictactoe;

import com.xoff.ia.common.Eval;
import com.xoff.ia.common.Minimax;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMinimax {

    @Test
    @DisplayName("basic test Minimx tictactoie")
    public void testMinimax() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(3);
        long start = System.currentTimeMillis();
        Eval e = Minimax.minimax(gameStateTicTacToe, 5, true);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("elasped time " + timeElapsed / 1000.); // 34s
        assertEquals(0.0, e.getScore(), 0.0f);
    }
    @Test
    @DisplayName("game test Minimx tictactoie")
    public void testAGame() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(3);
       while (!gameStateTicTacToe.isTerminal()){
           System.out.println(gameStateTicTacToe);
           Eval e = Minimax.minimax(gameStateTicTacToe, 5, gameStateTicTacToe.isCurrentPlayer());
           if (e.getBestMove()==null){
               System.out.println("fini");
               break;
           }

           gameStateTicTacToe=(GameStateTicTacToe)gameStateTicTacToe.play(e.getBestMove());


       }
        System.out.println(gameStateTicTacToe);
    }
}
