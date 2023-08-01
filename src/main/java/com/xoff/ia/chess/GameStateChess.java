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

    private List<String> positions;
    private int nbMoveWithoutTakeOrPawnMove;

    private List<String> moves;

    public GameStateChess() {
        lastMove = null;
        currentPlayer = Color.WHITE;
        positions = new ArrayList<>();
        moves = new ArrayList<>();
        nbMoveWithoutTakeOrPawnMove = 0;
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        pieces = new Piece[8][8];
        for (int row = 2; row < 6; row++) {

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("state:");
        sb.append(currentPlayer).append("-");

        for (int row = 7; row >= 0; row--) {
            sb.append("\n");
            for (int col = 0; col < 8; col++) {
                sb.append(pieces[row][col] + " ");
            }
        }

        return sb.toString();
    }

    public void empty() {
        lastMove = null;
        currentPlayer = Color.WHITE;
        positions.clear();
        nbMoveWithoutTakeOrPawnMove = 0;
        whitePieces.clear();
        blackPieces.clear();
        moves.clear();
        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {
                pieces[row][col] = new Empty(row, col);
            }
        }
    }

    public GameStateChess copy() {

        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.setCurrentPlayer(currentPlayer);

        gameStateChess.nbMoveWithoutTakeOrPawnMove = nbMoveWithoutTakeOrPawnMove;
        for (String s : positions) {
            gameStateChess.positions.add(s);
        }
        for (String s : moves) {
            gameStateChess.moves.add(s);
        }
        if (lastMove != null) gameStateChess.setLastMove((PieceMove) lastMove.copy());
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


    public List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList<>();
        List<Piece> pieces = (currentPlayer == Color.WHITE) ? whitePieces : blackPieces;
        for (Piece piece : pieces) {
            moves.addAll(piece.generatePossibleMoves(this));
        }
        // TODO chaque move, le jouer et voir si ca met nous meme en echec
        return moves;
    }

    private Piece findPieceIntoPieces(Color color, int row, int column) {
        List<Piece> pieces = (color == Color.WHITE) ? whitePieces : blackPieces;
        for (Piece piece : pieces) {
            if (piece.getRow() == row && piece.getColumn() == column) {
                return piece;
            }
        }

        return null;
    }

    private void removePieceIntoPieces(Color color, int row, int column) {
        List<Piece> pieces = (color == Color.WHITE) ? whitePieces : blackPieces;
        for (Piece piece : pieces) {
            if (piece.getRow() == row && piece.getColumn() == column) {
                pieces.remove(piece);
                break;
            }
        }

    }

    public GameStateChess play(Move move) {

        GameStateChess gameStateChess = this.copy();

        PieceMove currentMove = (PieceMove) move;
        Piece source = gameStateChess.getPieces()[currentMove.getSource().getRow()][currentMove.getSource().getColumn()];
        Piece pieceOfList = gameStateChess.findPieceIntoPieces(currentPlayer, source.getRow(), source.getColumn());


        pieceOfList.setHasMoved(true);

        // if EP or promotion getPieceType==PAWN, useless to test
        if (source.getPieceType() == PieceType.PAWN || currentMove.getMoveType() == MoveType.TAKE) {
            gameStateChess.setNbMoveWithoutTakeOrPawnMove(0);
        }

        if (currentMove.getMoveType() == MoveType.NA) {

            pieceOfList.setRow(currentMove.getDestination().getRow());
            pieceOfList.setColumn(currentMove.getDestination().getColumn());
            // fill destination
            gameStateChess.getPieces()[currentMove.getDestination().getRow()][currentMove.getDestination().getColumn()] = pieceOfList;


        } else if (currentMove.getMoveType() == MoveType.TAKE) {

            pieceOfList.setRow(currentMove.getDestination().getRow());
            pieceOfList.setColumn(currentMove.getDestination().getColumn());
            // fill destination
            gameStateChess.removePieceIntoPieces(currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE, currentMove.getDestination().getRow(), currentMove.getDestination().getColumn());

            gameStateChess.getPieces()[currentMove.getDestination().getRow()][currentMove.getDestination().getColumn()] = pieceOfList;

        } else if (currentMove.getMoveType() == MoveType.SHORT_CASTLE || currentMove.getMoveType() == MoveType.LONG_CASTLE) {
            // TODO
        } else if (currentMove.getMoveType() == MoveType.PROMOTION_BISHOP || currentMove.getMoveType() == MoveType.PROMOTION_KNIGHT || currentMove.getMoveType() == MoveType.PROMOTION_QUEEN || currentMove.getMoveType() == MoveType.PROMOTION_ROOK) {
            // TODO
        }

        gameStateChess.getPieces()[currentMove.getSource().getRow()][currentMove.getSource().getColumn()] = new Empty(currentMove.getSource().getRow(), currentMove.getSource().getColumn());

        gameStateChess.getPositions().add(toString());
        gameStateChess.setLastMove(currentMove);
        gameStateChess.moves.add(currentMove.toString());
        gameStateChess.setCurrentPlayer(currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE);


        return gameStateChess;
    }

    public boolean isCheck() {
        List<Move> moves = getPossibleMoves();
        Piece myKing = (currentPlayer == Color.WHITE) ? whiteKing : blackKing;
        for (Move move : moves) {
            PieceMove pieceMove = (PieceMove) move;
            Case destination = pieceMove.getDestination();
            if (myKing.getRow() == destination.getRow() && myKing.getColumn() == destination.getColumn()) {
                return true;
            }
        }
        return false;
    }

    public boolean isTerminal() {
        List<Move> possibleMoves = getPossibleMoves();
        return possibleMoves.size() == 0;
    }

    public float score() {
        float score = 0f;
        List<Piece> pieces = (currentPlayer == Color.WHITE) ? whitePieces : blackPieces;
        for (Piece piece : pieces) {
            score = score + piece.estimateValue();
        }
        List<Piece> piecesOpp = (currentPlayer != Color.WHITE) ? whitePieces : blackPieces;
        for (Piece piece : pieces) {
            score = score - piece.estimateValue();
        }
        return score;
    }

}
