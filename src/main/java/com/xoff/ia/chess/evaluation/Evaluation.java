package com.xoff.ia.chess.evaluation;

import com.xoff.ia.chess.Color;
import com.xoff.ia.chess.GameStateChess;
import com.xoff.ia.chess.piece.King;
import com.xoff.ia.chess.piece.Piece;
import com.xoff.ia.chess.piece.PieceType;

import java.util.List;

public class Evaluation {

    private static boolean intoMagicSqaure(int row,int column){
        return (row==3||row==4)&&(column==3||column==4);
    }
    public static float evaluate(GameStateChess gameStateChess){
        float score = 0f;
        List<Piece> piecesCurrent = (gameStateChess.getCurrentPlayer() == Color.WHITE) ? gameStateChess.getWhitePieces() : gameStateChess.getBlackPieces();
        boolean isThereQueenCurrent=   piecesCurrent
                .stream()
                .allMatch((s) -> s.getPieceType()==PieceType.QUEEN);

        List<Piece> piecesOpp = (gameStateChess.getCurrentPlayer() != Color.WHITE) ? gameStateChess.getWhitePieces() : gameStateChess.getBlackPieces();
        boolean isThereQueenOpp=  piecesOpp
                .stream()
                .allMatch((s) -> s.getPieceType()==PieceType.QUEEN);
        GamePhase gamePhase=GamePhase.OPENING;
        if (!isThereQueenCurrent||!isThereQueenOpp){
            gamePhase=GamePhase.MIDDLE_GAME;
            if (piecesCurrent.size()<8||piecesOpp.size()<8){
                gamePhase=GamePhase.ENDING;
            }
        }

        for (Piece piece : piecesCurrent) {
            score = score + piece.estimateValue();
            if (piece.getPieceType() == PieceType.KING) {
                King k = (King) piece;
                score = score + (k.isHasCastled() ? 0.5f : 0.f);
            }
            if (piece.getPieceType()==PieceType.BISHOP||piece.getPieceType()==PieceType.KNIGHT||piece.getPieceType()==PieceType.PAWN){
                score = score + (intoMagicSqaure(piece.getRow(),piece.getColumn()) ? 0.2f : 0.f);
            }
            switch (gamePhase){
                case OPENING:
                    if (piece.getPieceType()==PieceType.BISHOP||piece.getPieceType()==PieceType.KNIGHT){

                            score = score + (piece.isHasMoved() ? 0.2f : 0.f);

                    }
                    break;
                case MIDDLE_GAME:break;
                case ENDING:

                    break;
            }
        }
        for (Piece piece : piecesOpp) {
            score = score - piece.estimateValue();
            if (piece.getPieceType() == PieceType.KING) {
                King k = (King) piece;
                score = score + (k.isHasCastled() ? -0.2f : 0.f);
            }

            switch (gamePhase){
                case OPENING:

                    break;
                case MIDDLE_GAME:break;
                case ENDING:break;
            }

        }



        return score;
    }
}
