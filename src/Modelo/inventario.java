
package Modelo;

public class inventario {
    private int inventario_id;
    private String inventario_nombre;
    private double inventario_precio_compra;
    private double inventario_precio_venta;
    private int inventario_cantidad;
    private String inventario_fecha_registro;
    private int tipo_id;

    public inventario() {
    }

    public inventario(int inventario_id, String inventario_nombre, double inventario_precio_compra, double inventario_precio_venta, int inventario_cantidad, String inventario_fecha_registro, int tipo_id) {
        this.inventario_id = inventario_id;
        this.inventario_nombre = inventario_nombre;
        this.inventario_precio_compra = inventario_precio_compra;
        this.inventario_precio_venta = inventario_precio_venta;
        this.inventario_cantidad = inventario_cantidad;
        this.inventario_fecha_registro = inventario_fecha_registro;
        this.tipo_id = tipo_id;
    }

    public int getInventarioID() {
        return inventario_id;
    }

    public void setInventarioID(int inventarioID) {
        this.inventario_id = inventarioID;
    }

    public String getInventarioNombre() {
        return inventario_nombre;
    }

    public void setInventarioNombre(String inventarioNombre) {
        this.inventario_nombre = inventarioNombre;
    }

    public double getInventarioPrecioCompra() {
        return inventario_precio_compra;
    }

    public void setInventarioPrecioCompra(double inventarioPrecioCompra) {
        this.inventario_precio_compra = inventarioPrecioCompra;
    }

    public double getInventarioPrecioVenta() {
        return inventario_precio_venta;
    }

    public void setInventarioPrecioVenta(double inventarioPrecioVenta) {
        this.inventario_precio_venta = inventarioPrecioVenta;
    }

    public int getInventarioCantidad() {
        return inventario_cantidad;
    }

    public void setInventarioCantidad(int inventarioCantidad) {
        this.inventario_cantidad = inventarioCantidad;
    }

    public String getInventarioFechaRegistro() {
        return inventario_fecha_registro;
    }

    public void setInventarioFechaRegistro(String inventarioFechaRegistro) {
        this.inventario_fecha_registro = inventarioFechaRegistro;
    }

    public int getTipoID() {
        return tipo_id;
    }

    public void setTipoID(int tipoID) {
        this.tipo_id = tipoID;
    }
    
    
    
}
