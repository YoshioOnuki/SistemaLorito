
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
    
    //Actualizar Usuario
    public int updateUsuario(Object[] o) {
        int r = 0;
        String sql = "UPDATE usuario SET usuario_user=?, usuario_contra=? WHERE trabajador_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r = ps.executeUpdate();
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error actualizar Usuario" + e);
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
                entUsu.setUsuario_id(rs.getInt(1));
                entUsu.setUsuario_user(rs.getString(2));
                entUsu.setUsuario_contra(rs.getString(3));
                entUsu.setUsuario_estado(rs.getInt(4));
                entUsu.setTrabajador_id(rs.getInt(5));
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Usuario:  " + e);
        }
        
        return entUsu;
    }
    
    //Validamos usuario trabajador
    public Modelo.usuario validarUsuarioTrabajador(int id){
        Modelo.usuario entUsu = new usuario();
        int estado = 1;
        
        String msql = "SELECT * FROM usuario WHERE trabajador_id=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(msql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                entUsu.setUsuario_id(rs.getInt(1));
                entUsu.setUsuario_user(rs.getString(2));
                entUsu.setUsuario_contra(rs.getString(3));
                entUsu.setUsuario_estado(rs.getInt(4));
                entUsu.setTrabajador_id(rs.getInt(5));
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Usuario Trabajador:  " + e);
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
    
     public int validarDuplicados(String usua){
        int cont = 0;
        String r = "";
        
        String sql = "SELECT usuario_user FROM usuario WHERE usuario_user=?";
        
        try {
            acce = con.conectardb();
            ps = acce.prepareStatement(sql);
            ps.setObject(1, usua);
            rs = ps.executeQuery();
            while(rs.next()){
                r = rs.getString(1);
                if(!r.isEmpty()){
                    cont++;
                    r = "";
                    System.out.println(cont);
                }
            }
            
            acce.close();
        } catch (Exception e) {
            System.out.println("Error al validar Usuarios duplicados:  " + e);
        }
        
        return cont;
    }
}
