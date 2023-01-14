
package Modelo;

public class inventario {
    private int inventario_id;
    private String inventario_nombre;
    private double inventario_precio_compra;
    private double inventario_precio_venta;
    private int inventario_cantidad;
    private String inventario_fecha_registro;
    private int inventario_estado;
    private int tipo_id;

    public inventario() {
    }

    public inventario(int inventario_id, String inventario_nombre, double inventario_precio_compra, double inventario_precio_venta, int inventario_cantidad, String inventario_fecha_registro, int inventario_estado, int tipo_id) {
        this.inventario_id = inventario_id;
        this.inventario_nombre = inventario_nombre;
        this.inventario_precio_compra = inventario_precio_compra;
        this.inventario_precio_venta = inventario_precio_venta;
        this.inventario_cantidad = inventario_cantidad;
        this.inventario_fecha_registro = inventario_fecha_registro;
        this.inventario_estado = inventario_estado;
        this.tipo_id = tipo_id;
    }

    public int getInventario_id() {
        return inventario_id;
    }

    public void setInventario_id(int inventario_id) {
        this.inventario_id = inventario_id;
    }

    public String getInventario_nombre() {
        return inventario_nombre;
    }

    public void setInventario_nombre(String inventario_nombre) {
        this.inventario_nombre = inventario_nombre;
    }

    public double getInventario_precio_compra() {
        return inventario_precio_compra;
    }

    public void setInventario_precio_compra(double inventario_precio_compra) {
        this.inventario_precio_compra = inventario_precio_compra;
    }

    public double getInventario_precio_venta() {
        return inventario_precio_venta;
    }

    public void setInventario_precio_venta(double inventario_precio_venta) {
        this.inventario_precio_venta = inventario_precio_venta;
    }

    public int getInventario_cantidad() {
        return inventario_cantidad;
    }

    public void setInventario_cantidad(int inventario_cantidad) {
        this.inventario_cantidad = inventario_cantidad;
    }

    public String getInventario_fecha_registro() {
        return inventario_fecha_registro;
    }

    public void setInventario_fecha_registro(String inventario_fecha_registro) {
        this.inventario_fecha_registro = inventario_fecha_registro;
    }

    public int getInventario_estado() {
        return inventario_estado;
    }

    public void setInventario_estado(int inventario_estado) {
        this.inventario_estado = inventario_estado;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }
    
    
    
    
}
