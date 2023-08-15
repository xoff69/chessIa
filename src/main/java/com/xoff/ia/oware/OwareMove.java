package com.xoff.ia.oware;

import com.xoff.ia.common.Copyable;
import com.xoff.ia.common.Move;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OwareMove implements Move {

    private int source;

    @Override
    public Copyable copy() {
        OwareMove other = new OwareMove();
        other.setSource(source);
        return other;
    }
}
