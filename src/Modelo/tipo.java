
package Modelo;

public class tipo {
    private int tipo_id;
    private String tipo_descripcion;
    private int tipo_estado;

    public tipo() {
    }

    public tipo(int tipoID, String tipoDescripcion, int tipoEstado) {
        this.tipo_id = tipoID;
        this.tipo_descripcion = tipoDescripcion;
        this.tipo_estado = tipoEstado;
    }

    public int getTipoID() {
        return tipo_id;
    }

    public void setTipoID(int tipoID) {
        this.tipo_id = tipoID;
    }

    public String getTipoDescripcion() {
        return tipo_descripcion;
    }

    public void setTipoDescripcion(String tipoDescripcion) {
        this.tipo_descripcion = tipoDescripcion;
    }

    public int getTipoEstado() {
        return tipo_estado;
    }

    public void setTipoEstado(int tipoEstado) {
        this.tipo_estado = tipoEstado;
    }
    
    
    
}
