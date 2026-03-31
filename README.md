# Java Rendezések gui

## Main

1. A Megjelenés beállítása (Look and Feel)
A try-catch blokkban található ciklus a Java beépített stíluskészletei között keres:

UIManager.getInstalledLookAndFeels(): Lekéri az összes elérhető grafikus stílust, amit a Java támogat.
Nimbus: Ez egy modern, vektoralapú grafikai téma. A kód megkeresi, és ha megtalálja, a setLookAndFeel utasítással alkalmazza az egész programra.
A kosztümizációhoz használom.

```java
 try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
```

2. Biztonságos indítás (Thread Safety)
Event Dispatch Thread (EDT) nevű szál --> Ez az a szál, ami kizárólag a felhasználói eseményekkel (kattintás, gépelés) és a rajzolással foglalkozik.
```java
 java.awt.EventQueue.invokeLater(() -> new gui().setVisible(true));
```

## Rajzolás

A paintComponent felülírása egy jelenlegi workaround megoldás a design érdekében.
Az oszlopok az aktuális input számok alapú megjelenítésére használom.

```java
@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
```

## :root a javában

A színek és stílus gyors téma változtatásának érdekében a Szinek enumban nem színneveket adtam, hanem "mire használjuk" nevet.

```java
public enum Szinek {
    HATTER(new Color(255,217,218)),
    BETU(new Color(234,99,140)),
```

## animáció sebesség

Miliszekundumok enum-ban, beszédes elnevezéssel

```java
public enum Sebesseg {
    VILLAM(300),
    GYORS(450),
    KOZEPES(600),
    LASSU(800),
    LEPESENKENT(1500);
```
