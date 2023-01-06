/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.trabajadorController;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author yoshi
 */
public class SubmoduloTrabajador extends javax.swing.JPanel {

    DefaultTableModel m = new DefaultTableModel();
    Controlador.trabajadorController trabController= new trabajadorController();
    
    public SubmoduloTrabajador() {
        initComponents();
        placeholders();
        buscarEmpleado();
    }

    
    void placeholders(){
        Textp txte = new Textp("Buscar Nombre/DNI", txtBuscarTrabajador);
    }
    
    void buscarEmpleado(){
        try {
            m = trabController.consultarTrabajador(txtBuscarTrabajador.getText());
            tablaTrab.setModel(m);
            
            TableColumn t1 = tablaTrab.getColumn("ID");
            t1.setPreferredWidth(50);
            t1.setMaxWidth(50);
            t1.setMinWidth(50);
            
            TableColumn t2 = tablaTrab.getColumn("DNI");
            t2.setPreferredWidth(100);
            t2.setMaxWidth(100);
            t2.setMinWidth(100);
            
            TableColumn t3 = tablaTrab.getColumn("NOMBRES");
            t3.setPreferredWidth(240);
            t3.setMaxWidth(240);
            t3.setMinWidth(240);
            
            TableColumn t4 = tablaTrab.getColumn("DIRECCION");
            t4.setPreferredWidth(290);
            t4.setMaxWidth(290);
            t4.setMinWidth(290);
            
            TableColumn t5 = tablaTrab.getColumn("ROL");
            t5.setPreferredWidth(150);
            t5.setMaxWidth(150);
            t5.setMinWidth(150);
            
            tablaTrab.setRowHeight(25);
        } catch (Exception e) {
            System.out.println("Error al listar Trabajadores: " + e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarTrabajador = new javax.swing.JTextField();
        btnNuevo3 = new javax.swing.JPanel();
        IconNuevo3 = new javax.swing.JLabel();
        IconNuevoHover3 = new javax.swing.JLabel();
        Tabla = new javax.swing.JScrollPane();
        tablaTrab = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(970, 550));
        setMinimumSize(new java.awt.Dimension(970, 550));

        jPanel6.setBackground(new java.awt.Color(53, 66, 89));
        jPanel6.setMaximumSize(new java.awt.Dimension(970, 25));
        jPanel6.setMinimumSize(new java.awt.Dimension(970, 25));

        btnExit.setBackground(new java.awt.Color(53, 66, 89));
        btnExit.setMaximumSize(new java.awt.Dimension(40, 25));
        btnExit.setMinimumSize(new java.awt.Dimension(40, 25));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SF UI Display", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 25));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 25));
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 25));

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("SF UI Display", 1, 20)); // NOI18N
        jLabel1.setText("TRABAJADORES");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(190, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(190, 50));

        txtBuscarTrabajador.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscarTrabajador.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtBuscarTrabajador.setBorder(null);
        txtBuscarTrabajador.setMaximumSize(new java.awt.Dimension(120, 18));
        txtBuscarTrabajador.setMinimumSize(new java.awt.Dimension(120, 18));
        txtBuscarTrabajador.setPreferredSize(new java.awt.Dimension(120, 18));
        txtBuscarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarTrabajadorActionPerformed(evt);
            }
        });
        txtBuscarTrabajador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarTrabajadorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtBuscarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevo3.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo3.setMaximumSize(new java.awt.Dimension(110, 42));
        btnNuevo3.setMinimumSize(new java.awt.Dimension(110, 42));
        btnNuevo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevo3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevo3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevo3MouseExited(evt);
            }
        });

        IconNuevo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconNuevo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnNuevo.png"))); // NOI18N

        IconNuevoHover3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconNuevoHover3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnNuevoHover.png"))); // NOI18N

        javax.swing.GroupLayout btnNuevo3Layout = new javax.swing.GroupLayout(btnNuevo3);
        btnNuevo3.setLayout(btnNuevo3Layout);
        btnNuevo3Layout.setHorizontalGroup(
            btnNuevo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IconNuevo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnNuevo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(IconNuevoHover3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
        );
        btnNuevo3Layout.setVerticalGroup(
            btnNuevo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevo3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(IconNuevo3))
            .addGroup(btnNuevo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevo3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(IconNuevoHover3)))
        );

        Tabla.setMaximumSize(new java.awt.Dimension(830, 315));
        Tabla.setMinimumSize(new java.awt.Dimension(830, 315));
        Tabla.setPreferredSize(new java.awt.Dimension(830, 315));

        tablaTrab.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        tablaTrab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla.setViewportView(tablaTrab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(500, 500, 500)
                                .addComponent(btnNuevo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(Tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(237, 19, 19));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(53,66,89));
    }//GEN-LAST:event_btnExitMouseExited

    private void txtBuscarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarTrabajadorActionPerformed

    }//GEN-LAST:event_txtBuscarTrabajadorActionPerformed

    private void txtBuscarTrabajadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarTrabajadorKeyTyped
        //buscarTrabajador();
    }//GEN-LAST:event_txtBuscarTrabajadorKeyTyped

    private void btnNuevo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevo3MouseClicked
//        Vista.HabitacionNuevo habitNuevo = new Vista.HabitacionNuevo();
//
//        habitNuevo.setSize(700, 510);
//        habitNuevo.setLocation(0, 0);
//        Contenido.panelContenido.removeAll();
//        Contenido.panelContenido.add(habitNuevo, BorderLayout.CENTER);
//        Contenido.panelContenido.revalidate();
//        Contenido.panelContenido.repaint();
    }//GEN-LAST:event_btnNuevo3MouseClicked

    private void btnNuevo3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevo3MouseEntered
        IconNuevo3.setVisible(false);
        IconNuevoHover3.setVisible(true);
    }//GEN-LAST:event_btnNuevo3MouseEntered

    private void btnNuevo3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevo3MouseExited
        IconNuevo3.setVisible(true);
        IconNuevoHover3.setVisible(false);
    }//GEN-LAST:event_btnNuevo3MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconNuevo;
    private javax.swing.JLabel IconNuevo1;
    private javax.swing.JLabel IconNuevo2;
    private javax.swing.JLabel IconNuevo3;
    private javax.swing.JLabel IconNuevoHover;
    private javax.swing.JLabel IconNuevoHover1;
    private javax.swing.JLabel IconNuevoHover2;
    private javax.swing.JLabel IconNuevoHover3;
    private javax.swing.JScrollPane Tabla;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnNuevo;
    private javax.swing.JPanel btnNuevo1;
    private javax.swing.JPanel btnNuevo2;
    private javax.swing.JPanel btnNuevo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTable tablaTrab;
    private javax.swing.JTextField txtBuscarTrabajador;
    // End of variables declaration//GEN-END:variables
}
