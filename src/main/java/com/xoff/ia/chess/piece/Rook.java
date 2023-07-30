package com.xoff.ia.chess.piece;

import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.PieceMove;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(int row, int column, Color color) {
        super(row, column, PieceType.ROOK);
        setColor(color);
    }

    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {

        List<PieceMove> moves = new ArrayList<>();
        {
            int r = row;
            int c = column - 1;
            while (c > -1) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }

                c--;
            }
        }
        {
            int r = row;
            int c = column + 1;
            while (c < 8) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }

                c++;
            }
        }
        {
            int r = row - 1;
            int c = column;
            while (r > -1) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }

                r--;
            }
        }
        {
            int r = row + 1;
            int c = column;
            while (r < 8) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }

                r++;
            }
        }
        return moves;
    }

    public String toString() {
        return getColor() == Color.WHITE ? "R" : "r";
    }

}
