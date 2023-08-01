package com.xoff.ia.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Eval {
    private float score;
    private Move bestMove;

    public Eval(float score, Move bestMove) {
        this.score = score;
        this.bestMove = bestMove;
    }




}
