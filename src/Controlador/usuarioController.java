
package Controlador;

import DB.ConDB;
import Modelo.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class usuarioController {
    PreparedStatement ps;
    ResultSet rs;
    
    DB.ConDB con = new ConDB();
    Connection acce;
    
    //Agregar trabajador
    public int addUsuario(Object[] ob) {
        int r = 0;
        String sql = "INSERT INTO usuario(usuario_user, usuario_contra, usuario_estado, trabajador_id) VALUES(?,?,?,?)";
        
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
            System.out.println("Error al agregar usuario" + e);
        }
        
        return r;
    }
    
    //Validamos los campos del login
    public Modelo.usuario validarUsuario(String usu, String cont){
        Modelo.usuario entUsu = new usuario();
        int estado = 1;
        
        String msql = "SELECT * FROM usuario WHERE usuario_user=? AND usuario_contra=? AND usuario_estado=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setString(1, usu);
            ps.setString(2, cont);
            ps.setInt(3, estado);
            rs = ps.executeQuery();
            while(rs.next()){
                entUsu.setUsuarioID(rs.getInt(1));
                entUsu.setUsuarioUser(rs.getString(2));
                entUsu.setUsuarioContra(rs.getString(3));
                entUsu.setUsuarioEstado(rs.getInt(4));
                entUsu.setTrabajadorID(rs.getInt(5));
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Usuario:  " + e);
        }
        
        return entUsu;
    }
    
    //Actualizar estado del usuario
    public int estadoUsuario(int usuarioID, int estado) {
        int r = 0;
        
        String sql = "UPDATE usuario SET usuario_estado=? WHERE usuario_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, estado);
            ps.setObject(2, usuarioID);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error actualizar estado de Usuario: "+ e);
        }
        
        return r;
    }
    
    
    //Retornamos el último ID del trabajador ingresado en la DB
//    public int ultimoIdUsuario(){
//        int r = 0;
//        
//        String sql = "SELECT max(usuario_id) FROM usuario";
//        
//        try {
//            acce = con.conectardb();
//            ps = acce.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                r = rs.getInt(1);
//            }
//            
//            acce.close();
//        } catch (Exception e) {
//            System.out.println("Error al obtener el último ID del usuario:  " + e);
//        }
//        
//        return r;
//    }
}
