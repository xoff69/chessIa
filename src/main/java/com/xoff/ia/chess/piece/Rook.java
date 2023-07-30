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
    public  float estimateValue(){
        return 6.0f;
    }
    public List<PieceMove> generatePossibleMoves(GameStateChess gameStateChess) {

        List<PieceMove> moves = new ArrayList<>();
        {
            int r = getRow();
            int c = getColumn() - 1;
            while (c > -1) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }

                c--;
            }
        }
        {
            int r = getRow();
            int c = getColumn() + 1;
            while (c < 8) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }

                c++;
            }
        }
        {
            int r = getRow() - 1;
            int c = getColumn();
            while (r > -1) {
                if (!evaluateAndNext(gameStateChess, r, c, moves)) {
                    break;
                }

                r--;
            }
        }
        {
            int r = getRow() + 1;
            int c = getColumn();
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
