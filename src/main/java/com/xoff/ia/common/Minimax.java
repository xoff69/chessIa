package com.xoff.ia.common;

import java.util.List;

public class Minimax implements  AlgorithmBestMove {


// TODO on renvoie aussi le move
    public static float minimax(GameState gameState, int depth, boolean maximizingPlayer) {

            if ((depth==0) || (gameState.isTerminal())){
            return gameState.score();
        }

            if (maximizingPlayer) {
                float value = Float.NEGATIVE_INFINITY;

                List<Move> moves  = gameState.getPossibleMove();
                for (Move move:moves) {

                    GameState child = gameState.getNewState(move);
                    value = Math.max(value, minimax(child, depth - 1, false));
                }
                return value;
            }
            else {
                float value = Float.POSITIVE_INFINITY;

                List<Move> moves  = gameState.getPossibleMove();
                for (Move move:moves) {

                    GameState child = gameState.getNewState(move);
                    value = Math.min(value, minimax(child, depth - 1, true));
                }
                return value;
            }
}
}
