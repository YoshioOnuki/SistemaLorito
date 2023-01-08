
package Modelo;

public class historial_cambios {
    private int historial_id;
    private String historial_descripcion;
    private String historial_fecha;
    private String historial_trabajador;

    public historial_cambios() {
    }

    public historial_cambios(int historial_id, String historial_descripcion, String historial_fecha, String historial_trabajador) {
        this.historial_id = historial_id;
        this.historial_descripcion = historial_descripcion;
        this.historial_fecha = historial_fecha;
        this.historial_trabajador = historial_trabajador;
    }

    public int getHistorial_id() {
        return historial_id;
    }

    public void setHistorial_id(int historial_id) {
        this.historial_id = historial_id;
    }

    public String getHistorial_descripcion() {
        return historial_descripcion;
    }

    public void setHistorial_descripcion(String historial_descripcion) {
        this.historial_descripcion = historial_descripcion;
    }

    public String getHistorial_fecha() {
        return historial_fecha;
    }

    public void setHistorial_fecha(String historial_fecha) {
        this.historial_fecha = historial_fecha;
    }

    public String getHistorial_trabajador() {
        return historial_trabajador;
    }

    public void setHistorial_trabajador(String historial_trabajador) {
        this.historial_trabajador = historial_trabajador;
    }

    
    
}
