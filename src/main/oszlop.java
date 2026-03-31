package main;

import javax.swing.*;
import java.awt.*;

public class oszlop extends JPanel {

    private int[] values = new int[0];
    private int aktivI = -1;
    private int aktivJ = -1;

    public oszlop() {
        setBackground(Szinek.HATTER.getColor());
    }

    public void setTomb(int[] tomb) {
        this.values = (tomb == null) ? new int[0] : tomb;
        this.aktivI = -1;
        this.aktivJ = -1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (values.length == 0) return;

        int width = getWidth();
        int height = getHeight();

        int max = 0;
        for (int v : values) if (v > max) max = v;
        if (max == 0) max = 1; // Osztás nullával elleni védelem

        int barWidth = width / values.length;
        int gap = 2;

        for (int i = 0; i < values.length; i++) {
            if (i == aktivI || i == aktivJ) {
                g.setColor(Szinek.AKTIV.getColor()); // Legyen feltűnőbb az aktív elem
            } else {
                g.setColor(Szinek.BETU.getColor());
            }
            
            int barHeight = (int) ((double) values[i] / max * (height - 20));
            int currentBarWidth = Math.max(1, barWidth - gap);

            g.fillRect(i * barWidth, height - barHeight, currentBarWidth, barHeight);
        }
    }

    public void setAktiv(int i, int j) {
        this.aktivI = i;
        this.aktivJ = j;
        this.paintImmediately(0, 0, getWidth(), getHeight());
    }
}