package com.xoff.ia.common;

import java.util.List;

public class Minimax implements AlgorithmBestMove {


    public static Eval minimax(GameState gameState, int depth, boolean maximizingPlayer) {
        Move bestMove = null;
        if (gameState.isTerminal()) {
            //      System.out.println("cas a");
            return new Eval(gameState.score(), null);
        } else if (depth == 0) {
            // System.out.println("cas b");
            List<Move> moves = gameState.getPossibleMoves();

            if (moves.size() > 0) {
                //    System.out.println("cas b2 "+moves.get(0));
                return new Eval(gameState.score(), moves.get(0));
            }
            // no else
        }

        if (maximizingPlayer) {
            float value = Float.NEGATIVE_INFINITY;
            List<Move> moves = gameState.getPossibleMoves();

            for (Move move : moves) {

                GameState child = gameState.play(move);

                Eval eval = minimax(child, depth - 1, false);
                if (eval.getScore() > value) {
                    value = eval.getScore();
                    bestMove = eval.getBestMove();
                }


            }
            return new Eval(value, bestMove);
        } else {
            float value = Float.POSITIVE_INFINITY;

            List<Move> moves = gameState.getPossibleMoves();
            for (Move move : moves) {

                GameState child = gameState.play(move);
                Eval eval = minimax(child, depth - 1, true);
                if (eval.getScore() < value) {
                    value = eval.getScore();
                    bestMove = eval.getBestMove();
                }


            }
            return new Eval(value, bestMove);
        }
    }
}
