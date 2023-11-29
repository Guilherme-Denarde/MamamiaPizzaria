package com.pizzeria.MammaMia.Entity;

public enum Categoria {



        PIZZA(0),
        PORCAO(1),
        BEBIDA(2);

        private final int value;

        Categoria(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


}
