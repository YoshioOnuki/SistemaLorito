
package Controlador;

import DB.ConDB;
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
}
