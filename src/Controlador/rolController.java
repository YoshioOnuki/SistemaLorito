
package Controlador;

import DB.ConDB;
import Modelo.rol;
import Modelo.trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            System.out.println("Error al agregar usuario" + e);
        }
        
        return r;
    }
    
    //Validamos los campos del login...
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
    
    
}
