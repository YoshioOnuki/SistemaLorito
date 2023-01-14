
package Controlador;

import DB.ConDB;
import Modelo.rol;
import Modelo.tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class tipoController {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConDB con = new ConDB();
    Connection acce;
    
    public void cargarComboTipo(JComboBox cbo){
        
        String sql = "SELECT tipo_descripcion FROM tipo";
        
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
            System.out.println("Error en combo Tipo: " + e);
        }
    }
    
    public int idTipo(String tipo) {
        int r = 0;
        String sql = "SELECT tipo_id FROM tipo WHERE tipo_descripcion=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setString(1, tipo);
            rs = ps.executeQuery();
            while(rs.next()){
                r = rs.getInt(1);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error obtener el ID del tipo" + e);
        }
        
        return r;
    }
    
    //Validamos Tipo
    public Modelo.tipo validarTipo(int idTipo){
        Modelo.tipo tipoModelo = new tipo();
        
        String msql = "SELECT * FROM tipo WHERE tipo_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setInt(1, idTipo);
            rs = ps.executeQuery();
            while(rs.next()){
                tipoModelo.setTipoID(rs.getInt(1));
                tipoModelo.setTipoDescripcion(rs.getString(2));
                tipoModelo.setTipoEstado(rs.getInt(3));
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Tipo:  " + e);
        }
        
        return tipoModelo;
    }
}
