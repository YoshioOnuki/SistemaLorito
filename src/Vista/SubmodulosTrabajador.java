
package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class SubmodulosTrabajador extends javax.swing.JPanel {

    public SubmodulosTrabajador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInventario = new javax.swing.JButton();
        btnEntradas = new javax.swing.JButton();

        setBackground(new java.awt.Color(144, 178, 228));
        setMaximumSize(new java.awt.Dimension(230, 340));
        setMinimumSize(new java.awt.Dimension(230, 340));
        setPreferredSize(new java.awt.Dimension(230, 340));

        btnInventario.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/inventario.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.setMaximumSize(new java.awt.Dimension(230, 50));
        btnInventario.setMinimumSize(new java.awt.Dimension(230, 50));
        btnInventario.setPreferredSize(new java.awt.Dimension(230, 50));
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnEntradas.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconEntradasSalidas.png"))); // NOI18N
        btnEntradas.setText("Entradas / Salidas");
        btnEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntradas.setMaximumSize(new java.awt.Dimension(230, 50));
        btnEntradas.setMinimumSize(new java.awt.Dimension(230, 50));
        btnEntradas.setPreferredSize(new java.awt.Dimension(230, 50));
        btnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        SubmoduloReporteInventario mInventario = new SubmoduloReporteInventario();
        
        mInventario.setSize(new Dimension(970, 550));
        mInventario.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mInventario,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradasActionPerformed
        SubmoduloEntradaSalida mEntradas = new SubmoduloEntradaSalida();
        
        mEntradas.setSize(new Dimension(970, 550));
        mEntradas.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mEntradas,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnEntradasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntradas;
    private javax.swing.JButton btnInventario;
    // End of variables declaration//GEN-END:variables
}
