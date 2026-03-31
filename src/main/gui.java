package main;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JSpinner;
import javax.swing.UIManager;

public class gui extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(gui.class.getName());

    String szoveg = "Rendezendő számok:\n";
    int[] tomb;
    private oszlop panel;

    public gui() {
        initComponents();
        szamokKiirasHelye.setText(szoveg);
        panel = new oszlop();
        grafikon.setLayout(new BorderLayout());
        grafikon.add(panel, BorderLayout.CENTER);
        stilusok();
    }

    private void stilusok() {
        // JFrame háttérszíne
        getContentPane().setBackground(Szinek.HATTER.getColor());

        // Panelek
        Design.applyPanelStyle(control);
        Design.applyPanelStyle(jPanel1);
        Design.applyPanelStyle(jPanel2);
        Design.applyPanelStyle(grafikon);

        // Gombok
        Design.applyButtonStyle(Hozzaadas);
        Design.applyButtonStyle(rajzolGomb);
        Design.applyButtonStyle(rendez);

        // TextArea + ScrollPane
        Design.applyScrollPaneStyle(jScrollPane1);
        szamokKiirasHelye.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        szamokKiirasHelye.setForeground(Szinek.FEKETE.getColor());  
        szamokKiirasHelye.setBackground(Szinek.ALICEBLUE.getColor());
        szamokKiirasHelye.setCaretColor(Szinek.FEKETE.getColor()); 

        // Spinner
        szamValaszto.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        szamValaszto.setBackground(Szinek.ALICEBLUE.getColor());
        szamValaszto.setForeground(Szinek.BETU.getColor());
        ((JSpinner.DefaultEditor) szamValaszto.getEditor()).getTextField()
                .setBackground(Szinek.ALICEBLUE.getColor());
        ((JSpinner.DefaultEditor) szamValaszto.getEditor()).getTextField()
                .setForeground(Szinek.BETU.getColor());

        // Spinner nyilak
        UIManager.put("Spinner.arrowButtonBackground", Szinek.HATTER.getColor());
        UIManager.put("Spinner.arrowButtonBorder", BorderFactory.createEmptyBorder());

        // ComboBox
        rendezesTipusok.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        rendezesTipusok.setBackground(Szinek.ALICEBLUE.getColor());
        rendezesTipusok.setForeground(Szinek.BETU.getColor());

        // Spinner stílus
        szamValaszto.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) szamValaszto.getEditor();
        spinnerEditor.getTextField().setBackground(Szinek.ALICEBLUE.getColor());
        spinnerEditor.getTextField().setForeground(Szinek.FEKETE.getColor()); 
        szamValaszto.setBackground(Szinek.ALICEBLUE.getColor());
        szamValaszto.setForeground(Szinek.FEKETE.getColor());

        // ComboBox stílus
        rendezesTipusok.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        rendezesTipusok.setBackground(Szinek.ALICEBLUE.getColor());
        rendezesTipusok.setForeground(Szinek.FEKETE.getColor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        control = new javax.swing.JPanel();
        rajzolGomb = new javax.swing.JButton();
        szamValaszto = new javax.swing.JSpinner();
        Hozzaadas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        szamokKiirasHelye = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        grafikon = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rendez = new javax.swing.JButton();
        rendezesTipusok = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rendezések");
        setMaximumSize(new java.awt.Dimension(720, 360));
        setMinimumSize(new java.awt.Dimension(720, 360));
        setPreferredSize(new java.awt.Dimension(720, 360));

        control.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));

        rajzolGomb.setText("Rajzol");
        rajzolGomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rajzolGombMouseClicked(evt);
            }
        });

        szamValaszto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999999999, 1));
        szamValaszto.setToolTipText("");

        Hozzaadas.setText("Hozzáadás");
        Hozzaadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HozzaadasMouseClicked(evt);
            }
        });

        szamokKiirasHelye.setColumns(20);
        szamokKiirasHelye.setLineWrap(true);
        szamokKiirasHelye.setRows(5);
        szamokKiirasHelye.setAutoscrolls(false);
        jScrollPane1.setViewportView(szamokKiirasHelye);

        javax.swing.GroupLayout controlLayout = new javax.swing.GroupLayout(control);
        control.setLayout(controlLayout);
        controlLayout.setHorizontalGroup(
            controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rajzolGomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, controlLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(szamValaszto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Hozzaadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        controlLayout.setVerticalGroup(
            controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlLayout.createSequentialGroup()
                .addGroup(controlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(szamValaszto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hozzaadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rajzolGomb)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Diagram"));

        grafikon.setMaximumSize(new java.awt.Dimension(1000, 600));
        grafikon.setMinimumSize(new java.awt.Dimension(300, 200));

        javax.swing.GroupLayout grafikonLayout = new javax.swing.GroupLayout(grafikon);
        grafikon.setLayout(grafikonLayout);
        grafikonLayout.setHorizontalGroup(
            grafikonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        grafikonLayout.setVerticalGroup(
            grafikonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grafikon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grafikon, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Rendezés"));

        rendez.setText("Rendez");
        rendez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rendezMouseClicked(evt);
            }
        });

        rendezesTipusok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Egyszerű", "Buborék", "Minimum" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rendezesTipusok, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rendez, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rendezesTipusok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(rendez))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rendez, rendezesTipusok});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rendezMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rendezMouseClicked
        if (tomb == null || tomb.length == 0 || !rendez.isEnabled()) {
            return;
        }

        // Gomb letiltása, hogy ne indulhasson el két rendezés egyszerre
        letilasEsEngedes(false);

        Rendez rendezes = new Rendez(
                tomb,
                () -> panel.repaint(),
                (i, j) -> {
                    panel.setAktiv(i, j);
                    // Ha vége a rendezésnek (visszakaptuk a -1, -1-et), gomb vissza
                    if (i == -1) {
                        letilasEsEngedes(true);
                    }
                }
        );

        int kesleltetes = Sebesseg.VILLAM.getIdo();
        int index = rendezesTipusok.getSelectedIndex();

        switch (index) {
            case 0:
                rendezes.egyszeruRendezes(kesleltetes);
                break;
            case 1:
                rendezes.buborekRendezes(kesleltetes);
                break;
            case 2:
                rendezes.minimumKivalasztasosRendezes(kesleltetes);
                break;
        }

    }//GEN-LAST:event_rendezMouseClicked

    private void HozzaadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HozzaadasMouseClicked
        int szam = (int) szamValaszto.getValue();
        szoveg += szam + "; ";
        szamokKiirasHelye.setText(szoveg);
    }//GEN-LAST:event_HozzaadasMouseClicked

    private void feldolgozEsRajzol() {
        String osszesSzam = szamokKiirasHelye.getText().replace("Rendezendő számok:\n", "").trim();
        if (osszesSzam.isEmpty()) {
            return;
        }
        if (osszesSzam.endsWith(";")) {
            osszesSzam = osszesSzam.substring(0, osszesSzam.length() - 1);
        }
        String[] szetvagottSzamok = osszesSzam.split("; ");
        tomb = new int[szetvagottSzamok.length];
        try {
            for (int i = 0; i < tomb.length; i++) {
                tomb[i] = Integer.parseInt(szetvagottSzamok[i].trim());
            }
            panel.setTomb(tomb);
            panel.repaint();
        } catch (NumberFormatException e) {
            System.err.println("Hiba: Érvénytelen formátum!");
        }
    }
    
    private void letilasEsEngedes(boolean enged){
        rendez.setEnabled(enged);
        rajzolGomb.setEnabled(enged);
        Hozzaadas.setEnabled(enged);
    }

    private void rajzolGombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rajzolGombMouseClicked
        feldolgozEsRajzol();
    }//GEN-LAST:event_rajzolGombMouseClicked

    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(() -> new gui().setVisible(true));
    }

    public void Ujrarazjol(oszlop panel) {
        grafikon.removeAll();
        grafikon.add(panel, BorderLayout.CENTER);
        grafikon.revalidate();
        grafikon.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hozzaadas;
    private javax.swing.JPanel control;
    private javax.swing.JPanel grafikon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rajzolGomb;
    private javax.swing.JButton rendez;
    private javax.swing.JComboBox<String> rendezesTipusok;
    private javax.swing.JSpinner szamValaszto;
    private javax.swing.JTextArea szamokKiirasHelye;
    // End of variables declaration//GEN-END:variables
}
