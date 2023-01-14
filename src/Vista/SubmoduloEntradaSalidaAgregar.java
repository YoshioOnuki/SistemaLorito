
package Vista;

import Controlador.detalleController;
import Controlador.inventarioController;
import Modelo.detalle_inventario;
import Modelo.inventario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class SubmoduloEntradaSalidaAgregar extends javax.swing.JPanel {

    Modelo.inventario inveModelo = new inventario();
    Modelo.detalle_inventario detalleModelo = new detalle_inventario();
    
    Controlador.inventarioController inveController = new inventarioController();
    Controlador.detalleController detalleController = new detalleController();
    
   
    public SubmoduloEntradaSalidaAgregar() {
        initComponents();
        titulo();
        cargarCboInven();
    }
    
    void cargarCboInven(){
        inveController.cargarComboInven(cboProducto);
    }
    
    
    void titulo(){
        if(SubmoduloEntradaSalida.tipoMovimiento == 1){
            lblTitulo.setText("");
            lblTitulo.setText("ENTRADA DE INVENTARIO");
        }else if(SubmoduloEntradaSalida.tipoMovimiento == 2){
            lblTitulo.setText("");
            lblTitulo.setText("SALIDA DE INVENTARIO");
        }
    }

    private void cargarDatos() {
        inveModelo = inveController.validarInventarioPorNombre(cboProducto.getSelectedItem().toString());
        
        txtNombre.setEnabled(false);
        txtCantidad.setEnabled(false);
        
        txtNombre.setText(inveModelo.getInventario_nombre());
        txtCantidad.setText(""+inveModelo.getInventario_cantidad());
    }
    
    void buscarProducto(){
        if(cboProducto.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Seleccione un producto");            
        }else{
            txtCant.setEnabled(true);
            cargarDatos();
            cboProducto.setEnabled(false);
        }
    }
    
    void limpiar(){
        txtNombre.setText("");
        txtCantidad.setText("");
        cboProducto.setEnabled(true);
        cboProducto.setSelectedIndex(0);
        txtCant.setEnabled(false);
        txtCant.setText("");
    }
    
    void guardarEntradaSalida(int opc){
        if(txtCant.isEnabled() == false || txtCant.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos requeridos vacios");
        }else{
            if(opc == 1){
                String desc = "Entrada";
                java.util.Date fecha1 = new Date();
                DateFormat fec = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = fec.format(fecha1);
                System.out.println(fecha);
                int cant = Integer.parseInt(txtCant.getText());
                int idtrabajador = Login.idtraba;
                inveModelo = inveController.validarInventarioPorNombre(txtNombre.getText());
                int idInventario = inveModelo.getInventario_id();
                
                Object[] ob = new Object[5];

                ob[0] = desc;
                ob[1] = fecha;
                ob[2] = cant;
                ob[3] = idtrabajador;
                ob[4] = idInventario;
                
                int cantidadModificada = inveModelo.getInventario_cantidad() + cant;

                int respuesta1 = detalleController.addDetalleInventario(ob);
                int respuesta2 = inveController.updateCantidadInventario(idInventario, cantidadModificada);

                if(respuesta1 > 0 && respuesta2 > 0){
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                }
                
                Vista.SubmoduloEntradaSalida mEntradaSalida = new Vista.SubmoduloEntradaSalida();

                mEntradaSalida.setSize(970, 550);
                mEntradaSalida.setLocation(0, 0);
                Principal.PanelPrincipal.removeAll();
                Principal.PanelPrincipal.add(mEntradaSalida, BorderLayout.CENTER);
                Principal.PanelPrincipal.revalidate();
                Principal.PanelPrincipal.repaint();
                
            }else if(opc == 2){
                String desc = "Salida";
                java.util.Date fecha1 = new Date();
                DateFormat fec = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = fec.format(fecha1);
                System.out.println(fecha);
                int cant = Integer.parseInt(txtCant.getText());
                int idtrabajador = Login.idtraba;
                inveModelo = inveController.validarInventarioPorNombre(txtNombre.getText());
                int idInventario = inveModelo.getInventario_id();
                
                if(inveModelo.getInventario_cantidad() < cant){
                    JOptionPane.showMessageDialog(null, "Cantidad de Salida no puede ser procesada");
                }else{
                    Object[] ob = new Object[5];

                    ob[0] = desc;
                    ob[1] = fecha;
                    ob[2] = cant;
                    ob[3] = idtrabajador;
                    ob[4] = idInventario;

                    int cantidadModificada = inveModelo.getInventario_cantidad() - cant;

                    int respuesta1 = detalleController.addDetalleInventario(ob);
                    int respuesta2 = inveController.updateCantidadInventario(idInventario, cantidadModificada);

                    if(respuesta1 > 0 && respuesta2 > 0){
                        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    } 
                    
                    Vista.SubmoduloEntradaSalida mEntradaSalida = new Vista.SubmoduloEntradaSalida();

                    mEntradaSalida.setSize(970, 550);
                    mEntradaSalida.setLocation(0, 0);
                    Principal.PanelPrincipal.removeAll();
                    Principal.PanelPrincipal.add(mEntradaSalida, BorderLayout.CENTER);
                    Principal.PanelPrincipal.revalidate();
                    Principal.PanelPrincipal.repaint();
                }
                
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
        jLabel3 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JPanel();
        IconRegresar = new javax.swing.JLabel();
        IconRegresarHover = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JPanel();
        IconGuardar = new javax.swing.JLabel();
        IconGuardarHover = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JPanel();
        lbBuscar = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JPanel();
        lbLimpiar = new javax.swing.JLabel();

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
        lblTitulo.setText("ENTRADA DE INVENTARIO");

        jLabel3.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad de entrada:");

        txtCant.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtCant.setEnabled(false);
        txtCant.setMaximumSize(new java.awt.Dimension(220, 30));
        txtCant.setMinimumSize(new java.awt.Dimension(220, 30));
        txtCant.setPreferredSize(new java.awt.Dimension(220, 30));
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        txtCantidad.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtCantidad.setEnabled(false);
        txtCantidad.setMaximumSize(new java.awt.Dimension(220, 30));
        txtCantidad.setMinimumSize(new java.awt.Dimension(220, 30));
        txtCantidad.setPreferredSize(new java.awt.Dimension(220, 30));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel7.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtNombre.setEnabled(false);
        txtNombre.setMaximumSize(new java.awt.Dimension(220, 30));
        txtNombre.setMinimumSize(new java.awt.Dimension(220, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(220, 30));

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

        jLabel8.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel8.setText("Buscar Producto:");

        cboProducto.setMaximumSize(new java.awt.Dimension(220, 30));
        cboProducto.setMinimumSize(new java.awt.Dimension(220, 30));
        cboProducto.setPreferredSize(new java.awt.Dimension(220, 30));

        btnBuscar.setBackground(new java.awt.Color(51, 71, 86));
        btnBuscar.setMaximumSize(new java.awt.Dimension(30, 29));
        btnBuscar.setMinimumSize(new java.awt.Dimension(30, 29));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });

        lbBuscar.setFont(new java.awt.Font("SF UI Display", 1, 18)); // NOI18N
        lbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        lbBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Iconlupa.png"))); // NOI18N
        lbBuscar.setText("Buscar ");
        lbBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lbBuscar.setMaximumSize(new java.awt.Dimension(30, 29));
        lbBuscar.setMinimumSize(new java.awt.Dimension(30, 29));
        lbBuscar.setPreferredSize(new java.awt.Dimension(30, 29));

        javax.swing.GroupLayout btnBuscarLayout = new javax.swing.GroupLayout(btnBuscar);
        btnBuscar.setLayout(btnBuscarLayout);
        btnBuscarLayout.setHorizontalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnBuscarLayout.setVerticalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        btnLimpiar.setBackground(new java.awt.Color(228, 65, 65));
        btnLimpiar.setMaximumSize(new java.awt.Dimension(30, 29));
        btnLimpiar.setMinimumSize(new java.awt.Dimension(30, 29));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });

        lbLimpiar.setFont(new java.awt.Font("SF UI Display", 1, 18)); // NOI18N
        lbLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        lbLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconBorrar.png"))); // NOI18N
        lbLimpiar.setText("Limpiar ");
        lbLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lbLimpiar.setMaximumSize(new java.awt.Dimension(30, 29));
        lbLimpiar.setMinimumSize(new java.awt.Dimension(30, 29));
        lbLimpiar.setPreferredSize(new java.awt.Dimension(30, 29));

        javax.swing.GroupLayout btnLimpiarLayout = new javax.swing.GroupLayout(btnLimpiar);
        btnLimpiar.setLayout(btnLimpiarLayout);
        btnLimpiarLayout.setHorizontalGroup(
            btnLimpiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnLimpiarLayout.setVerticalGroup(
            btnLimpiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitulo)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(90, 90, 90))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(39, 39, 39)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lblTitulo)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        Vista.SubmoduloReporteInventario mInventario = new Vista.SubmoduloReporteInventario();

        mInventario.setSize(970, 550);
        mInventario.setLocation(0, 0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mInventario, BorderLayout.CENTER);
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
        Vista.SubmoduloEntradaSalida mMovimientos = new Vista.SubmoduloEntradaSalida();

        mMovimientos.setSize(970, 550);
        mMovimientos.setLocation(0, 0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mMovimientos, BorderLayout.CENTER);
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

    private void txtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            evt.consume();
        }
        if(txtCant.getText().length() >= 11){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            evt.consume();
        }
        if(txtCantidad.getText().length() >= 11){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if(SubmoduloEntradaSalida.tipoMovimiento==1){
            guardarEntradaSalida(1);
        }else if(SubmoduloEntradaSalida.tipoMovimiento==2){
            guardarEntradaSalida(2);
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

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        buscarProducto();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        btnBuscar.setBackground(new Color(48, 105, 147));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        btnBuscar.setBackground(new Color(51,71,86));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        btnLimpiar.setBackground(new Color(246, 96, 96));
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        btnLimpiar.setBackground(new Color(228, 65, 65));
    }//GEN-LAST:event_btnLimpiarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconGuardar;
    private javax.swing.JLabel IconGuardarHover;
    private javax.swing.JLabel IconRegresar;
    private javax.swing.JLabel IconRegresarHover;
    private javax.swing.JPanel btnBuscar;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JPanel btnLimpiar;
    private javax.swing.JPanel btnRegresar;
    public static javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbLimpiar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    
}
