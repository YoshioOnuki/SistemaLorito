
package Controlador;

import DB.ConDB;
import Modelo.rol;
import Modelo.trabajador;
import Modelo.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


public class trabajadorController {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConDB con = new ConDB();
    Connection acce;
    
    //Agregar trabajador
    public int addTrabajador(Object[] ob) {
        int r = 0;
        String sql = "INSERT INTO trabajador(trabajador_DNI, trabajador_nombres, trabajador_direccion, rol_id) VALUES(?,?,?,?)";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, ob[0]);
            ps.setObject(2, ob[1]);
            ps.setObject(3, ob[2]);
            ps.setObject(4, ob[3]);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al agregar trabajador" + e);
        }
        
        return r;
    }
    
    //Actualizar trabajador
    public int updateTrabajador(Object[] o) {
        int r = 0;
        String sql = "UPDATE trabajador SET trabajador_DNI=?, trabajador_nombres=?, trabajador_direccion=?, rol_id=? WHERE trabajador_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error actualizar Trabajador" + e);
        }
        
        return r;
    }
    
    public int validarDuplicados(String dni){
        int cont = 0;
        String r = "";
        
        String sql = "SELECT trabajador_DNI FROM trabajador WHERE trabajador_DNI=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, dni);
            rs = ps.executeQuery();
            while(rs.next()){
                r = rs.getString(1);
                if(!r.isEmpty()){
                    cont++;
                    r = "";
                    System.out.println(cont);
                }
                    
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al obtener el último ID del trabajador:  " + e);
        }
        
        return cont;
    }
    
    
    //Validamos los campos del login...
    public Modelo.trabajador validarTrabajador(int idUsuario){
        Modelo.trabajador entTraba = new trabajador();
        
        String msql = "SELECT * FROM trabajador WHERE trabajador_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            while(rs.next()){
                entTraba.setTrabajadorID(rs.getInt(1));
                entTraba.setTrabajador_DNI(rs.getString(2));
                entTraba.setTrabajadorNombres(rs.getString(3));
                entTraba.setTrabajadorDireccion(rs.getString(4));
                entTraba.setRolID(rs.getInt(5));
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Trabajador:  " + e);
        }
        
        return entTraba;
    }
    
    //Mostrar los datos de trabajadores en tableModel
    public DefaultTableModel consultarTrabajador(String b){
        String []titulos={"ID","DNI","NOMBRES","DIRECCION","ROL", "USUARIO"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[6];
        Modelo.usuario usuaModelo = new usuario();
        Controlador.usuarioController usuaController = new usuarioController();
        
        
        
        String sql = "SELECT t.trabajador_id, t.trabajador_DNI, t.trabajador_nombres, t.trabajador_direccion, r.rol_descripcion FROM trabajador t INNER JOIN rol r ON t.rol_id=r.rol_id WHERE t.trabajador_id LIKE '%" + b + "%' OR t.trabajador_DNI LIKE '%" + b +"%' OR t.trabajador_nombres LIKE '%"+ b +"%' OR t.trabajador_direccion LIKE '%"+ b +"%' OR r.rol_descripcion LIKE '%"+ b +"%'";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                usuaModelo = usuaController.validarUsuarioTrabajador(rs.getInt(1));
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4);
                o[4] = rs.getString(5);
                if(usuaModelo.getUsuario_user() == null){
                    o[5] = "No asignado";
                }else{
                    o[5] = usuaModelo.getUsuario_user();
                }
                
                m.addRow(o);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al consultar trabajador para mostrar en tableModel: " + e);
        }

        return m;
    }
    
//    Retornamos el último ID del trabajador ingresado en la DB
    public int ultimoIdTrabajador(){
        int r = 0;
        
        String sql = "SELECT max(trabajador_id) FROM trabajador";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                r = rs.getInt(1);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al obtener el último ID del trabajador:  " + e);
        }
        
        return r;
    }
    
    //Validamos rol por trabajador.
    public String validarTrabajadorRol(int idTrab){
        Modelo.trabajador trabModelo = new trabajador();
        String rol = "";
        
        String msql = "SELECT r.rol_descripcion FROM trabajador t INNER JOIN rol r ON t.rol_id=r.rol_id WHERE t.trabajador_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setInt(1, idTrab);
            rs = ps.executeQuery();
            while(rs.next()){
                rol = rs.getString(1);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Rol del trabajador:  " + e);
        }
        
        return rol;
    }
    
    
}
