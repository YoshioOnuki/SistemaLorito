
package Modelo;

public class trabajador {
    private int trabajador_id;
    private String trabajador_DNI;
    private String trabajador_nombres;
    private String trabajador_direccion;
    private int rol_id;

    public trabajador() {
    }

    public trabajador(int trabajador_id, String trabajador_DNI, String trabajador_nombres, String trabajador_direccion, int rol_id) {
        this.trabajador_id = trabajador_id;
        this.trabajador_DNI = trabajador_DNI;
        this.trabajador_nombres = trabajador_nombres;
        this.trabajador_direccion = trabajador_direccion;
        this.rol_id = rol_id;
    }

    public int getTrabajadorID() {
        return trabajador_id;
    }

    public void setTrabajadorID(int trabajadorID) {
        this.trabajador_id = trabajadorID;
    }

    public String getTrabajador_DNI() {
        return trabajador_DNI;
    }

    public void setTrabajador_DNI(String trabajador_DNI) {
        this.trabajador_DNI = trabajador_DNI;
    }

    public String getTrabajadorNombres() {
        return trabajador_nombres;
    }

    public void setTrabajadorNombres(String trabajadorNombres) {
        this.trabajador_nombres = trabajadorNombres;
    }

    public String getTrabajadorDireccion() {
        return trabajador_direccion;
    }

    public void setTrabajadorDireccion(String trabajadorDireccion) {
        this.trabajador_direccion = trabajadorDireccion;
    }

    public int getRolID() {
        return rol_id;
    }

    public void setRolID(int rolID) {
        this.rol_id = rolID;
    }
    
    
    
}
