
package Vista;

import Controlador.inventarioController;
import Modelo.inventario;
import static Vista.SubmoduloTrabajador.idTrabajador;
import static Vista.SubmoduloTrabajador.nombress;
import static Vista.SubmoduloTrabajador.tipoCRUD;
import static Vista.SubmoduloTrabajador.tipoUsua;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class SubmoduloReporteInventario extends javax.swing.JPanel {
    
    DefaultTableModel m = new DefaultTableModel();
    
    Controlador.inventarioController inveController = new inventarioController();
    
    Modelo.inventario inveModelo = new inventario();
    
    public static int tipoCRUD, idInven;

    
    public SubmoduloReporteInventario() {
        initComponents();
        placeholders();
        buscarInventario();
    }

    void placeholders(){
        Textp txte = new Textp("Buscar", txtBuscarInventario);
        titulo();
    }
    
    void titulo(){
        if(Login.tipoRol.equalsIgnoreCase("Administrador")){
            lblTitulo.setText("");
            lblTitulo.setText("REPORTE DE INVENTARIO");
            btnNuevo.setVisible(false);
            IconNuevo.setVisible(false);
            IconNuevoHover.setVisible(false);
        }else if(Login.tipoRol.equalsIgnoreCase("Trabajador")){
            lblTitulo.setText("");
            lblTitulo.setText("INVENTARIO");
            btnNuevo.setVisible(true);
            IconNuevo.setVisible(true);
            IconNuevoHover.setVisible(true);
        }
    }
    
    void buscarInventario(){
        try {
            m = inveController.consultarInventario(txtBuscarInventario.getText());
            tablaInven.setModel(m);
            
            TableColumn t1 = tablaInven.getColumn("ID");
            t1.setPreferredWidth(50);
            t1.setMaxWidth(50);
            t1.setMinWidth(50);
            
            TableColumn t2 = tablaInven.getColumn("DESCRIPCION");
            t2.setPreferredWidth(180);
            t2.setMaxWidth(180);
            t2.setMinWidth(180);
            
            TableColumn t3 = tablaInven.getColumn("TIPO");
            t3.setPreferredWidth(150);
            t3.setMaxWidth(150);
            t3.setMinWidth(150);
            
            TableColumn t4 = tablaInven.getColumn("PRECIO COMPRA");
            t4.setPreferredWidth(100);
            t4.setMaxWidth(100);
            t4.setMinWidth(100);
            
            TableColumn t5 = tablaInven.getColumn("PRECIO VENTA");
            t5.setPreferredWidth(100);
            t5.setMaxWidth(100);
            t5.setMinWidth(100);
            
            TableColumn t6 = tablaInven.getColumn("CANTIDAD");
            t6.setPreferredWidth(100);
            t6.setMaxWidth(100);
            t6.setMinWidth(100);
            
            TableColumn t7 = tablaInven.getColumn("FECHA REGISTRO");
            t7.setPreferredWidth(150);
            t7.setMaxWidth(150);
            t7.setMinWidth(150);
            
            tablaInven.setRowHeight(25);
        } catch (Exception e) {
            System.out.println("Error al listar Inventario: " + e);
        }
    }
    
    void opcInventario(int opc){
        int fila = tablaInven.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{            
            if(opc == 1){
                inveModelo = inveController.validarInventario(Integer.parseInt(tablaInven.getValueAt(fila, 0).toString()));
                idInven = inveModelo.getInventario_id();
                System.out.println(idInven);
                tipoCRUD = 2;
                
                Vista.SubmoduloInventarioAgregar mInvenAgr = new Vista.SubmoduloInventarioAgregar();

                mInvenAgr.setSize(970, 550);
                mInvenAgr.setLocation(0, 0);
                Principal.PanelPrincipal.removeAll();
                Principal.PanelPrincipal.add(mInvenAgr, BorderLayout.CENTER);
                Principal.PanelPrincipal.revalidate();
                Principal.PanelPrincipal.repaint();
            }else if(opc == 2){
                inveModelo = inveController.validarInventario(Integer.parseInt(tablaInven.getValueAt(fila, 0).toString()));
                idInven = inveModelo.getInventario_id();
                System.out.println(idInven);
                int estado = 0;

                System.out.println(idInven);
                int respuesta = inveController.cambiarEstadoInventario(idInven, estado);
                
                if(respuesta > 0){
                    JOptionPane.showMessageDialog(null, "Inventario seleccionado fue eliminado");
                }
                buscarInventario();
            }
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuInventario = new javax.swing.JPopupMenu();
        actualizar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        jPanel6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarInventario = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JPanel();
        IconNuevo = new javax.swing.JLabel();
        IconNuevoHover = new javax.swing.JLabel();
        Tabla = new javax.swing.JScrollPane();
        tablaInven = new javax.swing.JTable();

        actualizar.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        menuInventario.add(actualizar);

        eliminar.setFont(new java.awt.Font("SF UI Display", 1, 14)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        menuInventario.add(eliminar);

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
        lblTitulo.setText("INVENTARIO");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(190, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(190, 50));

        txtBuscarInventario.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscarInventario.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtBuscarInventario.setBorder(null);
        txtBuscarInventario.setMaximumSize(new java.awt.Dimension(120, 18));
        txtBuscarInventario.setMinimumSize(new java.awt.Dimension(120, 18));
        txtBuscarInventario.setPreferredSize(new java.awt.Dimension(120, 18));
        txtBuscarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarInventarioActionPerformed(evt);
            }
        });
        txtBuscarInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarInventarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setMaximumSize(new java.awt.Dimension(110, 42));
        btnNuevo.setMinimumSize(new java.awt.Dimension(110, 42));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoMouseExited(evt);
            }
        });

        IconNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnNuevo.png"))); // NOI18N

        IconNuevoHover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconNuevoHover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnNuevoHover.png"))); // NOI18N

        javax.swing.GroupLayout btnNuevoLayout = new javax.swing.GroupLayout(btnNuevo);
        btnNuevo.setLayout(btnNuevoLayout);
        btnNuevoLayout.setHorizontalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IconNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(IconNuevoHover, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
        );
        btnNuevoLayout.setVerticalGroup(
            btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(IconNuevo))
            .addGroup(btnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNuevoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(IconNuevoHover)))
        );

        Tabla.setMaximumSize(new java.awt.Dimension(830, 315));
        Tabla.setMinimumSize(new java.awt.Dimension(830, 315));
        Tabla.setPreferredSize(new java.awt.Dimension(830, 315));

        tablaInven.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        tablaInven.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaInven.setComponentPopupMenu(menuInventario);
        Tabla.setViewportView(tablaInven);

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
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txtBuscarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarInventarioActionPerformed

    }//GEN-LAST:event_txtBuscarInventarioActionPerformed

    private void txtBuscarInventarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarInventarioKeyTyped
        buscarInventario();
    }//GEN-LAST:event_txtBuscarInventarioKeyTyped

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        tipoCRUD = 1;
        
        Vista.SubmoduloInventarioAgregar mInventarioAgre = new SubmoduloInventarioAgregar();
        
        mInventarioAgre.setSize(970, 550);
        mInventarioAgre.setLocation(0, 0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mInventarioAgre, BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseEntered
        IconNuevo.setVisible(false);
        IconNuevoHover.setVisible(true);
    }//GEN-LAST:event_btnNuevoMouseEntered

    private void btnNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseExited
        IconNuevo.setVisible(true);
        IconNuevoHover.setVisible(false);
    }//GEN-LAST:event_btnNuevoMouseExited

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        opcInventario(1);
    }//GEN-LAST:event_actualizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        opcInventario(2);
    }//GEN-LAST:event_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconNuevo;
    private javax.swing.JLabel IconNuevoHover;
    private javax.swing.JScrollPane Tabla;
    private javax.swing.JMenuItem actualizar;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnNuevo;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPopupMenu menuInventario;
    private javax.swing.JTable tablaInven;
    private javax.swing.JTextField txtBuscarInventario;
    // End of variables declaration//GEN-END:variables
}
