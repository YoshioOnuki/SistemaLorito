
package Modelo;

public class rol {
    private int rol_id;
    private String rol_descripcion;
    private int rol_estado;

    public rol() {
    }

    public rol(int rolID, String rolDescripcion, int rolEstado) {
        this.rol_id = rolID;
        this.rol_descripcion = rolDescripcion;
        this.rol_estado = rolEstado;
    }

    public int getRolID() {
        return rol_id;
    }

    public void setRolID(int rolID) {
        this.rol_id = rolID;
    }

    public String getRolDescripcion() {
        return rol_descripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rol_descripcion = rolDescripcion;
    }

    public int getRolEstado() {
        return rol_estado;
    }

    public void setRolEstado(int rolEstado) {
        this.rol_estado = rolEstado;
    }


    
    
    
}
