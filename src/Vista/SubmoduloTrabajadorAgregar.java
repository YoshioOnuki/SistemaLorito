
package Vista;

import Controlador.historialController;
import Controlador.rolController;
import Controlador.trabajadorController;
import Controlador.usuarioController;
import Modelo.rol;
import Modelo.trabajador;
import Modelo.usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class SubmoduloTrabajadorAgregar extends javax.swing.JPanel {
    
    Controlador.trabajadorController trabController= new trabajadorController();
    Controlador.rolController rolController= new rolController();
    Controlador.historialController histoController= new historialController();
    
    Modelo.trabajador trabModelo = new trabajador();
    Modelo.rol rolModelo = new rol();

    public SubmoduloTrabajadorAgregar() {
        initComponents();
        cargarCboRol();
        titulo();
    }
    
    
    void cargarCboRol(){
        rolController.cargarComboRol(cboRol);
    }
    
    void titulo(){
        if(SubmoduloTrabajador.tipoCRUD == 1){
            lblTitulo.setText("");
            lblTitulo.setText("AGREGAR TRABAJADOR");
            genCOD();
        }else if(SubmoduloTrabajador.tipoCRUD == 2){
            lblTitulo.setText("");
            lblTitulo.setText("ACTUALIZAR TRABAJADOR");
            cargarDatosActualizar();
        }
    }

    void genCOD(){
        int id = trabController.ultimoIdTrabajador();
        txtID.setText("" + (id+1));
    }
    
    //Cargar DAtos
    void cargarDatosActualizar(){
        int idTrab = SubmoduloTrabajador.idTrabajador; 
//        System.out.println("idTrabajador " + idTrab);
        trabModelo = trabController.validarTrabajador(idTrab);
        
        txtID.setText(""+ trabModelo.getTrabajadorID());
        txtDni.setText(""+ trabModelo.getTrabajador_DNI());
        txtNombres.setText(trabModelo.getTrabajadorNombres());
        txtDireccion.setText(trabModelo.getTrabajadorDireccion());
        rolModelo = rolController.validarRol(trabModelo.getRolID());
        cboRol.setSelectedItem(rolModelo.getRolDescripcion());
    }
    
    void agregarTrabajador(){
        if(txtDni.getText().equals("") || txtNombres.getText().equals("") ||txtDireccion.getText().equals("") || cboRol.getSelectedIndex()==0 ){
            JOptionPane.showMessageDialog(null, "Campos requeridos vacios");
            txtDni.requestFocus();
        }else{
            
            String dni = txtDni.getText();
            String nom = txtNombres.getText();
            String direc = txtDireccion.getText();
            int rol = rolController.idRol(cboRol.getSelectedItem().toString());
            
            if(trabController.validarDuplicados(dni) > 0){
                JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe");
            }else{
                Object[] ob = new Object[4];

                ob[0] = dni;
                ob[1] = nom;
                ob[2] = direc;
                ob[3] = rol;

                int respuesta = trabController.addTrabajador(ob);

                if(respuesta>0){
                    JOptionPane.showMessageDialog(null, "Datos del trabajador ingresados correctamente");
                }
                
                java.util.Date fechaActual = new Date();
                DateFormat fec2 = new SimpleDateFormat("yyyy-MM-dd");
                String fecha2 = fec2.format(fechaActual);
                String histo = "Agregar trabajador";

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
    
    void actualizarTrabajador(){
        if(txtDni.getText().equals("") || txtNombres.getText().equals("") ||txtDireccion.getText().equals("") || cboRol.getSelectedIndex()==0 ){
            JOptionPane.showMessageDialog(null, "Campos de textos vacios");
            txtDni.requestFocus();
        }else{
            
            int id = Integer.parseInt(txtID.getText());
            String dni = txtDni.getText();
            String nom = txtNombres.getText();
            String direc = txtDireccion.getText();
            int rol = rolController.idRol(cboRol.getSelectedItem().toString());
            trabModelo = trabController.validarTrabajador(id);
            
            if(dni.equalsIgnoreCase(trabModelo.getTrabajador_DNI())){
//                System.out.println(dni);
                if(trabController.validarDuplicados(dni) > 1){
                    JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe");
                }else{
                    Object[] ob = new Object[5];
                    ob[0] = dni;
                    ob[1] = nom;
                    ob[2] = direc;
                    ob[3] = rol;
                    ob[4] = id;

                    int respuesta = trabController.updateTrabajador(ob);

                    if(respuesta>0){
                        JOptionPane.showMessageDialog(null, "Datos del trabajador actualizadoos correctamente");
                    }
                    
                    java.util.Date fechaActual = new Date();
                    DateFormat fec2 = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha2 = fec2.format(fechaActual);
                    String histo = "Actualizar trabajador";

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
            }else if(trabController.validarDuplicados(dni) > 0){
                JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe");
            }else{
                Object[] ob = new Object[5];
                ob[0] = dni;
                ob[1] = nom;
                ob[2] = direc;
                ob[3] = rol;
                ob[4] = id;

                int respuesta = trabController.updateTrabajador(ob);

                if(respuesta>0){
                    JOptionPane.showMessageDialog(null, "Datos del trabajador actualizadoos correctamente");
                }
                
                java.util.Date fechaActual = new Date();
                DateFormat fec2 = new SimpleDateFormat("yyyy-MM-dd");
                String fecha2 = fec2.format(fechaActual);
                String histo = "Actualizar trabajador";

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

        jPanel6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JPanel();
        IconRegresar = new javax.swing.JLabel();
        IconRegresarHover = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboRol = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JPanel();
        IconGuardar = new javax.swing.JLabel();
        IconGuardarHover = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(970, 550));
        setMinimumSize(new java.awt.Dimension(970, 550));
        setPreferredSize(new java.awt.Dimension(970, 550));

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
        lblTitulo.setText("AGREGAR TRABAJADOR");

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setMaximumSize(new java.awt.Dimension(115, 42));
        btnRegresar.setMinimumSize(new java.awt.Dimension(115, 42));
        btnRegresar.setName(""); // NOI18N
        btnRegresar.setPreferredSize(new java.awt.Dimension(115, 42));
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

        jLabel2.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        txtDni.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtDni.setMaximumSize(new java.awt.Dimension(270, 30));
        txtDni.setMinimumSize(new java.awt.Dimension(270, 30));
        txtDni.setPreferredSize(new java.awt.Dimension(270, 30));
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        txtNombres.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtNombres.setMaximumSize(new java.awt.Dimension(270, 30));
        txtNombres.setMinimumSize(new java.awt.Dimension(270, 30));
        txtNombres.setPreferredSize(new java.awt.Dimension(270, 30));

        jLabel4.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel4.setText("Dirección:");

        txtDireccion.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtDireccion.setMaximumSize(new java.awt.Dimension(270, 30));
        txtDireccion.setMinimumSize(new java.awt.Dimension(270, 30));
        txtDireccion.setPreferredSize(new java.awt.Dimension(270, 30));

        jLabel5.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel5.setText("Rol:");

        cboRol.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        cboRol.setMaximumSize(new java.awt.Dimension(270, 30));
        cboRol.setMinimumSize(new java.awt.Dimension(270, 30));
        cboRol.setPreferredSize(new java.awt.Dimension(270, 30));

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

        jLabel7.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel7.setText("ID:");

        txtID.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtID.setEnabled(false);
        txtID.setMaximumSize(new java.awt.Dimension(270, 30));
        txtID.setMinimumSize(new java.awt.Dimension(270, 30));
        txtID.setPreferredSize(new java.awt.Dimension(270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(44, 44, 44)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(123, Short.MAX_VALUE))))
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
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
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

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if(SubmoduloTrabajador.tipoCRUD==1){
            agregarTrabajador();
        }else if(SubmoduloTrabajador.tipoCRUD==2){
            actualizarTrabajador();
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

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            evt.consume();
        }
        if(txtDni.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconGuardar;
    private javax.swing.JLabel IconGuardarHover;
    private javax.swing.JLabel IconRegresar;
    private javax.swing.JLabel IconRegresarHover;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JComboBox<String> cboRol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
