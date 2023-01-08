
package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;


public class SubmodulosAdmin extends javax.swing.JPanel {

    public SubmodulosAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTrabajadores = new javax.swing.JButton();
        btnReporteEntrada = new javax.swing.JButton();
        btnReporteSalida = new javax.swing.JButton();
        btnHistorialCambios = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();

        setBackground(new java.awt.Color(144, 178, 228));
        setMaximumSize(new java.awt.Dimension(230, 340));
        setMinimumSize(new java.awt.Dimension(230, 340));
        setPreferredSize(new java.awt.Dimension(230, 340));

        btnTrabajadores.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconTrabajador.png"))); // NOI18N
        btnTrabajadores.setText("Trabajadores");
        btnTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrabajadores.setMaximumSize(new java.awt.Dimension(230, 50));
        btnTrabajadores.setMinimumSize(new java.awt.Dimension(230, 50));
        btnTrabajadores.setPreferredSize(new java.awt.Dimension(230, 50));
        btnTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajadoresActionPerformed(evt);
            }
        });

        btnReporteEntrada.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnReporteEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/entrada.png"))); // NOI18N
        btnReporteEntrada.setText("Reporte Entradas");
        btnReporteEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteEntrada.setMaximumSize(new java.awt.Dimension(230, 50));
        btnReporteEntrada.setMinimumSize(new java.awt.Dimension(230, 50));
        btnReporteEntrada.setPreferredSize(new java.awt.Dimension(230, 50));
        btnReporteEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteEntradaActionPerformed(evt);
            }
        });

        btnReporteSalida.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnReporteSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salida.png"))); // NOI18N
        btnReporteSalida.setText("Reporte Salidas");
        btnReporteSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteSalida.setMaximumSize(new java.awt.Dimension(230, 50));
        btnReporteSalida.setMinimumSize(new java.awt.Dimension(230, 50));
        btnReporteSalida.setPreferredSize(new java.awt.Dimension(230, 50));
        btnReporteSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteSalidaActionPerformed(evt);
            }
        });

        btnHistorialCambios.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnHistorialCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconCambio.png"))); // NOI18N
        btnHistorialCambios.setText("Historial de Cambios");
        btnHistorialCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorialCambios.setMaximumSize(new java.awt.Dimension(230, 50));
        btnHistorialCambios.setMinimumSize(new java.awt.Dimension(230, 50));
        btnHistorialCambios.setPreferredSize(new java.awt.Dimension(230, 50));
        btnHistorialCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialCambiosActionPerformed(evt);
            }
        });

        btnInventario.setFont(new java.awt.Font("SF UI Display", 0, 16)); // NOI18N
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/inventario.png"))); // NOI18N
        btnInventario.setText("Reporte Inventario");
        btnInventario.setMaximumSize(new java.awt.Dimension(230, 50));
        btnInventario.setMinimumSize(new java.awt.Dimension(230, 50));
        btnInventario.setPreferredSize(new java.awt.Dimension(230, 50));
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReporteEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReporteSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistorialCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnReporteEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnReporteSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnHistorialCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajadoresActionPerformed
        SubmoduloTrabajador mTraba = new SubmoduloTrabajador();
        
        mTraba.setSize(new Dimension(970, 550));
        mTraba.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mTraba,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnTrabajadoresActionPerformed

    private void btnReporteEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteEntradaActionPerformed
        SubmoduloReporteEntradas mEntrada = new SubmoduloReporteEntradas();
        
        mEntrada.setSize(new Dimension(970, 550));
        mEntrada.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mEntrada,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnReporteEntradaActionPerformed

    private void btnReporteSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteSalidaActionPerformed
        SubmoduloReporteSalidas mSalida = new SubmoduloReporteSalidas();
        
        mSalida.setSize(new Dimension(970, 550));
        mSalida.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mSalida,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnReporteSalidaActionPerformed

    private void btnHistorialCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialCambiosActionPerformed
        SubmoduloReporteCambios mCambios = new SubmoduloReporteCambios();
        
        mCambios.setSize(new Dimension(970, 550));
        mCambios.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mCambios,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnHistorialCambiosActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        SubmoduloReporteInventario mInventario = new SubmoduloReporteInventario();
        
        mInventario.setSize(new Dimension(970, 550));
        mInventario.setLocation(0,0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mInventario,BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnInventarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorialCambios;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnReporteEntrada;
    private javax.swing.JButton btnReporteSalida;
    private javax.swing.JButton btnTrabajadores;
    // End of variables declaration//GEN-END:variables
}
