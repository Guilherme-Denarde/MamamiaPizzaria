package com.pizzeria.MammaMia.Entity;

public enum Payment {
    PIX(0),
    CARD(1),
    MONEY(2),
    CHECK(3);

    private final int value;

    Payment(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
