package main;
import javax.swing.SwingUtilities;
import java.util.function.BiConsumer;
public class Rendez {

    private int[] tomb;
    private Runnable rajzolas;
    private BiConsumer<Integer, Integer> aktivCallback;

    public Rendez(int[] bemenoTomb,
                  Runnable rajzolas,
                  BiConsumer<Integer, Integer> aktivCallback) {

        this.tomb = (bemenoTomb == null || bemenoTomb.length < 1)
                ? new int[]{2, 5, 8, 3, 7, 6, 4}
                : bemenoTomb;

        this.rajzolas = rajzolas;
        this.aktivCallback = aktivCallback;
    }

    public void egyszeruRendezes() {
        new Thread(() -> {
            for (int i = 0; i < tomb.length - 1; i++) {
                for (int j = i + 1; j < tomb.length; j++) {

                    if (tomb[i] > tomb[j]) {
                        cserel(i, j);
                    }

                    frissit(i, j);
                    sleep();
                }
            }
            vege();
        }).start();
    }

    public void buborekRendezes() {
        new Thread(() -> {
            for (int i = 0; i < tomb.length - 1; i++) {
                for (int j = 0; j < tomb.length - 1 - i; j++) {

                    if (tomb[j] > tomb[j + 1]) {
                        cserel(j, j + 1);
                    }
                    frissit(j, j + 1);
                    sleep();
                }
            }
            vege();
        }).start();
    }

    public void minimumKivalasztasosRendezes() {
        new Thread(() -> {
            for (int i = 0; i < tomb.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < tomb.length; j++) {

                    if (tomb[j] < tomb[minIndex]) {
                        minIndex = j;
                    }

                    frissit(i, j);
                    sleep();
                }
                if (minIndex != i) {
                    cserel(i, minIndex);
                    frissit(i, minIndex);
                    sleep();
                }
            }
            vege();
        }).start();
    }

    private void frissit(int i, int j) {

        if (aktivCallback != null) {
            SwingUtilities.invokeLater(() -> aktivCallback.accept(i, j));
        }

        if (rajzolas != null) {
            SwingUtilities.invokeLater(rajzolas);
        }
    }

    private void vege() {
        if (aktivCallback != null) {
            SwingUtilities.invokeLater(() -> aktivCallback.accept(-1, -1));
        }
    }

    private void cserel(int i, int j) {
        int temp = tomb[i];
        tomb[i] = tomb[j];
        tomb[j] = temp;
    }

    private void sleep() {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int[] getTomb() {
        return tomb;
    }
}