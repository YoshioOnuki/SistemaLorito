
package Controlador;

import DB.ConDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

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
    
    //Consulta para mostrar Entradas
    public DefaultTableModel consultarSalida(String b, String tipo){
        String []titulos={"ID", "PRODUCTO","SALIDA","FECHA","TRABAJADOR"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[5];
        int cont = 1;
        
        String sql = "SELECT i.inventario_nombre, d.detalle_cantidad, d.detalle_fecha, t.trabajador_nombres FROM detalle_inventario d INNER JOIN inventario i ON d.inventario_id=i.inventario_id INNER JOIN trabajador t ON d.trabajador_id=t.trabajador_id WHERE d.detalle_descripcion=? AND (i.inventario_nombre LIKE '%" + b + "%' OR t.trabajador_nombres LIKE '%" + b +"%') ORDER BY 1 ASC";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, tipo);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = cont;
                o[1] = rs.getString(1);
                o[2] = rs.getInt(2);
                o[3] = rs.getString(3);
                o[4] = rs.getString(4);
                cont++;
//                System.out.println(o[1]);
                
                m.addRow(o);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al consultar datos de entradas o salidas para mostrar en la tabla: " + e);
        }

        return m;
    }
    
    //Consulta para mostrar Entradas
    public DefaultTableModel consultarEntrada(String b, String tipo){
        String []titulos={"ID", "PRODUCTO","ENTRADA","FECHA","TRABAJADOR"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[5];
        int cont = 1;
        
        String sql = "SELECT i.inventario_nombre, d.detalle_cantidad, d.detalle_fecha, t.trabajador_nombres FROM detalle_inventario d INNER JOIN inventario i ON d.inventario_id=i.inventario_id INNER JOIN trabajador t ON d.trabajador_id=t.trabajador_id WHERE d.detalle_descripcion=? AND (i.inventario_nombre LIKE '%" + b + "%' OR t.trabajador_nombres LIKE '%" + b +"%') ORDER BY 1 ASC";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, tipo);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = cont;
                o[1] = rs.getString(1);
                o[2] = rs.getInt(2);
                o[3] = rs.getString(3);
                o[4] = rs.getString(4);
                cont++;
//                System.out.println(o[1]);
                
                m.addRow(o);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al consultar datos de entradas o salidas para mostrar en la tabla: " + e);
        }

        return m;
    }
    
    
    //Consulta para mostrar Entradas
    public DefaultTableModel consultarEntradaSalida2(String b){
        String []titulos={"ID", "PRODUCTO","ENTRADA/SALIDA","FECHA","TRABAJADOR","MOVIMIENTO"};
        DefaultTableModel m = new DefaultTableModel(null, titulos);
        Object[] o = new Object[6];
        
        String sql = "SELECT d.detalle_id, i.inventario_nombre, d.detalle_cantidad, d.detalle_fecha, t.trabajador_nombres, d.detalle_descripcion FROM detalle_inventario d INNER JOIN inventario i ON d.inventario_id=i.inventario_id INNER JOIN trabajador t ON d.trabajador_id=t.trabajador_id WHERE i.inventario_nombre LIKE '%" + b + "%' OR t.trabajador_nombres LIKE '%" + b +"%' OR d.detalle_descripcion LIKE '%" + b +"%' ORDER BY 1 DESC";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getInt(3);
                o[3] = rs.getString(4);
                o[4] = rs.getString(5);
                o[5] = rs.getString(6);
                
                m.addRow(o);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al consultar entradas y salidas para mostrar en la tabla: " + e);
        }

        return m;
    }
    
}
