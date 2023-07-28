package com.xoff.ia.common;

import java.util.List;

public abstract class GameState {
// ajouter le winner 1 ou 2 ou draq

    private Winner winner;

    public abstract GameState copy();

    public abstract boolean isTerminal();

    public abstract float score();

    public abstract List<Move> getPossibleMove();

    public abstract GameState getNewState(Move move);


}
