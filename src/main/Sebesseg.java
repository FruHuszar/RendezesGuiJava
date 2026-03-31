package main;

public enum Sebesseg {
    VILLAM(20),
    GYORS(250),
    KOZEPES(400),
    LASSU(500),
    LEPESENKENT(1000);

    private final int miliszekundum;

    Sebesseg(int miliszekundum) {
        this.miliszekundum = miliszekundum;
    }

    public int getIdo() {
        return miliszekundum;
    }
}