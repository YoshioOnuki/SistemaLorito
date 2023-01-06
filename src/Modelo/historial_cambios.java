
package Modelo;

public class historial_cambios {
    private int historial_id;
    private String historial_descripcion;
    private String historial_fecha;
    private int historial_trabajador_id;

    public historial_cambios() {
    }

    public historial_cambios(int historialID, String historialDescripcion, String historialFecha, int historialTrabajadorID) {
        this.historial_id = historialID;
        this.historial_descripcion = historialDescripcion;
        this.historial_fecha = historialFecha;
        this.historial_trabajador_id = historialTrabajadorID;
    }

    public int getHistorialID() {
        return historial_id;
    }

    public void setHistorialID(int historialID) {
        this.historial_id = historialID;
    }

    public String getHistorialDescripcion() {
        return historial_descripcion;
    }

    public void setHistorialDescripcion(String historialDescripcion) {
        this.historial_descripcion = historialDescripcion;
    }

    public String getHistorialFecha() {
        return historial_fecha;
    }

    public void setHistorialFecha(String historialFecha) {
        this.historial_fecha = historialFecha;
    }

    public int getHistorialTrabajadorID() {
        return historial_trabajador_id;
    }

    public void setHistorialTrabajadorID(int historialTrabajadorID) {
        this.historial_trabajador_id = historialTrabajadorID;
    }
    
    
}
