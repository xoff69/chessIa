package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.PieceMove;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(int row, int column, Color color) {
        super(row, column, PieceType.BISHOP);
        setColor(color);
    }

    public float estimateValue() {
        return 3.0f;
    }

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {
        List<PieceMove> moves = new ArrayList<>();
        {
            int r = getRow() - 1;
            int c = getColumn() - 1;
            while (r > -1 && c > -1) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }
                r--;
                c--;
            }
        }
        {
            int r = getRow() + 1;
            int c = getColumn() - 1;
            while (r < 8 && c > -1) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }
                r++;
                c--;
            }
        }
        {
            int r = getRow() - 1;
            int c = getColumn() + 1;
            while (r > -1 && c < 8) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }
                r--;
                c++;
            }
        }
        {
            int r = getRow() + 1;
            int c = getColumn() + 1;
            while (r < 8 && c < 8) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }
                r++;
                c++;
            }
        }
        return moves;
    }

    public String toString() {
        return getColor() == Color.WHITE ? "B" : "b";
    }

}
