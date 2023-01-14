
package Vista;

import Controlador.historialController;
import Controlador.usuarioController;
import Modelo.usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class SubmoduloTrabajadorUsuario extends javax.swing.JPanel {
    
    Controlador.usuarioController usuaController = new usuarioController();
    Controlador.historialController histoController = new historialController();
    
    Modelo.usuario usuaModelo = new usuario();

    public SubmoduloTrabajadorUsuario() {
        initComponents();
        titulo();
    }
    
    
    void titulo(){
        if(SubmoduloTrabajador.tipoUsua == 1){
            lblTitulo.setText("");
            lblTitulo.setText("ASIGNAR USUARIO  -  " + SubmoduloTrabajador.nombress.toUpperCase());
        }else if(SubmoduloTrabajador.tipoUsua == 2){
            lblTitulo.setText("");
            lblTitulo.setText("ACTUALIZAR USUARIO " + SubmoduloTrabajador.nombress);
            cargarDatos();
        }
    }
    
    //Cargar DAtos
    void cargarDatos(){
        int idTrab = SubmoduloTrabajador.idTrabajador; 
//        System.out.println("idTrabajador " + idTrab);
        usuaModelo = usuaController.validarUsuarioTrabajador(idTrab);
        
        txtUsuario.setText(""+ usuaModelo.getUsuario_user());
    }
    
     void agregarUsuarioTrabajador(){
        if(txtUsuario.getText().equals("") || txtUsuario.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campos de textos vacios");
        }else{
            String usuario = txtUsuario.getText();
            String pass = txtContrasenia.getText();
            int id = SubmoduloTrabajador.idTrabajador;
            
            if(usuaController.validarDuplicados(usuario) > 0){
                JOptionPane.showMessageDialog(null, "El Usuario ingresado ya existe");
            }else{
                Object[] ob = new Object[4];

                ob[0] = usuario;
                ob[1] = pass;
                ob[2] = 1;
                ob[3] = id;

                int respuesta = usuaController.addUsuario(ob);

                if(respuesta>0){
                    JOptionPane.showMessageDialog(null, "Datos de Usuario ingresados correctamente");
                }
                
                java.util.Date fechaActual = new Date();
                DateFormat fec2 = new SimpleDateFormat("yyyy-MM-dd");
                String fecha2 = fec2.format(fechaActual);
                String histo = "Agregar Usuario";

                Object[] obHisto = new Object[3];

                obHisto[0] = histo;
                obHisto[1] = fecha2;
                obHisto[2] = Login.nombresTrab;

                int respuesta3 = histoController.addHistorial(obHisto);

                if(respuesta3 > 0){
                    System.out.println("Historial Agregado");
                }

                Vista.SubmoduloTrabajador mTrab = new Vista.SubmoduloTrabajador();

                mTrab.setSize(970, 550);
                mTrab.setLocation(0, 0);
                Principal.PanelPrincipal.removeAll();
                Principal.PanelPrincipal.add(mTrab, BorderLayout.CENTER);
                Principal.PanelPrincipal.revalidate();
                Principal.PanelPrincipal.repaint();
            }
        }
    }
    
    void actualizarUsuarioTrabajador(){
        if(txtUsuario.getText().equals("") || txtUsuario.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campos de textos vacios");
        }else{
            String usuario = txtUsuario.getText();
            String pass = txtContrasenia.getText();
            int id = SubmoduloTrabajador.idTrabajador;
            usuaModelo = usuaController.validarUsuarioTrabajador(id);
            
            if(usuario.equalsIgnoreCase(usuaModelo.getUsuario_user())){
//                System.out.println(usuario);
                if(usuaController.validarDuplicados(usuario) > 1){
                    JOptionPane.showMessageDialog(null, "El Usuario ingresado ya existe");
                }else{
                    Object[] ob = new Object[4];

                    ob[0] = usuario;
                    ob[1] = pass;
                    ob[2] = id;

                    int respuesta = usuaController.updateUsuario(ob);

                    if(respuesta>0){
                        JOptionPane.showMessageDialog(null, "Datos de Usuario actualizados correctamente");
                    }
                    
                    java.util.Date fechaActual = new Date();
                    DateFormat fec2 = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha2 = fec2.format(fechaActual);
                    String histo = "Actualizar Usuario";

                    Object[] obHisto = new Object[3];

                    obHisto[0] = histo;
                    obHisto[1] = fecha2;
                    obHisto[2] = Login.nombresTrab;

                    int respuesta3 = histoController.addHistorial(obHisto);

                    if(respuesta3 > 0){
                        System.out.println("Historial Agregado");
                    }

                    Vista.SubmoduloTrabajador mTrab = new Vista.SubmoduloTrabajador();

                    mTrab.setSize(970, 550);
                    mTrab.setLocation(0, 0);
                    Principal.PanelPrincipal.removeAll();
                    Principal.PanelPrincipal.add(mTrab, BorderLayout.CENTER);
                    Principal.PanelPrincipal.revalidate();
                    Principal.PanelPrincipal.repaint();
                }
            }else if(usuaController.validarDuplicados(usuario) > 0){
                JOptionPane.showMessageDialog(null, "El Usuario ingresado ya existe");
            }else{
                Object[] ob = new Object[4];

                ob[0] = usuario;
                ob[1] = pass;
                ob[2] = id;

                int respuesta = usuaController.updateUsuario(ob);

                if(respuesta>0){
                    JOptionPane.showMessageDialog(null, "Datos de Usuario actualizados correctamente");
                }
                
                java.util.Date fechaActual = new Date();
                DateFormat fec2 = new SimpleDateFormat("yyyy-MM-dd");
                String fecha2 = fec2.format(fechaActual);
                String histo = "Actualizar Usuario";

                Object[] obHisto = new Object[3];

                obHisto[0] = histo;
                obHisto[1] = fecha2;
                obHisto[2] = Login.nombresTrab;

                int respuesta3 = histoController.addHistorial(obHisto);

                if(respuesta3 > 0){
                    System.out.println("Historial Agregado");
                }

                Vista.SubmoduloTrabajador mTrab = new Vista.SubmoduloTrabajador();

                mTrab.setSize(970, 550);
                mTrab.setLocation(0, 0);
                Principal.PanelPrincipal.removeAll();
                Principal.PanelPrincipal.add(mTrab, BorderLayout.CENTER);
                Principal.PanelPrincipal.revalidate();
                Principal.PanelPrincipal.repaint();
            }  
            
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JPanel();
        IconRegresar = new javax.swing.JLabel();
        IconRegresarHover = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JPanel();
        IconGuardar = new javax.swing.JLabel();
        IconGuardarHover = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(970, 550));
        setMinimumSize(new java.awt.Dimension(970, 550));
        setPreferredSize(new java.awt.Dimension(970, 550));

        lblTitulo.setFont(new java.awt.Font("SF UI Display", 1, 20)); // NOI18N
        lblTitulo.setText("ASIGNAR USUARIO");

        jLabel7.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel7.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtUsuario.setMaximumSize(new java.awt.Dimension(270, 30));
        txtUsuario.setMinimumSize(new java.awt.Dimension(270, 30));
        txtUsuario.setPreferredSize(new java.awt.Dimension(270, 30));

        jLabel2.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        txtContrasenia.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtContrasenia.setMaximumSize(new java.awt.Dimension(270, 30));
        txtContrasenia.setMinimumSize(new java.awt.Dimension(270, 30));
        txtContrasenia.setPreferredSize(new java.awt.Dimension(270, 30));
        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyTyped(evt);
            }
        });

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

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setMaximumSize(new java.awt.Dimension(115, 42));
        btnRegresar.setMinimumSize(new java.awt.Dimension(115, 42));
        btnRegresar.setName(""); // NOI18N
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegresarMouseExited(evt);
            }
        });

        IconRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnRegresar.png"))); // NOI18N

        IconRegresarHover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconRegresarHover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnRegresarHover.png"))); // NOI18N

        javax.swing.GroupLayout btnRegresarLayout = new javax.swing.GroupLayout(btnRegresar);
        btnRegresar.setLayout(btnRegresarLayout);
        btnRegresarLayout.setHorizontalGroup(
            btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRegresarLayout.createSequentialGroup()
                .addComponent(IconRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnRegresarLayout.createSequentialGroup()
                    .addComponent(IconRegresarHover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnRegresarLayout.setVerticalGroup(
            btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IconRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(IconRegresarHover, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        );

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setMaximumSize(new java.awt.Dimension(115, 42));
        btnGuardar.setMinimumSize(new java.awt.Dimension(115, 42));
        btnGuardar.setName(""); // NOI18N
        btnGuardar.setPreferredSize(new java.awt.Dimension(115, 42));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });

        IconGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnGuardarNew.png"))); // NOI18N

        IconGuardarHover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IconGuardarHover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnGuardarNewHover.png"))); // NOI18N

        javax.swing.GroupLayout btnGuardarLayout = new javax.swing.GroupLayout(btnGuardar);
        btnGuardar.setLayout(btnGuardarLayout);
        btnGuardarLayout.setHorizontalGroup(
            btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGuardarLayout.createSequentialGroup()
                .addComponent(IconGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnGuardarLayout.createSequentialGroup()
                    .addComponent(IconGuardarHover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnGuardarLayout.setVerticalGroup(
            btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IconGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(IconGuardarHover, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitulo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lblTitulo)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(259, 259, 259)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        Vista.SubmoduloTrabajador mTrab = new Vista.SubmoduloTrabajador();

        mTrab.setSize(970, 550);
        mTrab.setLocation(0, 0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mTrab, BorderLayout.CENTER);
        Principal.PanelPrincipal.revalidate();
        Principal.PanelPrincipal.repaint();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        IconRegresar.setVisible(false);
        IconRegresarHover.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseEntered

    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        IconRegresar.setVisible(true);
        IconRegresarHover.setVisible(false);
    }//GEN-LAST:event_btnRegresarMouseExited

    private void txtContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyTyped
        
    }//GEN-LAST:event_txtContraseniaKeyTyped

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

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if(SubmoduloTrabajador.tipoUsua==1){
            agregarUsuarioTrabajador();
        }else if(SubmoduloTrabajador.tipoUsua==2){
            actualizarUsuarioTrabajador();
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        IconGuardar.setVisible(false);
        IconGuardarHover.setVisible(true);
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        IconGuardar.setVisible(true);
        IconGuardarHover.setVisible(false);
    }//GEN-LAST:event_btnGuardarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconGuardar;
    private javax.swing.JLabel IconGuardarHover;
    private javax.swing.JLabel IconRegresar;
    private javax.swing.JLabel IconRegresarHover;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
