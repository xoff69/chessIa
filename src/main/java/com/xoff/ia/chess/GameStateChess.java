package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Piece;
import com.xoff.ia.common.GameState;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class GameStateChess extends GameState {

    private Color currentPlayer;
    private Piece[][] pieces;

    private List<Piece> blackPieces;
    private List<Piece> whitePieces;

    private Piece blackKing;
    private Piece whiteKing;

    private Move lastMove;


    public GameStateChess() {
        pieces=new Piece[8][8];
        for (int row=0;row<8;row++){

            for (int col=0;col<8;col++){
                pieces[row][col]=Piece.empty();
            }
        }

    }

    public GameState copy() {

        return new GameStateChess();

    }

    public boolean isTerminal() {
        return true;
    }

    public float score() {
        return 5.0f;
    }

    public List<Move> getPossibleMove() {
        return new ArrayList<>();
    }

    public GameState getNewState(Move move) {
        return new GameStateChess();
    }
}
