package Beans;

public class SeleccionBean {
    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private int estadios_idEstadios;

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getEstadios_idEstadios() {
        return estadios_idEstadios;
    }

    public void setEstadios_idEstadios(int estadios_idEstadios) {
        this.estadios_idEstadios = estadios_idEstadios;
    }
}
