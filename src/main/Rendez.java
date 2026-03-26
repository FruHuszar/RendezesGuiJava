package main;

import java.util.Arrays;

public class Rendez {

    private int[] tomb;

    public Rendez(int[] bemenoTomb) {
    this.tomb = (bemenoTomb == null || bemenoTomb.length < 1) 
                ? new int[]{2, 5, 8, 3, 7, 6, 4} 
                : Arrays.copyOf(bemenoTomb, bemenoTomb.length);
}

    public void egyszeruRendezes() {
        for (int i = 0; i < tomb.length - 1; i++) {
            for (int j = i + 1; j < tomb.length; j++) {
                if (tomb[i] > tomb[j]) {
                    cserel(i, j);
                }
            }
        }
    }

    public void buborekRendezes() {
        for (int i = 0; i < tomb.length - 1; i++) {
            for (int j = 0; j < tomb.length - 1 - i; j++) {
                if (tomb[j] > tomb[j + 1]) {
                    cserel(j, j + 1);
                }
            }
        }
    }

    public void minimumKivalasztasosRendezes() {
        for (int i = 0; i < tomb.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tomb.length; j++) {
                if (tomb[j] < tomb[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                cserel(i, minIndex);
            }
        }
    }

    private void cserel(int i, int j) {
        int temp = tomb[i];
        tomb[i] = tomb[j];
        tomb[j] = temp;
    }

    public int[] getTomb() {
        return tomb;
    }
}