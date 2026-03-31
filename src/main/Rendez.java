package main;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.util.function.BiConsumer;

public class Rendez {

    private int[] tomb;
    private Runnable rajzolas;
    private BiConsumer<Integer, Integer> aktivCallback;
    private Timer alvas;
    private int i, j, minIndex;

    public Rendez(int[] bemenoTomb, Runnable rajzolas, BiConsumer<Integer, Integer> aktivCallback) {
        this.tomb = bemenoTomb;
        this.rajzolas = rajzolas;
        this.aktivCallback = aktivCallback;
    }

    public void buborekRendezes(int kesleltetes) {
        i = 0; j = 0;
        alvas = new Timer(kesleltetes, (ActionEvent e) -> {
            if (i < tomb.length - 1) {
                if (tomb[j] > tomb[j + 1]) cserel(j, j + 1);
                frissit(j, j + 1);
                j++;
                if (j >= tomb.length - 1 - i) { j = 0; i++; }
            } else { vege(); }
        });
        alvas.start();
    }

    public void egyszeruRendezes(int kesleltetes) {
        i = 0; j = 1;
        alvas = new Timer(kesleltetes, (ActionEvent e) -> {
            if (i < tomb.length - 1) {
                if (tomb[i] > tomb[j]) cserel(i, j);
                frissit(i, j);
                j++;
                if (j >= tomb.length) { i++; j = i + 1; }
            } else { vege(); }
        });
        alvas.start();
    }

    public void minimumKivalasztasosRendezes(int kesleltetes) {
        i = 0; j = 1; minIndex = 0;
        alvas = new Timer(kesleltetes, (ActionEvent e) -> {
            if (i < tomb.length - 1) {
                if (j < tomb.length) {
                    if (tomb[j] < tomb[minIndex]) minIndex = j;
                    frissit(i, j);
                    j++;
                } else {
                    if (minIndex != i) cserel(i, minIndex);
                    i++; j = i + 1; minIndex = i;
                    frissit(i, -1);
                }
            } else { vege(); }
        });
        alvas.start();
    }

    private void cserel(int a, int b) {
        int temp = tomb[a];
        tomb[a] = tomb[b];
        tomb[b] = temp;
    }

    private void frissit(int a, int b) {
        if (aktivCallback != null) aktivCallback.accept(a, b);
        if (rajzolas != null) rajzolas.run();
    }

    private void vege() {
        if (alvas != null) alvas.stop();
        if (aktivCallback != null) aktivCallback.accept(-1, -1);
    }
}