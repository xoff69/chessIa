package com.xoff.ia.common;

public class Eval {
    private float score;
    private Move bestMove;

    public Eval(float score, Move bestMove) {
        this.score = score;
        this.bestMove = bestMove;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Move getBestMove() {
        return bestMove;
    }

    public void setBestMove(Move bestMove) {
        this.bestMove = bestMove;
    }


}
