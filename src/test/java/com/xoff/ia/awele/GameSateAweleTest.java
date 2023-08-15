package com.xoff.ia.awele;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotNull;
class GameSateAweleTest {

    @Test
    void testConstructeur(){
        GameSateAwele gameSateAwele=new GameSateAwele();
        assertNotNull (gameSateAwele.getBoard());
    }
    @Test
    void isTerminal() {
    }

    @Test
    void score() {
    }

    @Test
    void getPossibleMoves() {
    }

    @Test
    void play() {
    }
}