package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Piece;
import com.xoff.ia.common.GameState;
import com.xoff.ia.common.Move;

import java.util.ArrayList;
import java.util.List;

public class GameStateChess extends GameState {

    private Color currentPlayer;
    private Piece[][] pieces;

    public GameStateChess() {

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
