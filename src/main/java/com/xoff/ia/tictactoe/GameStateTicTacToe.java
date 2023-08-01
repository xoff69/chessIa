package com.xoff.ia.tictactoe;

import com.xoff.ia.chess.Color;
import com.xoff.ia.common.GameState;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameStateTicTacToe extends GameState {
    private static final char EMPTY = '.';
    private static final char PLAYER_A = 'X'; // currentPlayer=true
    private static final char PLAYER_B = 'O';
    private int dimension;
    private char[][] board;

    private boolean currentPlayer;

    public GameStateTicTacToe(int dimension) {
        this.dimension = dimension;
        currentPlayer = true;
        board = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {

                board[i][j] = EMPTY;
            }

        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("current player :" + currentPlayer + "\n");

        for (int i = 0; i < dimension; i++) {
            sb.append("\n");
            for (int j = 0; j < dimension; j++) {
                sb.append(board[i][j] + " ");
            }
        }

        return sb.toString();
    }

    @Override
    public GameStateTicTacToe copy() {
        GameStateTicTacToe gameStateTicTacToe = new GameStateTicTacToe(this.dimension);
        gameStateTicTacToe.currentPlayer = currentPlayer;
        for (int i = 0; i < dimension; i++) {

            for (int j = 0; j < dimension; j++) {
                gameStateTicTacToe.board[i][j] = board[i][j];
            }
        }
        return gameStateTicTacToe;
    }

    @Override
    public boolean isTerminal() {
        if (Math.abs(score())>1000.){
            return true;
        }
        for (int i = 0; i < dimension; i++) {

            for (int j = 0; j < dimension; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean fullRow(char who) {
        for (int i = 0; i < dimension; i++) {
            boolean thisRow = true;
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] != who) {
                    thisRow = false;
                    break;
                }
            }
            if (thisRow) {
                return true;
            }
        }
        return false;

    }

    private boolean fullColumn(char who) {
        for (int j = 0; j < dimension; j++) {
            boolean thisCol = true;
            for (int i = 0; i < dimension; i++) {
                if (board[i][j] != who) {
                    thisCol = false;
                    break;
                }
            }
            if (thisCol) {
                return true;
            }
        }
        return false;

    }

    private boolean fullDiagonale(char who) {
        boolean thisDiag = true;
        int i = 0;
        int j = 0;
        while (i < dimension) {
            if (board[i][j] != who) {
                thisDiag = false;
                break;
            }
            i++;
            j++;
        }

        if (thisDiag) return true;
        i = 0;
        j = dimension - 1;
        while (i < dimension) {
            if (board[i][j] != who) {
                thisDiag = false;
                break;
            }
            i++;
            j--;
        }
        return thisDiag;

    }

    @Override
    public float score() {
        char c = currentPlayer ? PLAYER_A : PLAYER_B;
        if (fullRow(c) || fullDiagonale(c) || fullColumn(c)) {

            return Float.POSITIVE_INFINITY;
        }
        char opp = !currentPlayer ? PLAYER_A : PLAYER_B;
        if (fullRow(opp) || fullDiagonale(opp) || fullColumn(opp)) {

            return Float.NEGATIVE_INFINITY;
        }
        return 0.f;

    }

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {

            for (int j = 0; j < dimension; j++) {
                if (board[i][j] == EMPTY) {
                    TicTacMove ticTacMove = new TicTacMove();
                    ticTacMove.setI(i);
                    ticTacMove.setJ(j);
                    moves.add(ticTacMove);
                }
            }
        }

        return moves;
    }

    @Override
    public GameState play(Move move) {
        TicTacMove ticTacMove = (TicTacMove) move;
        GameStateTicTacToe gameStateTicTacToe = this.copy();
        gameStateTicTacToe.getBoard()[ticTacMove.getI()][ticTacMove.getJ()] = (currentPlayer) ? PLAYER_A : PLAYER_B;

        gameStateTicTacToe.setCurrentPlayer(currentPlayer  ? false: true);
        return gameStateTicTacToe;

    }
}
