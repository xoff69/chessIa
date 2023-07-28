package com.xoff.ia.common;

import java.util.List;

public class AlphaBeta implements AlgorithmBestMove {
// FIXME : methode static
/*
def alphabeta(gameState: GameState, depth:int, maximizingPlayer:bool,alpha=float('-inf'),beta=float('+inf')) :

    if (depth==0) or (gameState.isTerminal()):
        return gameState.score(),None


    if maximizingPlayer:
        value =float('-inf')
        possible_moves=gameState.getPossibleMoves()
        for move in possible_moves:
            child=gameState.getNewState(move)
            t=alphabeta(child,depth-1,False,alpha,beta)
            if t[0]>value:
                value=t[0]
                bestmove=move
            if value>= beta:
                break
            alpha=max(alpha,value)

    else: #(* minimizing player *)
        value =float('+inf')
        possible_moves = gameState.getPossibleMoves()
        for move in possible_moves:
            child = gameState.getNewState(move)
            t = alphabeta(child, depth - 1, True,alpha,beta)
            if  t[0]<value:
                value = t[0]
                bestmove = move
            if value <= alpha:
                break
            beta = min(beta, value)
    return value,bestmove
 */
    public static Eval minimax(GameState gameState, int depth, boolean maximizingPlayer) {
        Move bestMove = null;
        if ((depth == 0) || (gameState.isTerminal())) {
            return new Eval(gameState.score(), null);
        }

        if (maximizingPlayer) {
            float value = Float.NEGATIVE_INFINITY;

            List<Move> moves = gameState.getPossibleMove();


            for (Move move : moves) {

                GameState child = gameState.getNewState(move);


                Eval eval = minimax(child, depth - 1, false);
                if (eval.getScore() > value) {
                    value = eval.getScore();
                    bestMove = eval.getBestMove();
                }


            }
            return new Eval(value, bestMove);
        } else {
            float value = Float.POSITIVE_INFINITY;

            List<Move> moves = gameState.getPossibleMove();
            for (Move move : moves) {

                GameState child = gameState.getNewState(move);
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
