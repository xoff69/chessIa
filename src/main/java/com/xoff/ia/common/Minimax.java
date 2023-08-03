package com.xoff.ia.common;

import java.util.List;

public class Minimax implements AlgorithmBestMove {


    public static Eval minimax(GameState gameState, int depth, boolean maximizingPlayer) {

        if (depth==0||gameState.isTerminal()) {

            return new Eval(gameState.score(), null);
        }
        List<Move> moves = gameState.getPossibleMoves();
        Move bestMove = null;
        float bestMoveValue=maximizingPlayer?Float.NEGATIVE_INFINITY:Float.POSITIVE_INFINITY;


            for (Move move : moves) {
                GameState child = gameState.play(move);
                Eval eval= minimax(child, depth - 1, !maximizingPlayer);
float value=eval.getScore();
                if (maximizingPlayer) {
                    // Look for moves that maximize position
                    if (value > bestMoveValue) {
                        bestMoveValue = value;
                        bestMove = move;
                    }
                } else {
                    // Look for moves that minimize position
                    if (value < bestMoveValue) {
                        bestMoveValue = value;
                        bestMove = move;
                    }
                }
            }
//System.out.println(" best "+bestMove+" "+bestMoveValue+ " "+moves.size());
        return new Eval(bestMoveValue, bestMove!=null?bestMove:moves.get(0));


    }
}
