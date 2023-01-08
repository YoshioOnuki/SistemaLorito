
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

        btnTrabajadores = new javax.swing.JButton();
        btnReporteIngreso = new javax.swing.JButton();
        btnReporteSalida = new javax.swing.JButton();

        setBackground(new java.awt.Color(144, 178, 228));
        setMaximumSize(new java.awt.Dimension(230, 340));
        setMinimumSize(new java.awt.Dimension(230, 340));
        setPreferredSize(new java.awt.Dimension(230, 340));

        btnTrabajadores.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/inventario.png"))); // NOI18N
        btnTrabajadores.setText("Inventario");
        btnTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrabajadores.setMaximumSize(new java.awt.Dimension(230, 50));
        btnTrabajadores.setMinimumSize(new java.awt.Dimension(230, 50));
        btnTrabajadores.setPreferredSize(new java.awt.Dimension(230, 50));
        btnTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajadoresActionPerformed(evt);
            }
        });

        btnReporteIngreso.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnReporteIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/entrada.png"))); // NOI18N
        btnReporteIngreso.setText("Entradas");
        btnReporteIngreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteIngreso.setMaximumSize(new java.awt.Dimension(230, 50));
        btnReporteIngreso.setMinimumSize(new java.awt.Dimension(230, 50));
        btnReporteIngreso.setPreferredSize(new java.awt.Dimension(230, 50));
        btnReporteIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteIngresoActionPerformed(evt);
            }
        });

        btnReporteSalida.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnReporteSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salida.png"))); // NOI18N
        btnReporteSalida.setText("Salidas");
        btnReporteSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteSalida.setMaximumSize(new java.awt.Dimension(230, 50));
        btnReporteSalida.setMinimumSize(new java.awt.Dimension(230, 50));
        btnReporteSalida.setPreferredSize(new java.awt.Dimension(230, 50));
        btnReporteSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnReporteIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnReporteSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajadoresActionPerformed
        SubmoduloReporteInventario mInventario = new SubmoduloReporteInventario();
        
        mInventario.setSize(new Dimension(970, 550));
        mInventario.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mInventario,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnTrabajadoresActionPerformed

    private void btnReporteIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteIngresoActionPerformed

    }//GEN-LAST:event_btnReporteIngresoActionPerformed

    private void btnReporteSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteSalidaActionPerformed

    }//GEN-LAST:event_btnReporteSalidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporteIngreso;
    private javax.swing.JButton btnReporteSalida;
    private javax.swing.JButton btnTrabajadores;
    // End of variables declaration//GEN-END:variables
}
