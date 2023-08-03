package com.xoff.ia.common;

import java.util.List;

public class AlphaBeta implements AlgorithmBestMove {

    public static Eval alphabeta(GameState gameState, int depth, boolean maximizingPlayer, float alpha, float beta) {
        if (depth==0||gameState.isTerminal()) {

            return new Eval(gameState.score(), null);
        }
        List<Move> moves = gameState.getPossibleMoves();
        Move bestMove = null;
        float bestMoveValue=maximizingPlayer?Float.NEGATIVE_INFINITY:Float.POSITIVE_INFINITY;


        for (Move move : moves) {
            GameState child = gameState.play(move);
            Eval eval= alphabeta(child, depth - 1, !maximizingPlayer,alpha,beta);
            float value=eval.getScore();
            if (maximizingPlayer) {
                // Look for moves that maximize position
                if (value > bestMoveValue) {
                    bestMoveValue = value;
                    bestMove = move;
                }
                alpha=Float.max(alpha,value);
            } else {
                // Look for moves that minimize position
                if (value < bestMoveValue) {
                    bestMoveValue = value;
                    bestMove = move;
                }
                beta=Float.min(beta,value);
            }
            if (beta<=alpha){
                break;
            }
        }
//System.out.println(" best "+bestMove+" "+bestMoveValue+ " "+moves.size());
        return new Eval(bestMoveValue, bestMove!=null?bestMove:moves.get(0));


    }
}
