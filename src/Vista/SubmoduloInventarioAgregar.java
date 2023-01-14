
package Vista;

import Controlador.historialController;
import Controlador.inventarioController;
import Controlador.rolController;
import Controlador.tipoController;
import Modelo.inventario;
import Modelo.tipo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class SubmoduloInventarioAgregar extends javax.swing.JPanel {

    Controlador.inventarioController inveController = new inventarioController();
    Controlador.tipoController tipoController = new tipoController();
    Controlador.historialController histoController = new historialController();
    
    Modelo.inventario inveModelo = new inventario();
    Modelo.tipo tipoModelo = new tipo();
    
    public SubmoduloInventarioAgregar() {
        initComponents();
        cargarCboRol();
        titulo();
    }

    
    void cargarCboRol(){
        tipoController.cargarComboTipo(cboTipo);
    }
    
    void titulo(){
        if(SubmoduloReporteInventario.tipoCRUD == 1){
            lblTitulo.setText("");
            lblTitulo.setText("AGREGAR INVENTARIO");
            
        }else if(SubmoduloReporteInventario.tipoCRUD == 2){
            lblTitulo.setText("");
            lblTitulo.setText("ACTUALIZAR INVENTARIO");
            cargarDatos();
        }
    }
    
    //Cargamos los datos del inventario seleccionado
    void cargarDatos(){
        int id = SubmoduloReporteInventario.idInven; 
        
        txtCantidad.setEnabled(false);
        jcalFecha.setEnabled(false);
        
        inveModelo = inveController.validarInventario(id);
        
        txtNombre.setText(inveModelo.getInventario_nombre());
        txtCompra.setText(""+inveModelo.getInventario_precio_compra());
        txtVenta.setText(""+inveModelo.getInventario_precio_venta());
        txtCantidad.setText(""+inveModelo.getInventario_cantidad());
//        System.out.println(tipoModelo.getTipoDescripcion());
//        System.out.println(inveModelo.getTipo_id());
        cboTipo.setSelectedIndex(inveModelo.getTipo_id());
        try {
            SimpleDateFormat formatodeltexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;
            fecha = (Date) formatodeltexto.parse(inveModelo.getInventario_fecha_registro());
            jcalFecha.setDate(fecha);
        } catch (Exception e) {
        }
    }
    
    void agregarInventario(){
        if(txtNombre.getText().equals("") || txtCompra.getText().equals("") || txtVenta.getText().equals("") || txtCantidad.getText().equals("") || jcalFecha.getDate() == null ||  cboTipo.getSelectedIndex()==0 ){
            JOptionPane.showMessageDialog(null, "Campos requeridos vacios");
            txtNombre.requestFocus();
        }else{
            
            String nombre = txtNombre.getText();
            float precioCompra = Float.parseFloat(txtCompra.getText());
            float precioVenta = Float.parseFloat(txtVenta.getText());
            int cant = Integer.parseInt(txtCantidad.getText());
            Date f = jcalFecha.getDate();
            DateFormat fec = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = fec.format(f);
            int tipo = tipoController.idTipo(cboTipo.getSelectedItem().toString());
            
            
            Object[] ob = new Object[7];

            ob[0] = nombre;
            ob[1] = precioCompra;
            ob[2] = precioVenta;
            ob[3] = cant;
            ob[4] = fecha;
            ob[5] = 1;
            ob[6] = tipo;

            int respuesta1 = inveController.addInventario(ob);

            if(respuesta1 > 0){
                JOptionPane.showMessageDialog(null, "Datos del inventario ingresados correctamente");
            }
            
            java.util.Date fechaActual = new Date();
            DateFormat fec2 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha2 = fec2.format(fechaActual);
            String histo = "Agregar inventario";
            
            Object[] obHisto = new Object[3];

            obHisto[0] = histo;
            obHisto[1] = fecha2;
            obHisto[2] = Login.nombresTrab;
            
            int respuesta2 = histoController.addHistorial(obHisto);

            if(respuesta2>0){
                System.out.println("Historial Agregado");
            }

            Vista.SubmoduloReporteInventario mInventario = new Vista.SubmoduloReporteInventario();

            mInventario.setSize(970, 550);
            mInventario.setLocation(0, 0);
            Principal.PanelPrincipal.removeAll();
            Principal.PanelPrincipal.add(mInventario, BorderLayout.CENTER);
            Principal.PanelPrincipal.revalidate();
            Principal.PanelPrincipal.repaint();
        }
    }
    
    
    void actualizarInventario(){
        if(txtNombre.getText().equals("") || txtCompra.getText().equals("") || txtVenta.getText().equals("") ||  cboTipo.getSelectedIndex()==0 ){
            JOptionPane.showMessageDialog(null, "Campos requeridos vacios");
            txtNombre.requestFocus();
        }else{
            int id = SubmoduloReporteInventario.idInven; 
            String nombre = txtNombre.getText();
            String pCompra = txtCompra.getText();
            String pVenta = txtVenta.getText();
            int tipo = tipoController.idTipo(cboTipo.getSelectedItem().toString());
            
            inveModelo = inveController.validarInventario(id);
            
            Object[] ob = new Object[4];
            ob[0] = nombre;
            ob[1] = pCompra;
            ob[2] = pVenta;
            ob[3] = tipo;

            int respuesta = inveController.updateInventario(ob, id);

            if(respuesta>0){
                JOptionPane.showMessageDialog(null, "Datos del Inventario actualizados correctamente");
            }
            
            java.util.Date fechaActual = new Date();
            DateFormat fec2 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha2 = fec2.format(fechaActual);
            
            String histo = "Actualizar inventario";
            
            Object[] obHisto = new Object[3];

            obHisto[0] = histo;
            obHisto[1] = fecha2;
            obHisto[2] = Login.nombresTrab;
            
            int respuesta2 = histoController.addHistorial(obHisto);

            if(respuesta2>0){
                System.out.println("Historial Agregado");
            }

            Vista.SubmoduloReporteInventario mInven = new Vista.SubmoduloReporteInventario();

            mInven.setSize(970, 550);
            mInven.setLocation(0, 0);
            Principal.PanelPrincipal.removeAll();
            Principal.PanelPrincipal.add(mInven, BorderLayout.CENTER);
            Principal.PanelPrincipal.revalidate();
            Principal.PanelPrincipal.repaint();
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
        txtCompra = new javax.swing.JTextField();
        txtVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JPanel();
        IconGuardar = new javax.swing.JLabel();
        IconGuardarHover = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcalFecha = new com.toedter.calendar.JDateChooser();

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
        lblTitulo.setText("AGREGAR INVENTARIO");

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
        jLabel2.setText("Precio Compra:");

        jLabel3.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel3.setText("Precio Venta:");

        txtCompra.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtCompra.setMaximumSize(new java.awt.Dimension(220, 30));
        txtCompra.setMinimumSize(new java.awt.Dimension(220, 30));
        txtCompra.setPreferredSize(new java.awt.Dimension(220, 30));
        txtCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompraKeyTyped(evt);
            }
        });

        txtVenta.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtVenta.setMaximumSize(new java.awt.Dimension(220, 30));
        txtVenta.setMinimumSize(new java.awt.Dimension(220, 30));
        txtVenta.setPreferredSize(new java.awt.Dimension(220, 30));
        txtVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVentaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad:");

        txtCantidad.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtCantidad.setMaximumSize(new java.awt.Dimension(220, 30));
        txtCantidad.setMinimumSize(new java.awt.Dimension(220, 30));
        txtCantidad.setPreferredSize(new java.awt.Dimension(220, 30));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel5.setText("Tipo:");

        cboTipo.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        cboTipo.setMaximumSize(new java.awt.Dimension(220, 30));
        cboTipo.setMinimumSize(new java.awt.Dimension(220, 30));
        cboTipo.setPreferredSize(new java.awt.Dimension(220, 30));

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
        jLabel7.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        txtNombre.setMaximumSize(new java.awt.Dimension(220, 30));
        txtNombre.setMinimumSize(new java.awt.Dimension(220, 30));
        txtNombre.setPreferredSize(new java.awt.Dimension(220, 30));

        jLabel8.setFont(new java.awt.Font("SF UI Display", 0, 14)); // NOI18N
        jLabel8.setText("Fecha de Registro:");

        jcalFecha.setMaximumSize(new java.awt.Dimension(220, 30));
        jcalFecha.setMinimumSize(new java.awt.Dimension(220, 30));
        jcalFecha.setPreferredSize(new java.awt.Dimension(220, 30));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcalFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(72, 72, 72)
                        .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lblTitulo)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8))
                            .addComponent(jcalFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
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
        Vista.SubmoduloReporteInventario mInventario = new Vista.SubmoduloReporteInventario();

        mInventario.setSize(970, 550);
        mInventario.setLocation(0, 0);
        Principal.PanelPrincipal.removeAll();
        Principal.PanelPrincipal.add(mInventario, BorderLayout.CENTER);
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

    private void txtCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompraKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            evt.consume();
        }
        if(txtCompra.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_txtCompraKeyTyped

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if(SubmoduloReporteInventario.tipoCRUD==1){
            agregarInventario();
        }else if(SubmoduloReporteInventario.tipoCRUD==2){
            actualizarInventario();
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

    private void txtVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentaKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            evt.consume();
        }
        if(txtCompra.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_txtVentaKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9'){
            evt.consume();
        }
        if(txtCompra.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconGuardar;
    private javax.swing.JLabel IconGuardarHover;
    private javax.swing.JLabel IconRegresar;
    private javax.swing.JLabel IconRegresarHover;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private com.toedter.calendar.JDateChooser jcalFecha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCompra;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtVenta;
    // End of variables declaration//GEN-END:variables
}
