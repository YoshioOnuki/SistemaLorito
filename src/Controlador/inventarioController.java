
package Controlador;

import DB.ConDB;
import Modelo.inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class inventarioController {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConDB con = new ConDB();
    Connection acce;
    
    
    //Ingresamos inventario
    public int addInventario(Object[] ob) {
        int r = 0;
        String sql = "INSERT INTO inventario(inventario_nombre, inventario_precio_compra, inventario_precio_venta, inventario_cantidad, inventario_fecha_registro, tipo_id) VALUES(?,?,?,?,?,?)";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, ob[0]);
            ps.setObject(2, ob[1]);
            ps.setObject(3, ob[2]);
            ps.setObject(4, ob[3]);
            ps.setObject(5, ob[4]);
            ps.setObject(6, ob[5]);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al ingresar Inventario: " + e);
        }
        
        return r;
    }
    
    //Actualizando inventario
    public int updateInventario(Object[] ob, int inventarioID) {
        int r = 0;
        
        String sql = "UPDATE inventario SET inventario_nombre=?, inventario_precio_compra=?, inventario_precio_venta=?, tipo_id=? WHERE inventario_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, ob[0]);
            ps.setObject(2, ob[1]);
            ps.setObject(3, ob[2]);
            ps.setObject(4, ob[3]);
            ps.setObject(5, inventarioID);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error actualizar el inventario: "+ inventarioID + ": " + e);
        }
        
        return r;
    }
    
    //Actualizar cantidad de inventario
    public int updateCantidadInventario(int inventarioID, int cant) {
        int r = 0;
        
        String sql = "UPDATE inventario SET inventario_cantidad=? WHERE inventario_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, cant);
            ps.setObject(2, inventarioID);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error en la entrada de inventario: "+ inventarioID + ": " + e);
        }
        
        return r;
    }
    
    //Eliminando inventario
    public int deleteInventario(int inventarioID) {
        int r = 0;
        
        String sql = "DELETE FROM inventario WHERE inventario_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, inventarioID);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al Eliminar inventario: "+ inventarioID + ": " + e);
        }
        
        return r;
    }
    
    //Validamos el inventario
    public Modelo.inventario validarInventario(int idInven){
        Modelo.inventario entInventario = new inventario();
        
        String msql = "SELECT * FROM inventario WHERE inventario_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setInt(1, idInven);
            rs = ps.executeQuery();
            while(rs.next()){
                entInventario.setInventarioID(rs.getInt(1));
                entInventario.setInventarioNombre(rs.getString(2));
                entInventario.setInventarioPrecioCompra(rs.getDouble(3));
                entInventario.setInventarioPrecioVenta(rs.getDouble(4));
                entInventario.setInventarioCantidad(rs.getInt(5));
                entInventario.setInventarioFechaRegistro(rs.getString(6));
                entInventario.setTipoID(rs.getInt(7));
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Inventario:  " + e);
        }
        
        return entInventario;
    }
    
    //Retornar cantidad del inventario
    public int cantidadInventario(int idInven){
        int r = 0;
        
        String msql = "SELECT inventario_cantidad FROM inventario WHERE inventario_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            r = rs.getInt(1);
            rs = ps.executeQuery();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al retornar cantidad de Inventario:  " + e);
        }
        
        return r;
    }
    
    //Mostrar los datos del inventario en una tabla
    public DefaultTableModel consultarInventario(String b){
        String [] encabe={"ID","DESCRIPCION","TIPO","PRECIO COMPRA","PRECIO VENTA","CANTIDAD","FECHA REGISTRO"};
        DefaultTableModel m = new DefaultTableModel(null, encabe);
        Object[] o = new Object[8];
        
        String sql = "SELECT i.inventario_id, i.inventario_nombre, t.tipo_descripcion, i.inventario_precio_compra, i.inventario_precio_venta, i.inventario_cantidad, i.inventario_fecha_registro FROM inventario i INNER JOIN tipo t ON i.tipo_id=t.tipo_id WHERE i.inventario_id LIKE '%" + b + "%' OR i.inventario_nombre LIKE '%" + b +"%' OR t.tipo_descripcion LIKE '%"+ b +"%' OR i.inventario_precio_compra LIKE '%"+ b +"%' OR i.inventario_precio_venta LIKE '%"+ b +"%' OR i.inventario_cantidad LIKE '%"+ b +"%' OR i.inventario_fecha_registro LIKE '%"+ b +"%'";
   
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                o[0] = rs.getInt(1);
                o[1] = rs.getString(2);
                o[2] = rs.getString(3);
                o[3] = String.format("%.2f", rs.getDouble(4));
                o[4] = String.format("%.2f", rs.getDouble(5));
                o[5] = rs.getInt(6);
                o[6] = rs.getString(7);

                m.addRow(o);
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("error consultar datos del inventario: " + e);
        }

        return m;
    }
}
