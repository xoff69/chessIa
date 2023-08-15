package com.xoff.ia.chess;

import com.xoff.ia.chess.evaluation.Evaluation;
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
import java.util.StringTokenizer;

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

    public static GameStateChess string2GameStateChess(String source) {
        GameStateChess gameStateChess = new GameStateChess();
        gameStateChess.getBlackPieces().clear();
        gameStateChess.getWhitePieces().clear();

        String color = source.substring("state:".length(), source.indexOf("-"));
        // System.out.println("color " + color);
        if (color.contains("WHITE")) {
            gameStateChess.setCurrentPlayer(Color.WHITE);
        } else {
            gameStateChess.setCurrentPlayer(Color.BLACK);
        }
        String suite = source.substring(source.indexOf("-") + 1);
        //  System.out.println("suite " + suite);
        int r = 7;
        int c = 0;
        int i = 0;

        for (char car : suite.toCharArray()) {

            switch (car) {
                case '.':
                    gameStateChess.getPieces()[r][c] = new Empty(r, c);
                    c++;
                    break;
                case 'p':
                    gameStateChess.getPieces()[r][c] = new Pawn(r, c, Color.BLACK);
                    gameStateChess.getBlackPieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'P':
                    gameStateChess.getPieces()[r][c] = new Pawn(r, c, Color.WHITE);
                    gameStateChess.getWhitePieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'r':
                    gameStateChess.getPieces()[r][c] = new Rook(r, c, Color.BLACK);
                    gameStateChess.getBlackPieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'R':
                    gameStateChess.getPieces()[r][c] = new Rook(r, c, Color.WHITE);
                    gameStateChess.getWhitePieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'n':
                    gameStateChess.getPieces()[r][c] = new Knight(r, c, Color.BLACK);
                    gameStateChess.getBlackPieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'N':
                    gameStateChess.getPieces()[r][c] = new Knight(r, c, Color.WHITE);
                    gameStateChess.getWhitePieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'B':
                    gameStateChess.getPieces()[r][c] = new Bishop(r, c, Color.WHITE);
                    gameStateChess.getWhitePieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'b':
                    gameStateChess.getPieces()[r][c] = new Bishop(r, c, Color.BLACK);
                    gameStateChess.getBlackPieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'q':
                    gameStateChess.getPieces()[r][c] = new Queen(r, c, Color.BLACK);
                    gameStateChess.getBlackPieces().add(gameStateChess.getPieces()[r][c]);
                    gameStateChess.setBlackKing(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'Q':
                    gameStateChess.getPieces()[r][c] = new Queen(r, c, Color.WHITE);
                    gameStateChess.getWhitePieces().add(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                case 'k':
                    gameStateChess.getPieces()[r][c] = new King(r, c, Color.BLACK);
                    gameStateChess.getBlackPieces().add(gameStateChess.getPieces()[r][c]);
                    gameStateChess.setBlackKing(gameStateChess.getPieces()[r][c]);
                    c++;

                    break;
                case 'K':
                    gameStateChess.getPieces()[r][c] = new King(r, c, Color.WHITE);
                    gameStateChess.getWhitePieces().add(gameStateChess.getPieces()[r][c]);
                    gameStateChess.setWhiteKing(gameStateChess.getPieces()[r][c]);
                    c++;
                    break;
                default:
            }
            i++;
            if (c == 8) {
                c = 0;
                r--;
                if (r == -1) {
                    break;
                }
            }

        }

        String moves = suite.substring(i);
        moves = moves.substring(moves.lastIndexOf("#") + 1);
        moves = moves.substring("moves".length() + 1);
        StringTokenizer str = new StringTokenizer(moves, ",");
        while (str.hasMoreElements()) {
            String token = str.nextToken(); //TODO
            //   System.out.println("a " + token);
            //gameStateChess.setLastMove(token);
        }

        return gameStateChess;
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
        sb.append("\n##moves:");
        for (String m : moves) {
            sb.append(m).append(",");
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
        gameStateChess.getWhitePieces().clear();
        gameStateChess.getBlackPieces().clear();
        gameStateChess.getPositions().clear();
        gameStateChess.getMoves().clear();

        gameStateChess.setCurrentPlayer(currentPlayer);

        gameStateChess.nbMoveWithoutTakeOrPawnMove = nbMoveWithoutTakeOrPawnMove;
        for (String s : positions) {
            gameStateChess.getPositions().add(s);
        }
        for (String s : moves) {
            gameStateChess.moves.add(s);
        }
        if (lastMove != null) gameStateChess.setLastMove((PieceMove) lastMove.copy());
        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

                gameStateChess.getPieces()[row][col] = (getPieces()[row][col]).copy();
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
            //    System.out.println("piece = "+piece+" "+piece.generatePossibleMoves(this).size());
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
        List<Piece> pieces = (currentPlayer == Color.WHITE) ? whitePieces : blackPieces;
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

        } else if (currentMove.getMoveType() == MoveType.EP) {

            pieceOfList.setRow(currentMove.getDestination().getRow());
            pieceOfList.setColumn(currentMove.getDestination().getColumn());
            // fill destination
            gameStateChess.removePieceIntoPieces(currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE, currentMove.getSource().getRow(), currentMove.getDestination().getColumn());

            gameStateChess.getPieces()[currentMove.getDestination().getRow()][currentMove.getDestination().getColumn()] = pieceOfList;

        } else if (currentMove.getMoveType() == MoveType.SHORT_CASTLE || currentMove.getMoveType() == MoveType.LONG_CASTLE) {

            if (currentMove.getMoveType() == MoveType.SHORT_CASTLE) {
                pieceOfList.setRow(currentMove.getSource().getRow());
                pieceOfList.setColumn(6);

                //    System.out.println("Catle King " + whiteKing + "-" + blackKing);

                Rook rook = (Rook) findPieceIntoPieces(currentPlayer, currentMove.getSource().getRow(), 7);
                rook.setColumn(5);

            } else {
                pieceOfList.setRow(currentMove.getSource().getRow());
                pieceOfList.setColumn(3);

                //       System.out.println("grand Catle King " + whiteKing + "-" + blackKing);

                Rook rook = (Rook) findPieceIntoPieces(currentPlayer, currentMove.getSource().getRow(), 0);
                rook.setColumn(4);
            }
            King k = (King) pieceOfList;
            k.setHasCastled(true);

        } else if (currentMove.getMoveType() == MoveType.PROMOTION_BISHOP || currentMove.getMoveType() == MoveType.PROMOTION_KNIGHT || currentMove.getMoveType() == MoveType.PROMOTION_QUEEN || currentMove.getMoveType() == MoveType.PROMOTION_ROOK) {

            gameStateChess.removePieceIntoPieces(currentPlayer, source.getRow(), source.getColumn());

            switch (currentMove.getMoveType()) {
                case PROMOTION_BISHOP:
                    Bishop bishop = new Bishop(currentMove.getDestination().getRow(), currentMove.getDestination().getColumn(), currentPlayer);
                    pieces.add(bishop);
                    break;
                case PROMOTION_KNIGHT:
                    Knight knight = new Knight(currentMove.getDestination().getRow(), currentMove.getDestination().getColumn(), currentPlayer);
                    pieces.add(knight);
                    break;
                case PROMOTION_QUEEN:
                    Queen queen = new Queen(currentMove.getDestination().getRow(), currentMove.getDestination().getColumn(), currentPlayer);
                    pieces.add(queen);
                    break;
                case PROMOTION_ROOK:
                    Rook rook = new Rook(currentMove.getDestination().getRow(), currentMove.getDestination().getColumn(), currentPlayer);
                    pieces.add(rook);
                    break;
                default:
                    break;
            }

        } else if (currentMove.getMoveType() == MoveType.PROMOTION_BISHOP_TAKE || currentMove.getMoveType() == MoveType.PROMOTION_KNIGHT_TAKE || currentMove.getMoveType() == MoveType.PROMOTION_QUEEN_TAKE || currentMove.getMoveType() == MoveType.PROMOTION_ROOK_TAKE) {
            gameStateChess.removePieceIntoPieces(currentPlayer, source.getRow(), source.getColumn());
            gameStateChess.removePieceIntoPieces(currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE, currentMove.getDestination().getRow(), currentMove.getDestination().getColumn());
            switch (currentMove.getMoveType()) {
                case PROMOTION_BISHOP_TAKE:
                    Bishop bishop = new Bishop(currentMove.getDestination().getRow(), currentMove.getDestination().getColumn(), currentPlayer);
                    pieces.add(bishop);
                    break;
                case PROMOTION_KNIGHT_TAKE:
                    Knight knight = new Knight(currentMove.getDestination().getRow(), currentMove.getDestination().getColumn(), currentPlayer);
                    pieces.add(knight);
                    break;
                case PROMOTION_QUEEN_TAKE:
                    Queen queen = new Queen(currentMove.getDestination().getRow(), currentMove.getDestination().getColumn(), currentPlayer);
                    pieces.add(queen);
                    break;
                case PROMOTION_ROOK_TAKE:
                    Rook rook = new Rook(currentMove.getDestination().getRow(), currentMove.getDestination().getColumn(), currentPlayer);
                    pieces.add(rook);
                    break;
                default:
                    break;
            }
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
        return Evaluation.evaluate(this);
    }

}
