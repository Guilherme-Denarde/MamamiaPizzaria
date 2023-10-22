package com.pizzeria.MammaMia.Entity;

public enum Permission {
    ADMINISTRATOR(0),
    MANAGER(1),
    EMPLOYEE(2);

    private final int value;

    Permission(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
