package Beans;

import java.sql.Date;

public class SeleccionBean {
    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private String nombreEstadio;
    private int idSeleccionLocal;
    private int idSeleccionVisitante;
    private Date fecha;

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

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public int getIdSeleccionLocal() {
        return idSeleccionLocal;
    }

    public void setIdSeleccionLocal(int idSeleccionLocal) {
        this.idSeleccionLocal = idSeleccionLocal;
    }

    public int getIdSeleccionVisitante() {
        return idSeleccionVisitante;
    }

    public void setIdSeleccionVisitante(int idSeleccionVisitante) {
        this.idSeleccionVisitante = idSeleccionVisitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
