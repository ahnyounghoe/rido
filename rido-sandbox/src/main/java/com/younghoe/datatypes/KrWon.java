package com.younghoe.datatypes;

import java.text.DecimalFormat;

/**
 * Created by tony on 2016. 1. 26..
 */
public class KrWon {
    private int amount;

    public KrWon(int amount) {
        this.amount = amount;
    }

    public String withComma() {
        return new DecimalFormat("#,###,###,###").format(this.amount);
    }

    public int amount() {
        return this.amount;
    }
}
