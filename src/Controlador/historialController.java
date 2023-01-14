
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
        String sql = "INSERT INTO historial_cambios(historial_descripcion, historial_fecha, historial_trabajador) VALUES(?,?,?)";
        
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
    
    //Consulta para mostrar Historial de Cambios
    public DefaultTableModel consultarCambios(String b){
        String []titulos={"ID","DESCRIPCION","FECHA","TRABAJADOR"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[5];
        
        String sql = "SELECT historial_id, historial_descripcion, historial_fecha, historial_trabajador FROM historial_cambios WHERE historial_id LIKE '%" + b + "%' OR historial_descripcion LIKE '%" + b +"%' OR historial_fecha LIKE '%" + b +"%' OR historial_trabajador LIKE '%" + b +"%' ORDER BY 1 DESC";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = rs.getString(4);
                
                m.addRow(o);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al consultar Historial de Cambios: " + e);
        }

        return m;
    }
    
    
}
