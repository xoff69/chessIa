package com.xoff.ia.common;

import java.util.List;

public class AlphaBeta implements AlgorithmBestMove {

    public static Eval alphabeta(GameState gameState, int depth, boolean maximizingPlayer,float alpha,float beta) {
        Move bestMove = null;
        if ((depth == 0) || (gameState.isTerminal())) {
            return new Eval(gameState.score(), null);
        }

        if (maximizingPlayer) {
            float value = Float.NEGATIVE_INFINITY;

            List<Move> moves = gameState.getPossibleMove();


            for (Move move : moves) {

                GameState child = gameState.getNewState(move);


                Eval eval = alphabeta(child, depth - 1, false,alpha,beta);
                if (eval.getScore() > value) {
                    value = eval.getScore();
                    bestMove = eval.getBestMove();
                }
                if (value>= beta)
                        break;
                alpha=Math.max(alpha,value);
            }
            return new Eval(value, bestMove);
        } else {
            float value = Float.POSITIVE_INFINITY;

            List<Move> moves = gameState.getPossibleMove();
            for (Move move : moves) {

                GameState child = gameState.getNewState(move);
                Eval eval = alphabeta(child, depth - 1, true,alpha,beta);
                if (eval.getScore() < value) {
                    value = eval.getScore();
                    bestMove = eval.getBestMove();
                }
                if (value <= alpha)
                break;
                        beta = Math.min(beta, value);

            }
            return new Eval(value, bestMove);
        }
    }
}
