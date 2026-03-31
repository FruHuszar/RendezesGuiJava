package main;

public enum Sebesseg {
    VILLAM(300),
    GYORS(450),
    KOZEPES(600),
    LASSU(800),
    LEPESENKENT(1500);

    private final int miliszekundum;

    Sebesseg(int miliszekundum) {
        this.miliszekundum = miliszekundum;
    }

    public int getIdo() {
        return miliszekundum;
    }
}