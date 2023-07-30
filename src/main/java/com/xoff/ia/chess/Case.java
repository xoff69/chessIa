package com.xoff.ia.chess;

import com.xoff.ia.common.Copyable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Case implements Copyable {
    int row;
    int column;

    public Case copy() {
        Case caset = new Case(this.row, this.column);

        return caset;
    }

    public String toString() {
        return String.valueOf((char) ('a' + column)) + String.valueOf(row + 1);
    }
}
