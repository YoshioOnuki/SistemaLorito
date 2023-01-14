
package Vista;

import Controlador.detalleController;
import Controlador.historialController;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class SubmoduloReporteCambios extends javax.swing.JPanel {
    
    DefaultTableModel m = new DefaultTableModel();
    Controlador.historialController historialController = new historialController();

    public SubmoduloReporteCambios() {
        initComponents();
        placeholders();
        buscarCambios();
    }
    
    
    void placeholders(){
        Textp txte = new Textp("Buscar", txtBuscarCambios);
    }
    
    void buscarCambios(){
        try {
            m = historialController.consultarCambios(txtBuscarCambios.getText());
            tablaHistorialCambios.setModel(m);
            
            //"ID","DESCRIPCION","FECHA","TRABAJADOR"
            
            TableColumn t1 = tablaHistorialCambios.getColumn("ID");
            t1.setPreferredWidth(50);
            t1.setMaxWidth(50);
            t1.setMinWidth(50);
            
            TableColumn t2 = tablaHistorialCambios.getColumn("DESCRIPCION");
            t2.setPreferredWidth(330);
            t2.setMaxWidth(330);
            t2.setMinWidth(330);
            
            TableColumn t3 = tablaHistorialCambios.getColumn("FECHA");
            t3.setPreferredWidth(150);
            t3.setMaxWidth(150);
            t3.setMinWidth(150);
            
            TableColumn t4 = tablaHistorialCambios.getColumn("TRABAJADOR");
            t4.setPreferredWidth(300);
            t4.setMaxWidth(300);
            t4.setMinWidth(300);
            
            tablaHistorialCambios.setRowHeight(25);
        } catch (Exception e) {
            System.out.println("Error al listar Salidas: " + e);
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
        txtBuscarCambios = new javax.swing.JTextField();
        Tabla = new javax.swing.JScrollPane();
        tablaHistorialCambios = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(970, 550));
        setMinimumSize(new java.awt.Dimension(970, 550));
        setName(""); // NOI18N

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
        jLabel1.setText("HISTORIAL DE CAMBIOS");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(190, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(190, 50));

        txtBuscarCambios.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscarCambios.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtBuscarCambios.setBorder(null);
        txtBuscarCambios.setMaximumSize(new java.awt.Dimension(120, 18));
        txtBuscarCambios.setMinimumSize(new java.awt.Dimension(120, 18));
        txtBuscarCambios.setPreferredSize(new java.awt.Dimension(120, 18));
        txtBuscarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCambiosActionPerformed(evt);
            }
        });
        txtBuscarCambios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCambiosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtBuscarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabla.setMaximumSize(new java.awt.Dimension(830, 315));
        Tabla.setMinimumSize(new java.awt.Dimension(830, 315));
        Tabla.setPreferredSize(new java.awt.Dimension(830, 315));

        tablaHistorialCambios.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        tablaHistorialCambios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla.setViewportView(tablaHistorialCambios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
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

    private void txtBuscarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCambiosActionPerformed

    }//GEN-LAST:event_txtBuscarCambiosActionPerformed

    private void txtBuscarCambiosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCambiosKeyTyped
        buscarCambios();
    }//GEN-LAST:event_txtBuscarCambiosKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Tabla;
    private javax.swing.JPanel btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTable tablaHistorialCambios;
    private javax.swing.JTextField txtBuscarCambios;
    // End of variables declaration//GEN-END:variables
}
