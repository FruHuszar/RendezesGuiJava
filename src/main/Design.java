package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Design {

    public static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus nem elérhető, marad alap L&F");
        }
    }

    public static void applyButtonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Szinek.HATTER.getColor());
        button.setForeground(Szinek.BETU.getColor());
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Szinek.AKTIV.getColor());
            }
            public void mouseExited(MouseEvent evt) {
                button.setBackground(Szinek.HATTER.getColor());
            }
        });
    }

    public static void applyPanelStyle(JPanel panel) {
        panel.setBackground(Szinek.HATTER.getColor());
        panel.setForeground(Szinek.BETU.getColor());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public static void applyLabelStyle(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Szinek.BETU.getColor());
    }

    public static void applyTextFieldStyle(JTextField field) {
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(Szinek.BETU.getColor());
        field.setBackground(Szinek.ALICEBLUE.getColor());
        field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    public static void applyScrollPaneStyle(JScrollPane scrollPane) {
        scrollPane.getViewport().setBackground(Szinek.HATTER.getColor());
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    public static void applyTableStyle(JTable table) {
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setForeground(Szinek.BETU.getColor());
        table.setBackground(Szinek.ALICEBLUE.getColor());
        table.setRowHeight(25);
        table.setFillsViewportHeight(true);
    }
}