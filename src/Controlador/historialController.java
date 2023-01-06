
package Controlador;

import DB.ConDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class historialController {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConDB con = new ConDB();
    Connection acce;
    
    
    //Ingresamos inventario
    public int addHistorial(Object[] ob) {
        int r = 0;
        String sql = "INSERT INTO historial_cambios(historial_descripcion, historial_fecha, historial_trabajador_id) VALUES(?,?,?)";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, ob[0]);
            ps.setObject(2, ob[1]);
            ps.setObject(3, ob[2]);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al generar historial de cambios: " + e);
        }
        
        return r;
    }
    
    
}
