
package Modelo;

public class detalle_inventario {
    private int detalle_id;
    private String detalle_descripcion;
    private String detalle_fecha;
    private int detalle_cantidad;
    private int trabajador_id;
    private int inventario_id;

    public detalle_inventario() {
    }

    public detalle_inventario(int detalle_id, String detalle_descripcion, String detalle_fecha_ingreso, int detalle_cantidad, int trabajador_id, int inventario_id) {
        this.detalle_id = detalle_id;
        this.detalle_descripcion = detalle_descripcion;
        this.detalle_fecha = detalle_fecha_ingreso;
        this.detalle_cantidad = detalle_cantidad;
        this.trabajador_id = trabajador_id;
        this.inventario_id = inventario_id;
    }

    public int getDetalle_id() {
        return detalle_id;
    }

    public void setDetalle_id(int detalle_id) {
        this.detalle_id = detalle_id;
    }

    public String getDetalle_descripcion() {
        return detalle_descripcion;
    }

    public void setDetalle_descripcion(String detalle_descripcion) {
        this.detalle_descripcion = detalle_descripcion;
    }

    public String getDetalle_fecha_ingreso() {
        return detalle_fecha;
    }

    public void setDetalle_fecha_ingreso(String detalle_fecha_ingreso) {
        this.detalle_fecha = detalle_fecha_ingreso;
    }

    public int getDetalle_cantidad() {
        return detalle_cantidad;
    }

    public void setDetalle_cantidad(int detalle_cantidad) {
        this.detalle_cantidad = detalle_cantidad;
    }

    public int getTrabajador_id() {
        return trabajador_id;
    }

    public void setTrabajador_id(int trabajador_id) {
        this.trabajador_id = trabajador_id;
    }

    public int getInventario_id() {
        return inventario_id;
    }

    public void setInventario_id(int inventario_id) {
        this.inventario_id = inventario_id;
    }
    
    
}
