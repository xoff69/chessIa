package com.xoff.chessia;

import com.xoff.ia.common.Minimax;

public class Main {

    public static void main(String[] args) {

        GameStateChess gameStateChess=new GameStateChess();

        System.out.println(" minimax :"+ Minimax.minimax(gameStateChess, 5, true));

    }
}