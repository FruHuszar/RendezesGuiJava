package main;

import java.awt.Color;

public enum Szinek {
    HATTER(new Color(255,217,218)),
    BETU(new Color(234,99,140)),
    AKTIV(new Color(137,2,62)),
    ALICEBLUE(new Color(240, 248, 255)),
    DARK(new Color(48,52,63)),
    FEKETE(new Color(27,32,33));

    private final Color color;

    Szinek(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}