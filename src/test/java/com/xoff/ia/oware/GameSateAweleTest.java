package com.xoff.ia.oware;

import com.xoff.ia.common.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameSateAweleTest {

    @Test
    void testConstructeur() {
        GameStateOware gameSateAwele = new GameStateOware();
        System.out.println(gameSateAwele.toString());
        assertNotNull(gameSateAwele.getBoard());
    }

    @Test
    void isTerminal() {
    }

    @Test
    void score() {
    }

    @Test
    void getPossibleMoves() {
        GameStateOware gameSateAwele = new GameStateOware();
        List<Move> moves = gameSateAwele.getPossibleMoves();
        assertNotNull(moves);
        assertTrue(moves.size() > 0);
        for (Move move : moves) {
            System.out.println(move);
        }
    }

    @Test
    @DisplayName("play basic")
    void playBasic() {
        GameStateOware gameSateAwele = new GameStateOware();
        OwareMove owareMove =new OwareMove();
        owareMove.setSource(3);
        gameSateAwele=gameSateAwele.play(owareMove);
        System.out.println(gameSateAwele.toString());
        assertTrue(gameSateAwele.getBoard()[3]==0);
    }
    @Test
    @DisplayName("play complex1")
    void playComplex1() {
        GameStateOware gameSateAwele = new GameStateOware();
        OwareMove owareMove =new OwareMove();
        owareMove.setSource(3);
        gameSateAwele.getBoard()[3]=24;
        gameSateAwele=gameSateAwele.play(owareMove);
        System.out.println(gameSateAwele.toString());
        assertTrue(gameSateAwele.getBoard()[3]==0);
    }
}