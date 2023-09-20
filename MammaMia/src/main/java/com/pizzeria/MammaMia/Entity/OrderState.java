package com.pizzeria.MammaMia.Entity;

public enum OrderState {
    OPEN(0),
    MAKING(1),
    FINISHED(2),
    CANCELED(3);

    private final int value;

    OrderState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
