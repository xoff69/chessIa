package com.xoff.ia.chess;

import com.xoff.ia.chess.evaluation.Evaluation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EvaluationTest {

    @Test
    @DisplayName("basic test evaluation")
    public void testEvaluation() {
        String source = "state:BLACK-\n" + "r n b q k b n r \n" + "p p p p p p p p \n" + ". . . . . . . . \n" + ". . . . . . . . \n" + ". . . . . . . . \n" + "N . . . . . . . \n" + "P P P P P P P P \n" + "R . B Q K B N R \n" + "##moves:Na3,b6 ";
        GameStateChess gameStateChess = GameStateChess.string2GameStateChess(source);
        float score=Evaluation.evaluate(gameStateChess);
        System.out.println(gameStateChess);
        System.out.println("score "+score);
        Assertions.assertNotEquals(score,0.f,0.3f);
    }
}
