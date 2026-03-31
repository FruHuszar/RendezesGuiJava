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
        i = 0;
        j = 0;
        alvas = new Timer(kesleltetes, (ActionEvent e) -> {
            if (i < tomb.length - 1) {
                if (tomb[j] > tomb[j + 1]) {
                    cserel(j, j + 1);
                }
                frissit(j, j + 1);
                j++;
                if (j >= tomb.length - 1 - i) {
                    j = 0;
                    i++;
                }
            } else {
                vege();
            }
        });
        alvas.start();
    }

    public void egyszeruRendezes(int kesleltetes) {
        i = 0;
        j = 1;
        alvas = new Timer(kesleltetes, (ActionEvent e) -> {
            if (i < tomb.length - 1) {
                if (tomb[i] > tomb[j]) {
                    cserel(i, j);
                }
                frissit(i, j);
                j++;
                if (j >= tomb.length) {
                    i++;
                    j = i + 1;
                }
            } else {
                vege();
            }
        });
        alvas.start();
    }

    public void minimumKivalasztasosRendezes(int kesleltetes) {
        i = 0;
        j = 1;
        minIndex = 0;
        alvas = new Timer(kesleltetes, (ActionEvent e) -> {
            if (i < tomb.length - 1) {
                if (j < tomb.length) {
                    if (tomb[j] < tomb[minIndex]) {
                        minIndex = j;
                    }
                    frissit(i, j);
                    j++;
                } else {
                    if (minIndex != i) {
                        cserel(i, minIndex);
                    }
                    i++;
                    j = i + 1;
                    minIndex = i;
                    frissit(i, -1);
                }
            } else {
                vege();
            }
        });
        alvas.start();
    }

    public void mergeRendezesIndit(int kesleltetes) {
        // Új szálon indítjuk, hogy a Thread.sleep ne akassza meg a GUI-t
        new Thread(() -> {
            mergeSortRekurziv(0, tomb.length - 1, kesleltetes);
            vege();
        }).start();
    }

    private void mergeSortRekurziv(int bal, int jobb, int kesleltetes) {
        if (bal < jobb) {
            int kozep = bal + (jobb - bal) / 2;

            mergeSortRekurziv(bal, kozep, kesleltetes);
            mergeSortRekurziv(kozep + 1, jobb, kesleltetes);

            merge(bal, kozep, jobb, kesleltetes);
        }
    }

    private void merge(int bal, int kozep, int jobb, int kesleltetes) {
        // Segédtömbök létrehozása
        int n1 = kozep - bal + 1;
        int n2 = jobb - kozep;

        int[] balTomb = new int[n1];
        int[] jobbTomb = new int[n2];

        for (int i = 0; i < n1; ++i) {
            balTomb[i] = tomb[bal + i];
        }
        for (int j = 0; j < n2; ++j) {
            jobbTomb[j] = tomb[kozep + 1 + j];
        }

        int i = 0, j = 0;
        int k = bal;

        while (i < n1 && j < n2) {
            // Vizualizáció: éppen ezt a két indexet hasonlítjuk össze
            frissitEsVar(bal + i, kozep + 1 + j, kesleltetes);

            if (balTomb[i] <= jobbTomb[j]) {
                tomb[k] = balTomb[i];
                i++;
            } else {
                tomb[k] = jobbTomb[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            tomb[k] = balTomb[i];
            frissitEsVar(k, -1, kesleltetes);
            i++;
            k++;
        }

        while (j < n2) {
            tomb[k] = jobbTomb[j];
            frissitEsVar(k, -1, kesleltetes);
            j++;
            k++;
        }
    }

    private void cserel(int a, int b) {
        int temp = tomb[a];
        tomb[a] = tomb[b];
        tomb[b] = temp;
    }

    private void frissit(int a, int b) {
        if (aktivCallback != null) {
            aktivCallback.accept(a, b);
        }
        if (rajzolas != null) {
            rajzolas.run();
        }
    }

    private void frissitEsVar(int a, int b, int kesleltetes) {
        frissit(a, b);
        try {
            Thread.sleep(kesleltetes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void vege() {
        if (alvas != null) {
            alvas.stop();
        }
        if (aktivCallback != null) {
            aktivCallback.accept(-1, -1);
        }
    }
}
