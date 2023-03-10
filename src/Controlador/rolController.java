
package Controlador;

import DB.ConDB;
import Modelo.rol;
import Modelo.trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class rolController {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConDB con = new ConDB();
    Connection acce;
    
    public int idRol(String rol) {
        int r = 0;
        String sql = "SELECT rol_id FROM rol WHERE rol_descripcion=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setString(1, rol);
            rs = ps.executeQuery();
            while(rs.next()){
                r = rs.getInt(1);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error obtener el ID del Rol" + e);
        }
        
        return r;
    }
    
    //Validamos Rol
    public Modelo.rol validarRol(int idRol){
        Modelo.rol rolModelo = new rol();
        
        String msql = "SELECT * FROM rol WHERE rol_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setInt(1, idRol);
            rs = ps.executeQuery();
            while(rs.next()){
                rolModelo.setRolID(rs.getInt(1));
                rolModelo.setRolDescripcion(rs.getString(2));
                rolModelo.setRolEstado(rs.getInt(3));
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Rol:  " + e);
        }
        
        return rolModelo;
    }
    
    public void cargarComboRol(JComboBox cbo){
        
        String sql = "SELECT rol_descripcion FROM rol";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            cbo.removeAllItems();
            cbo.addItem("Seleccione");
            
            while(rs.next()){
                cbo.addItem(rs.getString(1));
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error en combo Rol: " + e);
        }
    }
    
    
}
