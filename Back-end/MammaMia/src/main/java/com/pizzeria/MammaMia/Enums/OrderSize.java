package com.pizzeria.MammaMia.Enums;

public enum OrderSize {
    P(0),
    M(1),
    G(2),
    GG(3);

    private final int value;

    OrderSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
