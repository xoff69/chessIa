package com.xoff.ia.chess;

import com.xoff.ia.chess.piece.Bishop;
import com.xoff.ia.chess.piece.Empty;
import com.xoff.ia.chess.piece.King;
import com.xoff.ia.chess.piece.Knight;
import com.xoff.ia.chess.piece.Pawn;
import com.xoff.ia.chess.piece.Piece;
import com.xoff.ia.chess.piece.PieceType;
import com.xoff.ia.chess.piece.Queen;
import com.xoff.ia.chess.piece.Rook;
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

    private PieceMove lastMove;


    public GameStateChess() {
        lastMove = null;
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        pieces = new Piece[8][8];
        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {
                pieces[row][col] = new Empty(row, col);
            }
        }
        // 0,0 is bottom left
        int row = 0, col = 0;
        {
            Color color = Color.WHITE;


            Rook rookW1 = new Rook(row, 0, color);
            whitePieces.add(rookW1);
            pieces[row][0] = rookW1;

            Rook rookW2 = new Rook(row, 7, color);
            whitePieces.add(rookW2);
            pieces[row][7] = rookW2;


            Knight knightW1 = new Knight(row, 1, color);
            whitePieces.add(knightW1);
            pieces[row][1] = knightW1;


            Knight knightW2 = new Knight(row, 6, color);
            whitePieces.add(knightW2);
            pieces[row][6] = knightW2;


            Bishop bishopW1 = new Bishop(row, 2, color);
            whitePieces.add(bishopW1);
            pieces[row][2] = bishopW1;


            Bishop bishopW2 = new Bishop(row, 5, color);
            whitePieces.add(bishopW2);
            pieces[row][5] = bishopW2;

            Queen queenW = new Queen(row, 3, color);
            whitePieces.add(queenW);
            pieces[row][3] = queenW;

            whiteKing = new King(row, 4, color);
            whitePieces.add(whiteKing);
            pieces[row][4] = whiteKing;

            row = 1;
            for (col = 0; col < 8; col++) {
                Pawn pawn = new Pawn(row, col, color);
                whitePieces.add(pawn);
                pieces[row][col] = pawn;
            }
        }
        {
            Color color = Color.BLACK;
            row = 7;

            Rook rookW1 = new Rook(row, 0, color);
            blackPieces.add(rookW1);
            pieces[row][0] = rookW1;

            Rook rookW2 = new Rook(row, 7, color);
            blackPieces.add(rookW2);
            pieces[row][7] = rookW2;


            Knight knightW1 = new Knight(row, 1, color);
            blackPieces.add(knightW1);
            pieces[row][1] = knightW1;


            Knight knightW2 = new Knight(row, 6, color);
            blackPieces.add(knightW2);
            pieces[row][6] = knightW2;


            Bishop bishopW1 = new Bishop(row, 2, color);
            blackPieces.add(bishopW1);
            pieces[row][2] = bishopW1;


            Bishop bishopW2 = new Bishop(row, 5, color);
            blackPieces.add(bishopW2);
            pieces[row][5] = bishopW2;

            Queen queenW = new Queen(row, 3, color);
            blackPieces.add(queenW);
            pieces[row][3] = queenW;

            blackKing = new King(row, 4, color);
            blackPieces.add(blackKing);
            pieces[row][4] = blackKing;

            row = 6;
            for (col = 0; col < 8; col++) {
                Pawn pawn = new Pawn(row, col, color);
                blackPieces.add(pawn);
                pieces[row][col] = pawn;
            }
        }
    }

    public void print() {
        for (int row = 7; row >= 0; row--) {
            System.out.print("\n");
            for (int col = 0; col < 8; col++) {
                System.out.print(pieces[row][col] + " ");
            }
        }
        System.out.println("---");
        System.out.println("White ");
        for (Piece piece : whitePieces) {
            System.out.print(piece + " ");
        }
        System.out.println("---");
        System.out.println("Black ");
        for (Piece piece : blackPieces) {
            System.out.print(piece + " ");
        }
    }

    public GameStateChess copy() {


        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.setCurrentPlayer(currentPlayer);
        if (lastMove != null) gameStateChess.setLastMove((PieceMove)lastMove.copy());
        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

                gameStateChess.getPieces()[row][col] = getPieces()[row][col].copy();
                if (gameStateChess.getPieces()[row][col].getColor() == Color.WHITE) {
                    gameStateChess.getWhitePieces().add(gameStateChess.getPieces()[row][col]);
                    if (gameStateChess.getPieces()[row][col].getPieceType() == PieceType.KING) {
                        gameStateChess.setWhiteKing(gameStateChess.getPieces()[row][col]);
                    }
                } else {
                    gameStateChess.getBlackPieces().add(gameStateChess.getPieces()[row][col]);
                    if (gameStateChess.getPieces()[row][col].getPieceType() == PieceType.KING) {
                        gameStateChess.setBlackKing(gameStateChess.getPieces()[row][col]);
                    }
                }
            }
        }

        return gameStateChess;

    }

    public boolean isTerminal() {
        return getPossibleMoves().size()==0;
    }

    public float score() {
        return 5.0f;
    }

    public List<Move> getPossibleMoves() {
        List<Move> moves=new ArrayList<>();
        List<Piece> pieces=(currentPlayer==Color.WHITE)?whitePieces:blackPieces;
        for (Piece piece:pieces){
            moves.addAll(piece.generatePossibleMoves(this));
        }
        return moves;
    }

    public GameStateChess play(Move move) {
        lastMove=(PieceMove)move;
// empty source
        // fill destination

        // update liste des pieces de chaque couleur

        // update king
        return this;
    }

    public boolean isEchec(){
        return false;
    }

}
