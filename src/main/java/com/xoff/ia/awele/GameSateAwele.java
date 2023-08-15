package com.xoff.ia.awele;

import com.xoff.ia.common.GameState;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameSateAwele extends GameState {

    private int[][] board;
    private boolean currentPlayer;

    public GameSateAwele(){
        board=new int[2][5]; // classical dimension
        currentPlayer=true;
        for (int i=0;i<2;i++){
            for (int j=0;j<5;j++){
                board[i][j]=4;
            }
        }
    }

    @Override
    public GameState copy() {
        return null;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public float score() {
        return 0;
    }

    @Override
    public List<Move> getPossibleMoves() {
        return null;
    }

    @Override
    public GameState play(Move move) {
        return null;
    }
}
