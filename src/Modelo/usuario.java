
package Modelo;


public class usuario {
    private int usuario_id;
    private String usuario_user;
    private String usuario_contra;
    private int usuario_estado;
    private int trabajador_id;

    public usuario() {
    }

    public usuario(int usuarioID, String usuarioUser, String usuarioContra, int usuarioEstado, int trabajadorID) {
        this.usuario_id = usuarioID;
        this.usuario_user = usuarioUser;
        this.usuario_contra = usuarioContra;
        this.usuario_estado = usuarioEstado;
        this.trabajador_id = trabajadorID;
    }

    public int getUsuarioID() {
        return usuario_id;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuario_id = usuarioID;
    }

    public String getUsuarioUser() {
        return usuario_user;
    }

    public void setUsuarioUser(String usuarioUser) {
        this.usuario_user = usuarioUser;
    }

    public String getUsuarioContra() {
        return usuario_contra;
    }

    public void setUsuarioContra(String usuarioContra) {
        this.usuario_contra = usuarioContra;
    }

    public int getUsuarioEstado() {
        return usuario_estado;
    }

    public void setUsuarioEstado(int usuarioEstado) {
        this.usuario_estado = usuarioEstado;
    }

    public int getTrabajadorID() {
        return trabajador_id;
    }

    public void setTrabajadorID(int trabajadorID) {
        this.trabajador_id = trabajadorID;
    }
    
    
}
