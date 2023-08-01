package com.xoff.ia.tictactoe;

import com.xoff.ia.common.Copyable;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicTacMove implements Move {
    private int i;
    private int j;

    @Override
    public Copyable copy() {
        TicTacMove other = new TicTacMove();
        other.i = i;
        other.j = j;
        return other;

    }
}
