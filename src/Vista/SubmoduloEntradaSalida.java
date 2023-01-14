
package Vista;

import Controlador.detalleController;
import Controlador.inventarioController;
import Modelo.detalle_inventario;
import Modelo.inventario;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class SubmoduloEntradaSalida extends javax.swing.JPanel {
    
    Modelo.inventario inveModelo = new inventario();
    Modelo.detalle_inventario detalleModelo = new detalle_inventario();
    
    Controlador.detalleController detalleController = new detalleController();
    Controlador.inventarioController inveController = new inventarioController();
    
    DefaultTableModel m = new DefaultTableModel();
    public static int tipoMovimiento, idInven, idTrabajador = Login.idtraba;

    public SubmoduloEntradaSalida() {
        initComponents();
        placeholders();
        buscarEntradaSalida();
    }

    
    void placeholders(){
        Textp txte = new Textp("Buscar", txtBuscarEntradaSalida);
    }
    
    void entradaSalida(int opc){
        if(opc == 1){
            tipoMovimiento = 1;
            SubmoduloEntradaSalidaAgregar mAgre = new SubmoduloEntradaSalidaAgregar();

            mAgre.setSize(970, 550);
            mAgre.setLocation(0, 0);
            Principal.PanelPrincipal.removeAll();
            Principal.PanelPrincipal.add(mAgre, BorderLayout.CENTER);
            Principal.PanelPrincipal.revalidate();
            Principal.PanelPrincipal.repaint();
        }else if(opc == 2){
            tipoMovimiento = 2;
            SubmoduloEntradaSalidaAgregar mAgre = new SubmoduloEntradaSalidaAgregar();

            mAgre.setSize(970, 550);
            mAgre.setLocation(0, 0);
            Principal.PanelPrincipal.removeAll();
            Principal.PanelPrincipal.add(mAgre, BorderLayout.CENTER);
            Principal.PanelPrincipal.revalidate();
            Principal.PanelPrincipal.repaint();
        }
    }
    
     void buscarEntradaSalida(){
        try {
            m = detalleController.consultarEntradaSalida2(txtBuscarEntradaSalida.getText());
            tablaEntradaSalida.setModel(m);
            
            //"ID", "PRODUCTO","ENTRADA/SALIDA","FECHA","TRABAJADOR","MOVIMIENTO"
            
            TableColumn t1 = tablaEntradaSalida.getColumn("ID");
            t1.setPreferredWidth(50);
            t1.setMaxWidth(50);
            t1.setMinWidth(50);
            
            TableColumn t3 = tablaEntradaSalida.getColumn("PRODUCTO");
            t3.setPreferredWidth(170);
            t3.setMaxWidth(170);
            t3.setMinWidth(170);
            
            TableColumn t4 = tablaEntradaSalida.getColumn("ENTRADA/SALIDA");
            t4.setPreferredWidth(110);
            t4.setMaxWidth(110);
            t4.setMinWidth(110);
            
            TableColumn t5 = tablaEntradaSalida.getColumn("FECHA");
            t5.setPreferredWidth(100);
            t5.setMaxWidth(100);
            t5.setMinWidth(100);
            
            TableColumn t6 = tablaEntradaSalida.getColumn("TRABAJADOR");
            t6.setPreferredWidth(300);
            t6.setMaxWidth(300);
            t6.setMinWidth(300);
            
            TableColumn t7 = tablaEntradaSalida.getColumn("MOVIMIENTO");
            t7.setPreferredWidth(90);
            t7.setMaxWidth(90);
            t7.setMinWidth(90);
            
            tablaEntradaSalida.setRowHeight(25);
        } catch (Exception e) {
            System.out.println("Error al listar Entradas y Salidas: " + e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnEntrada = new javax.swing.JPanel();
        IconEntrada = new javax.swing.JLabel();
        IconEntradaHover = new javax.swing.JLabel();
        btnSalida = new javax.swing.JPanel();
        IconSalida = new javax.swing.JLabel();
        IconSalidaHover = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarEntradaSalida = new javax.swing.JTextField();
        Tabla = new javax.swing.JScrollPane();
        tablaEntradaSalida = new javax.swing.JTable();

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

        lblTitulo.setFont(new java.awt.Font("SF UI Display", 1, 20)); // NOI18N
        lblTitulo.setText("ENTRADAS Y SALIDAS");

        btnEntrada.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrada.setMaximumSize(new java.awt.Dimension(121, 42));
        btnEntrada.setMinimumSize(new java.awt.Dimension(121, 42));
        btnEntrada.setPreferredSize(new java.awt.Dimension(121, 42));
        btnEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntradaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntradaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntradaMouseExited(evt);
            }
        });

        IconEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnEntrada.png"))); // NOI18N

        IconEntradaHover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconEntradaHover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnEntradaHover.png"))); // NOI18N

        javax.swing.GroupLayout btnEntradaLayout = new javax.swing.GroupLayout(btnEntrada);
        btnEntrada.setLayout(btnEntradaLayout);
        btnEntradaLayout.setHorizontalGroup(
            btnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IconEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(IconEntradaHover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnEntradaLayout.setVerticalGroup(
            btnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntradaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(IconEntrada))
            .addGroup(btnEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntradaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(IconEntradaHover)))
        );

        btnSalida.setBackground(new java.awt.Color(255, 255, 255));
        btnSalida.setMaximumSize(new java.awt.Dimension(121, 42));
        btnSalida.setMinimumSize(new java.awt.Dimension(121, 42));
        btnSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalidaMouseExited(evt);
            }
        });

        IconSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnSalida.png"))); // NOI18N

        IconSalidaHover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconSalidaHover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnSalidaHover.png"))); // NOI18N

        javax.swing.GroupLayout btnSalidaLayout = new javax.swing.GroupLayout(btnSalida);
        btnSalida.setLayout(btnSalidaLayout);
        btnSalidaLayout.setHorizontalGroup(
            btnSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IconSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(IconSalidaHover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSalidaLayout.setVerticalGroup(
            btnSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalidaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(IconSalida))
            .addGroup(btnSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalidaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(IconSalidaHover)))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(190, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(190, 50));

        txtBuscarEntradaSalida.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscarEntradaSalida.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtBuscarEntradaSalida.setBorder(null);
        txtBuscarEntradaSalida.setMaximumSize(new java.awt.Dimension(120, 18));
        txtBuscarEntradaSalida.setMinimumSize(new java.awt.Dimension(120, 18));
        txtBuscarEntradaSalida.setPreferredSize(new java.awt.Dimension(120, 18));
        txtBuscarEntradaSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEntradaSalidaActionPerformed(evt);
            }
        });
        txtBuscarEntradaSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarEntradaSalidaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtBuscarEntradaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarEntradaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabla.setMaximumSize(new java.awt.Dimension(830, 315));
        Tabla.setMinimumSize(new java.awt.Dimension(830, 315));
        Tabla.setPreferredSize(new java.awt.Dimension(830, 315));

        tablaEntradaSalida.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        tablaEntradaSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla.setViewportView(tablaEntradaSalida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txtBuscarEntradaSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEntradaSalidaActionPerformed
        
    }//GEN-LAST:event_txtBuscarEntradaSalidaActionPerformed

    private void txtBuscarEntradaSalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEntradaSalidaKeyTyped
        buscarEntradaSalida();
    }//GEN-LAST:event_txtBuscarEntradaSalidaKeyTyped

    private void btnEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaMouseClicked
        entradaSalida(1);
    }//GEN-LAST:event_btnEntradaMouseClicked

    private void btnEntradaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaMouseEntered
        IconEntrada.setVisible(false);
        IconEntradaHover.setVisible(true);
    }//GEN-LAST:event_btnEntradaMouseEntered

    private void btnEntradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaMouseExited
        IconEntrada.setVisible(true);
        IconEntradaHover.setVisible(false);
    }//GEN-LAST:event_btnEntradaMouseExited

    private void btnSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseClicked
        entradaSalida(2);
    }//GEN-LAST:event_btnSalidaMouseClicked

    private void btnSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseEntered
        IconSalida.setVisible(false);
        IconSalidaHover.setVisible(true);
    }//GEN-LAST:event_btnSalidaMouseEntered

    private void btnSalidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseExited
        IconSalida.setVisible(true);
        IconSalidaHover.setVisible(false);
    }//GEN-LAST:event_btnSalidaMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconEntrada;
    private javax.swing.JLabel IconEntradaHover;
    private javax.swing.JLabel IconSalida;
    private javax.swing.JLabel IconSalidaHover;
    private javax.swing.JScrollPane Tabla;
    private javax.swing.JPanel btnEntrada;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnSalida;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaEntradaSalida;
    private javax.swing.JTextField txtBuscarEntradaSalida;
    // End of variables declaration//GEN-END:variables
}
