
package Modelo;


public class usuario {
    private int usuario_id;
    private String usuario_user;
    private String usuario_contra;
    private int usuario_estado;
    private int trabajador_id;

    public usuario() {
    }

    public usuario(int usuario_id, String usuario_user, String usuario_contra, int usuario_estado, int trabajador_id) {
        this.usuario_id = usuario_id;
        this.usuario_user = usuario_user;
        this.usuario_contra = usuario_contra;
        this.usuario_estado = usuario_estado;
        this.trabajador_id = trabajador_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_user() {
        return usuario_user;
    }

    public void setUsuario_user(String usuario_user) {
        this.usuario_user = usuario_user;
    }

    public String getUsuario_contra() {
        return usuario_contra;
    }

    public void setUsuario_contra(String usuario_contra) {
        this.usuario_contra = usuario_contra;
    }

    public int getUsuario_estado() {
        return usuario_estado;
    }

    public void setUsuario_estado(int usuario_estado) {
        this.usuario_estado = usuario_estado;
    }

    public int getTrabajador_id() {
        return trabajador_id;
    }

    public void setTrabajador_id(int trabajador_id) {
        this.trabajador_id = trabajador_id;
    }

    

    
    
}
