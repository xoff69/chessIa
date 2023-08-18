package com.xoff.ia.oware;

import com.xoff.ia.common.GameState;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameStateOware extends GameState {

    private static final int DIMENSION = 12;
    private static final int INITIAL_SEEDS = 4;

    private int[] board;
    private boolean currentPlayer;
    private int bagA;
    private int bagB;

    public GameStateOware() {
        board = new int[DIMENSION]; // classical dimension
        currentPlayer = true;

        for (int j = 0; j < DIMENSION; j++) {
            board[j] = INITIAL_SEEDS;
        }

    }

    private static int indexByPlayer(boolean player) {
        return player ? 0 : DIMENSION / 2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentPlayer).append("--\n");
        stringBuilder.append(getBagA()).append("-").append(getBagB()).append("--\n");

        for (int j = DIMENSION - 1; j >= DIMENSION / 2; j--) {
            stringBuilder.append(board[j]).append(" ");

        }
        stringBuilder.append("\n");
        for (int j = 0; j < DIMENSION / 2; j++) {
            stringBuilder.append(board[j]).append(" ");

        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    @Override
    public GameStateOware copy() {
        GameStateOware gameStateAwele = new GameStateOware();
        gameStateAwele.setCurrentPlayer(currentPlayer);
        for (int j = 0; j < DIMENSION; j++) {
            gameStateAwele.getBoard()[j] = board[j];
        }
        gameStateAwele.setBagA(getBagA());
        gameStateAwele.setBagB(getBagB());
        return gameStateAwele;
    }

    @Override
    public boolean isTerminal() {
        return getPossibleMoves().size() == 0 || bagA > 25 || bagB > 25;
    }

    @Override
    public float score() {
        return currentPlayer ? bagA - bagB : bagB - bagA;
    }

    private boolean isStarving(boolean color) {
        int left = indexByPlayer(color);

        for (int i = left; i < left + DIMENSION / 2; i++) {
            if (board[i] != 0) return false;
        }
        return true;
    }

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList<>();
        int left = indexByPlayer(currentPlayer);
        boolean isOpponentStarving = isStarving(!currentPlayer);


        for (int i = left; i < left + DIMENSION / 2; i++) {

            if (board[i] > 0) {

                // if opponent is starving and this move does not feed him, this move is invalid
                if (isOpponentStarving) {
                    if (board[i] < left + DIMENSION / 2) {
                        System.out.println("starving " + toString());
                        continue;
                    }
                }

                OwareMove move = new OwareMove();
                move.setSource(i);
                // don t allow a move who can starve opponent
                GameStateOware gameStateOware = this.copy();
                gameStateOware.play(move);

                System.out.println("play " + gameStateOware);
                if (!gameStateOware.isStarving(!currentPlayer)) {
                    moves.add(move);
                }
            }

        }


        return moves;
    }

    @Override
    public GameStateOware play(Move move) {

        GameStateOware gameStateOware = this.copy();

        OwareMove owareMove = (OwareMove) move;
        int sourceIndex = indexByPlayer(currentPlayer) + owareMove.getSource();
        int absoluteIndex = sourceIndex;
        int seeds = gameStateOware.getBoard()[sourceIndex];
        gameStateOware.getBoard()[sourceIndex] = 0;
        while (seeds > 0) {

            absoluteIndex = (absoluteIndex + 1) % DIMENSION;
            // we can not add seed into source case
            if (absoluteIndex == sourceIndex) {
                continue;
            }
            gameStateOware.getBoard()[absoluteIndex] = gameStateOware.getBoard()[absoluteIndex] + 1;

            seeds--;
        }
        if (!(absoluteIndex > indexByPlayer(currentPlayer) && absoluteIndex < indexByPlayer(currentPlayer) + DIMENSION / 22)) {
            // collect
            System.out.println("collect " + absoluteIndex);

            while (absoluteIndex >= indexByPlayer(!currentPlayer)) {
                if (gameStateOware.getBoard()[absoluteIndex] == 2 || gameStateOware.getBoard()[absoluteIndex] == 3) {

                    System.out.println(absoluteIndex + " collect ramassage " + gameStateOware.getBoard()[absoluteIndex]);
                    if (currentPlayer) {
                        gameStateOware.setBagA(gameStateOware.getBagA() + gameStateOware.getBoard()[absoluteIndex]);

                    } else {
                        gameStateOware.setBagB(gameStateOware.getBagB() + gameStateOware.getBoard()[absoluteIndex]);
                    }
                    gameStateOware.getBoard()[absoluteIndex] = 0;
                } else break;

                absoluteIndex = (absoluteIndex - 1) % DIMENSION;
            }
        }


        gameStateOware.setCurrentPlayer(!currentPlayer);


        return gameStateOware;
    }
}
