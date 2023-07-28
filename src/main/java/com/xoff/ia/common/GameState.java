package com.xoff.ia.common;

import java.util.List;

public interface GameState {
// ajouter le winner 1 ou 2 ou draq

    public boolean isTerminal();
    public float score();

    public List<Move> getPossibleMove();

    public GameState getNewState(Move move);


}
