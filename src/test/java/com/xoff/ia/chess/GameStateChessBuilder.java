package com.xoff.ia.chess;

public class GameStateChessBuilder {

    public static GameStateChess build3Moves(){
        GameStateChess gameStateChess=new GameStateChess();
        PieceMove move1=new PieceMove();
        // e4
        {
            Case source = new Case(1, 5);
            Case destination = new Case(3, 5);

            move1.setSource(source);
            move1.setDestination(destination);
            move1.setMoveType(MoveType.NA);
        }
        PieceMove move2=new PieceMove(); //e5
        {
            Case source = new Case(6, 5);
            Case destination = new Case(4, 5);

            move2.setSource(source);
            move2.setDestination(destination);
            move2.setMoveType(MoveType.NA);
        }
        PieceMove move3=new PieceMove();
        {
            Case source = new Case(0, 6);
            Case destination = new Case(2, 5);

            move3.setSource(source);
            move3.setDestination(destination);
            move3.setMoveType(MoveType.NA);
        }

        gameStateChess=gameStateChess.play(move1);
        gameStateChess=gameStateChess.play(move2);
        gameStateChess= gameStateChess.play(move3);
        return gameStateChess;
    }
}
