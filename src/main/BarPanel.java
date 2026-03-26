package main;

import javax.swing.*;
import java.awt.*;

public class BarPanel extends JPanel {

    int[] values;
    private int aktivI = -1;
    private int aktivJ = -1;

    public BarPanel() {
        this(new int[]{2, 5, 8, 3, 7, 6, 4});
        setBackground(Szinek.HATTER.getColor());
    }

    public BarPanel(int[] values) {
        this.values = (values == null || values.length < 1)
                ? new int[]{2, 5, 8, 3, 7, 6, 4}
                : values;
    }

    public void setTomb(int[] tomb) {
        this.values = tomb;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Debug
        //System.out.println("Width: " + width + " Height: " + height);
        int max = 0;
        for (int v : values) {
            if (v > max) {
                max = v;
            }
        }

        int barWidth = width / values.length;
        int gap = 5;

        g.setColor(Color.LIGHT_GRAY);

        for (int i = 0; i < values.length; i++) {

            if (i == aktivI || i == aktivJ) {
                g.setColor(Color.DARK_GRAY);
            } else {
                g.setColor(Color.LIGHT_GRAY);
            }
            int barHeight = (int) ((double) values[i] / max * height);
            int currentBarWidth = Math.max(1, barWidth - gap);

            g.fillRect(
                    i * barWidth,
                    height - barHeight,
                    currentBarWidth,
                    barHeight
            );
        }
    }
    
    public void setAktiv(int i, int j) {
        this.aktivI = i;
        this.aktivJ = j;
        repaint();
    }
}
