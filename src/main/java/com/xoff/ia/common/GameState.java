package com.xoff.ia.common;

import java.util.List;

public interface GameState {

    public boolean isTerminal();
    public float score();

    public List<Move> getPossibleMove();

    public GameState getNewState(Move move);


}
