package main;

import java.awt.Color;

public enum Szinek {
    HATTER(new Color(49, 54, 40)),
    BETU(new Color(255, 228, 196)),
    AKTIV(new Color(60, 54, 40)),
    ALICEBLUE(new Color(240, 248, 255)),
    FEKETE(new Color(0, 0, 0));

    private final Color color;

    Szinek(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}