
package Controlador;

import DB.ConDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class detalleController {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConDB con = new ConDB();
    Connection acce;
    
    //Ingresamos inventario
    public int addDetalleInventario(Object[] ob) {
        int r = 0;
        String sql = "INSERT INTO detalle_inventario(detalle_descripcion, detalle_fecha, detalle_cantidad, trabajador_id, inventario_id) VALUES(?,?,?,?,?)";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, ob[0]);
            ps.setObject(2, ob[1]);
            ps.setObject(3, ob[2]);
            ps.setObject(4, ob[3]);
            ps.setObject(5, ob[4]);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al ingresar Detalle de Inventario: " + e);
        }
        
        return r;
    }
}
